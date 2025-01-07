package org.algorithm;

import java.util.stream.IntStream;

public class CountAlgorithm {

    /**
     * 개수 알고리즘
     * 주어진 범위에 주어진 조건에 해당되는 자료들의 개수
     * EX) 1부터 1000까지의 정수 중 13의 배수의 개수
     */

    public static void main(String[] args) {
        // [1] INPUT
        int [] numbers = IntStream.rangeClosed(1,1000).toArray();
        int count = 0;

        // [2] PROCESS
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] % 13 == 0) count++;
        }

        long count1 = IntStream.rangeClosed(1, 1000).filter(n -> n % 13 == 0).count();

        // [3] OUTPUT
        System.out.println("1부터 1000까지의 정수 중 13의 배수의 개수: " + count);
        System.out.println("1부터 1000까지의 정수 중 13의 배수의 개수: " + count1);
    }

}
