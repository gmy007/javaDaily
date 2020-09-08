package com.cug.nowkerTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main4 {
    static class Node {
        int val;
        Node left, right;
        public Node(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] str = in.readLine().split(" ");
        int n = Integer.valueOf(str[0]);
        int ro = Integer.valueOf(str[1]);
        Map<Integer, Node> map = new HashMap<>();
        Node root = getNodeFromVal(map, ro);
        for (int i = 0; i < n; i++) {
            str = in.readLine().split(" ");
            int cur = Integer.valueOf(str[0]);
            int l = Integer.valueOf(str[1]);
            int r = Integer.valueOf(str[2]);
            Node curRoot = getNodeFromVal(map, cur);
            Node left = getNodeFromVal(map, l);
            Node right = getNodeFromVal(map, r);
            curRoot.left = left;
            curRoot.right = right;
        }
        int m = Integer.valueOf(in.readLine());
        Map<Node, Node> parentMap = new HashMap<>();
        buildParentMap(parentMap, root);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            str = in.readLine().split(" ");
            int v1 = Integer.valueOf(str[0]);
            int v2 = Integer.valueOf(str[1]);
            Node o1 = getNodeFromVal(map, v1);
            Node o2 = getNodeFromVal(map, v2);
            Node ancestor = findLowestCommonAncestor(parentMap, o1, o2);
            // 对于有多组数据输入的情况，用StringBuilder.append()每个结果，最后一起输出
            // 不要每组数据都用System.out.println()
            sb.append(ancestor.val).append("\n");
        }
        System.out.print(sb.toString());
    }

    private static Node getNodeFromVal(Map<Integer, Node> map, int val) {
        map.putIfAbsent(val, new Node(val));
        return map.get(val);
    }

    private static void buildParentMap(Map<Node, Node> map, Node root) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            map.put(root.left, root);
        }
        if (root.right != null) {
            map.put(root.right, root);
        }
        buildParentMap(map, root.left);
        buildParentMap(map, root.right);
    }

    public static Node findLowestCommonAncestor(Map<Node, Node> parentMap, Node o1, Node o2) {
        Set<Node> set1 = new HashSet<>();
        while (o1 != null) {
            set1.add(o1);
            o1 = parentMap.get(o1);
        }
        while (!set1.contains(o2)) {
            o2 = parentMap.get(o2);
        }
        return o2;
    }
}
