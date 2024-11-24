import java.util.ArrayList;

// Definition for a binary tree node.
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static boolean isInTree(TreeNode root, int target) {
        if (root == null) {
            return false;
        }
        if (root.val == target) {
            return true;
        }
        return isInTree(root.left, target) || isInTree(root.right, target);
    }

    public static int largestValueBST(TreeNode root) {
        if (root == null) {
            return -1;
        }
        int mx = root.val;
        TreeNode curr = root;
        while (curr != null) {
            mx = curr.val;
            curr = curr.right;
        }
        return mx;
    }

    public static int largestValue(TreeNode root) {
        if (root == null) {
            return -1;
        }
        int mx = root.val;
        mx = Math.max(mx, largestValue(root.left));
        mx = Math.max(mx, largestValue(root.right));
        return mx;
    }

    public static void allvalues(TreeNode root, ArrayList<Integer> values) {
        if (root == null) {
            return;
        }
        allvalues(root.left, values);
        values.add(root.val);
        allvalues(root.right, values);
    }

    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}
