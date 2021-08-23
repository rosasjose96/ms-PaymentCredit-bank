package com.bootcamp.msPaymentCredit.services.impl;

import com.bootcamp.msPaymentCredit.models.dto.TransactionDTO;
import com.bootcamp.msPaymentCredit.services.ITransactionDTOService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

/**
 * The type Transaction active service.
 */
@Service
public class TransactionActiveServiceImpl implements ITransactionDTOService {

    private static final Logger LOGGER = LoggerFactory.getLogger(TransactionActiveServiceImpl.class);

    @Autowired
    @Qualifier("client")
    private WebClient.Builder client;

    @Override
    public Mono<TransactionDTO> saveTransaction(TransactionDTO transaction) {
        LOGGER.info("initializing Transaction create");

        return client
                .baseUrl("http://TRANSACTION-SERVICE/api/transaction")
                .build()
                .post()
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(transaction)
                .retrieve()
                .bodyToMono(TransactionDTO.class);
    }

}
