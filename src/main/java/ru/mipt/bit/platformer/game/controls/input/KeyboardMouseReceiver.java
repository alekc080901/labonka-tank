package ru.mipt.bit.platformer.game.controls.input;

import com.badlogic.gdx.Gdx;
import ru.mipt.bit.platformer.game.controls.commands.Command;

import java.util.HashMap;
import java.util.Map;

public class KeyboardMouseReceiver implements InputReceiver {
    /*
    Класс, считывающий нажатие игроком клавиш клавиатуры.
     */

    private static final HashMap<Integer, Command> keyboardMouseInput = DefaultInputSettings.forKeyboardMouse();

    public Command receiveInput() {
        for (Map.Entry<Integer, Command> entry : keyboardMouseInput.entrySet()) {
            if (Gdx.input.isKeyPressed(entry.getKey())) {
                return entry.getValue();
            }
        }
        return null;
    }

}
