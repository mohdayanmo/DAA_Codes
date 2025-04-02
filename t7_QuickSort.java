package T6_Sorting;

public class t7_QuickSort {

    static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    static int partition(int[] arr, int st, int end){
        int pivot = arr[st];
        int count = 0;
        for(int i =st+1; i<=end; i++){
            if(arr[i]<= pivot) count++;
        }
        int pivotIdx = st+count;
        swap(arr, st, pivotIdx);
        int i =st; int j = end;
        while(i<pivotIdx && j>pivotIdx){
            while(arr[i]<=arr[pivotIdx]) i++;
            while(arr[j]>arr[pivotIdx]) j--;
            if(i<pivotIdx && j>pivotIdx){
                swap(arr, i, j);
                i++; j--;
            }
        }
        return pivotIdx;
    }
    static void quickSort(int[] arr, int st, int end){
        if(st>=end) return;
        int pivotIdx = partition(arr, st, end);
        quickSort(arr, st, pivotIdx-1);
        quickSort(arr, pivotIdx+1, end);
    }
    public static void main(String[] args) {
        int[] arr = {2,5,7,12,9,1,3,4,6};
        quickSort(arr, 0, arr.length-1);
        for(int i: arr){
            System.out.print(i+" ");
        }
    }
}
