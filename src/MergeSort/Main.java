package MergeSort;

import java.util.Arrays;

public class Main {
    public static void conquere (int[] arr, int start ,int mid, int end) {

        int[] demo = new int[end-start + 1];
        int idx = 0;
        int i = start;
        int j = mid+1;

        while(i <= mid && j <= end) {
            if(arr[i] < arr[j]) {
                demo[idx++] = arr[i++];
            }else {
                demo[idx++] = arr[j++];
            }
        }

        while (i <= mid) {
            demo[idx++] = arr[i++];
        }

        while (j <= end) {
            demo[idx++] = arr[j++];
        }

        for(i=start, j=0; j<demo.length; j++ , i++) {
            arr[i] = demo[j];
        }

    }
    public static void divide(int[] arr , int start, int end) {
        if (start == end) {
            return;
        }
        int mid = start + (end - start) / 2;
        divide(arr,start, mid);
        divide(arr, mid+1, end);
        conquere(arr, start, mid, end);

    }
    public static void main(String[] args) {
        int[] arr = {6,7,5,1,3,2,9,8,4};

        divide(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
}
