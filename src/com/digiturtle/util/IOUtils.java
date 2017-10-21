package com.digiturtle.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;

import org.lwjgl.BufferUtils;

public class IOUtils {
	
	public static ByteBuffer read(InputStream stream) throws IOException {
		ByteArrayOutputStream bytes = new ByteArrayOutputStream();
		copy(stream, bytes, 1024);
		byte[] data = bytes.toByteArray();
		ByteBuffer buffer = BufferUtils.createByteBuffer(data.length);
		buffer.put(data);
		buffer.flip();
		return buffer;
	}
	
	public static void copy(InputStream in, OutputStream out, int buffer) throws IOException {
		byte[] chunk = new byte[buffer];
		int read = 0;
		while ((read = in.read(chunk)) > 0) {
			out.write(chunk, 0, read);
		}
	}

}
