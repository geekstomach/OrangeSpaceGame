package ru.geekbrains.orangespace.base;


import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;

/**
 * Базовый класс экрана
 */



public class Base2DScreen implements Screen, InputProcessor {

private Game game;

    public Base2DScreen(Game game) {
        this.game = game;
        Gdx.input.setInputProcessor(this);
        //сообщаем системе что класс Base2DScreen
        // и производные теперь являются InputProcessor
    }

    @Override
    public void show() {
        System.out.println("show");
    }

    @Override
    public void render(float delta) {

    }

    @Override
    public void resize(int width, int height) {
        System.out.println("resize w = " + width + ", h = " + height + ".");
    }

    @Override
    public void pause() {
        System.out.println("pause");
    }

    @Override
    public void resume() {
        System.out.println("resume");
    }


//когда экран закрывается
    @Override
    public void hide() {
        System.out.println("hide");
        dispose();
    }

    @Override
    public void dispose() {
        System.out.println("dispose");
    }
//-------------------------------------------------------------------------------------------
// методы от  интерфейса InputProcessor ()
    @Override
    public boolean keyDown(int keycode) {
        System.out.println("keyDown: keycode = " + keycode );
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        System.out.println("keyUp: keycode = " + keycode );
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        System.out.println("keyTyped: character = " + character );
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
/*
        System.out.println("touchDown: screenX = " + screenX + "screenY = " + screenY
                + "pointer = " + pointer + "button = " + button);
*/
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
/*
        System.out.println("touchUp: screenX = " + screenX + "screenY = " + screenY
                + "pointer = " + pointer + "button = " + button);
*/
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        System.out.println("touchDragged: screenX = " + screenX + "screenY = " + screenY
                + "pointer = " + pointer);
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        //System.out.println("mouseMoved: screenX = " + screenX + "screenY = " + screenY);
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        System.out.println("scrolled: amount = " + amount);
        return false;
    }
}
