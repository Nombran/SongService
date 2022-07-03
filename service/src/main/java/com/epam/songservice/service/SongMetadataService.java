package com.epam.songservice.service;

import com.epam.songservice.dto.MultipleSongMetadataIdDto;
import com.epam.songservice.dto.SongMetadataDto;
import com.epam.songservice.dto.SongMetadataIdDto;
import com.epam.songservice.exception.SongMetadataNotExists;
import com.epam.songservice.exception.SongMetadataNotFoundException;
import com.epam.songservice.exception.SongMetadataServiceValidationException;
import com.epam.songservice.mapper.SongMetadataMapper;
import com.epam.songservice.model.SongMetadata;
import com.epam.songservice.repository.SongMetadataRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * @author www.epam.com
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class SongMetadataService {
    private final SongMetadataRepository repository;
    private final SongMetadataMapper mapper;

    public SongMetadataIdDto storeSongMetadata(SongMetadataDto metadata) {
        log.info("Saving metadata for " + metadata.getName() + " song ....");
        val metadataEntity = mapper.toEntity(metadata);
        repository.save(metadataEntity);
        log.info("Song " + metadata.getName() + " has saved successfully");
        return mapper.toIdDto(metadataEntity);
    }

    public SongMetadataDto findSongMetadata(int id) {
        val entity = repository.findById(id).orElseThrow(
                () -> new SongMetadataNotFoundException("Song with id = " + id + " doesn't exist")
        );
        return mapper.toMetadataDto(entity);
    }

    public SongMetadataDto findSongMetadataByResourceId(Integer resourceId) {
        val entity = repository.findByResourceId(resourceId).orElseThrow(
                () -> new SongMetadataNotFoundException("Song with resourceId = " + resourceId + " doesn't exist")
        );
        return mapper.toMetadataDto(entity);
    }

    @Transactional
    public MultipleSongMetadataIdDto deleteSongMetadata(List<Integer> ids, List<Integer> resourceIds) {
        if(!CollectionUtils.isEmpty(ids) && CollectionUtils.isEmpty(resourceIds)) {
            return deleteSongMetadataById(ids);
        }
        if(CollectionUtils.isEmpty(ids) && !CollectionUtils.isEmpty(resourceIds)) {
            return deleteSongMetadataByResourceIds(resourceIds);
        }
        throw new SongMetadataServiceValidationException("Only one request param should be provided");
    }

    private MultipleSongMetadataIdDto deleteSongMetadataById(List<Integer> ids) {
        val entities = ids.stream().map(id -> repository.findById(id).orElseThrow(() -> new SongMetadataNotExists("Song with id = " + id + " doesn't exist"))).toList();
        val deletedIds = entities.stream().map(SongMetadata::getId).peek(repository::deleteById).toList();
        return new MultipleSongMetadataIdDto(deletedIds);
    }

    private MultipleSongMetadataIdDto deleteSongMetadataByResourceIds(List<Integer> ids) {
        val entities = ids.stream().map(id -> repository.findByResourceId(id).orElseThrow(() -> new SongMetadataNotExists("Song with resource = " + id + " doesn't exist"))).toList();
        val deletedIds = entities.stream().map(SongMetadata::getId).peek(repository::deleteById).toList();
        return new MultipleSongMetadataIdDto(deletedIds);
    }


}
