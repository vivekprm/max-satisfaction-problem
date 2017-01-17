package com.satisfaction.services;

import com.satisfaction.services.exceptions.ServiceException;

/**
 * Created by cov-127 on 17/1/17.
 */
public interface SatisfactionService {
    long getMaxSatisfactionValue(String path) throws ServiceException;
}
