package com.converter.TrendyolCaseFurkanGurcay.controllerTest;

import com.converter.TrendyolCaseFurkanGurcay.controller.LinkController;
import com.converter.TrendyolCaseFurkanGurcay.dto.TransactionDTO;
import com.converter.TrendyolCaseFurkanGurcay.model.Transaction;
import com.converter.TrendyolCaseFurkanGurcay.service.TransactionService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class LinkControllerTest {

    @Mock
    TransactionService mockTransactionService;

    @InjectMocks
    LinkController linkController;

    @Test
    void saveDeeplink() throws MalformedURLException, UnsupportedEncodingException, URISyntaxException {
        Transaction transaction = new Transaction();
        transaction.setRequestedLink("https://www.trendyol.com/casio/saat-p-5215125");
        when(mockTransactionService.createDeeplink(any())).thenReturn(transaction);

        TransactionDTO dto = new TransactionDTO();
        ResponseEntity<Transaction> actual = this.linkController.saveDeeplink(dto);

        assertAll(
                () -> assertEquals(transaction, actual.getBody()),
                () -> assertEquals(HttpStatus.OK,actual.getStatusCode())
        );
    }


    @Test
    void saveUrl() throws MalformedURLException, UnsupportedEncodingException, URISyntaxException {
        Transaction transaction = new Transaction();
        transaction.setRequestedLink("ty://?Page=Product&ContentId=5215125");
        when(mockTransactionService.createUrl(any())).thenReturn(transaction);

        TransactionDTO dto = new TransactionDTO();
        ResponseEntity<Transaction> actual = this.linkController.saveUrl(dto);

        assertAll(
                () -> assertEquals(transaction,actual.getBody()),
                () -> assertEquals(HttpStatus.OK,actual.getStatusCode())
        );

}}
