package ru.mipt.bit.platformer.game.controls;

import ru.mipt.bit.platformer.game.controls.command_processing.PlayerCommandHandler;

import java.util.List;

public class InputController {
    /*
    Класс, считывающий пользвательский ввод с различных устройств и перенаправляющий его на управление игровыми
    сущностями.
     */

    private final List<PlayerCommandHandler> handlers;

    public InputController(List<PlayerCommandHandler> handlers) {
        this.handlers = handlers;
    }

    public void handleAllPlayers(float deltaTime) {
        for (PlayerCommandHandler handler : handlers) {
            handler.handleSinglePlayer(deltaTime);
        }
    }
}
