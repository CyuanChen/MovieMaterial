import java.sql.*;
import java.util.Scanner;
import java.io.*;
 
public class Search_tag{
  public String fileLostFlag = "檔案遺失";
  public String path = "/home/peter/workspace";
  
//  Search search_f = new Search(){};
//    
//  Scanner scanner = new Scanner(System.in);
//  String getThefile_name = scanner.nextLine();
//  
//  //search_f.file_name = getThefile_name.getSrting();
  public void search()
  {
    System.out.println("Please enter the tag you want to search");
    Scanner scanner = new Scanner(System.in);
    String getThetag_name = scanner.nextLine();

    Connection c = null;
    Statement stmt = null;
    try
    {
      Class.forName("org.sqlite.JDBC");
      c = DriverManager.getConnection("jdbc:sqlite:testsql.db");

      c.setAutoCommit(false);
      //System.out.println("Opened database successfully");
      
      if(getThetag_name == "")
      {
        stmt = c.createStatement();
        ResultSet rs2 = stmt.executeQuery( "SELECT * FROM person;" );
        while(rs2.next())
        {
          String  file_name = rs2.getString("file_name");
          String  tag_name = rs2.getString("tag");
          if(tag_name.equals(getThetag_name))
          {
            System.out.println( "search :" +getThetag_name +"\nprint file_name and tag :");
            System.out.println( "NAME = " + file_name );
            if(tag_name == "")
            {
              System.out.println( "TAG = " + fileLostFlag);
            }
            else{
              System.out.println( "TAG = " + tag_name);
            }
            System.out.println();
          }
        }
        rs2.close();
        stmt.close();
        c.close(); 
 
      }
      //是否要確認資料夾位置
      else{
        stmt = c.createStatement();
        ResultSet rs2 = stmt.executeQuery( "SELECT * FROM person;" );
        while(rs2.next())
        {
          String  file_name = rs2.getString("file_name");
          String  tag_name = rs2.getString("tag");
          if(tag_name.equals(getThetag_name))
          {
            System.out.println( "search :" +getThetag_name +"\nprint file_name and tag :");
            System.out.println( "NAME = " + file_name );
            System.out.println( "TAG = " + tag_name );
            System.out.println();
          }
        }
        rs2.close();
        stmt.close();
        c.close();
      }
    } catch ( Exception e ) {
      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
      System.exit(0);
    }
    System.out.println("Operation done successfully");
  }

  public void search_file()
  {
    System.out.println("Please enter the file you want to search");
    Scanner scanner = new Scanner(System.in);
    String getThefile_name = scanner.nextLine();

    Connection c = null;
    Statement stmt = null;
    try
    {
      Class.forName("org.sqlite.JDBC");
      c = DriverManager.getConnection("jdbc:sqlite:testsql.db");

      c.setAutoCommit(false);
      //System.out.println("Opened database successfully");
      File file = new File(path); 
      File[] files = file.listFiles();
      String a = ""; 
      stmt = c.createStatement(); 
      for (int fileInList = 0; fileInList < files.length; fileInList++) 
      { 
        //System.out.println(files[fileInList].getName()); 
        a = files[fileInList].getName();
        String nname = "insert into person1 values( '" + a + "', 'test' )";
        stmt.executeUpdate(nname);
      }
      ResultSet rs3 = stmt.executeQuery("SELECT * FROM person1;");
      ResultSet rs4 = stmt.executeQuery("SELECT * FROM person;");
      while(rs4.next()){
        rs3.next();
        String new_file_name = rs3.getString("file_name");
        String old_file_name = rs4.getString("file_name");
        do {
          System.out.println("miss file:" + old_file_name);
          System.out.println("");
          rs4.next();
        }while(old_file_name.equals(new_file_name) == false);
        if(old_file_name.equals(new_file_name)== false){
          
        }




        System.out.println(old_file_name);
        System.out.println(new_file_name);

      }

      
      if(getThefile_name == "")
      {
        ResultSet rs2 = stmt.executeQuery( "SELECT * FROM person;" );
        while(rs2.next())
        {
          String  file_name = rs2.getString("file_name");
          String  tag_name = rs2.getString("tag");
          if(file_name.equals(getThefile_name))
          {
            System.out.println( "search :" +getThefile_name +"\nprint file_name and tag :");
            System.out.println( "NAME = " + file_name );
            if(tag_name == "")
            {
              System.out.println( "TAG = " + fileLostFlag);
            }
            else{
              System.out.println( "TAG = " + tag_name);
            }
            System.out.println();
          }
        }
        rs2.close();
        stmt.close();
        c.close(); 
 
      }
      //是否要確認資料夾位置
      else{
        stmt = c.createStatement();
        ResultSet rs2 = stmt.executeQuery( "SELECT * FROM person;" );
        while(rs2.next())
        {
          String  file_name = rs2.getString("file_name");
          String  tag_name = rs2.getString("tag");
          if(file_name.equals(getThefile_name))
          {
            System.out.println( "search :" +getThefile_name +"\nprint file_name and tag :");
            System.out.println( "NAME = " + file_name );
            System.out.println( "TAG = " + tag_name );
            System.out.println();
          }
        }
        rs2.close();
        stmt.close();
        c.close();
      }
    } catch ( Exception e ) {
      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
      System.exit(0);
    }
    System.out.println("Operation done successfully");
  }
  // public static void main( String args[] )
  //   { 
  //    System.out.println("Please enter the name of the file you want to search :");
  //    Scanner scanner = new Scanner(System.in);
  //    String getThefile_name = scanner.nextLine();
  //    search(getThefile_name);
  //    //System.out.println( "SELECT " + getThefile_name + " FROM testsql;" );
  //    scanner.close();
  //   }
}