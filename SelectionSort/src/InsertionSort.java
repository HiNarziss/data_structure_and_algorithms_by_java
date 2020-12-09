import java.util.Arrays;

/**
 * @author Narziss
 * @version 1.0
 * @description: TODO
 * @date 2020/12/9 16:29
 */
public class InsertionSort {
    private InsertionSort() {
    }

    public static <E extends Comparable<E>> void sort(E[] arr) {
        for (int i = 0; i < arr.length; i++) {

            //将arr[i]插入到合适的位置
            for (int j = i; j - 1 >= 0; j--) {
                if (arr[j].compareTo(arr[j - 1]) < 0) {
                    swap(arr, j, j - 1);
                } else break;
            }
//            for(int j = i; j - 1 >= 0 && arr[j].compareTo(arr[j - 1]) < 0; j --){
//                swap(arr, j, j - 1);
//            }
        }
    }

    public static <E extends Comparable<E>> void sort2(E[] arr) {
        for (int i = 0; i < arr.length; i++) {
            E t = arr[i];
            int j;
            for (j = i; j - 1 >= 0 && t.compareTo(arr[j - 1]) < 0; j--) {
                arr[j] = arr[j - 1];
            }
            arr[j] = t;
        }
    }

    private static <E> void swap(E[] arr, int i, int j) {
        E t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void main(String[] args) {
        int[] dataSize = {10000, 100000};
        for (int n : dataSize) {
            System.out.println("Random Array : ");
            Integer[] arr = ArrayGenerator.generatorRandomArray(n, n);
            Integer[] arr2 = Arrays.copyOf(arr, arr.length);
            SortingHelper.sortTest("SelectionSort", arr);
            SortingHelper.sortTest("InsertionSort", arr2);
            System.out.println();

            System.out.println("Ordered Array : ");
            arr = ArrayGenerator.generateOrderedArray(n);
            arr2 = Arrays.copyOf(arr, arr.length);
            SortingHelper.sortTest("SelectionSort", arr);
            SortingHelper.sortTest("InsertionSort", arr2);
            System.out.println();
        }
    }
}
