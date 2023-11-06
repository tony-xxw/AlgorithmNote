package heap;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) {
//        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
//        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
//
//        maxHeap.offer(1);
//        maxHeap.offer(3);
//        maxHeap.offer(2);
//        maxHeap.offer(5);
//        maxHeap.offer(4);
//
//        Integer peek = maxHeap.peek();
//
//        Integer poll = maxHeap.poll();
//        System.out.println("peek " + peek + " poll: " + poll);


//        System.out.println("heap: size" + maxHeap.size() + " heap isEmpty " + maxHeap.isEmpty());

        ArrayHeap heap = new ArrayHeap(Arrays.asList(9,8,6,6,7,5,2,1,4,3,6,2),true);
        heap.push(7);
        System.out.println("入堆");
        for (Integer integer : heap.getHeap()) {
            System.out.print(integer + ",");
        }
        System.out.println("出堆");
        System.out.println(heap.pop());
        for (Integer integer : heap.getHeap()) {
            System.out.print(integer + ",");
        }
    }


}
