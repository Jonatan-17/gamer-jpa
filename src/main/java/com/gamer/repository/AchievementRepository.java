package com.gamer.repository;

import com.gamer.entity.Achievement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AchievementRepository extends JpaRepository<Achievement, Long> {

    List<Achievement> findByVideoGameId(Long videoGameId);
}
