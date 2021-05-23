import java.util.LinkedList;
import java.util.Queue;
/*
Abhishek Mishra
 Question: Given the root to the binary tree, implement serialize(root) which serializes the
 tree into a string and deserialize(String) which deserializes the string back into the tree
 */

public class Solution003 {

    public static void main(String s[]) {
        Node root = createTree();
        String serializedString = serialize(root);
        System.out.println(serializedString);
        Node node = deserialize_helper(serializedString);
        System.out.println(node.value);

    }

    //creating serializable method
    public static String serialize(Node root) {
        if (root == null) {
            return "X";
        }
        String leftSerialize = serialize(root.leftNode);
        String rightSerialize = serialize(root.rightNode);

        return root.value + "," + leftSerialize + "," + rightSerialize;
    }

    // deserializable helper method
    public static Node deserialize_helper(String data) {
        String arr[] = data.split(",");
        Queue<String> q = new LinkedList<>();
        for (String s : arr) {
            q.add(s);
        }
        Node root = deserialize(q);
        return root;
    }

    //deserializable method
    private static Node deserialize(Queue<String> q) {

        if (q.size() == 0) {
            return null;
        }
        // poll method return and remove the head of the queue
        String peek = q.poll();
        if (peek.equals("X")) {
            return null;
        }
        Node root = new Node(Integer.parseInt(peek)); // peek is in string
        root.leftNode = deserialize(q);
        root.rightNode = deserialize(q);
        return root;
    }


    //create a tree
    private static Node createTree() {

        //2nd node
        Node two = new Node(2);
        two.leftNode = null;
        two.rightNode = null;

        //3rd node
        Node three = new Node(3);
        three.leftNode = null;
        three.rightNode = null;

        // root node
        Node root = new Node(1);
        root.leftNode = two;
        root.rightNode = three;
        return root;
    }

    //creating Tree Node
    private static final class Node {
        private final int value;
        private Node leftNode;
        private Node rightNode;

        public Node(int value) {
            this.value = value;
        }
    }

}
