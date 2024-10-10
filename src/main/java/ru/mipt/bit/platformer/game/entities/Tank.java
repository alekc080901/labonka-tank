package ru.mipt.bit.platformer.game.entities;

import ru.mipt.bit.platformer.game.player.Player;

public class Tank implements Player {
    /*
    Класс игрока.
     */
    private Coordinates coordinates;
    private Coordinates destination;
    private float rotation = 0f;
    public Tank(Coordinates coordinates) {
        this.coordinates = coordinates;
        this.destination = coordinates;
    }

    @Override
    public Coordinates getCoordinates() {
        return coordinates;
    }

    @Override
    public Coordinates getDestination() {
        return destination;
    }

    public void setDestination(Coordinates destination) {
        this.destination = new Coordinates(destination);
    }

    @Override
    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = new Coordinates(coordinates.x, coordinates.y);
    }

    @Override
    public float getRotation() {
        return rotation;
    }

    @Override
    public void setRotation(float rotation) {
        this.rotation = rotation;
    }
}
