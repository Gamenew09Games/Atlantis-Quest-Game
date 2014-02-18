package com.gamenew09.school.atlantisquestgame.graphic;

import java.awt.Graphics;

public class ThreeDimensionalDrawing {
	
	private Graphics g;
	
	public ThreeDimensionalDrawing(Graphics g){
		this.g = g;
	}
	
	public void draw3DRectangle(int x, int y, int z, int width, int height){
		g.drawRect(x, y, width, height);
		g.drawRect(x + width, y, 100, height + 20);
	}
	
}
