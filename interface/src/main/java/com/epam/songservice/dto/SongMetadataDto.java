package com.epam.songservice.dto;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.*;

/**
 * @author www.epam.com
 */
@Builder
@Data
public class SongMetadataDto {
    @NotNull
    @Size(min = 1, max = 40)
    private String name;
    @NotNull
    @Size(min = 1, max = 40)
    private String artist;
    @NotNull
    @Size(min = 1, max = 40)
    private String album;
    @NotNull
    @Size(min = 1, max = 40)
    @Pattern(regexp = "[012345]\\d:[012345]\\d")
    private String duration;
    @NotNull
    @Min(1)
    private Long resourceId;
    @NotNull
    @Min(1400)
    @Max(2022)
    private Integer year;
}
