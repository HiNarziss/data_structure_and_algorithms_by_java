import java.util.Random;

/**
 * @author Narziss
 * @version 1.0
 * @description: TODO
 * @date 2020/12/8 20:26
 */
public class ArrayGenerator {
    private ArrayGenerator(){}
    public static Integer[] generateOrderedArray(int n){

        Integer[] arr = new Integer[n];
        for(int i = 0;i < n; i ++){
            arr[i] = i;
        }
        return arr;
    }

    //生成一个长度为n的随机数组，每个数字的范围是[0, bound)
    public static Integer[] generatorRandomArray(int n, int bound){
        Integer[] arr = new Integer[n];
        Random rnd = new Random();
        for(int i = 0; i < n; i ++){
            arr[i] = rnd.nextInt(bound);
        }
        return arr;
    }
}
