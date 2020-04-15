package com.mathif92.testservice.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Service;

@RefreshScope
@Slf4j
@Service
public class RefreshTestService {

    @Value("${test.transactional.value:Transactional Value!}")
    public String transactionalValue;

}
