package com.suspiciouscloud.bountyhunter.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.suspiciouscloud.bountyhunter.bountyHunter;

public class MainGameScreen implements Screen{
	public static final int SPEED = 150;
	public static final int STICKMAN_WIDTH_PIXEL = 40;
	public static final int STICKMAN_HEIGHT_PIXEL = 40;
	public static final int STICKMAN_WIDTH = STICKMAN_WIDTH_PIXEL * 3;
	public static final int STICKMAN_HEIGHT = STICKMAN_HEIGHT_PIXEL * 3;
	public static final float STICKMAN_ANIMATION_SPEED = 0.5f;
	
	public static final int FRAME_COLS = 4;
	public static final int FRAME_ROWS = 1;
	
	
	
	private double x;
	private double y;
	private bountyHunter game;
	
	Animation<TextureRegion> idleAnimation; // Must declare frame type (TextureRegion)
	Texture animationSheet;
	SpriteBatch spriteBatch;
	float stateTime;

	public MainGameScreen(bountyHunter game) {
		this.game = game;
		this.x = game.GAME_SCREEN_WIDTH / 2 - STICKMAN_HEIGHT / 2;
		this.y = 50;
		
		animationSheet = new Texture("stickMan_idle.png");
		
		TextureRegion[][] tmp = TextureRegion.split(animationSheet, 
				animationSheet.getWidth() / FRAME_COLS,
				animationSheet.getHeight() / FRAME_ROWS);

		// Place the regions into a 1D array in the correct order, starting from the top 
		// left, going across first. The Animation constructor requires a 1D array.
		TextureRegion[] walkFrames = new TextureRegion[FRAME_COLS * FRAME_ROWS];
		int index = 0;
		for (int i = 0; i < FRAME_ROWS; i++) {
			for (int j = 0; j < FRAME_COLS; j++) {
				walkFrames[index++] = tmp[i][j];
			}
		}

		// Initialize the Animation with the frame interval and array of frames
		walkAnimation = new Animation<TextureRegion>(0.025f, walkFrames);

		// Instantiate a SpriteBatch for drawing and reset the elapsed animation
		// time to 0
		spriteBatch = new SpriteBatch();
		stateTime = 0f;
	}
	
	@Override
	public void show() {
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		double deltaTime = Gdx.graphics.getDeltaTime();
		stateTime += deltaTime;
		
		if (Gdx.input.isKeyPressed(Keys.DOWN)) {
			y -= SPEED * deltaTime;
		}
		
		if (Gdx.input.isKeyPressed(Keys.UP)) {
			y += SPEED * deltaTime;
		}
		
		if (Gdx.input.isKeyPressed(Keys.LEFT)) {
			x -= SPEED * deltaTime;
		}
		
		if (Gdx.input.isKeyPressed(Keys.RIGHT)) {
			x += SPEED * deltaTime;
		}
		
		TextureRegion currentFrame = (TextureRegion) animations[animationStates].getKeyFrame(stateTime, true);
		
		
		game.batch.begin();
		
		game.batch.draw(currentFrame, x, y);
		
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
