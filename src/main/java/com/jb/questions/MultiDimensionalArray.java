package com.jb.questions;

public class MultiDimensionalArray {

	Long[][] mArray;

	MultiDimensionalArray(Long[][] mArray) {
		this.mArray = mArray;
	}

	// Assumed this method returns value
	public static Long getValue(int row, int column) {

		// ..

		return null;
	}

	public static Long sum(MultiDimensionalArray mArray, int[] lengthOfDimension) {

		long sum = 0;

		for (int i = 0; i < lengthOfDimension.length; i++) {
			for (int j = 0; j < lengthOfDimension[i]; j++) {
				sum += getValue(i, j);
			}
		}
		return sum;

	}

}
