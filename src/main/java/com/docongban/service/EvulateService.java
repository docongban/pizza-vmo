package com.docongban.service;

import com.docongban.entity.Evulate;
import org.springframework.stereotype.Service;

@Service
public interface EvulateService {

    void saveEvulate(Evulate evulate, Integer orderAccountId);
}
