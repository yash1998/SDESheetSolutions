import java.util.HashMap;


public class LRUCache {
    int cap;
    HashMap<Integer, Node> map;
    Node head, tail;

    LRUCache(int capacity) {
        cap = capacity;
        map = new HashMap<>();
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        int res = -1;
        if (map.containsKey(key)) {
            Node node = map.get(key);
            res = node.value;
            map.remove(key);
            delete(node);
            insert(node);
            map.put(key, head.next);
        }
        return res;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            map.remove(key);
            delete(node);
        }
        if (map.size() == cap) {
            map.remove(tail.prev.key);
            delete(tail.prev);
        }
        insert(new Node(key, value));
        map.put(key, head.next);
    }

    private void delete(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        node.next = null;
        node.prev = null;
    }

    private void insert(Node node) {
        node.next = head.next;
        node.prev = head;
        head.next = node;
        node.next.prev = node;
    }
}

class Node {
    int key;
    int value;
    Node prev;
    Node next;

    Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}
