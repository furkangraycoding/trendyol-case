package com.converter.TrendyolCaseFurkanGurcay.mapper;

import com.converter.TrendyolCaseFurkanGurcay.dto.TransactionDTO;
import com.converter.TrendyolCaseFurkanGurcay.model.Transaction;
import org.springframework.stereotype.Component;

@Component
public class LinkMapper {

    public Transaction mapFromTransactionDTOtoTransaction(TransactionDTO transactionDTO){
        if(transactionDTO ==null){
            return new Transaction(0,0,"","");
        }
        return new Transaction(transactionDTO.getId(), transactionDTO.getCreationDate(),
                transactionDTO.getWebUrlObject(), transactionDTO.getDeepLinkObject());
    }


}
