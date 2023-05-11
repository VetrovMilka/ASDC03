package org.example.asdc;

public class ProductTree {
    private Node root;
    private static class Node {
        private Product product;
        private Node left;
        private Node right;

        public Node(Product product) {
            this.product = product;
        }
    }

    // Метод для обхода дерева в прямом порядке
    public void traversePreOrder() {
        traversePreOrder(root);
    }

    private void traversePreOrder(Node node) {
        if (node != null) {
            System.out.println(node.product);
            traversePreOrder(node.left);
            traversePreOrder(node.right);
        }
    }

    // Метод для обхода дерева в обратном порядке
    public void traversePostOrder() {
        traversePostOrder(root);
    }

    private void traversePostOrder(Node node) {
        if (node != null) {
            traversePostOrder(node.left);
            traversePostOrder(node.right);
            System.out.println(node.product);
        }
    }

    // Метод для центрированного/симметричного обхода дерева
    public void traverseInOrder() {
        traverseInOrder(root);
    }

    private void traverseInOrder(Node node) {
        if (node != null) {
            traverseInOrder(node.left);
            System.out.println(node.product);
            traverseInOrder(node.right);
        }
    }

    // Метод для вставки элемента в дерево
    public void insert(Product product) {
        root = insert(root, product);
    }

    private Node insert(Node node, Product product) {
        if (node == null) {
            return new Node(product);
        }

        if (product.compareTo(node.product) < 0) {
            node.left = insert(node.left, product);
        } else if (product.compareTo(node.product) > 0) {
            node.right = insert(node.right, product);
        }

        return node;
    }

    // Метод для удаления элемента из дерева
    public void remove(int id) {
        root = remove(root, search(id));
    }

    private Node remove(Node node, Product product) {
        if (node == null) {
            return null;
        }

        if (product.compareTo(node.product) < 0) {
            node.left = remove(node.left, product);
        } else if (product.compareTo(node.product) > 0) {
            node.right = remove(node.right, product);
        } else {
            if (node.left == null) {
                return node.right;
            } else if (node.right == null) {
                return node.left;
            }

            Node temp = findMin(node.right);
            node.product = temp.product;
            node.right = remove(node.right, temp.product);
        }

        return node;
    }

    private Node findMin(Node node) {
        while (node.left != null) {
            node = node.left;
        }

        return node;
    }
    // Метод для поиска элемента в дереве
    public Product search(int id) {
        return search(root, id).product;
    }

    private Node search(Node node, int id) {
        if (node == null || node.product.getId() == id) {
            return node;
        }

        if (id < node.product.getId()) {
            return search(node.left, id);
        } else {
            return search(node.right, id);
        }
    }
}



