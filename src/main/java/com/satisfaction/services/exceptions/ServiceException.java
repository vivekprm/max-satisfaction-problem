package com.satisfaction.services.exceptions;

/**
 * Checked Exception to be thrown at service layer.
 * Created by vivek mishra on 17/1/17.
 */
public class ServiceException extends Exception {
    public ServiceException(String s){
        super(s);
    }
}
