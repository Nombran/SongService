package com.epam.songservice.client;

import com.epam.songservice.dto.SongMetadataDto;
import com.epam.songservice.dto.SongMetadataIdDto;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

/**
 * @author www.epam.com
 */
@RequiredArgsConstructor
public class SongServiceClientImpl implements SongServiceClient{

    @Value("${song.service.baseUrl}")
    private String baseUrl;

    private final RestTemplate songServiceRestTemplate;


    @Override
    public SongMetadataIdDto storeSongMetadata(SongMetadataDto songMetadata) {
        val request = new HttpEntity<>(songMetadata);
        return songServiceRestTemplate.postForObject(baseUrl, request, SongMetadataIdDto.class);
    }

    @Override
    public void removeMetadataByIds(List<Integer> ids) {
        val deleteUrl = UriComponentsBuilder.fromHttpUrl(baseUrl).queryParam("id", ids).toUriString();
        songServiceRestTemplate.delete(deleteUrl);
    }

    @Override
    public void removeMetadataByResourceIds(List<Integer> resourceIds) {
        val deleteUrl = UriComponentsBuilder.fromHttpUrl(baseUrl).queryParam("resourceId", resourceIds).toUriString();
        songServiceRestTemplate.delete(deleteUrl);
    }

    @Override
    public SongMetadataDto findSongMetadataByResourceId(Integer resourceId) {
        return songServiceRestTemplate.getForEntity(UriComponentsBuilder.fromHttpUrl(baseUrl).queryParam("resourceId" ,resourceId).toUriString(), SongMetadataDto.class).getBody();
    }
}
