package test.java;

import java.util.Arrays;

import main.java.implementation.sorts.InsertionSort;

public class LinkedListTest {
        public static void main(String[] args){
        int trial = 500000;
        int[] arr = arrGenerator();
        int[] arrCopy = null;
        if(arr != null){
            arrCopy = arr.clone();
        }    
        InsertionSort.sort(arr);
        Arrays.sort(arrCopy);
        boolean cont = true;
        int i = 0;
        while(i<= trial && cont){
            cont = Arrays.equals(arr, arrCopy);
            i++;
        }
        System.out.println("Compare:"+cont);
    }

    public static int[] arrGenerator(){
        int sizeUpperLimit = 10000;
        int numUpperLimit = 1000;
        int size = (int) (Math.random() * sizeUpperLimit)-1;
        if(size == 0){
            return null;
        }
        int[] arr = new int[size];
        for(int i=0; i<size; i++){
            arr[i] = (int) (Math.random() * numUpperLimit);
        }
        return arr;
    }
}
