package problem3;

import java.util.ArrayList;
import java.util.Iterator;

public class YypQueue<E> implements Queue<E> {

    private ArrayList<E> data;

    public YypQueue() {
        this.data = new ArrayList<>();
    }

    public YypQueue(int size) {
        this.data = new ArrayList<>(size);
    }

    @Override
    public void push(E e) {
        this.data.add(e);
    }

    @Override
    public E pop() throws NullPointerException {
        if (this.data.isEmpty()) {
            throw new NullPointerException();
        }
        return this.data.remove(0);
    }

    @Override
    public E peekHead() throws NullPointerException {

        if (this.data.isEmpty()) {
            throw new NullPointerException();
        } else {
            return this.data.get(0);
        }
    }

    @Override
    public E peekTail() {
        if (this.data.isEmpty()) {
            throw new NullPointerException();
        } else {
            return this.data.get(this.size() - 1);
        }
    }

    @Override
    public int size() {
        return this.data.size();
    }

    @Override
    public boolean isEmpty() {
        return this.data.isEmpty();
    }

    @Override
    public void clear() {
        this.data.clear();
    }

    @Override
    public Iterator<E> iterator() {
        return data.iterator();
    }

    @Override
    public String toString() {
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < size(); i++) {
            buffer.append(data.get(i));
            if (i < size() - 1) {
                buffer.append(" -> ");
            }
        }
        return buffer.toString();
    }


    public static void main(String[] args) {
        YypQueue<String> stringYypQueue = new YypQueue<>(10);
        stringYypQueue.push("hello");
        stringYypQueue.push("naver");
        stringYypQueue.push("I");
        stringYypQueue.push("am");
        stringYypQueue.push("yyp");

        String pop1 = stringYypQueue.pop();
        System.out.println(stringYypQueue);
        System.out.println(stringYypQueue.isEmpty());
        System.out.println(stringYypQueue.peekHead());
        System.out.println(stringYypQueue.size());
        System.out.println(stringYypQueue);
    }
}
