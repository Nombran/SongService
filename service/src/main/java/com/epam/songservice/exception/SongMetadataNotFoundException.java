package com.epam.songservice.exception;

/**
 * @author www.epam.com
 */
public class SongMetadataNotFoundException extends RuntimeException{
    public SongMetadataNotFoundException(String message) {
        super(message);
    }
}
