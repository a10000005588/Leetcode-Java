import java.util.Scanner;

class MaxHeap {
    final int max = 10;
    int[] heap = new int[max];
    int last = 0;

    Scanner input = new Scanner(System.in);

    public void insert() {
        if(last > max-1) {
            System.out.println("Heap array is full!");
        } else {
            System.out.println("input data");
            heap[++last] = input.nextInt();
            adjustUp(last);
        }
    }

    // if child node is larger than parent node, then swap them.
    public void adjustUp(int index) {
        while(index > 1) {
            // stop when parent node is larger than its child node.
            if(heap[index] <= heap[index / 2]) {
                break;
            } else {
                swap(heap, index);
                // move to the parent node.
                index /= 2;
            }
        }
    }

    // for deleting the node, when a node was putting in the position of the deleting node.
    // it should check whether it is larger than its child node.
    public void adustDown(int index) {
        int nodeTobeMove = heap[index];
        // get the left child.
        int childIndex = index *2;
        while(childIndex <= last) {
            // if right child is larger then left child, childIndex++
            if( (childIndex<last) && heap[childIndex] < heap[childIndex+1]) {
                childIndex++;
            }

            // if parent node is larger then child node. skip
            if(heap[childIndex/2] > heap[childIndex]) {
                break;
            } else {
                heap[childIndex/2] = heap[childIndex];
                // move to the next child node.
                childIndex*=2;
            }
        }
        heap[childIndex/2] = nodeTobeMove;
    }

    public void del() {
        if (last <= 0) {
            System.out.println("Heap is null!");
        } else {
            System.out.println("Input del data :");
            int delData = input.nextInt();
            int delIndex = search(delData);
            if(delIndex==0) {
                System.out.println("Data not find!");
            } else {
                heap[delIndex] = heap[last];
                heap[last] = 0;
                // adjust from the root
                adustDown(1);
            }
        }
    }

    public int search(int data) {
        for(int delIndex=1; delIndex <= last; delIndex++) {
            if(heap[delIndex] == data) {
                return delIndex;
            }
        }
        return 0;
    }

    public void show() {
        for(int index=1; index<=last; index++) {
            System.out.printf(" %d\n", heap[index]);
        }
    }

    public void swap(int[] arr, int index) {
        int temp = arr[index];
        arr[index] = arr[index/2];
        arr[index/2]  = temp;
    }
}

public class Main {

    public static void main(String[] args) {
        MaxHeap heap = new MaxHeap();
        Scanner input = new Scanner(System.in);

        while(true) {
            System.out.println("Select action: (1) Insert a node (2) Show heap (3) Delete a node");
            int node = input.nextInt();
            switch(node) {
                case 1:
                    heap.insert();
                    break;
                case 2:
                    heap.show();
                    break;
                case 3:
                    heap.del();
            }
        }
    }
}
