/**
 * @author Narziss
 * @version 1.0
 * @description: TODO
 * @date 2020/12/8 15:39
 */
public class LinearSearch {
    private LinearSearch(){}
    public static <E> int search(E[] data, E target){
        for(int i = 0; i < data.length; i++){
            //判断引用相等 ==
            //我们想判断的是值相等 equals():类对象判等
            if(data[i].equals(target)){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args){
        int n = 1000000;
        Integer[] data = ArrayGenerator.generateOrderedArray(n);
        //基本数据类型int自动装箱，但是数组不行
        //Java8新增类型推断机制 可省略LinearSearch.<Integer>search
        LinearSearch.search(data, n);



    }
}
