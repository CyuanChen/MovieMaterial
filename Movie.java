import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.io.*;
import java.util.*;
public class Movie {
	public static void main(String[] args) throws ClassNotFoundException{
			// load the sqlite-JDBC driver using the current class loader
	    Class.forName("org.sqlite.JDBC");
	    create newcreate = new create();
	    int i = 0;
	   
	    System.out.println("Import file");
	    newcreate.import_file(i);
	    // System.out.println("Setup id and passward");
	    // newcreate.setup();
	    // System.out.println("Import new file");
	    // newcreate.import_file();
	    // System.out.println("Insert file.");
	    // newcreate.testcreate();
	    // Remove_record newRemove_record = new Remove_record();
	    // newRemove_record.delete_lost_file();
	    Search_tag newSearch_tag = new Search_tag();
	    // newSearch_tag.search();
	    newSearch_tag.search_file();
	    //LoginSystem newLoginSystem = new LoginSystem();
	    //newLoginSystem.loginsystem();



	}
}