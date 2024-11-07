package linkedList;

public class CustomLL {

    private Node head;
    private Node tail;

    private int size;

    public CustomLL(){
        this.size = 0;
    }

    public void insertAtHead(int value){
        Node node = new Node(value);
        node.next = head;
        head = node;
        if(tail == null){
            tail = head;
        }
        size++;
    }

    public void insertAtTail(int value){
        if(tail == null){
            insertAtHead(value);
            return;
        }
        Node node = new Node(value);
        tail.next = node;
        tail = node;
        size++;
    }

    public void insertAtIndex(int value, int index){
        if(index == 0){
            insertAtHead(value);
            return;
        }
        if(index == size){
            insertAtTail(value);
            return;
        }

        Node current = head;
        int i=0;
        while(i<index && current != null){
            if(i == index-1){
                Node node = new Node(value,current.next);
                current.next = node;
            }
            i++;
            current = current.next;
        }
        size++;
    }

    public int deleteFirst(){
        int val = head.value;
        head = head.next;
        if(head == null){
            tail = head;
        }
        size--;
        return val;
    }

    public int deleteLast(){
        if(head==tail){
            return deleteFirst();
        }
        Node current = head;
        while(current.next !=tail){
            current = current.next;
        }
        int val = current.next.value;
        current.next = null;
        tail = current;
        size--;
        return val;
    }

    public int delete(int index){
       if(index==0){
           return deleteFirst();
       }
       if(index == size-1)
           return deleteLast();
       Node current = head;
       int i=1;
       while(i<index && current!=null){
           current = current.next;
           i++;
       }
        int val = current.next.value;
        current.next = current.next.next;
        size--;
        return val;
    }

    public void Node(int index){
        int i =0;
        Node current = head;
        while(i < index){
            current = current.next;
        }
    }


    public void display(){
        Node current = head;
        System.out.print("[ ");
        while(current.next != null){
            System.out.print(current.value + ", ");
            current = current.next;
        }
        System.out.print(current.value);
        System.out.println(" ]");
    }

    private class Node{
        private int value;
        private Node next;

        public Node(int value){
            this.value = value;
        }

        public Node(int value, Node next){
            this.value = value;
            this.next =  next;
        }
    }


}
