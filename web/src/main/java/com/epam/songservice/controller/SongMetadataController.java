package com.epam.songservice.controller;

import com.epam.songservice.dto.MultipleSongMetadataIdDto;
import com.epam.songservice.dto.SongMetadataDto;
import com.epam.songservice.dto.SongMetadataIdDto;
import com.epam.songservice.service.SongMetadataService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

/**
 * @author www.epam.com
 */
@Validated
@RestController
@RequestMapping("/songs")
@RequiredArgsConstructor
public class SongMetadataController {

    private final SongMetadataService service;

    @GetMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public SongMetadataDto findSongMetadata(@PathVariable("id") Integer id) {
        return service.findSongMetadata(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public SongMetadataIdDto storeSongMetadata(@Valid @RequestBody SongMetadataDto songMetadata) {
        return service.storeSongMetadata(songMetadata);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.OK)
    public MultipleSongMetadataIdDto removeMetadata(@RequestParam("id") List<Integer> ids) {
        return service.deleteSongMetadata(ids);
    }

}
