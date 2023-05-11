package org.example.asdc;

import java.util.Collections;
import java.util.List;

public class Algorithms {


    public static Product linearSearch(List<Product> products, int targetId) {

        for (Product product : products) {
            if (product.getId() == targetId) {
                return product;
            }
        }
        return null;
    }

    public static Product searchInTree(List<Product> products, int targetId) {

        Collections.sort(products);

        ProductTree productTree = new ProductTree();
        for(Product product : products){
            productTree.add(product);
        }
        Product result = products.get(targetId-1);
        return productTree.get(result);
    }

    public static Product binarySearch(List<Product> products, int targetId) {

        Collections.sort(products);

        int left = 0;
        int right = products.size() - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            Product result = products.get(mid);
            int elementId = result.getId();

            if (elementId == targetId) {
                return result;
            }
            else if (elementId < targetId) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }
        return null;
    }

    public static Product interpolationSearch(List<Product> products, int targetId) {

        Collections.sort(products);

        int left = 0;
        int right = products.size() - 1;

        while (left <= right && targetId >= products.get(left).getId() && targetId <= products.get(right).getId()) {
            int leftId = products.get(left).getId();
            int rightId = products.get(right).getId();

            int pos = left + ((targetId - leftId) * (right - left))
                    / (rightId - leftId);

            Product result = products.get(pos);

            if (result.getId() == targetId) {
                return result;
            } else if (result.getId() < targetId) {
                left = pos + 1;
            } else {
                right = pos - 1;
            }
        }
        return null;
    }


    public static Product fibonacciSearch(List<Product> products, int targetId) {

        Collections.sort(products);

        Product product = products.get(targetId);
        int n = products.size();
        int fibMMm2 = 0;
        int fibMMm1 = 1;
        int fibM = fibMMm2 + fibMMm1;

        while (fibM < n) {
            fibMMm2 = fibMMm1;
            fibMMm1 = fibM;
            fibM = fibMMm2 + fibMMm1;
        }

        int offset = -1;

        while (fibM > 1) {
            int i = Math.min(offset + fibMMm2, n - 1);

            if (products.get(i).compareTo(product) < 0) {
                fibM = fibMMm1;
                fibMMm1 = fibMMm2;
                fibMMm2 = fibM - fibMMm1;
                offset = i;
            } else if (products.get(i).compareTo(product) > 0) {
                fibM = fibMMm2;
                fibMMm1 = fibMMm1 - fibMMm2;
                fibMMm2 = fibM - fibMMm1;
            } else {
                return products.get(i - 1);
            }
        }

        if (fibMMm1 == 1 && products.get(offset + 1).compareTo(product) == 0) {
            return products.get(offset + 1);
        }
        return null;
    }
}
