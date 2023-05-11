package org.example.asdc;

import java.io.IOException;
import java.util.List;

public class Main {
    private static final String FILE_PATH = "Products.csv";
    public static void main(String[] args) {
        ProductLinkedList list = Service.getProductLinkedList(FILE_PATH);

        list.traverseAndPrint();
        System.out.println("-------------------");
        Product productB = list.find(2);
        System.out.println("Found product: " + productB + " with id: " + 2 + "\n");
        Product product15 = list.find(15);
        list.remove(15);
        System.out.println("\n-------------------List after removing product with id 15-------------------\n");
        list.traverseAndPrint();
        list.add(product15);
        System.out.println("\n-------------------List after adding product with id 15 back-------------------\n");
        list.traverseAndPrint();
    }


}