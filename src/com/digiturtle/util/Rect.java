package com.digiturtle.util;

import java.util.HashMap;

public class Rect {
	
	private float x, y, width, height;
	
	private float s0, t0, s1, t1;
	
	private HashMap<Character, Float> advance;
	
	public Rect(float x, float y, float width, float height, float s0, float t0, float s1, float t1, HashMap<Character, Float> advance) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.s0 = s0;
		this.t0 = t0;
		this.s1 = s1;
		this.t1 = t1;
		this.advance = advance;
	}
	
	public float getX() {
		return x;
	}
	
	public float getY() {
		return y;
	}
	
	public float getWidth() {
		return width;
		
	}

	public float getHeight() {
		return height;
	}

	public float getS0() {
		return s0;
	}

	public float getT0() {
		return t0;
	}

	public float getS1() {
		return s1;
	}

	public float getT1() {
		return t1;
	}
	
	public HashMap<Character, Float> getAdvance() {
		return advance;
	}
	
}
