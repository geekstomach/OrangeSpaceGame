package ru.geekbrains.orangespace;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class OrangeSpace extends ApplicationAdapter {

	private Texture background;// Класс Texture декодирует файл изображения и загружает его в память графического процессора.
	private SpriteBatch batch; //SpriteBatch
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		background = new Texture("background.jpg");
		//Где-то пишут еще Gdx.files.internal , что это?

	}

	@Override
	public void render () { //после запуска метод вызывается 60 раз в сеунду
		Gdx.gl.glClearColor(1, 1, 1, 1); //SpriteBatch
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);//SpriteBatch
		//Все вызовы SpriteBatch для отрисовки должны быть заключены между методами begin() и end().
		// Вызовы методов для рисования другими средствами (не классом SpriteBatch)
		// не должно встречаться между методами begin() и end()
		batch.begin();//SpriteBatch
		batch.draw(background, 0, 0);//Созданная текстура передается в SpriteBatch для отрисовки.
		batch.end();//SpriteBatch
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		background.dispose();
	}
}
