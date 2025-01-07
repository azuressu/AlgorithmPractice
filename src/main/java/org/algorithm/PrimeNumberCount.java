package org.algorithm;

import java.util.Scanner;

public class PrimeNumberCount {

    /**
     * 소수 개수 세기
        * 정수 하나를 입력 받아, 2부터 해당 수까지 존재하는 모든 소수를 찾아 출력
     */
    
    public static void main(String[] args) {
        // [1] INPUT
        int count = 0;
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        boolean sw = true; // 소수인지 확인하는 boolean 변수

        // [2] PROCESS : 소수에 대한 개수 세기
        for (int i = 2; i<=number; i++) {
            sw = true;

            for (int j=2; j<i; j++) {
                if (i % j == 0) {
                    sw = false;
                    break;
                }
            }

            if (sw){
                count ++;
                System.out.print(i + "\t");

                if (count % 5 == 0) System.out.println();
            }
        }

        // [3] OUTPUT
        System.out.println("\n2부터 " + number + "까지의 소수의 개수: " + count);


    }
}
