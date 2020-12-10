package com.soonworld.dayofcode;
import java.io.*;
import java.util.*;

public class NestedLogic {
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */

            String returnedS = scanner.nextLine();
            String dueS = scanner.nextLine();

            String[] returned = returnedS.split(" ");
            String[] due = dueS.split(" ");
            boolean escape = false;
            int result = 0;

            for(int i=2; i>=0; i--){
                if(!returned[i].equals(due[i])){
                    switch(i){
                        case 0 :
                            if(Integer.parseInt(returned[0])>Integer.parseInt(due[0])){
                                result = 15*(Integer.parseInt(returned[0])-Integer.parseInt(due[0]));
                            }
                            escape = true;
                            break;
                        case 1 :
                            if(Integer.parseInt(returned[1])>Integer.parseInt(due[1])){
                                result = 500*(Integer.parseInt(returned[1])-Integer.parseInt(due[1]));
                            }
                            escape = true;
                            break;
                        case 2 :
                            if(Integer.parseInt(returned[2])>Integer.parseInt(due[2])){
                                result =10000;
                            }
                            escape = true;
                            break;
                    }
                }
                if(escape){
                    System.out.println(result);
                    break;
                }
            }
        scanner.close();
    }
}
