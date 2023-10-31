import javax.swing.tree.TreeNode;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}


// best. in order but iterative not recursive
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        LinkedList<TreeNode> stack = new LinkedList<>();

        while (true) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (--k == 0) return root.val;
            root = root.right;
        }
    }
}



// mine. works but ugly
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        PriorityQueue<Integer> PQ = new PriorityQueue<>((a,b) -> b-a);
        if(root == null){
            return -1;
        }

        DFS(root, k, PQ);

        return PQ.peek();
    }

    public void DFS(TreeNode root, int k, PriorityQueue<Integer> que){
        if(root != null){
            que.add(root.val);
            if (que.size() > k){
                que.poll();
            }
            DFS(root.left, k, que);
            DFS(root.right, k, que);
        }
    }
}

// DFS with priority queu limited to size of K



// FUGGIN DING DONG, THIS IS A BST. IF ITS KNOWN TO BE VALID, JUST TO IN-ORDER SEARCH AND INCREMENT COUNTER WITH
// EACH NON-NULL VAL FOUND AND RETURN VAL @ K WHEN COUNTER = K

class Solution {

    int count = 0;

    public int kthSmallest(TreeNode root, int k) {
        if(root == null){
            return ++count;
        }
        kthSmallest(root.left,k);
        count++;
        kthSmallest(root.right,k);
        // problem is, how do i break out of recursion stack entirely when count == k

    }
}