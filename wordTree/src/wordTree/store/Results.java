
package wordTree.store;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import wordTree.util.FileDisplayInterface;
import wordTree.util.MyLogger;
import wordTree.util.StdoutDisplayInterface;


public class Results implements FileDisplayInterface,StdoutDisplayInterface{

    private ArrayList<String> ResultData;
    private String Filename;
    private FileOutputStream outputFile;
    
    public Results()
    {
        MyLogger.writeMessage("In Results Constructor", MyLogger.DebugLevel.CONSTRUCTOR);
        ResultData=new ArrayList<String>();
    }
    public void setFilename(String filename)
    {
        
        Filename=filename;    
      
    }
        
    @Override
    public void writeSchedulesToFile (String s) {
        
        try
        {
           
            
        outputFile=new FileOutputStream(Filename);
        String Content1="";
        
        
        String Content="";
        
        for(String result:ResultData)
        {
            Content=Content+result+"\n";
        }
        Content1=Content1+Content;
        byte[] con=(Content1).getBytes();
        
         outputFile.write(con);

        }
        catch(FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch(IOException ex)
        {
            ex.printStackTrace();
        }
        finally
        {
            try
            {
            outputFile.close();
            }
            catch(Exception e)
            {
                
            }
        }
    }

    @Override
    public void writeToScreen(String s) {
        MyLogger.writeMessage("In writeToScreen function", MyLogger.DebugLevel.FROM_RESULTS);
        for(int i=0;i<ResultData.size();i++)
        {
            System.out.println(ResultData.get(i));
        }
       
    }
    
    
    public void storeNewResult(String s)
    {
         ResultData.add(s);
         MyLogger.writeMessage("Storing "+s+" in Results", MyLogger.DebugLevel.IN_RESULTS);
    }
   
    
}
