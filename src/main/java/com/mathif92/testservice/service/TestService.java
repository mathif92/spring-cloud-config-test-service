package com.mathif92.testservice.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Slf4j
@Service
public class TestService {

    @Autowired
    private RefreshTestService refreshTestService;

    @Transactional
    public void testTransactionalMethod() {
        log.info("Starting transactional method");

        try {
            for (int i = 0; i < 10; i++) {
                log.info("Transacional Value : {}", refreshTestService.transactionalValue);
            }
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        log.info("Finishing transactional method");

    }

}
