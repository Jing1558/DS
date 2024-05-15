import org.junit.jupiter.api.Test;

/**
 * @program: ds
 * @description:
 * @author: 黑娃
 * @create: 2024-05-15 15:51
 **/
public class LinkedListTest {
    @Test
    public void test() {
        List<String> list = new LinkedList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.printLinkList();
        list.addFirst("0");
        list.addLast("d");
        list.printLinkList();
    }
}
