package com.gamenew09.school.atlantisquestgame;

import java.awt.Graphics;
import java.util.ArrayList;

import com.gamenew09.school.atlantisquestgame.content.ContentLoader;

public abstract class GameModule {
	
	private ArrayList<GameModule> subModules = new ArrayList<GameModule>();
	
	public void addModule(GameModule gm){
		subModules.add(gm);
	}
	
	public void loadContent(ContentLoader loader){ }
	
	public void draw(Graphics g){
		if(subModules.size() > 0){
			for(GameModule gm : subModules){
				gm.draw(g);
			}
		}
	}
	
	public void update(double delta){
		if(subModules.size() > 0){
			for(GameModule gm : subModules){
				gm.update(delta);
			}
		}
	}
	
}
