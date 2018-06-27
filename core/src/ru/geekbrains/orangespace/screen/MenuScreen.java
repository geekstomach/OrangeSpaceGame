package ru.geekbrains.orangespace.screen;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;

import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import ru.geekbrains.orangespace.base.Base2DScreen;

/**
 * Экран меню
 */

public class MenuScreen extends Base2DScreen  {

    SpriteBatch batch;


    private Texture background;
    private Texture beetle;
    Vector2 target;
    Vector2 velocity;
    Vector2 direction;
    Vector2 location;
    Vector2 movement;
    float speed = 10;

    public MenuScreen(Game game) {
        super(game);
    }

    @Override
    public void show() { //метод равносилен методу create?
        super.show();
        batch = new SpriteBatch();

        background = new Texture("backgroundPaper.jpg");
        beetle = new Texture("beetle1.png");


        target = new Vector2(Gdx.graphics.getWidth()/2,Gdx.graphics.getHeight()/2);
        direction = new Vector2();
        movement = new Vector2();
        velocity = new Vector2();
        location = new Vector2(Gdx.graphics.getWidth()/2,Gdx.graphics.getHeight()/2);

    }

    @Override
    public void render(float delta) {
        super.render(delta);

        Gdx.gl.glClearColor(1,0,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);




        //нормализованный вектор направления от положения до точки касания.
        direction.set(target).sub(location).nor();
        velocity.set(direction).scl(speed);
        location.add(velocity);
        if (location.dst2(target) > velocity.len2()) {
            location.add(velocity);
        } else {
            location.set(target);
        }

        batch.begin();
        batch.draw(background,0,0);
        batch.draw(beetle,location.x-beetle.getWidth()/2,(Gdx.graphics.getHeight()-location.y)-beetle.getWidth()/2);
        batch.end();
         // game.setScreen(new GameScreen());
    }

    @Override
    public void dispose() {
        background.dispose();
        beetle.dispose();
        batch.dispose();
        super.dispose();
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {

       target.set(screenX,screenY);


        return true;
    }
}
