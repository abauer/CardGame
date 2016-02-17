package com.cardgame.game.desktop;

import com.badlogic.gdx.Files;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.cardgame.game.CardGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = CardGame.TITLE;
		config.width = CardGame.WIDTH * CardGame.SCALE;
		config.height = CardGame.HEIGHT * CardGame.SCALE;
		config.resizable = false;
		config.addIcon("icon_128.png", Files.FileType.Internal);
		config.addIcon("icon_32.png", Files.FileType.Internal);
		config.addIcon("icon_16.png", Files.FileType.Internal);
		new LwjglApplication(new CardGame(), config);
	}
}
