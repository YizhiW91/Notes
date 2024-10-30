package test;

import java.util.Arrays;

import implementation.MergeSort;
import implementation.QuickSort;

public class SortTest {

    public static void main(String[] args){
        int trial = 50000;
        int[] arr = arrGenerator();
        int[] res = QuickSort.sort(arr);
        Arrays.sort(arr);
        boolean cont = true;
        int i = 0;
        while(i<= trial && cont){
            cont = Arrays.equals(arr, res);
            i++;
        }
        System.out.println("Compare:"+cont);
    }

    public static int[] arrGenerator(){
        int sizeUpperLimit = 1000;
        int numUpperLimit = 100;
        int size = (int) (Math.random() * sizeUpperLimit);
        int[] arr = new int[size];
        for(int i=0; i<size; i++){
            arr[i] = (int) (Math.random() * numUpperLimit);
        }
        return arr;
    }

}
