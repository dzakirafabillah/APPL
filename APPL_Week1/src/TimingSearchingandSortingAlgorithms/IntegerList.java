/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TimingSearchingandSortingAlgorithms;

// ****************************************************************
// FILE: IntegerList.java
//
// Purpose: Define an IntegerList class with methods to create, fill,
// sort, and search in a list of integers.
//
// ****************************************************************
import java.util.Scanner;
import java.util.*;

public class IntegerList{
    int[] list; //values in the list
    //------------------------------------------------------------
    // Constructor -- takes an integer and creates a list of that
    // size. All elements default to value 0.
    //------------------------------------------------------------
    public IntegerList(int size){
        list = new int[size];
    }
    //------------------------------------------------------------
    // randomize -- fills the array with randomly generated integers
    // between 1 and 100, inclusive
    //------------------------------------------------------------
    public void randomize(){
        for (int i=0; i<list.length; i++)
            list[i] = (int)(Math.random() * 100) + 1;
    }
    //------------------------------------------------------------
    // fillSorted -- fills the array with sorted values
    //------------------------------------------------------------
    public void fillSorted(){
        for (int i=0; i<list.length; i++)
            list[i] = i + 2;
    }
    //------------------------------------------------------------
    // print -- prints array elements with indices, one per line
    //------------------------------------------------------------
    public String toString(){
        String s = "";
        for (int i=0; i<list.length; i++)
            s += i + ":\t" + list[i] + "\n";
        return s;
    }
    //------------------------------------------------------------
    // linearSearch -- takes a target value and returns the index
    // of the first occurrence of target in the list. Returns -1
    // if target does not appear in the list
    //------------------------------------------------------------
    public int linearSearch(int target){
        int location = -1;
        for (int i=0; i<list.length && location == -1; i++)
        if (list[i] == target)
            location = i;
        return location;
    }
    //------------------------------------------------------------
    // sortIncreasing -- uses selection sort
    //------------------------------------------------------------
    public void sortIncreasing(){
        for (int i=0; i<list.length-1; i++){
            int minIndex = minIndex(list, i);
            swap(list, i, minIndex);
        }
    }
    
    /*search element that smaller than list[i]*/
    private int minIndex(int[] list, int i) {
        int minIndex = i;
        for (int j = i+1; j < list.length; j++){
            if (list[j] < list[minIndex]){
                minIndex = j;
            }
        }
        return minIndex;
    }
    
    public void swap(int[] list, int a, int b){
        int temp = list[a];
        list[a] = list[b];
        list[b] = temp;
    }

    int binarySearch(int val) {
        int left = 0;
        int right = list.length - 1;

        while (left <= right) {
            int mid = left + (right - left)/2;   
            if (list[mid] < val) {
                left  = mid + 1;
            } else if (list[mid] > val) {
                right = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
    
    /*sorts the list into decreasing (instead of increasing) order. using 
    inserttion sort*/
    public void sortDecreasing(){
        for (int i = 1; i < list.length; i++) {
            int temp = list[i];
            int j = i - 1;
 
            /* Move elements if list[j] < list [j+1] */
            while (j >= 0 && list[j] < temp) {
                list[j + 1] = list[j];
                j = j - 1;
            }
            list[j + 1] = temp;
        }
    }

}