package com.gamenew09.school.atlantisquestgame.content;

import java.awt.image.BufferedImage;
import java.io.IOException;

import com.gamenew09.school.atlantisquestgame.graphic.SpriteSheet;

public class ContentLoader {
	
	public SpriteSheet loadSpriteSheet(String path) throws IOException{
		BufferedImageLoader loader = new BufferedImageLoader();
		BufferedImage img = loader.load(path);
		SpriteSheet spriteSheet = new SpriteSheet(img);
		return spriteSheet;
	}
	
}
