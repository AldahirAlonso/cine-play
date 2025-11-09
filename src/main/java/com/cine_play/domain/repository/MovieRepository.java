package com.cine_play.domain.repository;

import com.cine_play.domain.dto.MovieDto;
import com.cine_play.domain.dto.UpdateMovieDto;

import java.util.List;

public interface MovieRepository {
    List<MovieDto> getAll();
    MovieDto getById(long id);
    MovieDto save(MovieDto movieDto);
    MovieDto update(long id, UpdateMovieDto UpdateMovieDto);
    void delete(long id);
}
