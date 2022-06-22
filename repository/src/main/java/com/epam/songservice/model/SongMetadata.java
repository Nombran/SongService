package com.epam.songservice.model;

import lombok.*;

import javax.persistence.*;

/**
 * @author www.epam.com
 */
@Entity
@Table(name = "songs")
@Builder(toBuilder = true)
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Setter(value = AccessLevel.PACKAGE)
@Getter
public class SongMetadata {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String artist;
    private String album;
    private String duration;
    private long resourceId;
    private int year;
}
