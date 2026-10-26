package com.gamer.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "video_game")
@Getter
@Setter
@NoArgsConstructor
public class VideoGame {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String title;

    @Column(name = "release_year", nullable = false)
    private Integer releaseYear;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "developer_id", nullable = false)
    private Developer developer;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "genre_id", nullable = false)
    private Genre genre;

    @OneToMany(mappedBy = "videoGame", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Achievement> achievements = new ArrayList<>();

    public VideoGame(String title, Integer releaseYear, Developer developer, Genre genre) {
        this.title = title;
        this.releaseYear = releaseYear;
        this.developer = developer;
        this.genre = genre;
    }

    public void addAchievement(Achievement achievement) {
        achievements.add(achievement);
        achievement.setVideoGame(this);
    }
}
