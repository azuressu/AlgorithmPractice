package org.algorithm;

import java.util.Arrays;

public class SumAlgorithm {

    /**
     * 합계 알고리즘
     * 주어진 범위에 주어진 조건에 해당하는 자료들의 합계
        * EX) n명의 국어 점수 중, 80점 이상인 점수의 합계
     */

    public static void main(String[] args) {
        // [1] INPUT : n명의 국어 점수
        int [] scores = {100, 75, 50, 37, 90, 95};
        int sum = 0;

        // [2] PROCESS : 알고리즘 영역 (주어진 범위에 주어진 조건)
        for (int score : scores) {
            if (score >= 80) sum += score;
        }

        int streamsum = Arrays.stream(scores).filter(s -> s >= 80).sum();

        // [3] OUTPUT
        System.out.println(scores.length +"명의 점수 중 80점 이상의 총점: " + sum);
        System.out.println(scores.length +"명의 점수 중 80점 이상의 총점: " + streamsum);
    }

}