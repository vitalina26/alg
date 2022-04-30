package com.company;

import java.io.IOException;
import java.util.Collections;
import java.util.Random;
import java. util. Arrays;
import java.util.Scanner;

public class Main {
    public static int[] MinMaxArr(Integer[] arr)
    {
        int[] MinMax = new int[2];
        MinMax[0] = arr[0];
        MinMax[1] = MinMax[0];

        for (int i = 0; i < arr.length; i++)
        {
            if (arr[i] < MinMax[0])
                MinMax[0] = arr[i];
            if (arr[i] >  MinMax[1])
                MinMax[1]= arr[i];
        }

        return MinMax;
    }
    public static Integer[] Task_A (Integer[] arr, boolean oder)
    {
        int n = arr.length;
        Integer[] res = new Integer[n];
        Integer[] arrSorted = arr;
        if (oder == true)
            Arrays.sort(arrSorted);
        else
            Arrays.sort(arrSorted, Collections.reverseOrder());
        int center = n / 2;
        res[center] = arr[n - 1];

        int c = center;
        if (n%2 == 0)
            c--;

        for (int i = 1; i  <= c; i++)
        {
            res[center - i] = arr[n - i * 2];
            res[center + i] = arr[n - i * 2 - 1];
        }

        if (n % 2 == 0)
            res[0] = arr[0];

        return res;
    }
    //Б) сформувати масив – максимальне, мінімальне, максимальне (з тих, що залишились), мінімальне, … Вивести масив.
    public static Integer[] Task_B (Integer[] arr)
    {
        int n = arr.length;
        Integer[] result = new Integer[n];
        Integer[] arrSorted = arr;
        Arrays.sort(arrSorted, Collections.reverseOrder());

        for (int i = 0; i < n / 2; i++)
        {
            result[2 * i] = arrSorted[i];
            result[2 * i + 1] = arrSorted[n - i - 1];
        }

        if (n % 2 != 0)
            result[n - 1] = arrSorted[n / 2];

        return result;
    }
    public static void arrOut(Integer[] arr)
    {
        System.out.print("\n");
        for (int i = 0; i < arr.length; i++) {
            if(i % 20 == 0)
                System.out.print("\n");
            System.out.print(arr[i] + " ");
        }
    }
    public static Integer[] Task_C (Integer[] arr)
    {
        int n = arr.length;
        Integer[] res = new Integer[n];

        Integer[] pr = new Integer[n - n / 2];
        Integer[] np = new Integer[n / 2];

        for (int i = 0; i < n - n / 2; i++)
            pr[i] = arr[2 * i];

        for (int i = 0; i < n / 2; i++)
            np[i] = arr[2 * i + 1];

        Arrays.sort(pr, Collections.reverseOrder());
        Arrays.sort(np);

        for (int i = 0; i < n - n / 2; i++)
            arr[2 * i] = pr[i];

        for (int i = 0; i < n / 2; i++)
            arr[2 * i + 1] = np[i];

        return arr;
    }



    public static void main(String[] args) throws IOException {

        System.out.println("Enter n > 100");
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        Random r = new Random();
        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = r.nextInt(200);
            if(i % 20 == 0)
                System.out.print("\n");
            System.out.print(arr[i] + " ");
        }
        System.out.print("\n");
        int[] min_max = MinMaxArr(arr);
        System.out.println("MIN : " + min_max[0] + "  MAX : " + min_max[1]);

       Integer[] A1 = Task_A(arr,true);
        arrOut(A1);
        Integer[] A2 = Task_A(arr,false);
       arrOut(A2);
        Integer[] B = Task_B(arr);
        arrOut(B);
        Integer[] C = Task_C(arr);
        arrOut(arr);



    }
}
