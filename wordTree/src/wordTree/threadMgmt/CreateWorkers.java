package wordTree.threadMgmt;

import java.io.FileReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import wordTree.AVLTree.AVLTreeBuilder;
import wordTree.util.FileProcessor;
import wordTree.util.MyLogger;


public class CreateWorkers {
    FileProcessor fp;
    AVLTreeBuilder tree;
    
    public CreateWorkers(FileProcessor fp, AVLTreeBuilder tree) {
        MyLogger.writeMessage("In CreateWorkers Constructor", MyLogger.DebugLevel.CONSTRUCTOR);
        this.fp=fp;
        this.tree=tree;
    }
    
    /**
     * This method will create threads and then with the help of multi threading it will start populating those words in the AVL tree
     * @param num_of_threads the parameter to decide how many threads to made
     */
    public void startPopulateWorker(int num_of_threads)
    {
        PopulateThread pth=new PopulateThread(fp,tree);
        Thread[] threads=new Thread[num_of_threads];
       for(int i=0;i<threads.length;i++)
       {
           threads[i]=new Thread(new PopulateThread(fp,tree) );
           threads[i].setName("Thread"+i);
       }

        for(Thread thread :threads)
        {
            thread.start();
        }
        
         try
         {
             for(Thread thread : threads)
              {
                   thread.join();
                }
       
         }
         catch(Exception ex)
         {
             ex.printStackTrace();
         }
        
        
    }
    
    /**
     * This method will create threads and then with the help of multi threading it will start deleting those words from the AVL tree
     * @param num_of_threads the parameter to decide how many threads to made
     * @param words this array contains the words to be deleted
     */
     public void startDeleteWorkers(int num_of_threads,String []words)
     {
         Thread[] threads=new Thread[num_of_threads];
         
       for(int i=0;i<threads.length;i++)
       {
           threads[i]=new Thread(new DeleteThread(fp,tree,words[i]) );
           threads[i].setName("Thread"+i);
       }
         
       
       for(Thread thread:threads)
       {
           thread.start();
       }
        for(Thread thread:threads)
       {
             try {
                 thread.join();
             } catch (InterruptedException ex) {
                 Logger.getLogger(CreateWorkers.class.getName()).log(Level.SEVERE, null, ex);
             }
       }
       
       
       
     }
   
    
    
    
    
}
