package com.company;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        boolean continueProgram = true;

        do
        {
            System.out.print("Ievadiet masīva izmēru robežās (no 20 - 40):\n");

            int arrSize = 0;

            if (!scan.hasNextInt())
            {
                System.out.print("Ievadītajam masīva izmēram ir jābūt skaitlim!\n");
                scan.next();
                continue;
            }

            arrSize = scan.nextInt();

            if(arrSize < 20 || arrSize > 40)
            {
                System.out.print("Ievadītajam masīva izmēram ir jābūt skaitlim robežās no 20 līdz 40!\n");
                continue;
            }

            Random r = new Random();
            int[] arr = new int[arrSize];


            for ( int i = 0; i < arrSize; i++)
            {
                arr[i] = r.nextInt(99 - 10 + 1) + 10;
            }

            System.out.print("\nIzveidotais masīvs: \n" + Arrays.toString(arr));

            System.out.print("\n\nVai vēlaties kārtot masīva elementus augošā vai dilstošā secībā?\n");
            System.out.print("Ievadiet \"a\" lai kārtotu elementus augošā secībā.\n");
            System.out.print("Ievadiet \"d\" lai kārtotu elementus dilstošā secībā.\n");
            scan.nextLine();
            String orderInput = scan.nextLine();

            while(!orderInput.equalsIgnoreCase("a") && !orderInput.equalsIgnoreCase("d"))
            {
                System.out.print("Ievadiet \"a\" lai kārtotu elementus augošā secībā.\n");
                System.out.print("Ievadiet \"d\" lai kārtotu elementus dilstošā secībā.\n");
                orderInput = scan.nextLine();
            }

            String order;

            if(orderInput.equalsIgnoreCase("a"))
            {
                System.out.print("Masīvs sakārtots augošā secībā:\n");
                System.out.print( Arrays.toString(ascendingArray(arr, arrSize)));
            }
            else
            {
                System.out.print("Masīvs sakārtots dilstošā secībā:\n");
                System.out.print( Arrays.toString(descendingArray(arr, arrSize)));
            }
            continueProgram = false;
        }
        while(continueProgram == true);
    }

    public static int[] ascendingArray(int[] arr, int arrSize)
    {
        for(int i = 0; i < arrSize; i++)
        {
            for( int j = 1; j < arrSize; j++)
            {
                if(arr[j - 1] > arr[j] )
                {
                    int tmp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = tmp;
                }
            }
        }

        return arr;
    }

    public static int[] descendingArray(int[] arr, int arrSize)
    {
        for(int i = 0; i < arrSize; i++)
        {
            for( int j = 1; j < arrSize; j++)
            {
                if(arr[j - 1] < arr[j] )
                {
                    int tmp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = tmp;
                }
            }
        }

        return arr;
    }
}
