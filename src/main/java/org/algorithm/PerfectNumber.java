package org.algorithm;

public class PerfectNumber {
    /**
     * 완전수
     * 자신을 제외한 약수의 합이 자신과 같은 수
        * EX) 6 = 1+2+3
     * 1부터 1000까지 완전수 개수 구하기
     */

    public static void main(String[] args) {
        // [1] INPUT
        int sum = 0;   // 약수의 합계
        int count = 0; // 완전수의 개수
        int max = 0;   // 가장 큰 약수
        int rem = 0;   // 나머지값 임시 보관

        // [2] PROCESS
        for (int i=1; i<=10000; i++) {
            sum = 0;   // 매 반복마다 0으로 초기화
            max = i/2; // 모든 짝수를 2로 나누면 가장 큰 약수를 구할 수 있음
            for (int j=1; j<=max; j++) {
                if (i % j == 0) {
                    rem = i % j;  // 원래의 수 / 약수
                          // == i - (i / j) * j
                    if (rem == 0) {
                        sum += j; // 약수의 합계
                    }
                } // if
            } // for
            if (i == sum) {  // 원래 수 == 약수의 합 => 완전수
                System.out.println("완전수 : " + i);
                count ++;
            }
        }

        // [3] OUTPUT
        System.out.println("완전수 개수 : " + count);
    }
}
