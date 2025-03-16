import java.util.Scanner;

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
        left = right = null;
    }
}

public class KthSmallestBST {
    static int count = 0;
    static int result = -1;

    public static TreeNode insert(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);
        if (val < root.val) root.left = insert(root.left, val);
        else root.right = insert(root.right, val);
        return root;
    }

    public static void kthSmallest(TreeNode root, int k) {
        if (root == null) return;
        
        kthSmallest(root.left, k);
        
        count++;
        if (count == k) {
            result = root.val;
            return;
        }
        
        kthSmallest(root.right, k);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TreeNode root = null;

        System.out.println("Enter the number of nodes:");
        int n = scanner.nextInt();

        System.out.println("Enter the node values:");
        for (int i = 0; i < n; i++) {
            int val = scanner.nextInt();
            root = insert(root, val);
        }

        System.out.println("Enter k:");
        int k = scanner.nextInt();

        if(k>n)
        {
            System.out.println("Invalid k value. Please enter a value less than or equal to " + n);
            scanner.close();
            return;
        }
        kthSmallest(root, k);
        System.out.println("The " + k + "th smallest element is: " + result);
        
        scanner.close();
    }
}
