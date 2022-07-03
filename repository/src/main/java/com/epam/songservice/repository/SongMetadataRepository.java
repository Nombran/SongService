package com.epam.songservice.repository;

import com.epam.songservice.model.SongMetadata;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author www.epam.com
 */
@Repository
public interface SongMetadataRepository extends JpaRepository<SongMetadata, Integer> {
    Optional<SongMetadata> findByResourceId(long id);
}
