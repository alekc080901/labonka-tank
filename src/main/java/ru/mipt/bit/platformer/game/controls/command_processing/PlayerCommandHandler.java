package ru.mipt.bit.platformer.game.controls.command_processing;

import ru.mipt.bit.platformer.game.controls.commands.Command;
import ru.mipt.bit.platformer.game.player.PlayerRenderer;

public class PlayerCommandHandler {
    private final PlayerRenderer playerRenderer;
    private final CommandDistributor commandDistributors;

    public PlayerCommandHandler(PlayerRenderer playerRenderer, CommandDistributor commandDistributors) {
        this.playerRenderer = playerRenderer;
        this.commandDistributors = commandDistributors;
    }

    public void handleSinglePlayer(float deltaTime) {
        Command command = commandDistributors.getCurrentCommand();
        playerRenderer.handleCommand(command, deltaTime);
    }
}
