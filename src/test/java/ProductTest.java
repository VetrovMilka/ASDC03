import org.example.asdc.Product;
import org.junit.Test;


import static org.junit.Assert.*;

public class ProductTest {

    @Test
    public void testEquals() {
        Product product1 = new Product(1, "Product1", "Description1", 100, 10, "kg");
        Product product2 = new Product(1, "Product1", "Description1", 100, 10, "kg");
        Product product3 = new Product(2, "Product2", "Description2", 200, 20, "g");

        assertEquals(product1, product2);
        assertNotEquals(product1, product3);
    }

    @Test
    public void testHashCode() {
        Product product1 = new Product(1, "Product1", "Description1", 100, 10, "kg");
        Product product2 = new Product(1, "Product1", "Description1", 100, 10, "kg");
        Product product3 = new Product(2, "Product2", "Description2", 200, 20, "g");

        assertEquals(product1.hashCode(), product2.hashCode());
        assertNotEquals(product1.hashCode(), product3.hashCode());
    }

    @Test
    public void testToString() {
        Product product1 = new Product(1, "Product1", "Description1", 100, 10, "kg");

        assertEquals("1;Product1;Description1;100;10;kg", product1.toString());
    }

    @Test
    public void testCopy() {
        Product product1 = new Product(1, "Product1", "Description1", 100, 10, "kg");
        Product product2 = product1.copy();

        assertEquals(product1, product2);
        assertNotSame(product1, product2);
    }

    @Test
    public void testCreate() {
        Product product1 = Product.create(1, "Product1", "Description1", 100, 10, "kg");

        assertNotNull(product1);
        assertEquals(Integer.valueOf(1), product1.getId());
        assertEquals("Product1", product1.getName());
        assertEquals("Description1", product1.getDescription());
        assertEquals(Integer.valueOf(100), product1.getPrice());
        assertEquals(Integer.valueOf(10), product1.getPieces());
        assertEquals("kg", product1.getUnitOfMeasurement());
    }

    @Test
    public void testCompareTo() {
        Product product1 = new Product(1, "Product1", "Description1", 100, 10, "kg");
        Product product2 = new Product(2, "Product2", "Description2", 200, 20, "g");
        Product product3 = new Product(3, "Product3", "Description3", 300, 30, "ml");

        assertTrue(product1.compareTo(product2) < 0);
        assertTrue(product2.compareTo(product3) < 0);
        assertTrue(product1.compareTo(product3) < 0);
    }
}
