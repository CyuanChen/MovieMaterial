import javax.swing.*;
import java.awt.event.*;
import java.sql.*;



public class LoginSystem {
	
	Connection con;
	Statement st;
	ResultSet rs;
	
	JFrame f = new JFrame("Login");
	//JFrame f1 = new JFrame("Admin Login");
	JLabel l = new JLabel("ID");
	JLabel l1 = new JLabel("Password");
	JLabel l2 = new JLabel("User/Admin");
	JTextField t = new JTextField(10);
	JTextField t1 = new JTextField(10);
	JTextField t2 = new JTextField(5);
	JButton b = new JButton("Login");
	//JButton b1 = new JButton("Admin Login");
	
	
	
	
	public void loginsystem(){
		connect();
		frame();
		
	}
	
	public void connect(){
		
		try{
			
			String driver = "org.sqlite.JDBC" ;
			Class.forName(driver);
			
			String db = "jdbc:sqlite:testsql.db";
	//		String db1 = "jdbc:odbc:db1";
			con = DriverManager.getConnection(db);
	//		con = DriverManager.getConnection(db1);
			st = con.createStatement();
			
			
		}
		
		catch(Exception ex){
			
		}
	}
	
    public void frame(){
    	f.setSize(600,400);
    	f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	f.setVisible(true);
    	
    	JPanel p = new JPanel();
    	p.add(l);
    	p.add(t);
    	p.add(l1);
    	p.add(t1);
    	p.add(l2);
    	p.add(t2);
    	p.add(b);
    //	p.add(b1);
      	
    	f.add(p);
    	
		
	}
	

}