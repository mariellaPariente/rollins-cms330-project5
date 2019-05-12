import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
 
public class SearchEngine {
	public static void main(String[] args) {
        
        File fileName = new File("/home/codio/workspace/indexing/texts/macbeth.txt");
        Scanner reader = null;
            
        try {    
           reader = new Scanner(fileName);
            while (reader.hasNext()){
               //int i = reader.nextInt();
               //System.out.println(i);
               System.out.println(reader.nextLine());
            }
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
            
        }   
    }
}

