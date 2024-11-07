package linkedList;

public class InsertionLL {

    public static void main(String[] args) {
        CustomLL list = new CustomLL();
        list.insertAtTail(3);
        list.insertAtTail(2);
        list.insertAtTail(7);
        list.insertAtTail(8);
        list.insertAtIndex(6,2);
        list.insertAtTail(18);
        list.display();
        int val = list.deleteFirst();
        list.display();
         val = list.deleteLast();
        list.display();
        val = list.delete(2);
        list.display();
    }
}
