package com.suspiciouscloud.bountyhunter.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.suspiciouscloud.bountyhunter.bountyHunter;

public class MainMenuScreen implements Screen{
	public static final int SPEED = 150;

	private static final int PLAY_BUTTON_HEIGHT = 50;
	private static final int PLAY_BUTTON_WIDTH = 150;
	private static final int PLAY_BUTTON_Y = 200;
	
	private static final int EXIT_BUTTON_HEIGHT = 50;
	private static final int EXIT_BUTTON_WIDTH = 150;
	private static final int EXIT_BUTTON_Y = 100;
	
	bountyHunter game;
	Texture newGameButtonActive;
	Texture newGameButtonInactive;
	Texture exitButtonActive;
	Texture exitButtonInactive;
	
	
	public MainMenuScreen(bountyHunter game) {
		this.game = game;
		newGameButtonActive = new Texture("newGameButtonActive.png");
		newGameButtonInactive = new Texture("newGameButtonInactive.png");
		exitButtonActive = new Texture("exitButtonActive.png");
		exitButtonInactive = new Texture("exitButtonInactive.png");
	}
	
	
	@Override
	public void show() {
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		game.batch.begin();
		
		int invYCoord = bountyHunter.GAME_SCREEN_HEIGHT - Gdx.input.getY();
		int newGameButtonXCoord = (int) Math.floor(bountyHunter.GAME_SCREEN_WIDTH / 2 - PLAY_BUTTON_WIDTH / 2);
		int exitButtonXCoord = (int) Math.floor(bountyHunter.GAME_SCREEN_WIDTH / 2 - EXIT_BUTTON_WIDTH / 2);
		
		if (Gdx.input.getX() > newGameButtonXCoord && Gdx.input.getX() < (newGameButtonXCoord + PLAY_BUTTON_WIDTH)
				&& invYCoord > PLAY_BUTTON_Y && invYCoord < (PLAY_BUTTON_Y + PLAY_BUTTON_HEIGHT)) {
			game.batch.draw(newGameButtonActive, newGameButtonXCoord , PLAY_BUTTON_Y, PLAY_BUTTON_WIDTH, PLAY_BUTTON_HEIGHT);
			if (Gdx.input.isTouched()) {
				this.dispose();
				game.setScreen(new MainGameScreen(this.game));
				
			}
		}else {
			game.batch.draw(newGameButtonInactive, newGameButtonXCoord , PLAY_BUTTON_Y, PLAY_BUTTON_WIDTH, PLAY_BUTTON_HEIGHT);
		}
		
		if (Gdx.input.getX() > exitButtonXCoord && Gdx.input.getX() < (exitButtonXCoord + EXIT_BUTTON_WIDTH)
				&& invYCoord > EXIT_BUTTON_Y && invYCoord < (EXIT_BUTTON_Y + EXIT_BUTTON_HEIGHT)) {
			game.batch.draw(exitButtonActive, exitButtonXCoord , EXIT_BUTTON_Y, EXIT_BUTTON_WIDTH, EXIT_BUTTON_HEIGHT);
			if (Gdx.input.isTouched()) {
				Gdx.app.exit();
			}
		}else {
			game.batch.draw(exitButtonInactive, exitButtonXCoord , EXIT_BUTTON_Y, EXIT_BUTTON_WIDTH, EXIT_BUTTON_HEIGHT);
			
		}
		
		game.batch.end();
		}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
	}

}
