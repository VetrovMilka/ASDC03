package org.example.asdc;

public class ProductTree {

    private ProductNode root;

    public void add(Product product){
        root = insert(root, product);
    }
    public Product get(Product product){
        return search(root, product).data;
    }

    private ProductNode insert(ProductNode node, Product data) {
        if(node == null) {
            node = new ProductNode(data);
        }else {
            if(data.getId() < node.getData().getId()){
                node.setLeft(insert(node.getLeft(), data));
            }else if(data.getId() > node.getData().getId()){
                node.setRight(insert(node.getRight(), data));
            }
        }
        return node;
    }

    public ProductNode getRoot() {
        return root;
    }

    private ProductNode search(ProductNode root, Product data){
        if(root == null){
            return null;
        }
        while (root != null){
            if(data.equals(root.getData())){
                return root;
            }else if(data.getId() > root.getData().getId()){
                root = root.getRight();
            }else {
                root = root.getLeft();
            }
        }
        return null;
    }


    private static class ProductNode{
        private final Product data;
        private ProductNode left;
        private ProductNode right;

        public ProductNode(Product product){
            this.data = product;
            left = null;
            right = null;
        }


        public ProductNode getLeft() {
            return left;
        }

        public void setLeft(ProductNode left) {
            this.left = left;
        }

        public ProductNode getRight() {
            return right;
        }

        public void setRight(ProductNode right) {
            this.right = right;
        }

        public Product getData() {
            return data;
        }
    }
}
