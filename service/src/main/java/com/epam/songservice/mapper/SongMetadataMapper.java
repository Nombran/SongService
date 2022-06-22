package com.epam.songservice.mapper;

import com.epam.songservice.dto.SongMetadataDto;
import com.epam.songservice.dto.SongMetadataIdDto;
import com.epam.songservice.model.SongMetadata;
import org.springframework.stereotype.Component;

/**
 * @author www.epam.com
 */
@Component
public class SongMetadataMapper {

    public SongMetadata toEntity(SongMetadataDto dto) {
        return SongMetadata.builder()
                .name(dto.getName())
                .artist(dto.getArtist())
                .album(dto.getAlbum())
                .duration(dto.getDuration())
                .resourceId(dto.getResourceId())
                .year(dto.getYear())
                .build();
    }

    public SongMetadataIdDto toIdDto(SongMetadata entity) {
        return new SongMetadataIdDto(entity.getId());
    }

    public SongMetadataDto toMetadataDto(SongMetadata entity) {
        return SongMetadataDto.builder()
                .album(entity.getAlbum())
                .artist(entity.getArtist())
                .duration(entity.getDuration())
                .name(entity.getName())
                .resourceId(entity.getResourceId())
                .year(entity.getYear())
                .build();
    }
}
