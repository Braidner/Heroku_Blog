package org.braidner.blog.controller;

/**
 * @author KuznetsovNE/ 09.09.2015.
 */
public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String message) {
        super(message);
    }
}
