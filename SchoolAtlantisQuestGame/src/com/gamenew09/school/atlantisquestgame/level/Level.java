package com.gamenew09.school.atlantisquestgame.level;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.gamenew09.school.atlantisquestgame.util.Vector2;

public class Level {
	
	private BufferedImage[][] images = new BufferedImage[256][256];
	
	//TODO: Add functionality for entities.
	
	public Level(){
		
	}
	
	public Vector2 getSize(){
		return new Vector2(256, 256);
	}
	
	public void addTile(int x, int y, BufferedImage img){
		images[x][y] = img;
	}
	
	public void addSquareTiles(BufferedImage img, int x1, int y1, int x2, int y2){
		for(int y = 0; y < y1 + y2; y++){
			for(int x = 0; x < x1 + x2; x++){
				addTile(x, y, img);
			}
		}
	}
	
	public void draw(Graphics g){
		for(int y = 0; y < getSize().getY(); y++){
			for(int x = 0; x < getSize().getX(); x++){
				BufferedImage img = images[x][y];
				if(img != null){
					g.drawImage(img, x * 16, y * 16, null);
				}
			}
		}
	}
	
	public void update(){
		
	}
	
}
