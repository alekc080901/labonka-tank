package ru.mipt.bit.platformer.game.level;

import ru.mipt.bit.platformer.game.entities.GameEntity;

import java.util.ArrayList;
import java.util.List;

public class LevelEntityDatabase {
    /*
    Класс, хранящий методы создания готовых объектов и коллекцию всех созданных объектов (в данном случае танка и дерева).
    Является связывающим хвеном между логикой и графикой.
     */

    // Созданные объекты передаются и удаляются в LevelRenderer при остановке приложения
    public static List<LevelEntity> createdObjects = new ArrayList<>();

    private static LevelEntity getLevelObject(String path, GameEntity gameEntity) {
        LevelEntity object = new LevelEntity(gameEntity, path);
        createdObjects.add(object);
        return object;
    }

    public static LevelEntity getBlueTank(GameEntity gameEntity) {
        return getLevelObject("images/tank_blue.png", gameEntity);
    }

    public static LevelEntity getGreenTree(GameEntity gameEntity) {
        return getLevelObject("images/greenTree.png", gameEntity);
    }
}
