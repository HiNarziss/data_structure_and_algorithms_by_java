
/**
 * @author Narziss
 * @version 1.0
 * @description: TODO
 * @date 2020/12/9 18:43
 */
public class Array<E> {
    private E[] data;
    private int size;

    /**
     *
     * @param capacity
     */
    public Array(int capacity){
        data = (E[]) new Object[capacity];
        size = 0;
    }

    /**
     * 无参的构造函数，默认数组的容量capacity=10
     */
    public Array(){
        this(10);
    }

    /**
     * 获取数组中的元素个数
     * @return
     */
    public int getSize(){
        return size;
    }

    /**
     * 获取数组的容量
     * @return
     */
    public int getCapacity(){
        return data.length;
    }

    /**
     * 返回数组是否为空
     * @return
     */
    public boolean isEmpty(){
        return size == 0;
    }

    /**
     * 向所有元素后添加一个新元素
     * @param e
     */
    public void addLast(E e){
        add(size, e);
    }

    /**
     * 在所有元素前添加一个新元素
     * @param e
     */
    public void addFirst(E e){
        add(0, e);
    }
    /**
     * 在第index个位置插入一个新元素e
     * @param index
     * @param e
     */
    public void add(int index, E e){
        if(index < 0 || index > size){
            throw new IllegalArgumentException("AddL failed.Require index < 0 || index > size.");
        }
        if(size == data.length){
            resize(2 * data.length);
        }
        for(int i = size - 1; i >= index; i--){
            data[i + 1] = data[i];
        }
        data[index] = e;
        size++;
    }

    /**
     * 获取index索引位置的元素
     * @param index
     * @return
     */
    E get(int index){
        if(index < 0 || index > size){
            throw new IllegalArgumentException("Get failed.Index is Illegal.");
        }
        return data[index];
    }

    /**
     * 修改Index索引位置的元素
     * @param index
     * @param e
     */
    void set(int index, E e){
        if(index < 0 || index > size){
            throw new IllegalArgumentException("Set failed.Index is Illegal.");
        }
        data[index] = e;
    }

    /**
     * 查看数组中是否有元素e
     * @param e
     * @return
     */
    public boolean contains(E e){
        for(int i = 0; i < size; i++){
            if(data[i].equals(e)){
                return true;
            }
        }
        return false;
    }

    /**
     * 查找e所在索引,不存在返回-1
     * @param e
     * @return
     */
    public int find(E e){
        for(int i = 0; i < size; i++){
            if(data[i].equals(e)){
                return i;
            }
        }
        return -1;
    }

    /**
     * 删除元素并返回删除的元素
     * @param index
     * @return
     */
    public E remove(int index){
        if(index < 0 || index > size){
            throw new IllegalArgumentException("Set failed.Index is Illegal.");
        }
        E ret = data[index];
        for(int i = index + 1; i < size; i++){
            data[i - 1] = data[i];
        }
        size--;
        data[size] = null;//loitering objects != memory leak
        if(size == data.length / 4 && data.length /2 != 0){
            resize(data.length / 2);
        }
        return ret;
    }

    /**
     * 删除第一个元素并返回
     * @return
     */
    public E removeFirst(){
        return remove(0);
    }

    /**
     * 删除最后一个元素并返回删除的元素
     * @return
     */
    public E removeLast(){
        return remove(size - 1);
    }

    /**
     * 从数组删除元素e
     * @param e
     */
    public void removeElement(E e){
        int index = find(e);
        if(index != -1){
            remove(index);
        }
    }

    @Override
    public String toString() {
        StringBuilder res= new StringBuilder();
        res.append(String.format("Array:size = %d , capacity = %d\n", size, data.length));
        res.append("[");
        for(int i = 0; i < size; i++){
            res.append(data[i]);
            if(i != size - 1){
                res.append(", ");
            }
        }
        res.append("]");
        return res.toString();
    }

    private void resize(int capacity){
        E[] newData = (E[])new Object[capacity];
        for(int i = 0; i < size; i++){
            newData[i] = data[i];
        }
        data = newData;
    }
}
