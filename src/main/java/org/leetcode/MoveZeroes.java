package org.leetcode;

import java.util.Arrays;

public class MoveZeroes {

	/**
	 * 283. Move Zeroes
	 * Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
	 * Note that you must do this in-place without making a copy of the array.

	 * Example 1:
	 * Input: nums = [0,1,0,3,12]
	 * Output: [1,3,12,0,0]

	 * Example 2:
	 * Input: nums = [0]
	 * Output: [0]

	 * Constraints:
	 * 1 <= nums.length <= 104
	 * -231 <= nums[i] <= 231 - 1

	 * Follow up: Could you minimize the total number of operations done?
	 */
	// 오답
	public static int[] moveZeroes(int[] nums) {
		int n = nums.length;

		int left = 0;
		int right = 0;

		while (left < n && right < n) {

			while (nums[left] != 0 && left < n) {
				left ++;
				System.out.println("left: " + left);
			}

			while (nums[right] == 0 && right < n) {
				right ++;
				System.out.println("right: " + right);
			}

			// switch !
			int temp = nums[left];
			nums[left] = nums[right];
			nums[right] = temp;
			Arrays.stream(nums).forEach(System.out::println);

			left ++;
			right ++;
		}

		return nums;
	}

	public static int[] moveZeroes2(int[] nums) {
		int left = 0;

		for (int right = 0; right < nums.length; right++) {
			if (nums[right] != 0) {
				int temp = nums[right];
				nums[right] = nums[left];
				nums[left] = temp;
				left++;
			}
		}

		return nums;
	}

	public static void moveZeroes3(int[] nums) {
		if (nums == null || nums.length <= 1) return;

		int write = 0, read = 0;
		while (write < nums.length && read < nums.length) {
			if (nums[read] != 0) {
				nums[write] = nums[read];
				write++;
				read++;
			} else {
				read++;
			}
		}

		while (write < nums.length) {
			nums[write] = 0;
			write++;
		}
	}

	public static void main(String[] args) {
		Arrays.stream(moveZeroes2(new int[]{0, 1, 0, 3, 12})).forEach(System.out::println);
	}

}
