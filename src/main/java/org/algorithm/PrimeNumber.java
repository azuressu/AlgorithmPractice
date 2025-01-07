package org.algorithm;

import java.util.Scanner;

public class PrimeNumber {

    /**
     * 소수 : 1과 자기 자신만을 약수로 갖는 자연수
        * EX) 특정 수를 입력받아 소수인지 아닌지 판별
            * 5는 소수 : 1과 자기 자신만을 약수로 가짐
            * 6은 합성수 : 1과 6만이 아닌 2와 3도 약수로 가짐
            * 2부터 해당 수까지 나머지를 구해 나머지값이 0일 때 나눈 수가 해당 수라면 소수
     */

    public static void main(String[] args) {
        // [1] INPUT
        int number = 0;
        Scanner sc = new Scanner(System.in);
        number = sc.nextInt();

        // [2] PROCESS : 2부터 n까지 나누어 떨어지는 수가 발생할 때까지 반복
        int i = 1;
        do {
            i++;
            System.out.println(number + " % " + i + " = " + (number % i));
        } while (number % i != 0); // 소수는 number로만 나누어 떨어짐

        // [3] OUTPUT
        if (number == i) {
            System.out.println("소수");
        } else {
            System.out.println("합성수");
        }
    }
}
