import org.junit.jupiter.api.Test;

/**
 * @program: ds
 * @description:
 * @author: 黑娃
 * @create: 2024-05-17 08:46
 **/
public class ArrayListTest {
    @Test
    public void test() {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        list.add("6");
        System.out.println(list.toString());
        list.remove(0);
        System.out.println(list.toString());
        list.add("7");
        list.add("8");
        list.add("9");
        list.add("10");
        list.add("11");
        list.add("12");
        System.out.println(list.toString());
    }
}
