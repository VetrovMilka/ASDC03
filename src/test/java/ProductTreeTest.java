import org.example.asdc.Product;
import org.example.asdc.ProductTree;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class ProductTreeTest {
    private ProductTree tree;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @Before
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
        tree = new ProductTree();
        tree.insert(Product.create(1, "Хлеб1", "Белый хлеб1", 21, 31, "штука1"));
        tree.insert(Product.create(3, "Хлеб3", "Белый хлеб3", 23, 33, "штука3"));
        tree.insert(Product.create(2, "Хлеб2", "Белый хлеб2", 22, 32, "штука2"));
    }
    @Test
    public void testInsert() {
        //insert в before
        assertEquals("Хлеб1", tree.search(1).getName());
        assertEquals("Хлеб2", tree.search(2).getName());
        assertEquals("Хлеб3", tree.search(3).getName());
    }

    @Test
    public void testRemove() {
        tree.remove(1);
        assertNull(tree.search(1));
        assertEquals("Хлеб2", tree.search(2).getName());
        assertEquals("Хлеб3", tree.search(3).getName());
    }

    @Test
    public void testTraversePreOrder() {
        tree.traversePreOrder();

        assertEquals(tree.search(1).toString() + "\n"
                        + tree.search(3).toString() + "\n"
                        + tree.search(2).toString(),
                outputStreamCaptor.toString()
                        .trim());
    }

    @Test
    public void testTraversePostOrder() {
        tree.traversePostOrder();

        assertEquals(tree.search(2).toString() + "\n"
                + tree.search(3).toString() + "\n"
                + tree.search(1).toString(),
                outputStreamCaptor.toString()
                .trim());
    }

    @Test
    public void testTraverseInOrder() {
        tree.traverseInOrder();

        assertEquals(tree.search(1).toString() + "\n"
                        + tree.search(2).toString() + "\n"
                        + tree.search(3).toString(),
                outputStreamCaptor.toString()
                        .trim());
    }

    private String getOutput(Runnable r) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);
        PrintStream oldOut = System.out;
        System.setOut(ps);
        r.run();
        System.out.flush();
        System.setOut(oldOut);
        return baos.toString();
    }
}

