package ru.mipt.bit.platformer.game.core;

import ru.mipt.bit.platformer.game.controls.commands.MoveCommand;

public class PlayerMoveLogic {
    /*
    Класс, ответственный за перемещение игрока по полю (логическое). Также следит, чтобы игрок не врезался в препятствия.
     */

    private final Player player;
    private final BaseLevel level;

    public PlayerMoveLogic(Player player, BaseLevel level) {
        this.player = player;
        this.level = level;
    }

    public boolean startMove(MoveCommand direction) {
        Coordinates oldCoordinates = new Coordinates(player.getCoordinates());
        changeRotation(direction);
        moveAndChangeDestination(direction);
        if (!hasHitObstacle() && !hasTrespassedMap()) {
            return true;
        } else {
            player.setDestination(oldCoordinates);
            return false;
        }
    }

    public void finishMove() {
        player.setCoordinates(player.getDestination());
    }

    private boolean hasHitObstacle() {
        for (GameEntity obstacle : level.getObstacles()) {
            if (obstacle.getCoordinates().equals(player.getDestination())) {
                return true;
            }
        }
        return false;
    }

    private boolean hasTrespassedMap() {
        Coordinates coords = player.getDestination();
        Coordinates mapUpperRightLimit = level.getUpperRightSize();
        return coords.x >= mapUpperRightLimit.x || coords.x < 0 || coords.y >= mapUpperRightLimit.y || coords.y < 0;
    }

    private void moveAndChangeDestination(MoveCommand direction) {
        var coords = player.getDestination();
        coords.x += direction.getShiftX();
        coords.y += direction.getShiftY();
    }

    private void changeRotation(MoveCommand direction) {
        player.setRotation(direction.getRotation());
    }

    public Player getPlayer() {
        return player;
    }

    public Coordinates getDestination() {
        return player.getDestination();
    }

    public float getRotation() {
        return player.getRotation();
    }

    public void setPlayerCoordinates(Coordinates coordinates) {
        player.setDestination(coordinates);
        finishMove();
    }
}
