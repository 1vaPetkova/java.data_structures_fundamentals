package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter integers separated by one or more spaces:");
        int[] ints = parseInput(reader.readLine());

        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
        addIntegersToSinglyLinkedList(ints, singlyLinkedList);

        System.out.println("Enter index M:");
        int m = parseIntOrExit(reader.readLine());
        try {
            int index = singlyLinkedList.size() - 1 - m;
            Integer valueOfTheMthElement = singlyLinkedList.getElementAtIndex(index);
            System.out.printf("The Mth element is %d\n", valueOfTheMthElement);
        } catch (IllegalArgumentException e) {
            System.out.printf("Error: %s\n", e.getMessage());
        }
    }

    private static int parseIntOrExit(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.out.printf("Error: '%s' is not a valid integer!\n", input);
            System.exit(1);
        }
        return 0;
    }

    private static void addIntegersToSinglyLinkedList(int[] ints, SinglyLinkedList singlyLinkedList) {
        for (int num : ints) {
            singlyLinkedList.addLast(num);
        }
    }

    private static int[] parseInput(String input) {
        return Arrays.stream(input.split("\\s+"))
                .mapToInt(Main::parseIntOrExit)
                .toArray();
    }

}
