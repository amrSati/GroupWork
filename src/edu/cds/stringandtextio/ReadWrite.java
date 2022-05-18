package edu.cds.stringandtextio;

    //Section 8.22\\

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class ReadWrite {
    public static void main(String[] args) {
        // Ensure proper usage
        if (args.length != 1) {
            System.out.printf("Usage: java %s [filepath]", Count.class.getName());
            System.exit(1);
        }

        // Create file object
        File file = new File(args[0]);

        // Ensure file exists if not then create new file
        if (!file.exists())
            try {
                file.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        // Write Integers into file
        try (PrintWriter writer = new PrintWriter(file)) {
            Random random = new Random();
            for (int i = 0; i < 100; i++)
                writer.printf("%d ", (random.nextInt() % 1000000));

            writer.print(random.nextInt() % 1000000);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        // Read integers into array list
        ArrayList<Integer> list = new ArrayList<>();

        try (Scanner reader = new Scanner(file)) {
            list.add(reader.nextInt());
            while (reader.hasNext())
                list.add(reader.nextInt());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        // Sort integers
        int[] arr = sort(list);

        // Display output
        for (int i: arr) System.out.printf("%d\n", i);

        // DONE
    }

    // Sort an ArrayList and return a sorted array
    public static int[] sort(ArrayList list) {
        // Convert into array
        int[] arr = new int[100];
        for (int i = 0; i < list.size() - 1; i++)
            arr[i] = Integer.parseInt(String.valueOf(list.get(i)));

        // Bubble Sort Algorithm
        for (int i = 0; i < arr.length - 1; i++)
            for (int j = 0; j < arr.length - i - 1; j++)
                if (arr[j] > arr[j + 1]) {
                    // Swap arr[j+1] and arr[j]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }

        return arr;
    }
}
