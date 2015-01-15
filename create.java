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
  public String path = "/home/peter/workspace";
  
  /*public static void main(String[] args) throws ClassNotFoundException
  {
    Class.forName("org.sqlite.JDBC");
    create newMovie = new create();
   
    System.out.println("Import file");
    newMovie.import_file();
    System.out.println("Setup id and passward");
    newMovie.setup();
    System.out.println("Import new file");
    newMovie.import_file();
    System.out.println("Insert file.");
    newMovie.testcreate();
  }//end main*/
   public void testcreate(){
    //System.out.println("Please create your table use : sample(testid integer, testname string) ");
    //String s;
    String s2;
    String sql = "create table person (file_name string, tag string)";
    String s3;
    Scanner scan = new Scanner(System.in);
    //s = scan.next();
    Scanner scan2 = new Scanner(System.in);
    System.out.println("Please input your file name:");
    s2 = scan.next();
    System.out.println("Enter the tag:");
    s3 = scan.next();
    String sqlname = "insert into person values('" + s2 + "', '" + s3 + "')"; 
    Connection connection = null;
    try
    {
      // create a database connection  // means create a database
      connection = DriverManager.getConnection("jdbc:sqlite:testsql.db");

      Statement statement = connection.createStatement();
      statement.setQueryTimeout(30);  // set timeout to 30 sec.
      //----------------------------------------------------------
      statement.executeUpdate("drop table if exists person");
      statement.executeUpdate(sql);
      statement.executeUpdate(sqlname);
      
      //Ensure the test exist
      ResultSet rs = statement.executeQuery("select * from person");//print all entries
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

    public void import_file(int i ){
    // load the sqlite-JDBC driver using the current class loader 
    //String folder ;
    //System.out.println("Please input your folder path : /home/peter/workspace");
    //Scanner scan2 = new Scanner(System.in);
    //folder = scan2.nextLine();
    String table_name = "drop table if exists person"+ i;
    String create_table = "create table person" + i + "(file_name string, tag string)";


    Connection connection = null;
    try
    {
      // create a database connection  // means create a database
      connection = DriverManager.getConnection("jdbc:sqlite:testsql.db");

      Statement statement = connection.createStatement();
      statement.setQueryTimeout(30);  // set timeout to 30 sec.

      statement.executeUpdate("drop table if exists person");
      statement.executeUpdate("create table person (file_name string, tag string)");
      statement.executeUpdate("insert into person values('iphone', 'Apple')");
      statement.executeUpdate("insert into person values('iphone', '3C')");
      statement.executeUpdate("insert into person values('iphone', '')");
      statement.executeUpdate("insert into person values('TV','')");
      statement.executeUpdate("insert into person values('TV','3C')");
      statement.executeUpdate("insert into person values('chair','furniture')");
      statement.executeUpdate("drop table if exists person1");
      statement.executeUpdate("create table person1 (file_name string, tag string)");
      statement.executeUpdate("drop table if exists person2");
      statement.executeUpdate("create table person2 (file_name string, tag string)");
      statement.executeUpdate("drop table if exists person3");
      statement.executeUpdate("create table person3 (file_name string, tag string)");
      statement.executeUpdate("drop table if exists person4");
      statement.executeUpdate("create table person4 (file_name string, tag string)");
      statement.executeUpdate("drop table if exists person5");
      statement.executeUpdate("create table person5 (file_name string, tag string)");
      if (i > 0){
        statement.executeUpdate(table_name);
        statement.executeUpdate(create_table);
      }


      File file = new File(path); 
      File[] files = file.listFiles();
      String a = ""; 
       
      for (int fileInList = 0; fileInList < files.length; fileInList++) 
      { 
        //System.out.println(files[fileInList].getName()); 
        a = files[fileInList].getName();
        String nname = "insert into person values( '" + a + "', 'test' )";
        statement.executeUpdate(nname);
      }
      // Search
      ResultSet rs = statement.executeQuery("select * from person");
      while(rs.next())
      {
        // read the result set
        String file_name = rs.getString("file_name");
        String tag_name = rs.getString("tag");
        System.out.println("file name  = " + file_name);
        System.out.println("tag = " + tag_name);
        //search
        /*String search_file = "models.py";
        String search_tag = "test";
        if (tag_name.equals(search_tag)){
          System.out.println("Search tag = '"+  search_tag + "' and print file name:");
          System.out.println("file name = " + file_name );
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
  
  }//end import_file
  public void setup(){
    String s2;
    String sql = "create table setup (setup_id string, setup_passward string)";
    String manager_id = "manager";
    String manager_pwd = "m12345";
    String designer_id ="designer";
    String designer_pwd = "d45678";
    //Scanner scan = new Scanner(System.in);
    //s = scan.next();
    //System.out.println("Please input your file:");
    //s2 = scan.next();
    String sqlname = "insert into setup values('" + manager_id + "', '" + manager_pwd + "')";
    String sqlname2 = "insert into setup values('" + designer_id + "', '" + designer_pwd + "')"; 
    System.out.println("Please enter the path of the folder. default:/home/peter/workspace ");
    Scanner scan1 = new Scanner(System.in);
    path = scan1.next();

    Connection connection = null;
    try
    {
      // create a database connection  // means create a database
      connection = DriverManager.getConnection("jdbc:sqlite:testsql.db");

      Statement statement = connection.createStatement();
      statement.setQueryTimeout(30);  // set timeout to 30 sec.
      //----------------------------------------------------------
      statement.executeUpdate("drop table if exists setup");
      statement.executeUpdate(sql);
      statement.executeUpdate(sqlname);
      statement.executeUpdate(sqlname2);

      
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