import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.io.*;
import java.util.*;

public class create
{
  
  public static void main(String[] args) throws ClassNotFoundException
  {
    // load the sqlite-JDBC driver using the current class loader
    Class.forName("org.sqlite.JDBC");
    create createnew = new create();
    System.out.println("Insert file.");
    //createnew.testcreate();
    System.out.println("Import file");
    //createnew.import_file();
    System.out.println("Setup id and passward");
    createnew.setup();


  }//end main
  public void testcreate(){
    //System.out.println("Please create your table use : sample(testid integer, testname string) ");
    //String s;
    String s2;
    String sql = "create table testtable (testid integer, testname string)";
    int i = 1;
    Scanner scan = new Scanner(System.in);
    //s = scan.next();
    System.out.println("Please input your file:");
    s2 = scan.next();
    String sqlname = "insert into testtable values(" + i + ", '" + s2 + "')"; 
    Connection connection = null;
    try
    {
      // create a database connection  // means create a database
      connection = DriverManager.getConnection("jdbc:sqlite:hihi.db");

      Statement statement = connection.createStatement();
      statement.setQueryTimeout(30);  // set timeout to 30 sec.
      //----------------------------------------------------------
      statement.executeUpdate("drop table if exists testtable");
      statement.executeUpdate(sql);
      statement.executeUpdate(sqlname);
      
      //Ensure the test exist
      ResultSet rs = statement.executeQuery("select * from testtable");//print all entries
      while(rs.next())
      {
        // read the result set
        System.out.println("id = " + rs.getInt("testid"));
        System.out.println("name = " + rs.getString("testname"));
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

  }//end testcreate

    public void import_file(){
    // load the sqlite-JDBC driver using the current class loader
    System.out.println("Please input your file: ");
    String s;
    String sql = "create table testtable (testid integer, testname string)";
    int i = 1;
    Scanner scan = new Scanner(System.in);
    s = scan.nextLine(); 
    String sqlname = "insert into testtable values(2, '" + s + "')"; 
    String folder ;
    System.out.println("Please input your folder path : /home/peter/workspace");
    Scanner scan2 = new Scanner(System.in);
    folder = scan2.nextLine();

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

      File file = new File(folder); 
      File[] files = file.listFiles();
      String a = ""; 
       
      for (int fileInList = 0; fileInList < files.length; fileInList++) 
      { 
        //System.out.println(files[fileInList].getName()); 
        a = files[fileInList].getName();
        String nname = "insert into person values( '" + a + "', 'test' )";
        statement.executeUpdate(nname);
      }
      statement.executeUpdate("drop table if exists testtable");
      statement.executeUpdate(sql);
      statement.executeUpdate(sqlname);
      //statement.executeUpdate("delete from testsql where file = 'test'");
      //statement.executeUpdate("delete from testsql where file = 'neeho'");
      
      // Search
      ResultSet rs = statement.executeQuery("select * from person");
      while(rs.next())
      {
        // read the result set
        String file_name = rs.getString("file_name");
        String tag_name = rs.getString("tag");
        //System.out.println("file name  = " + file_name);
        //System.out.println("tag = " + tag_name);
        String search_file = "models.py";
        String search_tag = "test";
        if (tag_name.equals(search_tag)){
          System.out.println("Search tag = '"+  search_tag + "' and print file name:");
          System.out.println("file name = " + file_name );
        }

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
  


  }//end import_file
  public void setup(){
    System.out.println("Hello");
    String s2;
    String sql = "create table setup (setup_id string, setup_passward string)";
    String setup_id ="peterchen302";
    String setup_passward = "test123";
    //Scanner scan = new Scanner(System.in);
    //s = scan.next();
    //System.out.println("Please input your file:");
    //s2 = scan.next();
    String sqlname = "insert into setup values('" + setup_id + "', '" + setup_passward + "')"; 
    Connection connection = null;
    try
    {
      // create a database connection  // means create a database
      connection = DriverManager.getConnection("jdbc:sqlite:hihi.db");

      Statement statement = connection.createStatement();
      statement.setQueryTimeout(30);  // set timeout to 30 sec.
      //----------------------------------------------------------
      statement.executeUpdate("drop table if exists setup");
      statement.executeUpdate(sql);
      statement.executeUpdate(sqlname);
      
      //Ensure the test exist
      ResultSet rs = statement.executeQuery("select * from setup");//print all entries
      while(rs.next())
      {
        // read the result set
        System.out.println("test successed.");
        System.out.println("setup_id : " + rs.getString("setup_id"));
        System.out.println("setup_passward : " + rs.getString("setup_passward"));
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
  }



}