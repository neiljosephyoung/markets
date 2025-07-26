package com.njy.markets.exceptionhandler;

import com.njy.markets.exception.StockNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.net.URI;

@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(StockNotFoundException.class)
    public ResponseEntity<ProblemDetail> handleStockNotFound(StockNotFoundException ex, WebRequest request) {
        ProblemDetail problemDetail = ProblemDetail.forStatus(HttpStatus.NOT_FOUND);
        problemDetail.setTitle("Stock Not Found");
        problemDetail.setDetail(ex.getMessage());
        problemDetail.setType(URI.create("/error/stock-not-found.html"));
        problemDetail.setInstance(URI.create(request.getDescription(false).replace("uri=", "")));

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(problemDetail);
    }


}
