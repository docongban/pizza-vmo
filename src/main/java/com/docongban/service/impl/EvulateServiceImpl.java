package com.docongban.service.impl;

import com.docongban.entity.Evulate;
import com.docongban.repository.EvulateRepository;
import com.docongban.service.EvulateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Component
public class EvulateServiceImpl implements EvulateService {

    @Autowired
    EvulateRepository evulateRepository;

    @Override
    public void saveEvulate(Evulate evulate, Integer orderAccountId) {
        evulate.setOrderAccountId(orderAccountId);
        evulate.setTime(Instant.now());
        this.evulateRepository.save(evulate);
    }
}
