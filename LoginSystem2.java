import javax.swing.*;
import java.util.Scanner;
import java.awt.event.*;
import java.sql.*;
 
 
 
public class LoginSystem2 {
	
	Connection con;
	Statement st;
	ResultSet rs;
	
    String manager_id = "manager";
    String manager_pwd = "m12345";
    String designer_id ="designer";
    String designer_pwd = "d45678";
	
	JFrame f = new JFrame("Login");
	JFrame f1 = new JFrame("Admin Login");
	JLabel l = new JLabel("ID");
	JLabel l1 = new JLabel("Password");
	JLabel l2 = new JLabel("User/Admin");
	JTextField t = new JTextField(10);
	JTextField t1 = new JTextField(10);
	JTextField t2 = new JTextField(5);
	JButton b = new JButton("Login");
	//JButton b1 = new JButton(" Login");
	
	//Scanner in = new Scanner(System.in);
	String id = t.getText();
	String pwd = t1.getText();
	String adminn = t2.getText();
	
	
	
	
 
	 if (adminn.equals(manager_id)){
       if (id.equals(manager_id)){
           if (pwd.equals(manager_pwd))
        	   System.out.print("login success");
         }
         }
	 
	 if (adminn.equals(designer_id)){
	       if (id.equals(designer_id)){
	           if (pwd.equals(designer_pwd))
	        	   System.out.print("login success");
	         }	 
	 }
             
	
	
	
	
	public LoginSystem(){
		connect();
		frame();
		
	}
	
	public void connect(){
		
		try{
			
			String driver = "sun.jdbc.odbc.JdbcOdbcDriver" ;
			Class.forName(driver);
			
			String db = "jdbc:odbc:db1";
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
	//public static void main(String[] Args){
	//	new LoginSystem();
	//	
	//}
 
}