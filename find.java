import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class find
{
  public void find()
  {
    // load the sqlite-JDBC driver using the current class loader



    Connection connection = null;
    try
    {
      // create a database connection  // means create a database
      connection = DriverManager.getConnection("jdbc:sqlite:testsql.db");

      Statement statement = connection.createStatement();
      statement.setQueryTimeout(30);  // set timeout to 30 sec.

      
      //statement.executeUpdate("delete from testsql where file = 'test'");
      // Search
      ResultSet rs = statement.executeQuery("select file_name from person");
      while(rs.next())
      {
        // read the result set
        //System.out.println("test successed.");
        System.out.println("file_name : " + rs.getString("file_name"));
        //System.out.println("setup_passward : " + rs.getString("setup_passward"));
        
      }
      ResultSet rs2 = statement.executeQuery("select tag from person");
      while(rs2.next()){
        System.out.println("tag :" + rs2.getString("tag"));
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