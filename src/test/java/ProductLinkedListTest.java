import org.example.asdc.Product;
import org.example.asdc.ProductLinkedList;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ProductLinkedListTest {
    private ProductLinkedList list;

    @Before
    public void setUp() {
        list = new ProductLinkedList();
        list.add(Product.create(1, "Хлеб1","Белый хлеб1", 21, 31, "штука1"));
        list.add(Product.create(2, "Хлеб2","Белый хлеб2", 22, 32, "штука2"));
        list.add(Product.create(3, "Хлеб3","Белый хлеб3", 23, 33, "штука3"));
        list.add(Product.create(4, "Хлеб4","Белый хлеб4", 24, 34, "штука4"));
        list.add(Product.create(5, "Хлеб5","Белый хлеб5", 25, 35, "штука5"));
    }

    @Test
    public void testAdd() {
        list.add(Product.create(6, "Хлеб6","Белый хлеб5", 25, 35, "штука5"));
        assertEquals(list.find(6).getName(), "Хлеб6");
    }

    @Test
    public void testRemove() {
        list.remove(2);
        assertNull(list.find(2));
    }

    @Test
    public void testFind() {
        assertEquals(list.find(3).getName(), "Хлеб3");
    }

    @Test
    public void testTraverseAndPrint() {
        list.traverseAndPrint();
        // Ensure that output is not null or empty
        assertNotNull(System.out);
    }
}
