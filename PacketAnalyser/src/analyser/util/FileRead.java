package analyser.util;

import java.io.*;
import java.net.InetAddress;
import java.util.Scanner;

public class FileRead {

   
   public static void main(String args[])throws IOException {
      //File file = new File("Hello1.txt");    
   
	   System.out.println("Enter a file name:\n");
      Scanner getFilename = new Scanner(System.in);
    
     
    try (BufferedReader br = new BufferedReader(new FileReader(getFilename.nextLine()))){ 
    String line;
    while ((line = br.readLine()) != null) {
       // process the line.
       System.out.println(line);
      
    }
    System.out.println("Finished");
   // InetAddress ia = InetAddress.getByAddress(new byte[] {74,125,127,106});
 // or 
 InetAddress ia = InetAddress.getByName("8.8.8.8");
 System.out.println(ia.getCanonicalHostName());
    }
     }
   
   public void draw() throws IOException{
      //System.out.println(i+f);
      
      System.out.println("Enter a file name here:\n");
      Scanner getFilename = new Scanner(System.in);
      try (BufferedReader br = new BufferedReader(new FileReader(getFilename.nextLine()))){ 
      String line;
      while ((line = br.readLine()) != null) {
       // process the line.
      System.out.println(line);
      
      
    }
  }
}
}

   
   
   
