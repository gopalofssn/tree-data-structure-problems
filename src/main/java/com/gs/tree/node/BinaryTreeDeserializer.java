package com.gs.tree.node;

import java.util.LinkedList;
import java.util.Queue;

public final class BinaryTreeDeserializer {

  public static TreeNode deserialize(String content) {
    if (content == null || content.isBlank()) {
      return null;
    }

    String[] nodes = content.split(",");
    if (nodes.length == 0) {
      System.out.println("Input " + content);
      throw new IllegalArgumentException("Illegal Data format, please use sample as 1, 2, 3, X, 5, 7, X");
    }

    int index = 0;
    TreeNode root = buildTreNode(nodes[index]);
    index++;

    Queue<TreeNode> queue = new LinkedList<TreeNode>();
    queue.offer(root);

    while ( !queue.isEmpty() && (index < nodes.length) ) {
      int sz = queue.size();
      for (int i = 0; i < sz; i++) {
        TreeNode current = queue.poll();
        
        TreeNode left = buildTreNode(nodes[index]);
        index++;
        if(left != null) {
          current.left = left;
          queue.offer(left);
        }
        
        TreeNode right = buildTreNode(nodes[index]);
        index++;
        if(right != null) {
          current.right = right;
          queue.offer(right);
        }
        
      }
    }

    return root;
  }

  private static TreeNode buildTreNode(String valueAsString) {
    if (valueAsString.trim().equalsIgnoreCase("X")) {
      return null;
    }
    
    int value = Integer.parseInt(valueAsString.trim());
    
    return new TreeNode(value);
  }

  public static void main(String[] args) {
    TreeNode root = BinaryTreeDeserializer.deserialize("1, 2, 3, X, 5, 7, X, X, X, X, X");
    System.out.println(root);
    System.out.println( "same ? " + root.toString().equalsIgnoreCase("1, 2, 3, X, 5, 7, X, X, X, X, X"));
  }
}
