package com.epam.songservice.exception;

/**
 * @author www.epam.com
 */
public class SongMetadataServiceValidationException extends IllegalArgumentException{
    public SongMetadataServiceValidationException(String message) {
        super(message);
    }
}
