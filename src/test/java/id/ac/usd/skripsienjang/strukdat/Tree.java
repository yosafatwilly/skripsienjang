                    
package id.ac.usd.skripsienjang.strukdat;

public class Tree {
    private TreeNode root;
    int sum = 1;
    
    public Tree() {
    }
    public Tree(TreeNode root) {
        this.root = root;
    }
    public TreeNode getRoot() {
        return root;
    }
    public void setRoot(TreeNode root) {
        this.root = root;
    }
    public void insert(int key){
        if (getRoot() == null) {
            root = new TreeNode(key);
        }else{
            TreeNode baru = new TreeNode(key);
            TreeNode bantu = getRoot();
            while(true){
                if (key < bantu.getData()) {
                    if (bantu.getLeftNode() == null) {
                        bantu.setLeftNode(baru);
                        return;
                    }else{
                        bantu = bantu.getLeftNode();
                    }
                }else{
                    if (bantu.getRightNode() == null) {
                        bantu.setRightNode(baru);
                        return;
                    }else{
                        bantu = bantu.getRightNode();
                    }
                }
            }
        }
    }
    public TreeNode search(int key){
        TreeNode temp = getRoot();
        while(temp != null){
            if (temp.getData() == key) {
                return temp;
            }
            else if (key < temp.getData()) {
                    temp = temp.getLeftNode();
            }else{
                    temp = temp.getRightNode();                
            }
            sum++;
        }
        return temp;
    }

