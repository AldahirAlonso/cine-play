package com.cine_play.persistence;

import com.cine_play.domain.dto.MovieDto;
import com.cine_play.domain.repository.MovieRepository;
import com.cine_play.persistence.crud.CrudMovieEntity;
import com.cine_play.persistence.mapper.MovieMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MovieEntityRepository implements MovieRepository {
    private final CrudMovieEntity crudMovieEntity;
    private final MovieMapper movieMapper;

    public MovieEntityRepository(CrudMovieEntity crudMovieEntity, MovieMapper movieMapper) {
        this.crudMovieEntity = crudMovieEntity;
        this.movieMapper = movieMapper;
    }

    @Override
    public List<MovieDto> getAll() {
        this.crudMovieEntity.findAll();
        return this.movieMapper.toDto(this.crudMovieEntity.findAll());
    }
}
