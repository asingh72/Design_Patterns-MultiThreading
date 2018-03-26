package wordTree.threadMgmt;

import java.io.BufferedReader;
import wordTree.AVLTree.AVLTreeBuilder;
import wordTree.util.FileProcessor;
import wordTree.util.MyLogger;


public class PopulateThread implements Runnable{

  
   private FileProcessor fp;
   private AVLTreeBuilder tree;
    public PopulateThread(FileProcessor fpIn,AVLTreeBuilder treeIn)
    {
        fp=fpIn;
        tree=treeIn;
    }

    @Override
    public void run() {
        
        try
        {
            String line="";
         
           while((line=fp.readLine())!=null)
           {

               String[] inArray=line.split(" ");
               for(String word :inArray)
               {
                   tree.insertWord(word);
                MyLogger.writeMessage("Populating words in the tree ", MyLogger.DebugLevel.IN_RUN);

               }
           }
            
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }
    
}
