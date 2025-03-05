package org.leetcode;

public class IncreasingTriplet {

	/**
	 * 334. Increasing Triplet Subsequence
	 * Given an integer array nums, return true if there exists a triple of indices (i, j, k) such that i < j < k and nums[i] < nums[j] < nums[k].
	 * If no such indices exists, return false.

	 * Example 1:
	 * Input: nums = [1,2,3,4,5]
	 * Output: true
	 * Explanation: Any triplet where i < j < k is valid.

	 * Example 2:
	 * Input: nums = [5,4,3,2,1]
	 * Output: false
	 * Explanation: No triplet exists.

	 * Example 3:
	 * Input: nums = [2,1,5,0,4,6]
	 * Output: true
	 * Explanation: The triplet (3, 4, 5) is valid because nums[3] == 0 < nums[4] == 4 < nums[5] == 6.
	 *
	 * Constraints:
	 * 1 <= nums.length <= 5 * 105
	 * -231 <= nums[i] <= 231 - 1

	 * Follow up: Could you implement a solution that runs in O(n) time complexity and O(1) space complexity?
	 */
	// O(n) 시간 복잡도 - 처리 불가
	public static boolean increasingTriplet(int[] nums) {
		int num = Integer.MIN_VALUE;
		int count = 0;

		for (int i = 0; i<nums.length; i++) {
			if (i != 0 && num < nums[i]) {
				num = nums[i];
				count ++;
			} else if (i != 0 && nums[i-1] > nums[i] && count != 0){
				num = nums[i];
				count ++;
			} else {
				count = 0;
			}
		}

		return count >= 3 ? true : false;
	}

	// 정답
	public static boolean increasingTriplet2(int[] nums) {
		if (nums.length < 3) {
			return false;
		}
		
		// 큰 숫자로 초기화
		int first = Integer.MAX_VALUE, second = Integer.MAX_VALUE;

		for (int n : nums) {
			// n이 first보다 작다면 first를 n으로 초기화
			if (n <= first) {
				first = n;
			// n이 second보다 작다면 second를 n으로 초기화
			} else if (n <= second) {
				second = n;
			} else {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		System.out.println(increasingTriplet2(new int[] {5,4,3,2,1}));
	}
}
