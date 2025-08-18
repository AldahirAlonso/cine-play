package com.cine_play.domain.repository;

import com.cine_play.domain.dto.MovieDto;

import java.util.List;

public interface MovieRepository {
    List<MovieDto> getAll();
}
