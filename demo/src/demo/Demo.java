
package demo;

/**
 *
 * @author ankul / angad /Gursimar
 */
import static demo.CreateCsvFile.generateCsvFile;
import java.io.File;
import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import java.io.FileWriter;
import java.io.IOException;
import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;    
     



 class CreateCsvFile {

public static void generateCsvFile(String fileName, String x) {

      FileWriter writer = null;

 try {

     writer = new FileWriter(fileName);
//     System.out.println(x);
     String rolls = "";
     String attends = "";

     for (int i = 0; i < x.length(); i++) {

            if(x.charAt(i)>='0'&& x.charAt(i)<='9')
            { 
                rolls = rolls + x.charAt(i);
            }
            else{
                   writer.append( rolls + ",");
                System.out.println(rolls);
                           
            rolls = "";
            }
            if(x.charAt(i)>='A'&& x.charAt(i)<='Z')
            { 
                System.out.println(x.charAt(i));
                writer.append(x.charAt(i)+ "\n");
            }
        }


     System.out.println("CSV file is created...");

  } catch (IOException e) 
        { e.printStackTrace(); }
     finally
        { try 
            {
                writer.flush();
                writer.close();
            } 
          catch (IOException e) 
            {  e.printStackTrace(); }
        }
 }


}



public class Demo {

    public static void main(String[] args) {
        // TODO code application logic here
        CreateCsvFile csvf = new CreateCsvFile();
        String x="";
     File ff=new File("C:\\Users\\ankul singh\\Documents\\NetBeansProjects\\demo\\ip4.jpeg");
    ITesseract ii=new Tesseract();
    
    ii.setDatapath("C:\\Users\\ankul singh\\Documents\\NetBeansProjects\\demo\\src\\tessdata");
    try
    {
        String rs=ii.doOCR(ff);
        String m[]=rs.split("\n");
        int i=0,j;
        for(i=0;i<m.length;i++)
        {
            for(j=0;j<m[i].length();j++)
            {
                if(m[i].charAt(j)>='0'&&m[i].charAt(j)<='9'||m[i].charAt(j)==' '||m[i].charAt(j)>='A'&&m[i].charAt(j)<='Z')
                   x = x + Character.toString(m[i].charAt(j)) ;
            }
          
          System.out.print("\n");
        }
    }
    catch(Exception e){
        System.out.println(e);
    }
        
   DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH-mm-ss");  
   LocalDateTime now = LocalDateTime.now();  
   System.out.println(dtf.format(now));
 String location = "G:\\attendence"+dtf.format(now)+".csv";
 csvf.generateCsvFile(location, x);
    
  


    }

    
}

