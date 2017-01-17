package com.satisfaction.services;

import com.satisfaction.services.exceptions.ServiceException;

/**
 * Interface to provide maxSatisfactionValue
 * Created by vivek mishra on 17/1/17.
 */
public interface SatisfactionService {
    long getMaxSatisfactionValue(String path) throws ServiceException;
}
