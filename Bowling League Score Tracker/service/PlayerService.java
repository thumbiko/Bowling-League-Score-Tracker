package com.bowlingtracker.service;

import com.bowlingtracker.model.Player;
import com.bowlingtracker.repository.PlayerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService {

    private final PlayerRepository repository;

    public PlayerService(PlayerRepository repository) {
        this.repository = repository;
    }

    public List<Player> getAllPlayers() {
        return repository.findAll();
    }

    public Player addPlayer(Player player) {
        return repository.save(player);
    }
}