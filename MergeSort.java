package sxs169430;

public class MergeSort {

    public static void insertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            int k = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > k) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = k;
        }
    }

    public static void insertionSort(int[] arr, int start, int end) {
        for (int i = start; i <= end; ++i) {
            int k = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > k) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = k;
        }
    }

    /**
     * mergeSort take 1 Implementation
     *
     * @param A - Array to be sorted
     */
    public static void mergeSortTakeOne(int[] A) {
        mergeSortTakeOne(A, 0, A.length - 1);
    }

    public static void mergeSortTakeOne(int[] A, int p, int r) {
        if (p < r) {
            int q = (p + r) / 2;
            mergeSortTakeOne(A, p, q);
            mergeSortTakeOne(A, q + 1, r);
            mergeTakeOne(A, p, q, r);
        }
    }

    public static void mergeTakeOne(int[] A, int p, int q, int r) {
        int[] L = new int[q - p + 1];
        int[] R = new int[r - q];
        System.arraycopy(A, p, L, 0, q - p + 1);
        System.arraycopy(A, q + 1, R, 0, r - q);
        int i = 0, j = 0;
        for (int k = p; k <= r; k++) {
            if ((j >= R.length) || (i < L.length && L[i] <= R[j])) {
                A[k] = L[i++];
            } else {
                A[k] = R[j++];
            }
        }
    }
    // end of take 1 mergeSort

    public static void mergeSortTakeTwo(int[] A) {
        mergeSortTakeTwo(A, 0, A.length - 1);
    }

    public static void mergeSortTakeTwo(int[] A, int p, int r) {
        int T = 10;
        int[] B = new int[A.length];
        if (A.length < T) {
            insertionSort(A, p, r);
        } else {
            if (p < r) {
                int q = (p + r) / 2;
                mergeSortTakeTwo(A, p, q);
                mergeSortTakeTwo(A, q + 1, r);
                mergeTakeTwo(A, B, p, q, r);
            }
        }
    }

    public static void mergeTakeTwo(int A[], int B[], int p, int q, int r) {
        System.arraycopy(A, p, B, p, r - p + 1);
        int i = p, j = q + 1;
        for (int k = p; k <= r; k++) {
            if (j > r || (i <= q && B[i] <= B[j])) {
                A[k] = B[i++];
            } else
                A[k] = B[j++];
        }
    }

    public static void mergeSortTakeThree(int A[]) {
        int B[] = new int[A.length];
        System.arraycopy(A, 0, B, 0, A.length);
        mergeSortTakeThree(A, B, 0, A.length);
    }

    public static void mergeTakeThree(int A[], int B[], int left, int n) {
        int T = 10;
        if (n < T) {
            insertionSort(A, left, left + n - 1);
        } else {
            int Ln = n / 2;
            mergeTakeThree(B, A, left, Ln);
            mergeTakeThree(B, A, left + Ln, n - Ln);
            merge(A, B, left, left + Ln - 1, left + n - 1);
        }
    }

    public static void merge(int A[], int B[], int p, int q, int r) {
        int i = p;
        int j = q + 1;
        int k = p;
        while (i <= q && j <= r) {
            if (B[i] <= B[j]) {
                A[k + 1] = B[j++];
            } else {
                A[k++] = B[j++];
            }
        }
        while (i <= q) {
            A[k++] = B[i++];
        }
        while (j <= r) {
            A[k++] = B[j++];
        }
    }
}