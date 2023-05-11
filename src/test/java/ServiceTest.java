import org.example.asdc.Product;
import org.example.asdc.ProductLinkedList;
import org.example.asdc.ProductTree;
import org.example.asdc.Service;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

public class ServiceTest {

    private final static String TEST_DATA_PATH = "test_data.csv";
    private final static String TEST_PRODUCT_STRING = "1;Product 1;Description 1;100;10;pieces";

    @Test
    void testCsvToProduct() {
        Product expectedProduct = new Product(1, "Product 1", "Description 1", 100, 10, "pieces");
        Product actualProduct = Service.csvToProduct(TEST_PRODUCT_STRING);
        assertEquals(expectedProduct, actualProduct);
    }

    @Test
    void testGetProductLinkedList() throws IOException {
        String testData = TEST_PRODUCT_STRING + "\n" + "2;Product 2;Description 2;200;20;pieces";
        Files.write(Paths.get(TEST_DATA_PATH), testData.getBytes());

        ProductLinkedList expectedList = new ProductLinkedList();
        expectedList.add(new Product(1, "Product 1", "Description 1", 100, 10, "pieces"));
        expectedList.add(new Product(2, "Product 2", "Description 2", 200, 20, "pieces"));

        ProductLinkedList actualList = Service.getProductLinkedList(TEST_DATA_PATH);

        assertEquals(expectedList.find(0), actualList.find(0));
        assertEquals(expectedList.find(1), actualList.find(1));

        Files.deleteIfExists(Paths.get(TEST_DATA_PATH));
    }

    @Test
    void testGetProductTree() throws IOException {
        String testData = TEST_PRODUCT_STRING + "\n" + "2;Product 2;Description 2;200;20;pieces";
        Files.write(Paths.get(TEST_DATA_PATH), testData.getBytes());

        ProductTree expectedTree = new ProductTree();
        expectedTree.insert(new Product(1, "Product 1", "Description 1", 100, 10, "pieces"));
        expectedTree.insert(new Product(2, "Product 2", "Description 2", 200, 20, "pieces"));

        ProductTree actualTree = Service.getProductTree(TEST_DATA_PATH);

        assertEquals(expectedTree.search(0), actualTree.search(0));
        assertEquals(expectedTree.search(1), actualTree.search(1));

        Files.deleteIfExists(Paths.get(TEST_DATA_PATH));
    }

    @Test
    void testWriteData() throws IOException {
        Product product = new Product(1, "Product 1", "Description 1", 100, 10, "pieces");
        String expectedOutput = "\n" + product.toString();

        String testOutputPath = "test_output.csv";
        Service.writeData(testOutputPath, product);

        String actualOutput = Files.readString(Paths.get(testOutputPath));
        assertEquals(expectedOutput, actualOutput);

        Files.deleteIfExists(Paths.get(testOutputPath));
    }
}
