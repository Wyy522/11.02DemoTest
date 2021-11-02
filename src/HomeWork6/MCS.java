package HomeWork6;

import java.util.concurrent.atomic.AtomicReference;

class MCSLock {

    private final AtomicReference<Node> tail;

    private final ThreadLocal<Node> myNode;

    public MCSLock() {
        tail = new AtomicReference<>();
        myNode = ThreadLocal.withInitial(() -> new Node());
    }

    public void lock() {

        Node node = myNode.get();
        Node pred = tail.getAndSet(node);
        if (pred != null) {
            node.locked = true;
            pred.next = node;
            while (node.locked) {
            }
        }
    }

    public void unLock() {
        Node node = myNode.get();
        if (node.next == null) {
            if (tail.compareAndSet(node, null)) {
                return;
            }
            while (node.next == null) {
            }
        }
        node.next.locked = false;
        node.next = null;
    }

    class Node {
        volatile boolean locked = false;
        Node next = null;
    }

    public static void main(String[] args) {

        MCSLock lock = new MCSLock();

        Runnable task = new Runnable() {
            private int a;

            @Override
            public void run() {
                lock.lock();
                for (int i = 0; i < 10; i++) {
                    a++;
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(a);
                lock.unLock();
            }
        };

        new Thread(task).start();
        new Thread(task).start();
        new Thread(task).start();
        new Thread(task).start();
    }
}
