//package id.ac.usd.skripsienjang.tree;
//
//import java.util.Arrays;
//
//public class MainNode {
//    public static void main(String[] args) {
//        Node<String> root = new Node<>("Root");
//
//        Node<String> child1 = new Node<>("Child1");
//        child1.addChild("Grandchild1");
//        child1.addChild("Grandchild2");
//
//        Node<String> child2 = new Node<>("Child2");
//        child2.addChild("Grandchild3");
//
//        root.addChild(child1);
//        root.addChild(child2);
//        root.addChild("Child3");
//
//        root.addChildren(Arrays.asList(
//                new Node<>("Child4"),
//                new Node<>("Child5"),
//                new Node<>("Child6")
//        ));
//
//        for(Node node : root.getChildren()) {
//            System.out.println(node.getData());
//        }
//    }
//
//
//}
