package com.bootcamp.msPaymentCredit.services;

import com.bootcamp.msPaymentCredit.models.dto.TransactionActiveDTO;
import reactor.core.publisher.Mono;

public interface ITransactionDTOService {
    public Mono<TransactionActiveDTO> saveTransaction(TransactionActiveDTO transaction);
}
