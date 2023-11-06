package heap;

import java.util.ArrayList;
import java.util.List;

public class ArrayHeap {
    public List<Integer> getHeap() {
        return heap;
    }

    private List<Integer> heap;

    public ArrayHeap(List<Integer> heap, boolean isHeap) {
        this.heap = new ArrayList<>(heap);
        if (isHeap && !heap.isEmpty()) {
            for (int i = heap.size() - 1; i >= 0; i--) {
                siftDown(i);
            }
        }
    }


    public int left(int i) {
        return 2 * i + 1;
    }

    public int right(int i) {
        return 2 * i + 2;
    }

    public int parent(int i) {
        return (i - 1) / 2;
    }

    public int peek(int i) {
        return heap.get(0);
    }

    public void push(int i) {
        heap.add(i);
        siftUp(size() - 1);
    }

    private int size() {
        return heap.size();
    }

    public void siftUp(int i) {
        while (true) {
            int peek = parent(i);
            if (peek < 0 || heap.get(i) <= heap.get(peek)) {
                break;
            }
            swap(i, peek);
            i = peek;
        }
    }

    public int pop() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException();
        }
        //替换 堆顶和堆底
        swap(0, size() - 1);
        int result = heap.remove(size() - 1);
        siftDown(0);
        return result;
    }

    private void siftDown(int i) {

        while (true) {
            int l = left(i), r = right(i), m = i;
            if (l < size() && heap.get(l) > heap.get(m)) {
                m = l;
            }

            if (r < size() && heap.get(r) > heap.get(m)) {
                m = r;
            }

            if (m == i) {
                break;
            }
            swap(i, m);
            i = m;
        }

    }

    private boolean isEmpty() {
        return heap.isEmpty();
    }

    private void swap(int i, int j) {
        int temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }
}