    public TreeNode Parent(int key){
        TreeNode temp = getRoot();
        TreeNode parent = getRoot();
        while(temp != null){
            if (temp.getData() == key) {
                return parent;
            } else if (temp.getData() > key){
                parent = temp;
                temp = temp.getLeftNode();
            } else {
                parent = temp;
                temp = temp.getRightNode();
            }
        }
        return null;
    }
    public void inorderHelper(TreeNode tmp){
        if (tmp != null) {
            inorderHelper(tmp.getLeftNode());
            System.out.print(tmp.getData()+" ");
            inorderHelper(tmp.getRightNode());
        }
    }
    public void inOrderTraversal(){
        inorderHelper(root);
    }
    public void preorderHelper(TreeNode tmp){
        if (tmp != null) {
            System.out.print(tmp.getData()+" ");
            preorderHelper(tmp.getLeftNode());
            preorderHelper(tmp.getRightNode());
        }
    }
    public void preOrderTraversal(){
        preorderHelper(root);
    }
    public void postorderHelper(TreeNode tmp){
        if (tmp != null) {
            postorderHelper(tmp.getLeftNode());
            postorderHelper(tmp.getRightNode());
            System.out.print(tmp.getData()+" ");
        }
    }
    public void postOrderTraversal(){
        postorderHelper(root);
    }
    public boolean delete(int key){
        TreeNode bantu = search(key);
        if (bantu == null) {
            return false;
        }else{//start
            if (bantu.getData()==root.getData()) {
                if (bantu.getLeftNode() == null && bantu.getRightNode() == null) {
                    root = null;
                }else if(bantu.getLeftNode() == null){
                    root = bantu.getRightNode();
                }else if(bantu.getRightNode() == null){
                    root = bantu.getLeftNode();
                }else{
                    deleteSuccessor(key);
                }
            }else{
                TreeNode parent = Parent(key);
                if (key < parent.getData()) {
                    if (bantu.getLeftNode() == null && 
                            bantu.getRightNode() == null) {
                        parent.setLeftNode(null);
                    }else if(bantu.getRightNode() == null ) {
                        parent.setLeftNode(bantu.getLeftNode());
                    }else if(bantu.getLeftNode() == null){
                        parent.setLeftNode(bantu.getRightNode());
                    }else{
                        deleteSuccessor(key);
                    }
                }else{
                    if (bantu.getLeftNode() == null && 
                            bantu.getRightNode() == null) {
                        parent.setRightNode(null);
                    }else if(bantu.getRightNode() == null ) {
                        parent.setRightNode(bantu.getLeftNode());
                    }else if (bantu.getLeftNode() == null){
                        parent.setRightNode(bantu.getRightNode());
                    }else{
                        deleteSuccessor(key);
                    }
                }
            }
        }
        return true;
    }
    public void deleteSuccessor(int key){
        TreeNode node = search(key);
        TreeNode temp = getSuccessor(node);
        if(temp.getData() == node.getLeftNode().getData()){
            if(Parent(node.getData()).getRightNode() == node){
                Parent(node.getData()).setRightNode(node.getLeftNode());
            }else if (Parent(node.getData()).getLeftNode() == node){
                Parent(node.getData()).setLeftNode(node.getLeftNode());
            }
            node.getLeftNode().setRightNode(node.getRightNode());
        }else{
            if (temp.getLeftNode() == null ){
                Parent(temp.getData()).setRightNode(null);
            }else{
                Parent(temp.getData()).setRightNode(temp.getLeftNode());
            }
        }
        node.setData(temp.getData());
    }
    public TreeNode getSuccessor(TreeNode Node){
        TreeNode bantu = Node.getRightNode();
        while(bantu.getLeftNode() != null){
            bantu = bantu.getLeftNode();
        }
        return bantu;
    }
    public TreeNode getPredecessor(TreeNode Node){
        TreeNode bantu = Node.getLeftNode();
        while(bantu.getRightNode() != null){
            bantu = bantu.getRightNode();
        }
        return bantu;
    }
    public int nodecountHelper(TreeNode tmp){
        if (tmp != null) {
            return nodecountHelper(tmp.getRightNode())+nodecountHelper(tmp.getLeftNode())+1;
        }else{
            return 0;
        }
    }
    public void nodecountTraversal(int key){
        TreeNode node = search(key);
        System.out.println(nodecountHelper(node));
    }
    public void rightnodecountTraversal(int key){
        TreeNode node = search(key);
        System.out.println(nodecountHelper(node.getRightNode()));
    }
    public void leftnodecountTraversal(int key){
        TreeNode node = search(key);
        System.out.println(nodecountHelper(node.getLeftNode()));
    }
    public int leafcountHelper(TreeNode tmp){
        if (tmp == null) {
            return 0;
        }else if(tmp.getLeftNode() == null && tmp.getRightNode() == null){
            System.out.print(tmp.getData()+" ");
            return 1;
        }else{
            return leafcountHelper(tmp.getLeftNode())+leafcountHelper(tmp.getRightNode());
        }
    }
    public void leafcountTraversal(int key){
        TreeNode node = search(key);
        System.out.println("atau "+leafcountHelper(node)+" helai daun");
    }
    public void rightleafcountTraversal(int key){
        TreeNode node = search(key);
        System.out.println("atau "+leafcountHelper(node.getRightNode())+" helai daun");
    }
    public void leftleafcountTraversal(int key){
        TreeNode node = search(key);
        System.out.println("atau "+leafcountHelper(node.getLeftNode())+" helai daun");
    }
    public int heightHelper(TreeNode tmp){
        if (tmp == null) {
            return 0;
        }else{
            int leftHeight = heightHelper(tmp.getLeftNode());
            int rightHeight = heightHelper(tmp.getRightNode());
            if (leftHeight > rightHeight) {
                return leftHeight+1;
            }else {
                return rightHeight+1;
            }
        }
    }
    public void heightTraversal(int key){
        TreeNode node  = search(key);
        System.out.println(heightHelper(node));
    }
    public int nomor8Helper(TreeNode tmp){
        if (tmp == null) {
            return 0;
        }else if(tmp.getLeftNode() != null && tmp.getRightNode() == null){
            System.out.print(tmp.getData()+" ");
            return 1;
        }else{
            return nomor8Helper(tmp.getLeftNode())+nomor8Helper(tmp.getRightNode());
        }
    }
    public int nomor9Helper(TreeNode tmp){
        if (tmp == null) {
            return 0;
        }else if(tmp.getLeftNode() == null && tmp.getRightNode() != null){
            System.out.print(tmp.getData()+" ");
            return 1;
        }else{
            return nomor9Helper(tmp.getLeftNode())+nomor9Helper(tmp.getRightNode());
        }
    }
    public int nomor10Helper(TreeNode tmp){
        if (tmp == null) {
            return 0;
        }else if(tmp.getLeftNode() != null && tmp.getRightNode() != null){
            int a = nomor10Helper(tmp.getLeftNode())+nomor10Helper(tmp.getRightNode());
            System.out.print(tmp.getData()+" ");
            return a+1;
        }else{
            return 0;
        }
    }
    public void nomor8Traversal(int key){
        TreeNode node = search(key);
        System.out.println("atau "+nomor8Helper(node)+" helai daun");
    }
    public void nomor9Traversal(int key){
        TreeNode node = search(key);
        System.out.println("atau "+nomor9Helper(node)+" helai daun");
    }
    public void nomor10Traversal(int key){
        TreeNode node = search(key);
        System.out.println("atau "+nomor10Helper(node)+" helai daun");
    }
//    public TreeNode reflection(TreeNode tmp){
//        if (tmp == null) {
//            return tmp;
//        }else{
//            
//        }
//        return tmp;
//    }
//    public void refrectionTraversal(int key){
//        TreeNode node = search(key);
//        reflection(node);
//    }
}