package org.algorithm;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class AverageAlgorithm {
    /**
     * 평균 알고리즘
     * 주어진 범위에 주어진 조건에 해당하는 자료들의 평균
        * EX) n명의 점수 중 80점 이상 95점 이하인 점수의 평균
     */

    public static void main(String[] args) {
        // [1] INPUT
        int[] data = {90, 65, 78, 50, 95};
        int sum = 0;   // 합계
        int count = 0; // 개수

        // [2] PROCESS
        for (int i=0; i<data.length; i++) {
            if (data[i] >= 80 && data[i] <= 95) {
                sum += data[i];
                count ++;
            }
        }
        // 평균
        double average = (double) sum / count;

        double avg = Arrays.stream(data).filter(n -> n >= 80).filter(n -> n <= 95).average().orElse(0);

        // [3] OUTPUT
        System.out.println("80점 이상 95점 이하인 자료의 평균 : " + average);
        System.out.println("80점 이상 95점 이하인 자료의 평균 : " + avg);
    }

}
