
/**
 * @author Narziss
 * @version 1.0
 * @description: TODO
 * @date 2020/12/9 18:43
 */
public class Array {
    private int[] data;
    private int size;

    /**
     *
     * @param capacity
     */
    public Array(int capacity){
        this.data = new int[capacity];
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
    public void addLast(int e){
        add(size, e);
    }

    /**
     * 在所有元素前添加一个新元素
     * @param e
     */
    public void addFirst(int e){
        add(0, e);
    }
    /**
     * 在第index个位置插入一个新元素e
     * @param index
     * @param e
     */
    public void add(int index, int e){
        if(size == data.length){
            throw new IllegalArgumentException("Add failed.Array is full.");
        }
        if(index < 0 || index > size){
            throw new IllegalArgumentException("AddL failed.Require index < 0 || index > size.");
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
    int get(int index){
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
    void set(int index, int e){
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
    public boolean contains(int e){
        for(int i = 0; i < size; i++){
            if(data[i] == e){
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
    public int find(int e){
        for(int i = 0; i < size; i++){
            if(data[i] == e){
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
    public int remove(int index){
        if(index < 0 || index > size){
            throw new IllegalArgumentException("Set failed.Index is Illegal.");
        }
        int ret = data[index];
        for(int i = index + 1; i < size; i++){
            data[i - 1] = data[i];
        }
        return ret;
    }

    /**
     * 删除第一个元素并返回
     * @return
     */
    public int removeFirst(){
        return remove(0);
    }

    /**
     * 删除最后一个元素并返回删除的元素
     * @return
     */
    public int removeLast(){
        return remove(size - 1);
    }

    /**
     * 从数组删除元素e
     * @param e
     */
    public void removeElement(int e){
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
}
