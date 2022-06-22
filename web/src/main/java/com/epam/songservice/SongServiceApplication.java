package com.epam.songservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author www.epam.com
 */
@SpringBootApplication(scanBasePackages = "com.epam.songservice")
public class SongServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SongServiceApplication.class, args);
    }

}
