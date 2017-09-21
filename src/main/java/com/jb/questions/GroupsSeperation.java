package com.jb.questions;

import java.util.List;

public class GroupsSeperation {

	/**
	 * Method to check whether list of elements can be separated into k equal groups
	 * 
	 * @param list
	 * @param k
	 * @return
	 */
	public static boolean checkPartition(List<Integer> list, int k) {
		
		if(list == null)
			return false;
		if (k == 1)
			return true;
		// If total number of partitions are more than list size, then partition not
		// possible
		int n = list.size();
		if (n < k)
			return false;

		// if total sum is not divisible then we can't partition
		Integer totalSum = list.stream().mapToInt(Integer::intValue).sum();
		int avgValue = totalSum / k;
		if (totalSum % k != 0)
			return false;

		int subset = totalSum / k;
		int[] subsetSum = new int[k];
		boolean[] taken = new boolean[n];

		for (int i = 0; i < k; i++) {
			subsetSum[i] = 0;
		}

		for (int i = 0; i < n; i++) {
			taken[i] = false;
		}

		subsetSum[0] = list.get(n - 1);
		taken[n - 1] = true;

		return checkPartitionRec(list, subsetSum, taken, subset, k, n, 0, n - 1);

	}

	private static boolean checkPartitionRec(List<Integer> list, int[] subsetSum, boolean[] taken, int subset, int k,
			int n, int curIdx, int limitIdx) {

		if (subsetSum[curIdx] == subset) {
			if (curIdx == k - 2)
				return true;
			return checkPartitionRec(list, subsetSum, taken, subset, k, n, curIdx + 1, n - 1);
		}

		for (int i = limitIdx; i >= 0; i--) {

			if (taken[i])
				continue;
			int tmp = subsetSum[curIdx] + list.get(i);

			if (tmp <= subset) {

				taken[i] = true;
				subsetSum[curIdx] += list.get(i);
				boolean nxt = checkPartitionRec(list, subsetSum, taken, subset, k, n, curIdx, i - 1);

				taken[i] = false;
				subsetSum[curIdx] -= list.get(i);

				if (nxt)
					return true;

			}
		}

		return false;
	}

}
