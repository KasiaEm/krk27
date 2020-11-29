package com.sda.model.characters;

import com.sda.exceptions.GameOverException;

public interface Vunerable {
    void receiveDamage(int points) throws GameOverException;
}
