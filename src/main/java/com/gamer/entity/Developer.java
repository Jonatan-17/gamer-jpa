package com.gamer.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "developer")
@Getter
@Setter
@NoArgsConstructor
public class Developer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 100)
    private String name;

    @Column(nullable = false, length = 100)
    private String country;

    @OneToMany(mappedBy = "developer")
    private List<VideoGame> videoGames = new ArrayList<>();

    public Developer(String name, String country) {
        this.name = name;
        this.country = country;
    }
}
