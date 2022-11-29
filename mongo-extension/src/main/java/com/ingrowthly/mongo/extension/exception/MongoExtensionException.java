package com.ingrowthly.mongo.extension.exception;

/**
 * @since 2022/11/29
 */
public class MongoExtensionException extends RuntimeException {

    public MongoExtensionException(String message) {
        super(message);
    }

    public MongoExtensionException(String message, Throwable cause) {
        super(message, cause);
    }

    public MongoExtensionException(Throwable cause) {
        super(cause);
    }

}
