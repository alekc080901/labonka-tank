package ru.mipt.bit.platformer.game.player;

import ru.mipt.bit.platformer.game.entities.Coordinates;
import ru.mipt.bit.platformer.game.entities.GameEntity;

public interface Player extends GameEntity {
    void setRotation(float rotation);
    Coordinates getDestination();
    void setDestination(Coordinates coords);
}
