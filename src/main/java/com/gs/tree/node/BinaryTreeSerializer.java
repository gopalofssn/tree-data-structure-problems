package com.gs.tree.node;

import java.util.LinkedList;
import java.util.Queue;

public final class BinaryTreeSerializer {

  public static String serialize(TreeNode root) {
    if (root == null)
      return "null";

    StringBuilder sb = new StringBuilder();
    Queue<TreeNode> queue = new LinkedList<TreeNode>();
    queue.offer(root);

    while (!queue.isEmpty()) {
      int sz = queue.size();
      for (int index = 0; index < sz; index++) {
        TreeNode current = queue.poll();
        if (current == null) {
          sb.append("X, ");
          continue;
        }
        sb.append(current.value).append(", ");
        queue.offer(current.left);
        queue.offer(current.right);
      }
    }

    return sb.substring(0, sb.length() - 2); // "removing ,<space>
  }

}
