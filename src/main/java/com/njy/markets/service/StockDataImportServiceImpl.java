package com.njy.markets.service;

import com.njy.markets.mapper.StockMapper;
import com.njy.markets.model.generated.StockDto;
import com.njy.markets.model.generated.StocksResponse;
import com.njy.markets.repository.reactive.StockRepoReactive;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.jobrunr.jobs.annotations.Job;
import org.jobrunr.jobs.annotations.Recurring;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

@Slf4j
@Service
public class StockDataImportServiceImpl implements StockDataImportService {

    private final WebClient webClient;
    private final StockMapper stockMapper;
    private final StockRepoReactive stockRepoReactive;


    @Value("${stocks.import.concurrency}")
    private int concurrencyLevel;

    public StockDataImportServiceImpl(WebClient webClient, StockMapper stockMapper, StockRepoReactive stockRepoReactive) {
        this.webClient = webClient;
        this.stockMapper = stockMapper;
        this.stockRepoReactive = stockRepoReactive;
    }


    /*
      This is a returns a massive amount of data that cannot be streamed thanks to api response headers (thanks twelvedata).
      ISO-8601 S=start time offset H=period time in this case up to 3 hours after the registered start time of 2am local time.
     */
    @Recurring(id = "full-stock-list-download-carbon-aware", cron = "0 0 2 * * * [PT0S/PT3H]")
    @Job(name = "Download full stock list from api.twelvedata.com")
    @Override
    public void fetchAndSaveStocks() {
        log.info("Starting to fetch stocks...");
        webClient.get()
                .uri("/stocks")
                .retrieve()
                .bodyToMono(StocksResponse.class)
                .flatMapMany(response -> Flux.fromIterable(response.getData()))
                .doOnNext(stock -> log.debug("Processing stock: {}", stock.getSymbol()))
                .map(stockMapper::toEntity)
                .doOnNext(stock -> log.debug("Mapped stock: symbol={}, name={}", stock.getSymbol(), stock.getName()))
                .buffer(1000)
                .flatMap(stockRepoReactive::saveAll)
                .doOnError(e -> log.error("Failed to import stocks", e))
                .doOnComplete(() -> log.info("Completed fetching and saving stocks"))
                .subscribe();

    }
}
