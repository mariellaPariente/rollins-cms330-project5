import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.FileNotFoundException;
import java.io.*;
import java.util.*;
import java.io.StreamTokenizer;
import java.util.ArrayList;
 

public class searchEngine {
     
   public static int hashKey(ArrayList key) {
        return key.hashCode();
   }
    
   public searchEngine () {     
   
   }
    
//Read file with 1st scanner 
   public static void readFile (String fileName) { 
        File file = new File("/home/codio/workspace/texts/macbeth.txt");
        Scanner reader = null; 

        try { 
            reader = new Scanner(file);
            while (reader.hasNextLine()){     
                String line = reader.nextLine();// read file into a line
                //System.out.println(line); 
                String ln = cleanLine(line);    // remove puntcuation from line
                readLine(ln);                   // read line and tokenize words
            }
          }
        catch (FileNotFoundException e) {
            e.printStackTrace();
         } 
        finally {
            if (reader != null)
               reader.close();
         }
   }

    
//Remove all puntcuation and separate words by space 
  public static String cleanLine(String originalLine) {
      
    String cleanLine = originalLine; 
    cleanLine = cleanLine.replaceAll("(?m)^[ \t]*\r?\n", "");
    cleanLine = cleanLine.replaceAll("[\\p{Punct}&&[^\u0027]]"," ");
    cleanLine = cleanLine.replaceAll("\\s+", " ");

    return cleanLine;
   }
    
    
//Read lines with 2nd scanner to  
    public static void readLine (String str) {

    StringTokenizer tokenizedStr = new StringTokenizer(str, " ");
    HashMap<Integer, ArrayList<entry>> index = new HashMap<Integer, ArrayList<entry>>(); 
    ArrayList<String> word = new ArrayList<String>();  

        while (tokenizedStr.hasMoreTokens()) {
            word.add(tokenizedStr.nextToken());  
        }
        
        System.out.println(word);
        //System.out.println(word.size());
        //System.out.println(word.indexOf("ACT")); 
       
       
       /*parse out title, acts, scenes, character names 
        String playTitle;
        String playact;
        String playscene;
        String playCharacter;
        String originalLine; 
       
        *** Switch Case for ACT SCENE and TITLE using word index?  ***
  
        entry entryObj = new entry(title, act, scene, character, word, originalLine);

        int indexNum = hashKey(word);
        ArrayList<entry> entryList = index.get(indexNum);
        if (entryList == null){
            entryList = new ArrayList<entry>();
            entryList.add(entryObj);
            index.put(indexNum, entryList);
        }
        else{
            entryList.add(entryObj);
        }*/ 
    }

   

}



