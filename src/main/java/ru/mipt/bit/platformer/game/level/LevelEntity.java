package ru.mipt.bit.platformer.game.level;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import ru.mipt.bit.platformer.game.entities.Coordinates;
import ru.mipt.bit.platformer.game.entities.GameEntity;

import static ru.mipt.bit.platformer.util.GdxGameUtils.createBoundingRectangle;
import static ru.mipt.bit.platformer.util.GdxGameUtils.drawTextureRegionUnscaled;

public class LevelEntity {
    /*
    Класс объекта, размещенного на карте. Может быть кем угодно, лишь бы была нужная текстурка.
    */
    private final GameEntity gameEntity;
    private final Texture texture;
    private float rotation = 0f;
    private final TextureRegion graphics;

    private final Rectangle rectangle;

    public LevelEntity(GameEntity entity, String texturePath) {
        this.gameEntity = entity;
        this.texture = new Texture(texturePath);
        this.graphics = new TextureRegion(texture);
        this.rectangle = createBoundingRectangle(graphics);
    }

    public void draw(Batch batch) {
        drawTextureRegionUnscaled(batch, graphics, rectangle, rotation);
    }

    public void dispose() {
        texture.dispose();
    }

    public Rectangle getRectangle() {
        return rectangle;
    }

    public Coordinates getCoordinates() {
        return gameEntity.getCoordinates();
    }

    public void setRotation(float rotation) {
        this.rotation = rotation;
    }

    public float getRotation() {
        return rotation;
    }
}
