package com.converter.TrendyolCaseFurkanGurcay.serviceTest;

import com.converter.TrendyolCaseFurkanGurcay.dto.TransactionDTO;
import com.converter.TrendyolCaseFurkanGurcay.mapper.LinkMapper;
import com.converter.TrendyolCaseFurkanGurcay.model.Transaction;
import com.converter.TrendyolCaseFurkanGurcay.repository.TransactionRepository;
import com.converter.TrendyolCaseFurkanGurcay.service.TransactionService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TransactionServiceTest {


    @Mock
    TransactionRepository mockTransactionRepository;
    @Mock
    LinkMapper linkMapper;

    @InjectMocks
    TransactionService transactionService;

    @Test
    void saveTransaction() throws MalformedURLException, UnsupportedEncodingException, URISyntaxException {

        // given
        Transaction transaction = new Transaction();
        transaction.setRequestedLink("https://www.trendyol.com/casio/saat-p-5215125");


        when(linkMapper.mapFromTransactionDTOtoTransaction(any())).thenReturn(transaction);
        when(mockTransactionRepository.save(any())).thenReturn(transaction);

        // when
        TransactionDTO dto = new TransactionDTO();
        Transaction actual = this.transactionService.createDeeplink(dto);

        // then
        assertAll(
                () -> assertNotNull(actual),
                () -> assertEquals(transaction, actual),
                () -> assertEquals("https://www.trendyol.com/casio/saat-p-5215125", actual.getRequestedLink())
        );
    }

    @Test
    void checkDeeplinkProductConversion() throws MalformedURLException, UnsupportedEncodingException, URISyntaxException {

        // given
        Transaction transaction = new Transaction();
        transaction.setRequestedLink("https://www.trendyol.com/casio/saat-p-5215125");


        when(linkMapper.mapFromTransactionDTOtoTransaction(any())).thenReturn(transaction);
        when(mockTransactionRepository.save(any())).thenReturn(transaction);

        // when
        TransactionDTO dto = new TransactionDTO();
        Transaction actual = this.transactionService.createDeeplink(dto);


        // then
        assertAll(
                () -> assertNotNull(actual),
                () -> assertEquals(transaction, actual),
                () -> assertEquals("ty://?Page=Product&ContentId=5215125", actual.getResponsedLink())
        );
    }

    @Test
    void checkDeeplinkSearchConversion() throws MalformedURLException, UnsupportedEncodingException, URISyntaxException {

        // given
        Transaction transaction = new Transaction();
        transaction.setRequestedLink("https://www.trendyol.com/sr?q=elbise");


        when(linkMapper.mapFromTransactionDTOtoTransaction(any())).thenReturn(transaction);
        when(mockTransactionRepository.save(any())).thenReturn(transaction);

        // when
        TransactionDTO dto = new TransactionDTO();
        Transaction actual = this.transactionService.createDeeplink(dto);


        // then
        assertAll(
                () -> assertNotNull(actual),
                () -> assertEquals(transaction, actual),
                () -> assertEquals("ty://?Page=Search&Query=elbise", actual.getResponsedLink())
        );
    }

    @Test
    void checkDeeplinkHomePageConversion() throws MalformedURLException, UnsupportedEncodingException, URISyntaxException {

        // given
        Transaction transaction = new Transaction();
        transaction.setRequestedLink("https://www.trendyol.com/Favoriler");


        when(linkMapper.mapFromTransactionDTOtoTransaction(any())).thenReturn(transaction);
        when(mockTransactionRepository.save(any())).thenReturn(transaction);

        // when
        TransactionDTO dto = new TransactionDTO();
        Transaction actual = this.transactionService.createDeeplink(dto);


        // then
        assertAll(
                () -> assertNotNull(actual),
                () -> assertEquals(transaction, actual),
                () -> assertEquals("ty://?Page=Home", actual.getResponsedLink())
        );
    }

    @Test
    void checkUrlHomePageConversion() throws MalformedURLException, UnsupportedEncodingException, URISyntaxException {

        // given
        Transaction transaction = new Transaction();
        transaction.setRequestedLink("ty://?Page=Home");


        when(linkMapper.mapFromTransactionDTOtoTransaction(any())).thenReturn(transaction);
        when(mockTransactionRepository.save(any())).thenReturn(transaction);

        // when
        TransactionDTO dto = new TransactionDTO();
        Transaction actual = this.transactionService.createUrl(dto);


        // then
        assertAll(
                () -> assertNotNull(actual),
                () -> assertEquals(transaction, actual),
                () -> assertEquals("https://www.trendyol.com", actual.getResponsedLink())
        );
    }
    @Test
    void checkUrlSearchConversion() throws MalformedURLException, UnsupportedEncodingException, URISyntaxException {

        // given
        Transaction transaction = new Transaction();
        transaction.setRequestedLink("ty://?Page=Search&Query=elbise");


        when(linkMapper.mapFromTransactionDTOtoTransaction(any())).thenReturn(transaction);
        when(mockTransactionRepository.save(any())).thenReturn(transaction);

        // when
        TransactionDTO dto = new TransactionDTO();
        Transaction actual = this.transactionService.createUrl(dto);


        // then
        assertAll(
                () -> assertNotNull(actual),
                () -> assertEquals(transaction, actual),
                () -> assertEquals("https://www.trendyol.com/sr?q=elbise", actual.getResponsedLink())
        );
    }
    @Test
    void checkUrlProductConversion() throws MalformedURLException, UnsupportedEncodingException, URISyntaxException {

        // given
        Transaction transaction = new Transaction();
        transaction.setRequestedLink("ty://?Page=Product&ContentId=2222&MerchantId=1111");


        when(linkMapper.mapFromTransactionDTOtoTransaction(any())).thenReturn(transaction);
        when(mockTransactionRepository.save(any())).thenReturn(transaction);

        // when
        TransactionDTO dto = new TransactionDTO();
        Transaction actual = this.transactionService.createUrl(dto);


        // then
        assertAll(
                () -> assertNotNull(actual),
                () -> assertEquals(transaction, actual),
                () -> assertEquals("https://www.trendyol.com/brand/name-p-2222&merchantId=1111", actual.getResponsedLink())
        );
    }
}

