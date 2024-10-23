package LinkedList;

public class DLL {

    private DNode head;
    private DNode tail;

    private int size;

    private class DNode{
        int val;
        DNode prev;
        DNode next;

        public DNode(int val) {
            this.val = val;
        }

        public DNode(int val, DNode prev, DNode next) {
            this.val = val;
            this.prev = prev;
            this.next = next;
        }
    }
}
