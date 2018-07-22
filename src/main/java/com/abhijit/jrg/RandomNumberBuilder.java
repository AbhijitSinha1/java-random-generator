package com.abhijit.jrg;

import java.lang.reflect.Array;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomNumberBuilder<T extends Number> {
	private int size;
	private T minLimit;
	private T maxLimit;
	private Class<T> clz;

	public RandomNumberBuilder(Class<T> clz) {
		this.clz = clz;
		size = 10;
	}

	public RandomNumberBuilder<T> setSize(int size) {
		this.size = size;
		return this;
	}

	public RandomNumberBuilder<T> setMinlimit(T minLimit) {
		this.minLimit = minLimit;
		return this;
	}

	public RandomNumberBuilder<T> setMaxlimit(T maxLimit) {
		this.maxLimit = maxLimit;
		return this;
	}

	public List<T> toList() {
		return IntStream.range(0, size)
			.boxed()
			.map(i -> RandomGenerator.number(minLimit, maxLimit, clz))
			.collect(Collectors.toList());
	}
	
	@SuppressWarnings("unchecked")
	public <R> List<R> toList(Function<? extends T, ? extends R> mapper) {
		return IntStream.range(0, size)
			.boxed()
			.map(i -> RandomGenerator.number(minLimit, maxLimit, clz))
			.map((Function<? super T, ? extends R>) mapper)
			.collect(Collectors.toList());
	}

	@SuppressWarnings("unchecked")
	public T[] toArray() {
		List<T> list = toList();
		T[] array = (T[]) Array.newInstance(clz, list.size());
		for (int i = 0; i < list.size(); i++) {
			array[i] = list.get(i);
		}
		return array;
	}
}
