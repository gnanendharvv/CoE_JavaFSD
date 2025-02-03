import java.util.*;

class BinaryTree {
    int value;
    BinaryTree left, right;
    BinaryTree(int value) {
        this.value = value;
        this.left = this.right = null;
    }
}

class TreeOperations {
    public String serializeTree(BinaryTree root) {
        if (root == null) return "null";
        return root.value + "," + serializeTree(root.left) + "," + serializeTree(root.right);
    }

    public BinaryTree deserializeTree(String data) {
        Queue<String> nodes = new LinkedList<>(Arrays.asList(data.split(",")));
        return buildTree(nodes);
    }

    private BinaryTree buildTree(Queue<String> nodes) {
        String value = nodes.poll();
        if (value.equals("null")) return null;
        BinaryTree node = new BinaryTree(Integer.parseInt(value));
        node.left = buildTree(nodes);
        node.right = buildTree(nodes);
        return node;
    }

    public static void main(String[] args) {
        TreeOperations operations = new TreeOperations();
        BinaryTree root = new BinaryTree(1);
        root.left = new BinaryTree(2);
        root.right = new BinaryTree(3);
        root.right.left = new BinaryTree(4);
        root.right.right = new BinaryTree(5);

        String serialized = operations.serializeTree(root);
        System.out.println("Serialized Binary Tree: " + serialized);

        BinaryTree deserializedRoot = operations.deserializeTree(serialized);
        System.out.println("Deserialization Completed");
    }
}
