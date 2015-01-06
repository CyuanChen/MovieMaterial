import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.io.*;
import java.util.*;


public class update
{
  public static void main(String[] args) throws ClassNotFoundException
  {
    // load the sqlite-JDBC driver using the current class loader
    Class.forName("org.sqlite.JDBC");
    
    System.out.println("Please enter the file name to update the tag you want: ");
    String test2 = "Lin";
    String filename;
    String tagname;
    String changetag;    
    Scanner scan1 = new Scanner(System.in);
    Scanner scan2 = new Scanner(System.in);
    Scanner scan3 = new Scanner(System.in);
    filename = scan1.nextLine(); 
    System.out.println("Please enter the tag name to update the tag you want: ");
    tagname = scan2.nextLine();
    System.out.println("Please enter the new tag name: ");
    changetag = scan3.nextLine();
    String sqlname = "update person set tag = '" + changetag + "' where tag = '" + tagname + "' AND file_name = '" +filename + "'";
 
    


    Connection connection = null;
    try
    {
      // create a database connection  // means create a database
      connection = DriverManager.getConnection("jdbc:sqlite:hihi.db");

      Statement statement = connection.createStatement();
      statement.setQueryTimeout(30);  // set timeout to 30 sec.

      statement.executeUpdate("drop table if exists person");
      statement.executeUpdate("create table person (file_name string, tag string)");
      statement.executeUpdate("insert into person values('iphone', 'Apple')");
      statement.executeUpdate("insert into person values('iphone', '3C')");
      statement.executeUpdate("insert into person values('iphone', 'used')");
      statement.executeUpdate("insert into person values('TV','furniture')");
      statement.executeUpdate("insert into person values('TV','3C')");
      statement.executeUpdate("insert into person values('chair','furniture')");
      //delete tag    use where tag
      //statement.executeUpdate("delete from person where tag = 'furniture' ");
      //statement.executeUpdate("insert into person values('TV', '')");
      //statement.executeUpdate("insert into person values('chair', '')");
      //update tag
      //statement.executeUpdate("update person set tag = 'NTUST' where tag = 'furniture' AND file_name = 'chair'");
      // delete tag
      statement.executeUpdate(sqlname);



  
  
      //statement.executeUpdate("delete from testtable where file = 'test'");
      //statement.executeUpdate("delete from testsql where file = 'neeho'");
      
      // Search
      ResultSet rs = statement.executeQuery("select * from person");
      while(rs.next())
      {
        // read the result set
        String file_name = rs.getString("file_name");
        String tag_name = rs.getString("tag");
        System.out.println("file name  = " + file_name);
        System.out.println("tag = " + tag_name);
        String search_tag = "Apple";
        String search_file = "iphone";  
        
        /*if (tag_name.equals(search_tag) && file_name.equals(search_file)){
          System.out.println();
          System.out.println("Search tag = '"+  search_tag + "' and print file name:");
          System.out.println("file name = " + file_name );
          System.out.println();
        }*/
        

      }


    }
    catch(SQLException e)
    {
      // if the error message is "out of memory", 
      // it probably means no database file is found
      System.err.println(e.getMessage());
    }
    finally
    {
      try
      {
        if(connection != null)
          connection.close();
      }
      catch(SQLException e)
      {
        // connection close failed.
        System.err.println(e);
      }
    }  
  


  }//end main
 
}