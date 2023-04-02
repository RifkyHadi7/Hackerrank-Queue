import java.util.Scanner;

class Node{
    String data;
    Node next;
    public Node(String data){
        this.data = data;
    }
}
class Queue {
    Node head;
    Node tail;
    int size;
    public void enqueue(String data){
        Node newNode = new Node(data);
        if (head == null){
            head = tail = newNode;
        }else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    public String dequeue(){
        if (head == null){
            return null;
        }else {
            Node temp = head;
            head = head.next;
            size--;
            return temp.data;
        }
    }
    
    public void print(){
        Node temp = head;
        while (temp != null){
            System.out.println("task " + temp.data);
            temp = temp.next;
        }
        System.out.println();
    }
}



public class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Queue queue = new Queue();
        int thread = scan.nextInt();
        scan.nextLine();
        while (true){
            String task = scan.nextLine();
            if (task.equals("START")){
                int i = 0;
                for (; i < thread; i++) {
                    if (queue.size != 0){
                        System.out.println("task " + queue.dequeue() + " done");
                    }else {
                        System.out.println((thread - i) + " idle thread");
                        break;
                    }
                }
                if (i == thread){
                    System.out.println((thread - i) + " idle thread");
                }

            }else if (task.equals("DONE")) {
                System.out.println("task left: ");
                queue.print();
                break;
            }else {
                queue.enqueue(task);
            }
        }
    }
}
