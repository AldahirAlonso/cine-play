package com.cine_play.domain.dto;

import com.cine_play.domain.Genre;

import java.time.LocalDate;

public record UpdateMovieDto(
        String title,
        LocalDate releaseDate,
        Double rating
) {
}
