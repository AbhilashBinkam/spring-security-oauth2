package com.synchrony.assignment.imagedirectory.exception;/*
 *
 * Created by
 * Binkam Abhilash
 * on 13-November-2023
 * image-directory
 *
 */

public class ObjectNotFoundException extends RuntimeException{

    public ObjectNotFoundException(String objectName, String id) {
        super("Could not find " + objectName + " with Id " + id + " :(");
    }

    public ObjectNotFoundException(String objectName, Integer id) {
        super("Could not find " + objectName + " with Id " + id + " :(");
    }

}
