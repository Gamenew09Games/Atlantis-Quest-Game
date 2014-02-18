package com.gamenew09.school.atlantisquestgame.screen;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import com.gamenew09.school.atlantisquestgame.content.ContentLoader;
import com.gamenew09.school.atlantisquestgame.graphic.SpriteSheet;
import com.gamenew09.school.atlantisquestgame.level.Level;
import com.gamenew09.school.atlantisquestgame.util.Gravities;
import com.gamenew09.school.atlantisquestgame.util.Vector2;

public class MainMenuScreen extends GameScreen {
	
	SpriteSheet playerSheet;
	SpriteSheet wallSheet;
	
	BufferedImage player1;
	Level lvl;
	
	Vector2 playerPos = new Vector2(0, 0);
	Vector2 playerVel = new Vector2(0, 0);
	
	public void loadContent(ContentLoader loader){ 
		lvl = new Level();
		try {
			playerSheet = loader.loadSpriteSheet("/spritesheets/player.png");
			wallSheet = loader.loadSpriteSheet("/spritesheets/walls.png");
		} catch (IOException e) { }
		player1 = playerSheet.grabImage(0, 0, 16, 16);
		lvl.addSquareTiles(wallSheet.grabImage(0, 0, 16, 16), 0, 0, 480, 16);
	}
	
	public void draw(Graphics g){
		super.draw(g);
		lvl.draw(g);
		g.drawImage(player1, (int)playerPos.getX(), (int)playerPos.getY(), null);
	}
	
	float gr = 0;
	
	public void update(double delta){
		gr += 0.00005f;
		playerVel.add(new Vector2(0, Gravities.EARTH * gr));
		//System.out.println(playerVel.toString());
		playerPos.add(playerVel.mutiply((float)delta));
		lvl.update();
		super.update(delta);
	}
	
}
