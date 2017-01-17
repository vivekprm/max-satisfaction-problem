package com.satisfaction.service;

import com.satisfaction.services.SatisfactionService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static junit.framework.TestCase.assertNotNull;

/**
 * Test class to check Satisfaction Service in injected in runner class.
 * Created by vivek mishra on 17/1/17.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class AppRunnerTest {
    @Autowired
    private CommandLineRunner clr;

    @Autowired
    private SatisfactionService satisfactionService;

    @Test
    public void appRunnerTest() throws Exception {
        this.clr.run();
        assertNotNull(satisfactionService);
    }
}
