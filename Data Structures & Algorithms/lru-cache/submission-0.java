public class Node {

    int key;
    int value;
    Node next;
    Node prev;

    public Node(int key, int value)
    {
        this.key = key;
        this.value = value;
    }
    
}
class LRUCache {

    DoublyLinkedList list;

    HashMap<Integer, Node> map ;

    int capacity;

    public LRUCache(int capacity) {

        this.capacity = capacity;
        list = new DoublyLinkedList();
        map = new HashMap<>();
    }
    
    public int get(int key) {
        
        if(!map.containsKey(key)) return -1;

        Node node = map.get(key);

        list.deleteNode(node);

        list.insertAtHead(node);

        return node.value;
    }
    
    public void put(int key, int value) {
        
        Node newNode = null;

        if(map.containsKey(key))
        {
            newNode = map.get(key);
            newNode.value = value;
            this.list.deleteNode(newNode);
            this.list.insertAtHead(newNode);

        }
        else{
            newNode = new Node(key, value);
            map.put(key, newNode);
            // check the cap
            if(this.list.size == this.capacity)
            {
                Node lruNode = this.list.deleteTailNode();
                map.remove(lruNode.key);
            }
            
            this.list.insertAtHead(newNode);
        }
    }
}
public class DoublyLinkedList {

    

    public Node head;

    public Node tail;

    int size;

    public DoublyLinkedList()
    {
        this.size = 0;
        this.head = new Node(-1,-1);
        this.tail = new Node(-1,-1);
        this.head.next = this.tail;
        this.tail.prev = this.head;
    }

    // Insert at head
    public void insertAtHead(Node node)
    {
        
        Node next = head.next;

        node.prev = head;
        node.next = next;

        head.next = node;
        next.prev = node;
        this.size++;

    }
    // Delete at middle
    public Node deleteNode(Node node)
    {
        Node prevNode = node.prev;
        Node nextNode = node.next;

        System.out.println(node.value);

        prevNode.next = nextNode;
        nextNode.prev = prevNode;

        node.prev = node.next = null;

        this.size--;

        return node;
    }


    // delete at tail
    public Node deleteTailNode()
    {
        Node lruNode =  tail.prev;

        lruNode.prev.next = tail;
        tail.prev = lruNode.prev;

        lruNode.prev = lruNode.next = null;

        this.size--;

        return lruNode;


    }

}
