package com.gamenew09.school.atlantisquestgame.util;

import java.awt.Rectangle;

public class Vector2 {
	
	private float x, y;
	
	public Vector2(float x, float y){
		this.x = x;
		this.y = y;
	}
	
	public Vector2 add(Vector2 vector){
		this.x += vector.x;
		this.y += vector.y;
		return this;
	}
	
	public Vector2 subtract(Vector2 vector){
		this.x -= vector.x;
		this.y -= vector.y;
		return this;
	}
	
	public Vector2 mutiply(Vector2 vector){
		this.x *= vector.x;
		this.y *= vector.y;
		return this;
	}
	
	public Vector2 divide(Vector2 vector){
		this.x /= vector.x;
		this.y /= vector.y;
		return this;
	}

	public float getX() {
		return x;
	}

	public Vector2 setX(float x) {
		this.x = x;
		return this;
	}

	public float getY() {
		return y;
	}

	public Vector2 setY(float y) {
		this.y = y;
		return this;
	}
	
	public Vector2 setVector(Vector2 vec){
		this.x = vec.x;
		this.y = vec.y;
		return this;
	}

	public Rectangle toRectangle(int i, int j) {
		return new Rectangle((int)x, (int)y, i, j);
	}

	public Vector2 reverse() {
		x = -x;
		y = -y;
		return this;
	}
	
	public String toString(){
		return "[X: "+x+", Y: "+y+"]";
	}

	public Vector2 mutiply(float m) {
		this.x *= m;
		this.y *= m;
		return this;
	}
	
}
