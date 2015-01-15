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
    // System.out.println("Please enter the file you want to search");
    // Scanner scanner = new Scanner(System.in);
    // String getThefile_name = scanner.nextLine();

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
      int count= 1,lend = 0;
      String numrs3[] = new String[200];
      String numrs3_tag[] = new String[2000];

      while(rs3.next())
      {
        numrs3[count-1] = rs3.getString("file_name");
        numrs3_tag[count-1] = rs3.getString("tag");
        count++;// all num in rs3
      }
      System.out.println(count);
      //rs4.first();
      ResultSet rs4 = stmt.executeQuery("SELECT * FROM person;");
      while(rs4.next())
      {
        int count2 = 0;
        //System.out.println("haha i am come");

        String old_file_name = rs4.getString("file_name");
        String old_tag = rs4.getString("tag");

        for(lend = 0;lend < count ;lend++)
        {
          if(old_file_name.equals(numrs3[lend]) && old_tag.equals(numrs3_tag[lend]))
          {
            //System.out.println("file : " + old_file_name + " is exist.");
          }else{
            count2++; //if not found then count2 ++
          }          
          //rs3.next();  
        }//end for
        if(count2 == count)
            System.out.println("this file:"+ old_file_name + " is not found");
          //should print iphone Tv chair
          System.out.println(count2);


        //rs3.first();
        }//end while



      // while(rs4.next())
      // {
      //   String old_file_name = rs4.getString("file_name");
      //   while(rs3.next())
      //   {
      //     String new_file_name = rs3.getString("file_name");
 
      //     if(old_file_name.equals(new_file_name))
      //     {
      //       System.out.println("file : " + old_file_name + "is exist.");
      //     }
      //     else if(old_file_name.equals(new_file_name) == false)
      //     {
      //       System.out.println("miss file:" + old_file_name);
      //       System.out.println("");
      //     }
      //     rs3.next();   
      //   }
      // }
    } catch ( Exception e ) {
      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
      System.exit(0);
    }
    System.out.println("Operation done successfully");
  }
}