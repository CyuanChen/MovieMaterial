import java.io.*;
import java.util.*;

public class FileDemo {
  public static void main (String[] args){
    FileDemo s = new FileDemo();
    s.getFileList("/home/peter/workspace");
  }  
  public void getFileList(String path){
    File file = new File(path); 
    File[] files = file.listFiles(); 
    for (int fileInList = 0; fileInList < files.length; fileInList++) 
    { 
      System.out.println(files[fileInList].getName()); 
    }
  }
}