package com.gamenew09.school.atlantisquestgame;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFrame;

import com.gamenew09.school.atlantisquestgame.content.ContentLoader;
import com.gamenew09.school.atlantisquestgame.graphic.SpriteSheet;
import com.gamenew09.school.atlantisquestgame.level.Level;
import com.gamenew09.school.atlantisquestgame.screen.MainMenuScreen;

public class MainGame extends Canvas implements Runnable{
	
	private static JFrame frame;
	
	ArrayList<GameModule> modules = new ArrayList<GameModule>();
	
	Thread thread;
	boolean running = false;
	
	public static int WIDTH = 480;
	public static int HEIGHT= WIDTH / 16 * 9;
	public static int SCALE = 2;
	public static final String TITLE = "Atlantis Game Project";
	
	private BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
	
	public static void main(String[] args){
		MainGame game = new MainGame();
		
		game.setPreferredSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
		game.setMaximumSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
		game.setMinimumSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
		
		frame = new JFrame();
		frame.add(game);
		frame.pack();
		frame.setResizable(false);
		//frame.setSize(new Dimension(WIDTH, HEIGHT));
		frame.setTitle(TITLE);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		game.start();
	}
	
	private synchronized void start(){
		if(running)
			return;
		
		running = true;
		thread = new Thread(this);
		thread.start();
	}
	
	private synchronized void stop(){
		if(!running){
			return;
		}
		
		running = false;
		try{
			thread.join();
		}catch(InterruptedException e){
			e.printStackTrace();
		}
		System.exit(1);
	}
	
	@Override
	public void run() {
		try{
			init();
		}catch(Exception e){
			e.printStackTrace();
		}
		long lastTime = System.nanoTime();
		final double amountOfTicks = 60;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		
		int updates = 0;
		int frames = 0;
		long timer = System.currentTimeMillis();
		
		while(running){
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			if(delta >= 1){
				update(delta);
				updates++;
				delta--;
			}
			render();
			frames++;
			
			if(System.currentTimeMillis() - timer > 1000){
				timer += 1000;
				System.out.println(updates + " Ticks, "+frames+" FPS");
				updates = 0;
				frames = 0;
			}
		}
		stop();
	}
	
	public void init(){
		modules.add(new MainMenuScreen());
		ContentLoader loader = new ContentLoader();
		if(modules.size() > 0){
			for(GameModule module : modules){
				module.loadContent(loader);
			}
		}
	}
	
	private void update(double delta){
		if(modules.size() > 0){
			for(GameModule module : modules){
				module.update(delta);
			}
		}
	}
	
	int rep = 0;
	
	private void render() {
		BufferStrategy bs = this.getBufferStrategy();
		
		if(bs == null){
			createBufferStrategy(3);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		image.getGraphics().clearRect(0, 0, this.getWidth(), this.getHeight());
		
		//////
		if(modules.size() > 0){
			for(GameModule module : modules){
				module.draw(image.getGraphics());
			}
		}
		g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
		//////
		g.dispose();
		bs.show();
	}
	
}
