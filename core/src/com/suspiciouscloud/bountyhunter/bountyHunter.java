package com.suspiciouscloud.bountyhunter;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.suspiciouscloud.bountyhunter.screens.MainMenuScreen;

public class bountyHunter extends Game {
	public static final int GAME_SCREEN_WIDTH = 720;
	public static final int GAME_SCREEN_HEIGHT = 480;
	
	public SpriteBatch batch;
		
	@Override
	public void create () {
		batch = new SpriteBatch();
		this.setScreen(new MainMenuScreen(this));
	}

	@Override
	public void render () {
		super.render();
	}
	
	/*@Override
	public void dispose () {
		super.dispose();
	}*/
}
