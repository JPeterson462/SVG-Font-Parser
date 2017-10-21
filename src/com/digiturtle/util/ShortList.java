package com.digiturtle.util;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;

// Based on OpenJDK implementation of ArrayList
@SuppressWarnings("serial")
public class ShortList extends PrimitiveList<Short> {
	
	private short[] elementData;
	
	public ShortList(int initialCapacity) {
		super();
		if (initialCapacity < 0) {
			throw new IllegalArgumentException("Illegal Capacity: " + initialCapacity);
		}
		elementData = new short[initialCapacity];
	}
	
	public ShortList(short[] data) {
		super();
		elementData = Arrays.copyOf(data, data.length);
		size = elementData.length;
	}
	
	public ShortList() {
		this(10);
	}
	
	public ShortList(Collection<? extends Short> c) {
		elementData = new short[c.size()];
		Iterator<? extends Short> itr = c.iterator();
		int i = 0;
		while (itr.hasNext()) {
			elementData[i++] = itr.next();
		}
		size = c.size();
	}
	
	public void shift(int index, int offset, int size) {
		System.arraycopy(elementData, index, elementData, index + offset, size);
	}
	
	public void trimToSize() {
		modCount++;
		int oldCapacity = elementData.length;
		if (size < oldCapacity) {
			elementData = Arrays.copyOf(elementData, size);
		}
	}
	
	public void ensureCapacity(int minCapacity) {
		modCount++;
		int oldCapacity = elementData.length;
		if (minCapacity > oldCapacity) {
//			short[] oldData = elementData;
			int newCapacity = (oldCapacity * 3) / 2 + 1;
			if (newCapacity < minCapacity) {
				newCapacity = minCapacity;
			}
			elementData = Arrays.copyOf(elementData, newCapacity);
		}
	}
	
	public Object clone() {
		return new ShortList(elementData);
	}
	
	public Object[] toArray() {
		short[] rawValues = Arrays.copyOf(elementData, size);
		Short[] values = new Short[rawValues.length];
		for (int i = 0; i < rawValues.length; i++) {
			values[i] = rawValues[i];
		}
		return values;
	}
	
	@SuppressWarnings("unchecked")
	public <T> T[] toArray(T[] a) {
		if (a.length < size) {
			return (T[]) toArray();
		}
		for (int i = 0; i < a.length; i++) {
			a[i] = (T) (Short) elementData[i];
		}
		if (a.length > size) {
			a[size] = null;
		}
		return a;
	}
	
	protected Short elementData(int index) {
		return elementData[index];
	}
	
	protected void elementData(int index, Short value) {
		elementData[index] = value;
	}

	private void writeObject(ObjectOutputStream s) throws IOException {
		int expectedModCount = modCount;
		s.defaultWriteObject();
		s.writeInt(elementData.length);
		for (int i = 0; i < size; i++) {
			s.writeShort(elementData[i]);
		}
		if (modCount != expectedModCount) {
			throw new ConcurrentModificationException();
		}
	}
	
	private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
		s.defaultReadObject();
		int arrayLength = s.readInt();
		short[] a = elementData = new short[arrayLength];
		for (int i = 0; i < size; i++) {
			a[i] = s.readShort();
		}
	}
	
}
