/**
 * @author Narziss
 * @version 1.0
 * @description: TODO
 * @date 2020/12/8 17:45
 */
public class ArrayGenerator {
    private ArrayGenerator(){}
    public static Integer[] generateOrderedArray(int n){
        Integer[] arr = new Integer[n];
        for(int i = 0; i < n; i ++){
            arr[i] = i;
        }
        return arr;
    }
}
