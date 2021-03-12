package com.gs.tree.node;

public class TreeNode {
  public int value;
  public TreeNode left;
  public TreeNode right;

  public TreeNode(int value) {
    this.value = value;
  }

  @Override
  public String toString() {
    BinaryTreePrinter.printTreeNode(this);
    return BinaryTreeSerializer.serialize(this);
  }
}
