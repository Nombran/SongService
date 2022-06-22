package com.epam.songservice.service;

import com.epam.songservice.dto.MultipleSongMetadataIdDto;
import com.epam.songservice.dto.SongMetadataDto;
import com.epam.songservice.dto.SongMetadataIdDto;
import com.epam.songservice.exception.SongMetadataNotExists;
import com.epam.songservice.exception.SongMetadataNotFoundException;
import com.epam.songservice.mapper.SongMetadataMapper;
import com.epam.songservice.model.SongMetadata;
import com.epam.songservice.repository.SongMetadataRepository;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author www.epam.com
 */
@Service
@RequiredArgsConstructor
public class SongMetadataService {
    private final SongMetadataRepository repository;
    private final SongMetadataMapper mapper;

    public SongMetadataIdDto storeSongMetadata(SongMetadataDto metadata) {
        val metadataEntity = mapper.toEntity(metadata);
        repository.save(metadataEntity);
        return mapper.toIdDto(metadataEntity);
    }

    public SongMetadataDto findSongMetadata(int id) {
        val entity = repository.findById(id).orElseThrow(
                () -> new SongMetadataNotFoundException("Song with id = " + id + " doesn't exist")
        );
        return mapper.toMetadataDto(entity);
    }

    @Transactional
    public MultipleSongMetadataIdDto deleteSongMetadata(List<Integer> ids) {
        val entities = ids.stream().map(id -> {
            return repository.findById(id).orElseThrow(() -> new SongMetadataNotExists("Song with id = " + id + " doesn't exist"));
        }).toList();
        val deletedIds = entities.stream().map(SongMetadata::getId).peek(repository::deleteById).toList();
        return new MultipleSongMetadataIdDto(deletedIds);
    }
}
