package com.converter.TrendyolCaseFurkanGurcay.service;

import com.converter.TrendyolCaseFurkanGurcay.LinkBuilder.DeeplinkToUrl;
import com.converter.TrendyolCaseFurkanGurcay.LinkBuilder.UrlToDeeplink;
import com.converter.TrendyolCaseFurkanGurcay.dto.TransactionDTO;
import com.converter.TrendyolCaseFurkanGurcay.mapper.LinkMapper;
import com.converter.TrendyolCaseFurkanGurcay.model.Transaction;
import com.converter.TrendyolCaseFurkanGurcay.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;


@Service
@RequiredArgsConstructor
public class TransactionService {

private final TransactionRepository transactionRepository;
private final LinkMapper linkMapper;


@Transactional
public Transaction createDeeplink(TransactionDTO transactionDTO) throws MalformedURLException, URISyntaxException, UnsupportedEncodingException {
    return transactionRepository.save(DeepLinkCreator(transactionDTO));
}

@Transactional
public Transaction createUrl(TransactionDTO transactionDTO) throws URISyntaxException {
    return transactionRepository.save(UrlCreator(transactionDTO));
}


public Transaction DeepLinkCreator(TransactionDTO transactionDTO) throws MalformedURLException, URISyntaxException, UnsupportedEncodingException {

    Transaction transaction=linkMapper.mapFromTransactionDTOtoTransaction(transactionDTO);

    String createdDeepLink = UrlToDeeplink. UrlToDeeplinkBuilder(transaction.getRequestedLink());

    transaction.setResponsedLink(createdDeepLink);

    return transaction;
    }


public Transaction UrlCreator(TransactionDTO transactionDTO) throws URISyntaxException {

    Transaction transaction=linkMapper.mapFromTransactionDTOtoTransaction(transactionDTO);

    String createdUrl = DeeplinkToUrl. DeeplinkToUrlBuilder(transaction.getRequestedLink());

    transaction.setResponsedLink(createdUrl);

    return transaction;

}

}


