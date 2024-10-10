package ru.mipt.bit.platformer.game.player;

import ru.mipt.bit.platformer.game.controls.commands.Command;
import ru.mipt.bit.platformer.game.controls.commands.MoveCommand;
import ru.mipt.bit.platformer.game.level.LevelEntity;
import ru.mipt.bit.platformer.game.level.LevelRenderer;

import static com.badlogic.gdx.math.MathUtils.isEqual;
import static ru.mipt.bit.platformer.util.GdxGameUtils.continueProgress;

public class PlayerRenderer implements Renderer {
    /*
    Класс, ответственный за отображение перемещения игрока на уровне. Обертка над логикой PlayerMoveLogic для рендера
    текстуры игрока на поле.
     */

    private final PlayerMoveLogic playerMoveLogic;
    private final LevelRenderer levelRenderer;
    private final LevelEntity player;
    public static final float MOVEMENT_SPEED = 0.4f;
    private float playerMovementProgress = 1f;

    public PlayerRenderer(LevelEntity player, PlayerMoveLogic playerMoveLogic, LevelRenderer levelRenderer) {
        this.player = player;
        this.playerMoveLogic = playerMoveLogic;
        this.levelRenderer = levelRenderer;
    }

    @Override
    public void handleCommand(Command command, float deltaTime) {
        if (command instanceof MoveCommand) {
            movePlayer((MoveCommand) command);
        }

        playerMovementProgress = continueProgress(playerMovementProgress, deltaTime, MOVEMENT_SPEED);
        levelRenderer.shiftEntity(
                player, playerMoveLogic.getDestination(), playerMovementProgress
        );
    }

    private void movePlayer(MoveCommand command) {
        if (isEqual(playerMovementProgress, 1f)) {
            // Finish previous move (do nothing if move hasn't been started)
            playerMoveLogic.finishMove();

            boolean hasStarted = playerMoveLogic.startMove(command);
            // Rotation for playerMoveLogic and player on screen are different entities
            player.setRotation(playerMoveLogic.getRotation());
            if (hasStarted) {
                playerMovementProgress = 0f;
            }
        }
    }
}
