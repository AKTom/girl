package com.controlcenter.service;

import com.controlcenter.domain.Girl;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class GirlServiceTest {
    @Autowired
    private GirlService girlService;
    @Test
    public void insertTwo() throws Exception {
    }

    @Test
    public void getAge() throws Exception {
    }

    @Test
    public void findOne() throws Exception {
        Girl girl = girlService.findOne(1);
        log.info("age={}",girl.getAge());
    }

}