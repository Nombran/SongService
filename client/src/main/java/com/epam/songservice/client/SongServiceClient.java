package com.epam.songservice.client;

import com.epam.songservice.dto.MultipleSongMetadataIdDto;
import com.epam.songservice.dto.SongMetadataDto;
import com.epam.songservice.dto.SongMetadataIdDto;

import java.util.List;

/**
 * @author www.epam.com
 */
public interface SongServiceClient {
    SongMetadataIdDto storeSongMetadata(SongMetadataDto songMetadata);

    void removeMetadataByIds(List<Integer> ids);

    void removeMetadataByResourceIds(List<Integer> resourceIds);

    SongMetadataDto findSongMetadataByResourceId(Integer resourceId);
}
