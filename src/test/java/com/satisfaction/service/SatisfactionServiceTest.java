package com.satisfaction.service;

import com.satisfaction.services.SatisfactionService;
import com.satisfaction.services.exceptions.ServiceException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

/**
 * Created by cov-127 on 17/1/17.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SatisfactionServiceTest {
    @Autowired
    private SatisfactionService satisfactionService;

    @Test
    public void testGetMaxSatisfaction() throws ServiceException {
        long max = satisfactionService.getMaxSatisfactionValue("src/main/resources/data.txt");
        assertTrue(max >= 0);
        assertEquals(2493893L, max);
    }

    @Test(expected = ServiceException.class)
    public void testGetMaxSatisfactionFileNotFound() throws ServiceException {
        satisfactionService.getMaxSatisfactionValue("null");
    }
}
