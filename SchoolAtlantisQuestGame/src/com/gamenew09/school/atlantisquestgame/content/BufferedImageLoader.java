package com.gamenew09.school.atlantisquestgame.content;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class BufferedImageLoader {
	
	private BufferedImage image;
	
	public BufferedImage load(String path) throws IOException{
		image = ImageIO.read(getClass().getResource(path));
		return image;
	}
	
}
