package org.w3c.dom.fonts.opengl;

import java.nio.ByteBuffer;

import org.lwjgl.opengl.GL11;

public class GLBitmap {
	
	private int width, height, glId;
	
	@SuppressWarnings("unused")
	private ByteBuffer pixels;
	
	private float scale;
	
	public GLBitmap(int width, int height, ByteBuffer pixels, float scale) {
		this.pixels = pixels;
		this.width = width;
		this.height = height;
		this.scale = scale;
		GL11.glEnable(GL11.GL_TEXTURE_2D);
		glId = GL11.glGenTextures();
		GL11.glBindTexture(GL11.GL_TEXTURE_2D, glId);
		GL11.glPixelStorei(GL11.GL_UNPACK_ALIGNMENT, 1);
		GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MAG_FILTER, GL11.GL_LINEAR);
		GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MIN_FILTER, GL11.GL_LINEAR);
		GL11.glTexImage2D(GL11.GL_TEXTURE_2D, 0, GL11.GL_ALPHA, width, height, 0, GL11.GL_ALPHA, GL11.GL_UNSIGNED_BYTE, pixels);
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
	
	public int getID() {
		return glId;
	}
	
	public float getScale() {
		return scale;
	}
	
	public void dispose() {
		pixels = null; // Let GC do it's job
		GL11.glDeleteTextures(glId);
	}

}
