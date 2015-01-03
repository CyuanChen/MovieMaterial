import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class find
{
  public static void main(String[] args) throws ClassNotFoundException
  {
    // load the sqlite-JDBC driver using the current class loader
    Class.forName("org.sqlite.JDBC");



    Connection connection = null;
    try
    {
      // create a database connection  // means create a database
      connection = DriverManager.getConnection("jdbc:sqlite:hihi.db");

      Statement statement = connection.createStatement();
      statement.setQueryTimeout(30);  // set timeout to 30 sec.

      
      //statement.executeUpdate("delete from testsql where file = 'test'");
      // Search
      ResultSet rs = statement.executeQuery("select * from testtable");
      while(rs.next())
      {
        // read the result set
        System.out.println("name = " + rs.getString("testname"));
        System.out.println("id = " + rs.getInt("testid"));
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