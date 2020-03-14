package problem3;

import java.util.Iterator;

public interface Queue<E> {

    //including push, pop, peek, empty methods.


    void push(E e);

    E pop();

    /**
     * 窥视头部元素(不删除)
     */
    E peekHead();

    /**
     * 窥视尾部元素(不删除)
     */
    E peekTail();

    /**
     * @return 返回当前队列中元素的个数
     */
    int size();

    /**
     * 判断当前队列是否为空
     *
     * @return 如果当前队列中元素个数为0，返回true；否则，返回false
     */
    boolean isEmpty();

    /**
     * 清除队列中所有元素
     */
    void clear();

    /**
     * 获得迭代器
     */
    Iterator<E> iterator();


}
