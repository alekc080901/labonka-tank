package ru.mipt.bit.platformer.game.controls.input;

import ru.mipt.bit.platformer.game.controls.commands.Command;

public interface InputReceiver {
    /*
    Интерфейс считывания нажатия кнопок с устройства.
     */

    Command receiveInput();
}
