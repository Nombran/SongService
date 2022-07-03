package com.epam.songservice.exception;

/**
 * @author www.epam.com
 */
public class SongMetadataIdAlreadyExists extends RuntimeException{
    public SongMetadataIdAlreadyExists(String message) {
        super(message);
    }
}
