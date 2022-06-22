package com.epam.songservice.repository;

import com.epam.songservice.model.SongMetadata;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author www.epam.com
 */
@Repository
public interface SongMetadataRepository extends CrudRepository<SongMetadata, Integer> {
}
