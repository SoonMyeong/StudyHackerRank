package com.soonworld.dayofcode;
import java.io.*;
import java.util.*;

public class ClassVsInstance {
    private int age;

    public ClassVsInstance(int initialAge) {
        // Add some more code to run some checks on initialAge
        this.age = initialAge;
    }

    public void amIOld() {
        // Write code determining if this person's age is old and print the correct statement:
        if(getAge() <0){
            System.out.println("Age is not valid, setting age to 0.");
            initAge();
        }else if (getAge()>=0 && getAge()<13){
            System.out.println("You are young.");
        }else if (getAge()>=13 && getAge()<18){
            System.out.println("You are a teenager.");
        }else{
            System.out.println("You are old.");
        }
    }

    public void yearPasses() {
        // Increment this person's age.
        this.age += 1;
    }
    public void initAge(){
        this.age = 0;
        amIOld();
    }
    public int getAge(){
        return age;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            int age = sc.nextInt();
            ClassVsInstance p = new ClassVsInstance(age);
            p.amIOld();
            for (int j = 0; j < 3; j++) {
                p.yearPasses();
            }
            p.amIOld();
            System.out.println();
        }
        sc.close();
    }
}