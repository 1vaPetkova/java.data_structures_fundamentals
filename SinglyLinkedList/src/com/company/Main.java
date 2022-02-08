package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter integers: ");
        String input = reader.readLine();

        SinglyLinkedList singlyLinkedList = new SinglyLinkedList(input);
        System.out.println("Enter index M: ");
        String mString = reader.readLine();
        Integer valueOfTheMthElement = singlyLinkedList.getElementAtIndex(mString);
        System.out.println(valueOfTheMthElement);
    }
}
