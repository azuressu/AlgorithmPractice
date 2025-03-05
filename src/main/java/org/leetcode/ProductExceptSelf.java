package org.leetcode;

import java.util.Arrays;

public class ProductExceptSelf {

    /**
     * 238. Product of Array Except Self

     * Hint
     * Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].
     * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
     * You must write an algorithm that runs in O(n) time and without using the division operation.

     * Example 1
     * Input: nums = [1,2,3,4]
     * Output: [24,12,8,6]

     * Example 2:
     * Input: nums = [-1,1,0,-3,3]
     * Output: [0,0,9,0,0]

     * Constraints:
     * 2 <= nums.length <= 105
     * -30 <= nums[i] <= 30
     * The input is generated such that answer[i] is guaranteed to fit in a 32-bit integer.

     * Follow up:
     * Can you solve the problem in O(1) extra space complexity?
     * (The output array does not count as extra space for space complexity analysis.)
     */

    public static int[] productExceptSelf(int[] nums) {
        // O(n) 이라면 이중 for문 안됨 for을 두 번 돌리거나 해야할 듯 ?

        // 답을 담을 배열 생성
        int[] answer = new int [nums.length];

        // 일단 출력해보자 ..
        for (int num : nums) {
            System.out.println(num);
        }
        
        return null;
    }
    
    public static int[] productExceptSelf2(int[] nums) {
        // 정답 배열 생성 후 1로 초기화
        int[] output = new int [nums.length];
        for (int i=0; i<output.length; i++) {
            output[i] = 1;
        }
        
        // 왼쪽부터 시작
        // 왼쪽에 해당하는 값을 결과 원소로 집어넣고, 해당 위치에 맞는 num 원소를 곱해 left에 저장
        /**
         i	left   output[i]	left (left *= nums[i])
         0	 1	   1 × 1 = 1	left = 1 × 1 = 1
         1	 1	   1 × 1 = 1	left = 1 × 2 = 2
         2	 2	   1 × 2 = 2	left = 2 × 3 = 6
         3	 6	   1 × 6 = 6	left = 6 × 4 = 24
         */
        int left = 1;
        for (int i = 0; i < nums.length; i++) {
            output[i] *= left;
            System.out.println("output[i]: " + output[i]);
            left *= nums[i];
            System.out.println("left: " + left);
        }

        // 오른쪽부터 시작
        // 오른쪽에 해당하는 값을 결과 원소로 집어넣고, 해당 위치에 있는 num 원소를 곱해 right에 저장
        /**
         i	right	output[i]      right (right *= nums[i])
         3	 1  	6 × 1 = 6	   right = 1 × 4 = 4
         2	 4	    2 × 4 = 8	   right = 4 × 3 = 12
         1	 12	    1 × 12 = 12	   right = 12 × 2 = 24
         0	 24 	1 × 24 = 24	   right = 24 × 1 = 24
         */
        int right = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            output[i] *= right;
            System.out.println("output[i]: " + output[i]);
            right *= nums[i];
            System.out.println("right: " + right);
        }

        return output;
    }

    public static int[] productExceptSelf3(int[] nums) {
        int n = nums.length;

        int prefix[] = new int[n];
        int suffix[] = new int[n];

        prefix[0] = 1;
        suffix[n-1] = 1;

        for(int i = 1; i < n; i++){
            prefix[i] = prefix[i-1] * nums[i-1];
        }

        for(int j = n-2;j >= 0; j--){
            suffix[j] = suffix[j+1] * nums[j+1];
        }

        for(int i = 0; i < n; i++){
            nums[i] = prefix[i] * suffix[i];
        }

        return nums;
    }

    public int[] productExceptSelf4 (int[] nums) {

        int length = nums.length;

        int[] answer = new int[length];

        answer[0] = 1;
        for (int i = 1; i < length; i++) {
            answer[i] =  answer[i - 1] * nums[i - 1];
        }

        int R = 1;
        for (int i = length - 2; i >= 0; i--) {
            R =  R * nums[i + 1];
            answer[i] = answer[i] * R;
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println();
        Arrays.stream(productExceptSelf2(new int[]{-1, 1, 0, -3, 3})).forEach(System.out::println);
    }
}
