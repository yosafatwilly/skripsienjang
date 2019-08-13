
package id.ac.usd.skripsienjang.strukdat;

public class MainProgram {
    public static void main(String[] args) {
        Tree tt = new Tree();
        tt.insert(42);
        tt.insert(21);
        tt.insert(38);
        tt.insert(27);
        tt.insert(71);
        tt.insert(82);
        tt.insert(55);
        tt.insert(63);
        tt.insert(6);
        tt.insert(2);
        tt.insert(40);
        tt.insert(12);
        
        System.out.print("InOrder  : ");
        tt.inOrderTraversal();
        System.out.println("");

        System.out.print("PreOrder : ");
        tt.preOrderTraversal();
        System.out.println("");
        
        System.out.print("PostOrder: ");
        tt.postOrderTraversal();
        System.out.println("");
        System.out.println("");
        
        System.out.print("Node 42 memiliki jumlah node                  = ");
        tt.nodecountTraversal(42);
        System.out.println("");
        
        System.out.print("Cabang kanan Node 42 memiliki jumlah node     = ");
        tt.rightnodecountTraversal(42);
        System.out.println("");
        
        System.out.print("Cabang kiri Node 42 memiliki jumlah node      = ");
        tt.leftnodecountTraversal(42);
        System.out.println("");
        
        System.out.println("Ketinggian dimulai dari 1 untuk root");
        
        System.out.print("Ketinggian node 6                             = ");
        tt.search(6);
        System.out.println(tt.sum);
        System.out.println("");
        
        System.out.print("Node 42 memiliki maks. ketinggian             = ");
        tt.heightTraversal(42);
        System.out.println("");
        
        System.out.print("Node 42 memiliki daun                         = ");
        tt.leafcountTraversal(42);
        System.out.println("");
        
        System.out.print("Cabang kanan node 42 memiliki daun            = ");
        tt.rightleafcountTraversal(42);
        System.out.println("");
        
        System.out.print("Cabang kiri node 42 memiliki daun             = ");
        tt.leftleafcountTraversal(42);
        System.out.println("");
        
        System.out.print("Node yang hanya memiliki cabang kiri          = ");
        tt.nomor8Traversal(42);
        System.out.println("");
        
        System.out.print("Node yang hanya memiliki cabang kanan         = ");
        tt.nomor9Traversal(42);
        System.out.println("");
        
        System.out.print("Node yang memiliki cabang kiri dan kanan      = ");
        tt.nomor10Traversal(42);
        System.out.println("");
//
//        System.out.print("Sebelum diceriminkan                          = ");
//        tt.inOrderTraversal();
//        System.out.println("");
//        System.out.println("");
//        
//        System.out.print("Setelah dicerminkan                           = ");
//        tt.refrectionTraversal(42);
//        System.out.println("");
    }
}
