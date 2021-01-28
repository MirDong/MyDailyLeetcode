  ## 二、二叉树

### 1.树的遍历

- #### 前序遍历

  前序遍历首先访问根节点，然后遍历左子树，最后遍历右子树。

  ```java
  //方法一  递归
      private static List<Integer> preOrderTraversal(TreeNode root){
          List<Integer> res = new ArrayList<>();
          preOrderByRecursive(root,res);
          return res;
      }
  
      private static List<Integer> preOrderByRecursive(TreeNode root, List<Integer> res) {
          if (root == null){
              return null;
          }
          res.add(root.val);
          preOrderByRecursive(root.leftTree,res);
          preOrderByRecursive(root.rightTree,res);
          return res;
      }
  ```

  **复杂度分析**  

  **时间复杂度**：O(n)，其中 nn、 是二叉树的节点数。每一个节点恰好被遍历一次。 

  **空间复杂度**：O(n)，为递归过程中栈的开销，平均情况下为 O(logn)，最坏情况下树呈现链状，为 O(n)。

  ```java
  //方法二  迭代
      private static List<Integer>preOrderTraversalByIterator(TreeNode root){
          List<Integer> res = new ArrayList<>();
          if (root == null){
              return res;
          }
  
          Deque<TreeNode> stack = new LinkedList<>();
          TreeNode node = root;
          while (!stack.isEmpty() || node != null){
              while (node != null){
                  res.add(node.val);
                  stack.push(node);
                  node = node.leftTree;
              }
              node = stack.pop();
              node = node.rightTree;
          }
          return res;
      }
  ```

  **复杂度分析**

  **时间复杂度**：O(n)，其中 n 是二叉树的节点数。每一个节点恰好被遍历一次。
  **空间复杂度**：O(n)，为迭代过程中显式栈的开销，平均情况下为 O(logn)，最坏情况下树呈现链状，为 O(n)。

- #### 中序遍历

- #### 后序遍历