package org.example;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        MyArray<String> myArray = new MyArray<>();

        myArray.addItem(in.nextLine());
        myArray.addItem(in.nextLine());
        myArray.addItem(in.nextLine());
        System.out.println(myArray);

        myArray.fillRand(13, new iRandomaiser() {
            @Override
            public String randomItem() {
                int step = (int) (Math.random() * 15 + 1);
                String str = "";
                for (int i = 0; i < step; i++){
                    str += (char) (Math.random() * 26 + 97);
                }
                return str;
            }
        });
        System.out.println(myArray);

        String min  = myArray.searchMaxMin(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        System.out.println(min);

        String max = myArray.searchMaxMin(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        });
        System.out.println(max);

        int aver = myArray.average(new iAverage<String>() {
            @Override
            public int average(String s) {
                int summ = 0;
                for (int i = 0; i < s.length(); i++){
                    summ += s.charAt(i);
                }
                return summ / s.length();
            }
        });
        System.out.println(aver);

        myArray.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        System.out.println(myArray);

        myArray.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        });
        System.out.println(myArray);

        int resSearch = myArray.search(in.nextLine(), new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        });
        System.out.println(resSearch);
    }
}