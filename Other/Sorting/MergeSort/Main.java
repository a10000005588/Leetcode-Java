import java.util.*;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");

        int[] sample = new int[]{5,7,2,1,6,3,4};

        MergeSort(sample, 0, sample.length-1);
        for(int i=0; i<sample.length; i++) {
            System.out.println(sample[i]);
        }
    }

    public static void MergeSort(int[] arr, int front, int end) {

        int mid = (front+end) /2;
        if(front < end) {
            MergeSort(arr, front, mid);
            MergeSort(arr, mid+1, end);

            doMerge(arr, front, mid, end);
        }
    }

    public static void doMerge(int[] arr, int front, int mid, int end) {

        // create two array : 1. leftArr, 2. rightArr
        List<Integer> leftArr = new ArrayList<>();
        List<Integer> rightArr = new ArrayList<>();

        for(int i=front; i<mid+1; i++) {
            leftArr.add(arr[i]);
        }
        leftArr.add(Integer.MAX_VALUE);

        for(int i=mid+1; i<end+1; i++) {
            rightArr.add(arr[i]);
        }
        rightArr.add(Integer.MAX_VALUE);


        // two pointer : left, right, to indicate where the value be selected.
        int left = 0;
        int right = 0;

        // select the lower value front leftArr or rightArr and put it to the arr
        for(int i=front; i<=end; i++) {
            if(leftArr.get(left) < rightArr.get(right)) {
                arr[i] = leftArr.get(left);
                left++;
            }else {
                arr[i] = rightArr.get(right);
                right++;
            }
        }
    }
}

