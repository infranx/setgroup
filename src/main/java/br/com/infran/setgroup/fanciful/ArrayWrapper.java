package br.com.infran.setgroup.fanciful;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import org.apache.commons.lang.Validate;

public final class ArrayWrapper<E> {
	private E[] _array;

	public ArrayWrapper(E... elements) {
		this.setArray(elements);
	}

	public E[] getArray() {
		return this._array;
	}

	public void setArray(E[] array) {
		Validate.notNull(array, "The array must not be null.");
		this._array = array;
	}

	public boolean equals(Object other) {
		return !(other instanceof ArrayWrapper) ? false : Arrays.equals(this._array, ((ArrayWrapper)other)._array);
	}

	public int hashCode() {
		return Arrays.hashCode(this._array);
	}

	public static <T> T[] toArray(Iterable<? extends T> list, Class<T> c) {
		int size = -1;
		if (list instanceof Collection) {
			Collection coll = (Collection)list;
			size = coll.size();
		}

		if (size < 0) {
			size = 0;

			for(Iterator var4 = list.iterator(); var4.hasNext(); ++size) {
				T element = (T) var4.next();
			}
		}

		Object[] result = (Object[])Array.newInstance(c, size);
		int i = 0;

		Object element;
		for(Iterator var6 = list.iterator(); var6.hasNext(); result[i++] = element) {
			element = (Object)var6.next();
		}

		return (T[]) result;
	}
}