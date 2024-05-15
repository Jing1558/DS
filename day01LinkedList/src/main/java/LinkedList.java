
/**
 * @program: ds
 * @description:
 * @author: 黑娃
 * @create: 2024-05-15 09:19
 **/
public class LinkedList<E> implements List<E> {
    transient int size;
    transient Node<E> first;

    transient Node<E> last;

    public LinkedList() {
    }

    @Override
    public boolean add(E e) {
        linkLast(e);
        return true;
    }

    private void linkLast(E e) {
        final Node<E> l = last;
        final Node<E> newNode = new Node<>(e, null, l);
        if (l == null) {
            first = newNode;
        } else {
            last.next = newNode;
        }
        last = newNode;
        size++;
    }

    @Override
    public boolean addFirst(E e) {
        linkFirst(e);
        return false;
    }

    private void linkFirst(E e) {
        final Node<E> f = first;
        final Node<E> newNode = new Node<>(e, f, null);
        if (f == null) {
            last = newNode;
        } else {
            f.prev = newNode;
        }
        first = newNode;
        size++;
    }

    @Override
    public boolean addLast(E e) {
        linkLast(e);
        return true;
    }

    @Override
    public boolean remove(Object o) {
        if (o == null) {
            for (Node<E> x = first; x != null; x = x.next) {
                if (x.item == null) {
                    unLink(x);
                    return true;
                }
            }
        } else {
            for (Node<E> x = first; x != null; x = x.next) {
                if (o.equals(x.item)) {
                    unLink(x);
                    return true;
                }
            }
        }
        return false;
    }

    private E unLink(Node<E> x) {
        E item = x.item;
        Node<E> prev = x.prev;
        Node<E> next = x.next;
        if (prev == null) {
            first = next;
        } else {
            prev.next = next;
            x.prev = null;
        }
        if (next == null) {
            last = prev;
        } else {
            next.prev = prev;
            x.next = null;
        }
        x.item = null;
        size--;
        return item;
    }

    @Override
    public E get(int index) {
        // 1.校验下标
        checkElementIndex(index);
        // 2.获取下标节点
        return node(index).item;
    }

    private Node<E> node(int index) {
        Node<E> x;
        if (index < (size >> 2)) {
            x = first;
            for (int i = 0; i < index; i++) {
                x = x.next;
            }
        } else {
            x = last;
            for (int i = size -1; i > index; i--) {
                x = x.prev;
            }
        }
        return x;
    }

    private void checkElementIndex(int index) {
        if (!isElementIndex(index)) {
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
        }
    }

    private boolean isElementIndex(int index) {
        return index >= 0 && index < size;
    }

    private String outOfBoundsMsg(int index) {
        return "Index: " + index + ", Size: " + size;
    }

    @Override
    public void printLinkList() {
        if (size == 0) {
            System.out.println("当前链表为空");
        } else {
            Node<E> temp = first;
            while (temp != null) {
                System.out.print(temp.item + "，");
                temp = temp.next;
            }
            System.out.println();
        }
    }

    private static class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;

        public Node(E item, Node<E> next, Node<E> prev) {
            this.item = item;
            this.next = next;
            this.prev = prev;
        }
    }
}
