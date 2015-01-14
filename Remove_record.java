import java.sql.*;
 
public class Remove_record 
{
	//public String fileLostFlag = "檔案遺失";
	public void delete_lost_file()
	{
		
		if(get_tag_name.equals(' '))
		{
			Connection c = null;
	    	Statement s = null;
	    	try
	    	{
	      		Class.forName("org.sqlite.JDBC");
	      		c = DriverManager.getConnection("jdbc:sqlite:testsql.db");
	    		c.setAutoCommit(false);
 
	    		s = c.createStatement();
 
	    		ResultSet rs2 = s.executeQuery("select * from person");
				while(rs2.next())
				{	
					String  file_name = rs2.getString("file_name");
          			String  tag_name = rs2.getString("tag_name");
 
					if(tag_name.equals(' '))
					{
						s.executeUpdate("delete from person where tag = ''");
	            	
					}
					System.out.println( "NAME = " + file_name );
					System.out.println( "TAG = " + tag_name );
					System.out.println();
	   			}
	   			rs2.close();
        		s.close();
        		c.close(); 
			}
			catch ( Exception e ) {
	     		System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	      		System.exit(0);
	    	}
	    	System.out.println("Operation done successfully");
	    }
	}

}