package ru.mipt.bit.platformer.game.level;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import ru.mipt.bit.platformer.game.entities.Coordinates;

import static ru.mipt.bit.platformer.util.GdxGameUtils.getSingleLayer;

public class Level {
    /*
    Класс с файлом уровня (карты).
     */
    private final TiledMap level;

    public Level(String path) {
        this.level = new TmxMapLoader().load(path);
    }

    public TiledMap getLevelObject() {
        return level;
    }

    public Coordinates getLevelSize() {
        int width = (int) level.getProperties().get("width");
        int height = (int) level.getProperties().get("height");
        return new Coordinates(width, height);
    }

    public TiledMapTileLayer getGroundLayer() {
        return getSingleLayer(level);
    }

    public void dispose() {
        level.dispose();
    }
}
