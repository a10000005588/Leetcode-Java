public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");

        int[] sample = new int[]{5,7,2,1,6,3,4};

        QuickSort(sample, 0, sample.length-1);
        for(int i=0; i<sample.length; i++) {
            System.out.println(sample[i]);
        }
    }

    public static void QuickSort(int[] arr, int front, int end) {

        if(front < end) {
            // pivot 為 arr[end]
            int pivot = arr[end];
            int i= front-1;

            for(int j=front; j<end; j++) { // to the end - 1, because end is pivot
                if(arr[j] < pivot) {
                    i++;
                    swap(arr, i, j);
                }
            }
            i++;  // i should move futher to be exchange by the pivot
            swap(arr, i, end);

            QuickSort(arr, front, i-1);  // exclude the pivot...
            QuickSort(arr, i+1, end);
        }
    }

    public static void swap(int[] arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }
}
