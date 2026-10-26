package com.gamer;

import com.gamer.entity.Achievement;
import com.gamer.entity.Developer;
import com.gamer.entity.Genre;
import com.gamer.entity.VideoGame;
import com.gamer.repository.AchievementRepository;
import com.gamer.repository.DeveloperRepository;
import com.gamer.repository.GenreRepository;
import com.gamer.repository.VideoGameRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
class RepositoryTests {

    @Autowired DeveloperRepository developerRepository;
    @Autowired GenreRepository genreRepository;
    @Autowired VideoGameRepository videoGameRepository;
    @Autowired AchievementRepository achievementRepository;

    @Test
    void savesAndQueriesRelatedEntities() {
        Developer dev = developerRepository.save(new Developer("FromSoftware", "Japan"));
        Genre genre = genreRepository.save(new Genre("RPG"));

        VideoGame game = new VideoGame("Elden Ring", 2022, dev, genre);
        game.addAchievement(new Achievement("Elden Lord", 100));
        game.addAchievement(new Achievement("Shardbearer Godrick", 20));
        videoGameRepository.save(game);

        assertThat(videoGameRepository.findByGenreName("RPG")).hasSize(1);
        assertThat(videoGameRepository.findByDeveloperName("FromSoftware")).hasSize(1);
        assertThat(achievementRepository.findByVideoGameId(game.getId())).hasSize(2);
        assertThat(developerRepository.findByName("FromSoftware")).isPresent();
    }
}
