import java.io.*;
public class file {
	public static void main (String[] args){
		File dir = new File("home/peter/testDir"); 
		File[] fileList = dir.listFiles(); 
    	for (int i = 0; i < fileList.length; i++) { 
                System.out.println(fileList[i].getName()); 
    		}
	}
}
