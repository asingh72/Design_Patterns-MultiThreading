
package wordTree.driver;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import wordTree.AVLTree.AVLTreeBuilder;
import wordTree.store.Results;
import wordTree.threadMgmt.CreateWorkers;
import wordTree.util.FileProcessor;
import wordTree.util.MyLogger;

public class Driver {
    
    
    
    public static void main(String[] args)
    {
        
        String input="";
        String output="";
        int num_of_threads=0;
        String delete_words="";
        int debug_value=0;
        
           Results result=new Results();
       
        
        
        if(args.length!=5)
        {
            System.err.println("Please enter the valid number of arguments");
        }
        else
        {
            input=args[0];
            output=args[1];
         result.setFilename(output);  
            if(!(Integer.parseInt(args[2])>=1&&Integer.parseInt(args[2])<=3))
            {
                System.err.println("Please enter the threads between 1 and 3");
            }
            else
            {
                num_of_threads=Integer.parseInt(args[2]);
                if(args[3].split(" ").length!=num_of_threads)
                {
                    System.out.println();
                }
                else
                {
                    delete_words=args[3];
                    if(!(Integer.parseInt(args[4])>=0&&Integer.parseInt(args[4])<=4))
                    {
                        System.err.println("Please enter the debug value between 0 and 4");
                    }
                    else
                    {
                        debug_value=Integer.parseInt(args[4]);
			MyLogger.setDebugValue(debug_value);
                       
                    }
                }
            }
        }
        
        
        
     

        AVLTreeBuilder tree=new AVLTreeBuilder();
      
        try {
            
         BufferedReader reader=new BufferedReader(new FileReader(input));

            FileProcessor fp=new FileProcessor(reader);
            
            CreateWorkers cw=new CreateWorkers(fp,tree);
            cw.startPopulateWorker(num_of_threads);
           cw.startDeleteWorkers(num_of_threads,delete_words.split(" "));
            
            
                    tree.countWords(tree.root);
                    tree.countCharacters(tree.root);
                    tree.countUniqueWords(tree.root);
                   
                    
                       result.storeNewResult("The total number of words: "+tree.getCount_Words());
                       result.storeNewResult("The total number of characters:"+tree.getCount_characters());
                       result.storeNewResult("The total number of distinct words: "+tree.getCount_unique_words());
                       
                       if(1==debug_value)
		       {
			       result.writeToScreen("");

		       }      
                       result.writeSchedulesToFile("");
                       
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Driver.class.getName()).log(Level.SEVERE, null, ex);
        }





                  
        
        
        
    }
    
}
