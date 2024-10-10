package ru.mipt.bit.platformer.game.entities;

public class Obstacle implements GameEntity{

    private Coordinates coordinates;
    private float rotation = 0f;

    public Obstacle(Coordinates coordinates, float rotation) {
        this.coordinates = coordinates;
        this.rotation = rotation;
    }

    public Obstacle(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    @Override
    public Coordinates getCoordinates() {
        return coordinates;
    }

    @Override
    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = new Coordinates(coordinates.x, coordinates.y);
    }

    @Override
    public float getRotation() {
        return rotation;
    }
}
