/**
 * @program: ds
 * @description:
 * @author: 黑娃
 * @create: 2024-05-15 09:16
 **/
public interface List<E> {
    boolean add(E e);

    boolean addFirst(E e);

    boolean addLast(E e);

    boolean remove(Object o);

    E get(int index);

    void printLinkList();
}
