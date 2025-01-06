package org.algorithm;

public class ArithmeticSequence {

    /**
     * 등차수열
     * 연속하는 두 수의 차이가 일정한 수열
        * EX) 1부터 20까지의 정수 중 홀수의 합을 구하는 프로그램
     */

    public static void main(String[] args) {
        // [1] INPUT
        int sum = 0;

        // [2] PROCESS
        for (int i = 1; i <= 20; i++) {
            if (i % 2 != 0) {
                sum += i;
                System.out.print(i + " ");
            }
        }

        // [3] OUTPUT
        System.out.println("\n1부터 20까지의 홀수의 합: " + sum);
    }
}
