package com.cleancode.knuth;

public class PrimeGenerator {
    private final int numberOfPrimes = 1000;
    private final int linesPerPage = 50;
    private final int columns = 4;
    private final int ordmax = 30;

    private int[] primes = new int[numberOfPrimes + 1];
    private int[] multiples = new int[ordmax + 1];

    private int primeIndex = 1;
    private boolean possiblyPrime;
    private int ord = 2;
    private int square = 9;
    private int n;

    public void invoke() {
        generatePrimes();
        NumberPrinter printer = new NumberPrinter();
        printer.print(primes, numberOfPrimes, linesPerPage, columns);
    }

    private void generatePrimes() {
        primes[1] = 2;
        int candidate = 1;

        while (primeIndex < numberOfPrimes) {
            do {
                candidate += 2;
                if (candidate == square) {
                    ord++;
                    square = primes[ord] * primes[ord];
                    multiples[ord - 1] = candidate;
                }
                n = 2;
                possiblyPrime = true;
                while (n < ord && possiblyPrime) {
                    while (multiples[n] < candidate)
                        multiples[n] += primes[n] + primes[n];
                    if (multiples[n] == candidate)
                        possiblyPrime = false;
                    n++;
                }
            } while (!possiblyPrime);
            primeIndex++;
            primes[primeIndex] = candidate;
        }
    }
}




