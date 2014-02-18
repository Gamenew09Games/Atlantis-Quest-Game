package com.gamenew09.school.atlantisquestgame.graphic;

import java.awt.image.BufferedImage;

public class SpriteSheet {
	
	private BufferedImage image;
	
	public SpriteSheet(BufferedImage image){
		this.image = image;
	}
	
	public BufferedImage getSpriteSheetImage(){
		return image;
	}
	
	public BufferedImage grabImage(int col, int row, int width, int height){
		final int TILE_SIZE = 16;
		col++;
		row++;
		BufferedImage img = image.getSubimage((col * TILE_SIZE) - TILE_SIZE, (row * TILE_SIZE) - TILE_SIZE, width, height);
		return img;
	}
	
}
