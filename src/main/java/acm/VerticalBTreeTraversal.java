package acm;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * @author kuangjunlin
 */
class VerticalBinaryTreeTraversal {
    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode6 = new TreeNode(6);
        TreeNode treeNode7 = new TreeNode(7);
        treeNode1.left=treeNode2;
        treeNode1.right=treeNode3;
        treeNode2.left=treeNode4;
        treeNode2.right=treeNode5;
        treeNode3.left=treeNode6;
        treeNode3.right=treeNode7;
        VerticalBinaryTreeTraversal v = new VerticalBinaryTreeTraversal();

        List<List<Integer>> lists = v.verticalTraversal(treeNode1);
        System.out.println(lists.toString());
    }
    List<Location> locations = new ArrayList<>();
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        dfs(root, 0, 0);
        Collections.sort(locations);

        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());

        int prev = locations.get(0).x;

        for (Location loc:locations
             ) {
            if (loc.x != prev){
                prev = loc.x;
                result.add(new ArrayList<>());
            }
            result.get(result.size() -1).add(loc.val);
        }
        return result;
    }

    public void dfs(TreeNode node, int x, int y){
        if (node != null){
            locations.add(new Location(x, y, node.val));
            dfs(node.left, x-1, y+1);
            dfs(node.right, x+1, y+1);
        }
    }
}

class Location implements Comparable<Location>{
    int x,y,val;

    public Location(int x, int y, int val) {
        this.x = x;
        this.y = y;
        this.val = val;
    }

    @Override
    public int compareTo(Location o) {
        if (this.x != o.x) {
            return Integer.compare(this.x, o.x);
        }else if (this.y != o.y){
            return Integer.compare(this.y, o.y);
        }else {
            return Integer.compare(this.val, o.val);
        }
    }
}

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val){ this.val = val; }
}

