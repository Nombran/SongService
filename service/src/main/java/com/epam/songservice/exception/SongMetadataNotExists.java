package com.epam.songservice.exception;

/**
 * @author www.epam.com
 */
public class SongMetadataNotExists extends RuntimeException{
    public SongMetadataNotExists(String message) {
        super(message);
    }
}
