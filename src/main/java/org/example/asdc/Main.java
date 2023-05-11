package org.example.asdc;

import java.io.IOException;
import java.util.List;

public class Main {
    private static final String FILE_PATH = "Products.csv";
    public static void main(String[] args) throws IOException {

//        Product product = Product.create(
//                27,
//                "Макароны",
//                "Макароны",
//                50,
//                122,
//                "piece");
//
//        Service.writeData(FILE_PATH, product);

        List<Product> products = Service.readData(FILE_PATH);

        long linearTime = System.nanoTime();
        Product linearSearchProduct = Algorithms.linearSearch(products, 2);
        System.out.println(linearSearchProduct);
        System.out.println("Linear search time: " + (System.nanoTime() - linearTime) + " nanoseconds \n");

        long binaryTime = System.nanoTime();
        Product binarySearchProduct = Algorithms.binarySearch(products, 3);
        System.out.println(binarySearchProduct);
        System.out.println("Binary search time: " + (System.nanoTime() - binaryTime) + " nanoseconds \n");

        long interpolationTime = System.nanoTime();
        Product interpolationSearchProduct = Algorithms.interpolationSearch(products, 4);
        System.out.println(interpolationSearchProduct);
        System.out.println("Interpolation search time: " + (System.nanoTime() - interpolationTime) + " nanoseconds \n");

        long fibonacciTime = System.nanoTime();
        Product fibonacciSearchProduct = Algorithms.fibonacciSearch(products, 5);
        System.out.println(fibonacciSearchProduct);
        System.out.println("Fibonacci search time: " + (System.nanoTime() - fibonacciTime) + " nanoseconds \n");

        long treeTime = System.nanoTime();
        Product treeSearchProduct = Algorithms.searchInTree(products, 6);
        System.out.println(treeSearchProduct);
        System.out.println("Search In Tree time: " + (System.nanoTime() - treeTime) + " nanoseconds \n");

    }

}