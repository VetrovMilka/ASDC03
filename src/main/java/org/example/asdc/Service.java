package org.example.asdc;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class Service {

    public static String SEPARATOR = ";";
    public static Product csvToProduct(String data) {
        try {
            String[] tokens = data.split(SEPARATOR);
            return Product.create(
                    Integer.parseInt(tokens[0]),
                    tokens[1],
                    tokens[2],
                    Integer.parseInt(tokens[3]),
                    Integer.parseInt(tokens[4]),
                    tokens[5]
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static List<Product> readData(String path) {
        String data;
        List<Product> result = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(path, StandardCharsets.UTF_8))) {
            while((data = reader.readLine()) != null) {
                data = data.replaceAll("\\p{C}", "");
                Product product = csvToProduct(data);
                result.add(product);
            }
        } catch(IOException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }

    public static void writeData(String path, Product product) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(path, true));
        writer.append("\n").append(product.toString());
        writer.close();
    }

}
