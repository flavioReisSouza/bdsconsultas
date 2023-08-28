package com.devsuperior.uri2611.repositories;

import com.devsuperior.uri2611.dto.MovieMinDTO;
import com.devsuperior.uri2611.entities.Movie;
import com.devsuperior.uri2611.projections.MovieMinProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Long> {

    @Query(nativeQuery = true, value = "SELECT movies.id, movies.name " //SQL RAIZ: SQL puro, sem JPQL
            + "FROM movies "
            + "INNER JOIN genres ON genres.id = movies.id_genres "
            + "WHERE genres.description = :genreName")
    List<MovieMinProjection> search1(String genreName);

    @Query("SELECT new com.devsuperior.uri2611.dto.MovieMinDTO(obj.id, obj.name) " //JPQL: SQL com orientação a objetos
            + "FROM Movie obj "
            + "WHERE obj.genre.description = :genreName")
    List<MovieMinDTO> search2(String genreName);
}
