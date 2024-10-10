package ru.mipt.bit.platformer.game.entities;

public interface GameEntity {
    /*
    Класс сущности игры без привязки к графике.
     */

    Coordinates getCoordinates();

    void setCoordinates(Coordinates coordinates);

    float getRotation();
}
