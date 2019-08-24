package cn.dataStructure.com;

public class MySingleList implements List {
    private Node head = new Node();
    private int size;

    @Override
    public int size() {
        return size;
    }

    @Override
    public Object get(int i) {
        //定义一个节点指向头节点的下一个节点，也就是第0 个节点
        Node p = head.next;
        for (int j = 0; j < i; j++) {
            p  = p.next;
        }
        return p.data;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object key) {
        Node p = head.next;
        for (int i = 0; i < size ; i++) {
            if (p.data == key) {
                return true;
            }
            p = p.next;
        }
        return false;
    }

    @Override
    public int indexOf(Object key) {
        Node p = head.next;
        for (int i = 0; i < size; i++) {
            if (p.data == key) {
                return i;

            }
            p = p.next;
        }
        return -1;
    }
    private void checkIndex(int i) {
        //这里的i可以为size位置，也就是放在末尾
       if (i < 0 || i > size) {
            throw new RuntimeException("下标越界异常:"+i);
        }
    }
    @Override
    public void add(int i, Object key) {
        checkIndex(i);
        Node node = new Node(key);
        Node p = head;
        for (int j = 0; j < i; j++) {
            p = p.next;
        }
        node.next = p.next;
        p.next = node;
        size++;
    }

    @Override
    public void add(Object key) {
        this.add(size,key);
    }

    @Override
    public boolean addAfter(Object obj, Object key) {
        Node p = head.next;
        Node node = new Node(key);
        for (int i = 0; i < size; i++) {
            if (p.data == obj) {
                node.next = p.next;
                p.next = node;
                size++;
                break;
            }
             p = p.next;
        }
        return true;
    }

    @Override
    public boolean addBefore(Object obj, Object key) {
         Node p = head.next;
         Node pre = head;
         Node node= new Node(key);
        for (int i = 0; i < size; i++) {
            if (p.data == obj) {
                node.next = p;
                pre.next = node;
                size++;
                break;
            }
            p = p.next;
            pre = pre.next;
        }
        return true;
    }


    @Override
    public Object remove(int i) {
        Node p = head.next;
        Node pre = head;
        Object ds = null;

        for (int j = 0; j < i; j++) {
            p = p.next;
            pre= pre.next;
        }
        ds = p.data;
        pre.next = p.next;
        size--;
      return ds;
    }

    @Override
    public boolean remove(Object obj) {
        Node p = head.next;
        Node pre = head;
        for (int i = 0; i < size; i++) {
            if (p.data == obj) {
                pre.next = p.next;
                size--;
                break;
            }
            p = p.next;
            pre = pre.next;
        }
        return true;
    }

    @Override
    public Object replace(int i, Object key) {
        Node p = head.next;
        Node pre = head;
        Object datas = null;
        for (int j = 0; j < i; j++) {
            p = p.next;
            pre = pre.next;
        }
        datas = p.data;
        p.data = key;
        return datas;
    }

    @Override
    public String toString() {
        Node p = head.next;
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size ; i++) {
            if ( i != size - 1) {
                sb.append(p.data+",");
            }else {
                sb.append(p.data);
            }
            p = p.next;
        }
        sb.append("]");
        return sb.toString();
    }
}
