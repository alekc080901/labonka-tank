package ru.mipt.bit.platformer.game.controls.command_processing;

import ru.mipt.bit.platformer.game.controls.commands.Command;

public interface CommandDistributor {
    Command getCurrentCommand();
}
