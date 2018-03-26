package wordTree.threadMgmt;

import wordTree.AVLTree.AVLTreeBuilder;
import wordTree.util.FileProcessor;


public class DeleteThread implements Runnable {
  private FileProcessor fp;
   private AVLTreeBuilder tree;
   private String word;
    public DeleteThread(FileProcessor fpIn,AVLTreeBuilder treeIn,String wordIn)
    {
        fp=fpIn;
        tree=treeIn;
        word=wordIn;
    }
    @Override
    public  void run() {
        
        try
        {
            tree.deleteWord(word, tree.root);
          
            
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }  
}
