/**
 * @author Narziss
 * @version 1.0
 * @description: TODO
 * @date 2020/12/10 21:03
 */
public class Main {
    public static void main(String[] args) {
        ArrayStack<Integer> stack = new ArrayStack<>();
        for(int  i = 0; i < 5; i++){
            stack.push(i);
            System.out.println(stack);
        }
        stack.pop();
        System.out.println(stack);
    }
}