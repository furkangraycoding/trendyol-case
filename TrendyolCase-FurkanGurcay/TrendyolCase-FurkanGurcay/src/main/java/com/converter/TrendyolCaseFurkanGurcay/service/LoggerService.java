package com.converter.TrendyolCaseFurkanGurcay.service;

import com.converter.TrendyolCaseFurkanGurcay.dto.LoggerDTO;
import com.converter.TrendyolCaseFurkanGurcay.dto.TransactionDTO;
import com.converter.TrendyolCaseFurkanGurcay.model.Logger;
import com.converter.TrendyolCaseFurkanGurcay.model.Transaction;
import com.converter.TrendyolCaseFurkanGurcay.repository.LoggerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
public class LoggerService {
    private final LoggerRepository loggerRepository;


    @Transactional(readOnly = true)
    public List<Logger> findAll() {
        List<Logger> loglist = new ArrayList<>();
        Iterable<Logger> loggersiter = loggerRepository.findAll();
        loggersiter.iterator().forEachRemaining(loglist::add);
        return loglist;
    }

    @Transactional
    public Logger save(LoggerDTO loggerDTO) {
        Logger logger=new Logger();
        logger.setMessage(loggerDTO.getThrowMessage());
        logger.setDate(loggerDTO.getThrowDate());
        logger.setStatus(loggerDTO.getThrowStatusCode());
        return loggerRepository.save(logger);
    }
}
