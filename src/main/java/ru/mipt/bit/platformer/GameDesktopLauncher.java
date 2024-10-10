package ru.mipt.bit.platformer;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import ru.mipt.bit.platformer.game.controls.InputController;
import ru.mipt.bit.platformer.game.controls.command_processing.PlayerCommandDistributor;
import ru.mipt.bit.platformer.game.controls.command_processing.PlayerCommandHandler;
import ru.mipt.bit.platformer.game.entities.Coordinates;
import ru.mipt.bit.platformer.game.entities.GameEntity;
import ru.mipt.bit.platformer.game.entities.Obstacle;
import ru.mipt.bit.platformer.game.entities.Tank;
import ru.mipt.bit.platformer.game.level.Level;
import ru.mipt.bit.platformer.game.level.LevelEntity;
import ru.mipt.bit.platformer.game.level.LevelEntityDatabase;
import ru.mipt.bit.platformer.game.level.LevelRenderer;
import ru.mipt.bit.platformer.game.player.PlayerMoveLogic;
import ru.mipt.bit.platformer.game.player.PlayerRenderer;

import java.util.List;

public class GameDesktopLauncher implements ApplicationListener {
    /*
    Класс, ответственный за инициализацию объектов
     */

    private LevelRenderer levelRenderer;
    private PlayerRenderer playerRenderer;
    private InputController inputController;

    @Override
    public void create() {
        Level level = new Level("level.tmx");
        Batch batch = new SpriteBatch();

        Tank player = new Tank(new Coordinates(1, 1));
        GameEntity obstacle = new Obstacle(new Coordinates(1, 3));

        LevelEntity blueTank = LevelEntityDatabase.getBlueTank(player);
        LevelEntity greenTree = LevelEntityDatabase.getGreenTree(obstacle);

        List<LevelEntity> textures = List.of(blueTank, greenTree);
        List<GameEntity> obstacles = List.of(obstacle);

        levelRenderer = new LevelRenderer(level, batch, textures);
        PlayerMoveLogic playerMoveLogic = new PlayerMoveLogic(player, obstacles, level.getLevelSize());
        playerRenderer = new PlayerRenderer(blueTank, playerMoveLogic, levelRenderer);

        PlayerCommandHandler tankHandler = new PlayerCommandHandler(playerRenderer, new PlayerCommandDistributor());
        var handlers = List.of(tankHandler);
        inputController = new InputController(handlers);
    }

    @Override
    public void render() {
        levelRenderer.clear();

        float deltaTime = levelRenderer.getDeltaTime();
        inputController.handleAllPlayers(deltaTime);

        levelRenderer.render();
    }

    @Override
    public void resize(int width, int height) {
        // do not react to window resizing
    }

    @Override
    public void pause() {
        // game doesn't get paused
    }

    @Override
    public void resume() {
        // game doesn't get paused
    }

    @Override
    public void dispose() {
        // dispose of all the native resources (classes which implement com.badlogic.gdx.utils.Disposable)
        levelRenderer.dispose();
    }

    public static void main(String[] args) {
        Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
        // level width: 10 tiles x 128px, height: 8 tiles x 128px
        config.setWindowedMode(1280, 1024);
        new Lwjgl3Application(new GameDesktopLauncher(), config);
    }
}
