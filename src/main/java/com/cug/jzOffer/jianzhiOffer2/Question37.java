package com.cug.jzOffer.jianzhiOffer2;

public class Question37 {

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    public static void main(String[] args) {
        Question37 question37 = new Question37();
        TreeNode root=question37.new  TreeNode(1);
         root.left=question37.new  TreeNode(2);
         root.right=question37.new TreeNode(3);
        String s = question37.Serialize(root);
        System.out.println(s);
        String s2="123!";

        //System.out.println(s2.indexOf("!"));;
        //System.out.println(s2.substring(1));
        question37.Deserialize(s);
    }
    String Serialize(TreeNode root) {
        if(root==null)
            return "#!";
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(root.val).append("!").append(Serialize(root.left)).append(Serialize(root.right));
        return stringBuilder.toString();

    }
    private String deserialize;
    TreeNode Deserialize(String str) {
        deserialize=str;
        return Deserialize();

    }
    public TreeNode Deserialize(){
        if(deserialize.length()==0)
            return null;


        int index=deserialize.indexOf("!");
        String node= index==-1? deserialize:deserialize.substring(0,index);
        deserialize=index== -1? "":deserialize.substring(index+1);
        if(node.equals("#"))
            return null;
        TreeNode treeNode = new TreeNode(Integer.valueOf(node));
        treeNode.left=Deserialize();
        treeNode.right=Deserialize();
        return treeNode;
    }
}
