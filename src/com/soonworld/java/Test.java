package com.soonworld.java;


/**
 *  소수 알고리즘 (Prime Number)
 *  예전에 풀었었는데 금새 까먹네..
 *  소수 알고리즘의 최적화로는 2부터 구할 소수값(n)의 루트까지 범위를 두고 해당 값을
 *  나눴을대 해당 범위에서 모두 나머지가 0이 아닌경우 소수가 된다. (1 혹은 자기 자신으로만 나눠야 0인 수를 소수 라고 함)
 */
public class Test {
    public static void main(String[] args) {
        int answer = 0;
        int n=10;

        for(int i=2; i<=n; i++ ){
            boolean check = true;
            for(int j=2; j*j<=i; j++){
                if(i%j ==0){
                    check=false;
                    break;
                }
            }
            if(check){
                answer++;
                System.out.println(i);
            }
        }
        System.out.println(answer);
    }

}
