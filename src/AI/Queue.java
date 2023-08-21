package AI;

class Queue {
    private int[] items;
    private int front;
    private int rear;
    private int size;
    private int capacity;

    public Queue(int capacity) {
        this.capacity = capacity;
        items = new int[capacity];
        front = -1;
        rear = -1;
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }

    public void enqueue(int item) {
        if (isFull()) {
            throw new RuntimeException("Queue is full");
        }

        rear = (rear + 1) % capacity;
        items[rear] = item;
        size++;
    }

    public int dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }

        int dequeuedItem = items[front];
        front = (front + 1) % capacity;
        size--;
        return dequeuedItem;
    }

    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }

        return items[front];
    }

    public int size() {
        return size;
    }

    public static void main(String[] args) {
        Queue queue = new Queue(5);

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        System.out.println(queue.dequeue()); // 1
        System.out.println(queue.dequeue()); // 2
        System.out.println(queue.dequeue()); // 3
    }
}


