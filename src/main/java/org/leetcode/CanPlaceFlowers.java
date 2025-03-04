package main.java.org.leetcode;

public class CanPlaceFlowers {

    /**
     * 605. Can Place Flowers
     * You have a long flowerbed in which some of the plots are planted, and some are not. However, flowers cannot be planted in adjacent plots
     * Given an integer array flowerbed containing 0's and 1's, where 0 means empty and 1 means not empty, and an integer n, return true if n new flowers can be planted in the flowerbed without violating the no-adjacent-flowers rule and false otherwise.

     * Example 1
     * Input: flowerbed = [1,0,0,0,1], n = 1
     * Output: true

     * Example 2
     * Input: flowerbed = [1,0,0,0,1], n = 2
     * Output: false

     * Constraints
         * 1 <= flowerbed.length <= 2 * 104
         * flowerbed[i] is 0 or 1.
         * There are no two adjacent flowers in flowerbed.
         * 0 <= n <= flowerbed.length
     */

    // 내 정답 (여기서는 되는데 사이트에서 안돌아감)
    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = 0;

        for (int i=1; i<flowerbed.length-2; i++) {
            if (flowerbed[i] == 1) continue;
            // 그럼 둘 다 1이 아닌 경우로 넘어올 것
            else {
                if (flowerbed[i+1] == 1 && i+1 != flowerbed.length-1) continue;
                else {
                    count ++;
                    flowerbed[i+1] = 1;
                }
            }
        }

        return count == n;
    }
    
    // 다른 답안
    private static boolean canPlaceFlowers2(int[] flowerbed, int n) {
        for (int i = 0; i < flowerbed.length; i++) {
            boolean left = (i == 0) || (flowerbed[i - 1] == 0);
            boolean right = (i == flowerbed.length - 1) || (flowerbed[i + 1] == 0);

            if (left && right && flowerbed[i] == 0) {
                flowerbed[i] = 1;
                n--;
            }
        }
        return n <= 0;
    }

    // 수정해서 오류난 답안 [0,0,1,0,0] n=1 false-> true가 나옴
    private static boolean canPlaceFlowers3(int[] flowerbed, int n) {
        int count = 0;

        for (int i=0; i<flowerbed.length; i++) {
            boolean left = (i == 0) || flowerbed[i-1] == 0;
            boolean right = (i == flowerbed.length-1) || flowerbed[i+1] == 0;

            if (left && right && flowerbed[i] == 0) {
                flowerbed[i] = 1;
                count ++;
            }
        }

        return count == n;
    }

    public static void main(String[] args) {
        int[] flowerbed = {1, 0, 0, 0, 0, 1};
        int n = 2;
        boolean output = true;
        boolean testoutput = canPlaceFlowers2(flowerbed, n);
        System.out.println(output == testoutput);
    }
}
