package org.algorithm;

public class ArrarySumAverage {
    /**
     * 2차원 배열 평균
     */

    public static void main(String[] args) {
        int [][] scores = {{90, 100, 0, 0}, {80, 90, 0, 0}, {100, 80, 0, 0}};

        for (int i=0; i<3; i++) {
            scores[i][2] = scores[i][0] + scores[i][1]; // 합계
            scores[i][3] = scores[i][2] / 2; // 평균
        }

        System.out.println("국어 영어 합계 평균");
        for (int i=0; i<3; i++) {
            for (int j=0; j<4; j++) {
                System.out.print(scores[i][j] + "\t");
            }
            System.out.println();
        }

    }
}
