package ru.geekbrains.orangespace.game;

import com.badlogic.gdx.Game;

import ru.geekbrains.orangespace.screen.MenuScreen;


/**
 * Основной клас игры
 */
public class Orange2DGame extends Game {
    @Override
    public void create() {
        setScreen(new MenuScreen(this));
    }

    //разобраться с переключением экранов(почему и как это удобно)
}
