package org.algorithm;

public class AverageCount {

    /**
     * 평균 이상 학생
     * EX) 5명의 학생의 점수를 입력 받아 전체 학생 평균 이상의 성적인 학생의 수를 구하기
     */

    public static void main(String[] args) {
        // [1] INPUT
        int [] scores = {100, 90, 80, 70, 60};
        int sum = 0;          // 총점
        int count = 0;        // 학생 수
        double average = 0.0; // 평균
        int resultCount = 0;  // 평균 이상 학생 수

        // [2] PROCESS
        for (int i=0; i<scores.length; i++) {
            sum += scores[i];
            count++;
        }

        if (sum != 0 && count != 0) average = (double) sum / count;

        for (int i=0; i<scores.length; i++) {
            if (scores[i] >= average) resultCount++;
        }

        // [3] OUTPUT
        System.out.println("평균 " + average + "점 이상을 받은 학생 수 : " + resultCount);
    }
}
