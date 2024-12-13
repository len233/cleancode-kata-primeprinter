package com.cleancode.knuth;

public class PrimePrinterHelper {
    private final int M = 1000;
    private final int RR = 50;
    private final int CC = 4;
    private final int ORDMAX = 30;
    private int[] P = new int[M + 1];
    private int[] MULT = new int[ORDMAX + 1];

    public void invoke() {
        generatePrimes();
        printPrimes();
    }

    private void generatePrimes() {
        int J = 1, K = 1, ORD = 2, SQUARE = 9, N;
        boolean JPRIME;
        P[1] = 2;

        while (K < M) {
            do {
                J += 2;
                if (J == SQUARE) {
                    ORD++;
                    SQUARE = P[ORD] * P[ORD];
                    MULT[ORD - 1] = J;
                }
                N = 2;
                JPRIME = true;
                while (N < ORD && JPRIME) {
                    while (MULT[N] < J)
                        MULT[N] += P[N] + P[N];
                    if (MULT[N] == J)
                        JPRIME = false;
                    N++;
                }
            } while (!JPRIME);
            K++;
            P[K] = J;
        }
    }

    private void printPrimes() {
        int PAGENUMBER = 1;
        int PAGEOFFSET = 1;
        int ROWOFFSET, C;

        while (PAGEOFFSET <= M) {
            System.out.print("The First ");
            System.out.print(M);
            System.out.print(" Prime Numbers === Page ");
            System.out.print(PAGENUMBER);
            System.out.println("\n");
            for (ROWOFFSET = PAGEOFFSET; ROWOFFSET <= PAGEOFFSET + RR - 1; ROWOFFSET++) {
                for (C = 0; C <= CC - 1; C++)
                    if (ROWOFFSET + C * RR <= M)
                        System.out.printf("%10d", P[ROWOFFSET + C * RR]);
                System.out.println();
            }
            System.out.println("\f");
            PAGENUMBER++;
            PAGEOFFSET += RR * CC;
        }
    }
}
