package com.cleancode.knuth;

public class NumberPrinter {
    public void print(int[] numbers, int totalNumbers, int rows, int columns) {
        int pageNumber = 1;
        int pageOffset = 1;

        while (pageOffset <= totalNumbers) {
            System.out.printf("The First %d Prime Numbers === Page %d%n%n", totalNumbers, pageNumber);
            for (int rowOffset = pageOffset; rowOffset <= pageOffset + rows - 1; rowOffset++) {
                for (int c = 0; c < columns; c++) {
                    if (rowOffset + c * rows <= totalNumbers) {
                        System.out.printf("%10d", numbers[rowOffset + c * rows]);
                    }
                }
                System.out.println();
            }
            System.out.println("\f");
            pageNumber++;
            pageOffset += rows * columns;
        }
    }
}
