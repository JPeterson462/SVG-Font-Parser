package com.digiturtle.util;

import java.io.Serializable;
import java.util.AbstractList;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;

public abstract class PrimitiveList<T> extends AbstractList<T> implements List<T>, RandomAccess, Cloneable, Serializable {

	private static final long serialVersionUID = 314159265358L;

	protected int size;
	
	public abstract void shift(int index, int offset, int size);
	
	public abstract void ensureCapacity(int minCapacity);
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public boolean contains(Object o) {
		return indexOf(o) >= 0;
	}
	
	protected abstract T elementData(int index);

	protected abstract void elementData(int index, T value);
	
	public T get(int index) {
		rangeCheck(index);
		return elementData(index);
	}
	
	public T set(int index, T element) {
		rangeCheck(index);
		T oldValue = elementData(index);
		elementData(index, element);
		return oldValue;
	}
	
	public boolean add(T t) {
		ensureCapacity(size + 1);
		elementData(size++, t);
		return true;
	}
	
	public void add(int index, T element) {
		rangeCheckForAdd(index);
		ensureCapacity(size + 1);
		shift(index, 1, size - index);
		elementData(index, element);
		size++;
	}
	
	public T remove(int index) {
		rangeCheck(index);
		modCount++;
		T oldValue = elementData(index);
		int numMoved = size - index - 1;
		if (numMoved > 0) {
			shift(index + 1, -1, numMoved);
		}
		size--;
		elementData(size, null);
		return oldValue;
	}
	
	public boolean remove(Object o) {
		if (o == null) {
			for (int index = 0; index < size; index++) {
				if (elementData(index) == null) {
					fastRemove(index);
					return true;
				}
			}
		} else {
			for (int index = 0; index < size; index++) {
				if (o.equals(elementData(index))) {
					fastRemove(index);
					return true;
				}
			}
		}
		return false;
	}
	
	private void fastRemove(int index) {
		modCount++;
		int numMoved = size - index - 1;
		if (numMoved > 0) {
			shift(index, 1, numMoved);
		}
		size--;
		elementData(size, null);
	}
	
	public void clear() {
		modCount++;
		for (int i = 0; i < size; i++) {
			elementData(i, null);
		}
		size = 0;
	}

	public int indexOf(Object o) {
		if (o == null) {
			return -1;
		}
		for (int i = 0; i < size; i++) {
			if (elementData(i) == o) {
				return i;
			}
		}
		return -1;
	}
	
	public int lastIndexOf(Object o) {
		if (o == null) {
			return -1;
		}
		for (int i = size - 1; i >= 0; i--) {
			if (elementData(i) == o) {
				return i;
			}
		}
		return -1;
	}
	
	@SuppressWarnings("unchecked")
	public boolean addAll(Collection<? extends T> c) {
		Object[] a = c.toArray();
		int numNew = a.length;
		ensureCapacity(size + numNew);
		for (int i = 0; i < numNew; i++) {
			elementData(size + i, (T) a[i]);
		}
		size += numNew;
		return numNew != 0;
	}
	
	@SuppressWarnings("unchecked")
	public boolean addAll(int index, Collection<? extends T> c) {
		rangeCheckForAdd(index);
		Object[] a = c.toArray();
		int numNew = a.length;
		ensureCapacity(size + numNew);
		int numMoved = size - index;
		if (numMoved > 0) {
			shift(index, numNew, numMoved);
		}
		for (int i = 0; i < numNew; i++) {
			elementData(size + i, (T) a[i]);
		}
		size += numNew;
		return numNew != 0;
	}
	
	protected void removeRange(int fromIndex, int toIndex) {
		modCount++;
		int numMoved = size - toIndex;
		shift(toIndex, fromIndex - toIndex, numMoved);
		int newSize = size - (toIndex - fromIndex);
		while (size != newSize) {
			size--;
			elementData(size, null);
		}
	}
	
	private void rangeCheck(int index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
		}
	}
	
	private void rangeCheckForAdd(int index) {
		if (index > size || index < 0) {
			throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
		}
	}
	
	private String outOfBoundsMsg(int index) {
		return "Index: " +index + ", Size: " + size;
	}
	
	public boolean removeAll(Collection<?> c) {
		return batchRemove(c, false);
	}
	
	public boolean retainAll(Collection<?> c) {
		return batchRemove(c, true);
	}
	
	private boolean batchRemove(Collection<?> c, boolean complement) {
		int r = 0, w = 0;
		boolean modified = false;
		try {
			for (; r < size; r++) {
				if (!(c.contains(elementData(r)) ^ complement)) { // ==
					elementData(w, elementData(r));
					w++;
				}
			}
		} finally {
			if (r != size) {
				shift(r, w - r, size - r);
				w += size - r;
			}
			if (w != size) {
				for (int i = w; i < size; i++) {
					elementData(i, null);
				}
				modCount += size - w;
				size = w;
				modified = true;
			}
		}
		return modified;
	}
	
	public ListIterator<T> listIterator(int index) {
		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException("Index: " + index);
		}
		return new ListItr(index);
	}
	
	public ListIterator<T> listIterator() {
		return new ListItr(0);
	}
	
	public Iterator<T> iterator() {
		return new Itr();
	}
	
	private class Itr implements Iterator<T> {
		
		protected int cursor, lastRet = -1, expectedModCount = modCount;

		@Override
		public boolean hasNext() {
			return cursor != size;
		}

		@Override
		public T next() {
			checkForComodification();
			int i = cursor;
			if (i >= size) {
				throw new NoSuchElementException();
			}
			cursor = i + 1;
			return elementData(lastRet = i);
		}
		
		public void remove() {
			if (lastRet < 0) {
				throw new IllegalStateException();
			}
			checkForComodification();
			try {
				PrimitiveList.this.remove(lastRet);
				cursor = lastRet;
				lastRet = -1;
				expectedModCount = modCount;
			} catch (IndexOutOfBoundsException e) {
				throw new ConcurrentModificationException();
			}
		}
		
		final void checkForComodification() {
			if (modCount != expectedModCount) {
				throw new ConcurrentModificationException();
			}
		}
		
	}
	
	private class ListItr extends Itr implements ListIterator<T> {
		
		ListItr(int index) {
			super();
			cursor = index;
		}

		@Override
		public void add(T t) {
			checkForComodification();
			try {
				int i = cursor;
				PrimitiveList.this.add(i, t);
				cursor = i + 1;
				lastRet = -1;
				expectedModCount = modCount;
			} catch (IndexOutOfBoundsException e) {
				throw new ConcurrentModificationException();
			}
		}

		@Override
		public boolean hasPrevious() {
			return cursor != 0;
		}

		@Override
		public int nextIndex() {
			return cursor;
		}

		@Override
		public T previous() {
			checkForComodification();
			int i = cursor - 1;
			if (i < 0) {
				throw new NoSuchElementException();
			}
			cursor = i;
			return elementData(lastRet = i);
		}

		@Override
		public int previousIndex() {
			return cursor - 1;
		}

		@Override
		public void set(T t) {
			if (lastRet < 0) {
				throw new IllegalStateException();
			}
			checkForComodification();
			try {
				PrimitiveList.this.set(lastRet, t);
			} catch (IndexOutOfBoundsException e) {
				throw new ConcurrentModificationException();
			}
		}
		
	}
	
	public List<T> subList(int fromIndex, int toIndex) {
		throw new IllegalStateException("Primitive lists cannot use subList()");
	}
	
}
