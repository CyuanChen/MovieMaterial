import java.util.Scanner;
 
 
class Login
{
	public void login() 
	{
		//String identity; 
		String manager_id = "manager";
	    String manager_pwd = "m12345";
		String designer_id ="designer";
	    String designer_pwd = "d45678";
		String a, b, c;
		System.out.println("請輸入帳號：");	
		Scanner id = new Scanner(System.in);
		a = id.next();
		System.out.println("請輸入密碼：");	
		Scanner pwd = new Scanner(System.in);
		b = id.next();
		System.out.println("請輸入身分別：");	
        Scanner identity = new Scanner(System.in);
        c = id.next();
 
		
        if (c.equals("manager")){
        if (a.equals(manager_id)||b.equals(manager_pwd)){ 
			System.out.println("登入成功!");	
			System.out.println("your identity is" + manager_id);
		}else
			System.out.println("登入失敗!");	
        }else if (c.equals("designer")){
        if (a.equals(designer_id)||b.equals(designer_pwd)){ 
    			System.out.println("登入成功!");
    			System.out.println("your identity is "+designer_id);	
    		}else
    			System.out.println("登入失敗!");	
    			
        }else 
        		System.out.println("登入失敗!");

	}
 
    
 
}