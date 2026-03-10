package com.bowlingtracker.model;

import jakarta.persistence.*;

@Entity
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String player;
    private int wins;
    private int losses;
    private int topScore;

    public Player() {}

    public Player(String player, int wins, int losses, int topScore) {
        this.player = player;
        this.wins = wins;
        this.losses = losses;
        this.topScore = topScore;
    }

    public int getGamesPlayed() {
        return wins + losses;
    }

    public double getWinPercentage() {
        int games = getGamesPlayed();
        if (games == 0) return 0;
        return (double) wins / games * 100;
    }

    // getters and setters
}