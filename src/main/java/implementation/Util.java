package main.java.implementation;

public class Util {
    public static <T> void swap(T[] arr, int i, int j){
        T helper = arr[i];
        arr[i] = arr[j];
        arr[j] = helper;
    }

    public static void swap(int[] arr, int i, int j){
        int helper = arr[i];
        arr[i] = arr[j];
        arr[j] = helper;
    }
}
