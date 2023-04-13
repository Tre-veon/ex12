class QueueFullException extends Exception {}

class QueueEmptyException extends Exception {}


class Queue<E> {
    private E[] elements;
    private int front = 0;
    private int rear = 0;
    private int size;

    Queue(int size) {
        elements = (E[]) new Object[size];
        this.size = size;
    }

    void enqueue(E element) throws QueueFullException {
        if (rear >= size) {
            throw new QueueFullException();
        }

        elements[rear] = element;
        rear++;
    }

    E dequeue() throws QueueEmptyException {
        if (front == rear) {
            throw new QueueEmptyException();
        }

        E returnElement = elements[front];
        front++;
        return returnElement;
    }
}

public class Main {
    public static void main(String[] args) {
        Queue<String> strings = new Queue<>(3);
        try {
            strings.enqueue("Hello");
            strings.enqueue("World");
            strings.enqueue("Queue");

            System.out.println(strings.dequeue()); // Outputs: Hello
            System.out.println(strings.dequeue()); // Outputs: World
            System.out.println(strings.dequeue());//Outputs: queue

        } catch (QueueFullException | QueueEmptyException e) {
            e.printStackTrace();
        }
    }
}