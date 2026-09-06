public class Node {
    int key;
    int val;
    Node next;
    Node prev;

    public Node(int key, int value) {
        this.key = key;
        this.val = value;
        this.next = null;
        this.prev = null;
    }
}

class LRUCache {
    int capacity;
    Map<Integer, Node> cache = new HashMap<>();
    Node head = new Node(0, 0);
    Node end = new Node(0, 0);

    public LRUCache(int capacity) {
        this.capacity = capacity;
        end.next = head;
        head.prev = end;
    }

    public int get(int key) {
        if (!cache.containsKey(key))
            return -1;

        Node tmp = cache.get(key);
        Node prevTmp = tmp.prev;
        Node nextTmp = tmp.next;

        prevTmp.next = nextTmp;
        nextTmp.prev = prevTmp;

        Node headPrev = head.prev;

        headPrev.next = tmp;
        tmp.prev = headPrev;
        tmp.next = head;
        head.prev = tmp;
        return tmp.val;
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            Node tmp = cache.get(key);
            tmp.val = value;
            Node prevTmp = tmp.prev;
            Node nextTmp = tmp.next;

            prevTmp.next = nextTmp;
            nextTmp.prev = prevTmp;

            Node headPrev = head.prev;

            headPrev.next = tmp;
            tmp.prev = headPrev;
            tmp.next = head;
            head.prev = tmp;
        } else {
            Node tmp = new Node(key, value);
            cache.put(key, tmp);

            Node headPrev = head.prev;
            tmp.next = head;
            headPrev.next = tmp;
            tmp.prev = headPrev;
            head.prev = tmp;

            if (cache.size() > capacity) {
                int removeKey = end.next.key;
                end.next.next.prev = end;
                end.next = end.next.next;
                cache.remove(removeKey);
            }
        }
    }
}
