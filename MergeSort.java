// Time Complexity :  O(nlogn)   ;where n is the number of elements in the array ; merging two sortes arrays takes linear O(n) time.
// Space Complexity : O(n)  ,as extra space is needed for storing elements of subarray in temporary array

//Code:

class MergeSort {
    // Merges two subarrays of arr[].
    // First subarray is arr[l..m]
    // Second subarray is arr[m+1..r]
    void merge(int arr[], int l, int m, int r) {
        // Your code here
        int size1 = m - l + 1;       //finding size of subarrays
        int size2 = r - m;

        int[] A = new int[size1];
        int[] B = new int[size2];   //creating temporary arrays for storing elements of subarray into it

        for (int i = 0; i < size1; i++) {      //storing subarray elements
            A[i] = arr[l + i];
        }
        for (int j = 0; j < size2; j++) {
            B[j] = arr[m + 1 + j];
        }

        int i = 0, j = 0, k = l;

        while (i < A.length && j < B.length) {
            if (A[i] < B[j]) {
                arr[k] = A[i];
                i++;
                k++;
            } else {
                arr[k] = B[j];
                j++;
                k++;
            }
        }
        while (i < A.length) {     //if elements are left in A[] array then all elements will be copied to arr[]
            arr[k] = A[i];
            i++;
            k++;
        }
        while (j < B.length) {   //if elements are left in B[] array then all elements will be copoed to arr[]
            arr[k] = B[j];
            j++;
            k++;
        }

    }

    // Main function that sorts arr[l..r] using
    // merge()
    void sort(int arr[], int l, int r) {
        // Write your code here
        // Call mergeSort from here
        if (l < r) {
            int mid = l + (r - l) / 2;
            sort(arr, l, mid);
            sort(arr, mid + 1, r);

            merge(arr, l, mid, r);
        }
    }

    /* A utility function to print array of size n */
    static void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    // Driver method
    public static void main(String args[]) {
        int arr[] = { 12, 11, 13, 5, 6, 7 };

        System.out.println("Given Array");
        printArray(arr);

        MergeSort ob = new MergeSort();
        ob.sort(arr, 0, arr.length - 1);

        System.out.println("\nSorted array");
        printArray(arr);
    }
}