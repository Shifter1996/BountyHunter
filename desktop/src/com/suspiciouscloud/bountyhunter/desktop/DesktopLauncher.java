package com.suspiciouscloud.bountyhunter.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.suspiciouscloud.bountyhunter.bountyHunter;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		
		config.foregroundFPS = 60;
		config.width = bountyHunter.GAME_SCREEN_WIDTH;
		config.height = bountyHunter.GAME_SCREEN_HEIGHT;
		
		new LwjglApplication(new bountyHunter(), config);
	}
}
