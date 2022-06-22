package com.epam.songservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

/**
 * @author www.epam.com
 */
@Data
@AllArgsConstructor
public class MultipleSongMetadataIdDto {
    private List<Integer> ids;
}
