package com.converter.TrendyolCaseFurkanGurcay.controller;

import com.converter.TrendyolCaseFurkanGurcay.dto.TransactionDTO;
import com.converter.TrendyolCaseFurkanGurcay.model.Transaction;
import com.converter.TrendyolCaseFurkanGurcay.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;


@RestController
@RequestMapping("/v1")
public class LinkController {

    private final TransactionService transactionService;

    @Autowired
    public LinkController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }


    @PostMapping(value = "/url-to-deeplink",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Transaction> saveDeeplink(@RequestBody TransactionDTO transactionDTO) throws MalformedURLException, URISyntaxException, UnsupportedEncodingException {
        return new ResponseEntity<>(transactionService.createDeeplink(transactionDTO), HttpStatus.OK);

    }
    @PostMapping(value = "/deeplink-to-url",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Transaction> saveUrl(@RequestBody TransactionDTO transactionDTO) throws MalformedURLException, URISyntaxException, UnsupportedEncodingException {
        return new ResponseEntity<>(transactionService.createUrl(transactionDTO), HttpStatus.OK);
    }

}
