package test.java;

import java.nio.Buffer;
import java.util.Arrays;

import main.java.implementation.sorts.BubbleSort;
import main.java.implementation.sorts.HeapSort;
import main.java.implementation.sorts.InsertionSort;
import main.java.implementation.sorts.MergeSort;
import main.java.implementation.sorts.QuickSort;
import main.java.implementation.sorts.RadixSort;


public class SortTest {
    
    public static void main(String[] args){
        int trial = 500000;
        boolean cont = true;
        int i = 0;
        while(i<= trial && cont){
            int[] arr = arrGenerator();
            int[] arrCopy = null;
            if(arr != null){
                arrCopy = arr.clone();
            }    
            QuickSort.sort(arr);
            if(arrCopy != null){
                Arrays.sort(arrCopy);
                cont &= Arrays.equals(arr, arrCopy);
            } else{
                cont &= (arr == null && arrCopy == null);
            }
            i++;
        }
        System.out.println("Compare:"+cont);
    }

    public static int[] arrGenerator(){
        int sizeUpperLimit = 100;
        int numUpperLimit = 1000;
        int size = (int) (Math.random() * sizeUpperLimit)+1;
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
