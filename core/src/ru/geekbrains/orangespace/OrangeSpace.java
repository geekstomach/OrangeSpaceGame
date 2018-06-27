package ru.geekbrains.orangespace;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class OrangeSpace extends ApplicationAdapter {

//Для задания координат используются числа с плавающей точкой,
// float используется чаще чем double, это повышпет производительность
	private SpriteBatch batch; //SpriteBatch

	private Sprite backgroundSprite;// Класс Texture декодирует файл изображения и загружает его в память графического процессора.
	private Sprite winTextSprite;

	private Sprite spaceshipSprite;
	private Sprite targetSprite;

	private boolean win;

	Texture beetle;
	Vector2 position;
	Vector2 velocity;
	
	@Override
	public void create () { //метод инициализирует переменные и загружает текстуры
		//загружаем текстуры различных элементов, в предь лучше делать все в одном файле
//Gdx.files.internal чем лучше?
//Также существует FileHandle
		batch = new SpriteBatch();
//Sprite инициализируется объектом Texture
		backgroundSprite = new Sprite(new Texture("background.jpg"));
		backgroundSprite.setPosition(0,0);

		spaceshipSprite = new Sprite(new Texture("mouse.png"));
		 spaceshipSprite.setPosition(20,20);

		targetSprite = new Sprite(new Texture("cheese.png"));
		targetSprite.setPosition(400,300);


		winTextSprite = new Sprite(new Texture("you-win.png"));
		winTextSprite.setPosition(170,60);

		win = false;



		beetle = new Texture("beetle.png");
		position = new Vector2(0f,0f);
		velocity = new Vector2(0.5f, 0.3f);
	}

	@Override
	public void render () { //метод содержит три основных блока кода process input, update, render
		// после запуска метод вызывается 60 раз в сеунду

		// проверяем действия пользователя, при нажатии кнопок премещаем корабль
		if (Gdx.input.isKeyPressed(Input.Keys.LEFT))
			spaceshipSprite.translateX(-1);
		if (Gdx.input.isKeyPressed(Input.Keys.RIGHT))
			spaceshipSprite.translateX(1);
		if (Gdx.input.isKeyPressed(Input.Keys.UP))
			spaceshipSprite.translateY(1);
		if (Gdx.input.isKeyPressed(Input.Keys.DOWN))
			spaceshipSprite.translateY(-1);


		//проверяем достиг ли корабль цели
		Rectangle targetRectangle = targetSprite.getBoundingRectangle();
		Rectangle spaceshipRectangle = targetSprite.getBoundingRectangle();

		if(targetRectangle.contains(spaceshipRectangle))
			win = true;


		//очистка экрана и отрисовка графики
		Gdx.gl.glClearColor(1, 1, 1, 1); //эта процедура происходит каждое прохожение тетода
		// отрисовывает закаршенный прямугольник

		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);//SpriteBatch
		//Все вызовы SpriteBatch для отрисовки должны быть заключены между методами begin() и end().
		// Вызовы методов для рисования другими средствами (не классом SpriteBatch)
		// не должно встречаться между методами begin() и end()



		batch.begin();//SpriteBatch Последовательность имеет значение
		//Созданная текстура передается в SpriteBatch для отрисовки.
		//batch.draw(background, 0, 0,2560,1440);
		backgroundSprite.draw(batch);
		targetSprite.draw(batch);
		spaceshipSprite.draw(batch);

		if (win)
			winTextSprite.draw(batch);

		batch.draw(beetle,position.x,position.y);

		batch.end();//SpriteBatch

		position.add(velocity);
	}
	
	@Override
	public void dispose () {
		batch.dispose();

	}
}
