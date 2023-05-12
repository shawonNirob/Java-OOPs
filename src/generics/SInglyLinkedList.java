package generics;

public class SInglyLinkedList<Type> {
    private Node<Type> head;

    public static class Node<Type>{
        private Type val;
        private Node<Type> next;

        public Node(Type val){
            this.val = val;
            this.next = null;
        }
    }

    public void addList(Type val){
        Node<Type> node = new Node<>(val);
        if(head == null){
            head = node;
        }else{
            Node<Type> curr = head;
            while(curr.next!=null){
                curr = curr.next;
            }
            curr.next = node;
        }
    }

    public void showList(){
        Node<Type> node = head;
        while(node != null){
            System.out.print(node.val+" ");
            node = node.next;
        }
    }

    public void addFirst(Type val){
        Node<Type> node = new Node<>(val);
        node.next = head;
        head = node;
    }

    public void addInList(Type val, Type target){
        Node<Type> node = new Node<>(val);
        Node<Type> curr = head;
        while(curr.val != target){
            curr = curr.next;
        }
        node.next = curr.next;
        curr.next = node;
    }
    public static void main(String[] args) {
        SInglyLinkedList<Integer> list = new SInglyLinkedList<>();
        list.addList(5);
        list.addList(6);
        list.addList(7);

        list.addInList(8,6);

        list.showList();

        SInglyLinkedList<String> list1 = new SInglyLinkedList<>();
        list1.addList("Nirob");
        list1.addList("is");
        list1.addList("best");

        list1.showList();
    }

}
