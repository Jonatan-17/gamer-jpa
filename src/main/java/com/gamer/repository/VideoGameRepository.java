package com.gamer.repository;

import com.gamer.entity.VideoGame;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VideoGameRepository extends JpaRepository<VideoGame, Long> {

    List<VideoGame> findByGenreName(String genreName);

    List<VideoGame> findByDeveloperName(String developerName);
}
