package kaisheng.project.test;

import java.applet.Applet;
import java.awt.Button;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Practice {
	public static void main(String[] args){
		
		
		
		JFrame jf = new JFrame("这是我的第一个窗口");
		JButton jb = new JButton("点我");
		jb.setSize(100, 100);
		//jf.setVisible(false);
		jf.setBounds(200, 200, 400, 300);
		jf.setDefaultCloseOperation(jf.EXIT_ON_CLOSE);
		jf.add(jb);
		jf.setVisible(true);
		
		/*String errorName = "";
		int errorTime = 0;
		boolean flag = true;
		java.util.Scanner input = new java.util.Scanner(System.in);*/
		
	/*	System.out.println("请输入您的名字：");
		String name = input.next();
		if("tom".equals(name)) {
			System.out.println("欢迎您tom");
		}*/
		
		/*while(flag){
			System.out.println("请输入你的帐号：");
			String name = input.next();
			
			System.out.println("请输入密码：");
			String password = input.next();
			
			if("jiang".equals(name) && "123".equals(password)){
				System.out.println("登录陈功，欢迎您"+name);
			}else {
				System.out.println("账户或密码错误！");
				if(name.equals(errorName)){
					errorTime++;
					if(errorTime == 3){
						System.out.println("您的帐号已经被冻结！");
						flag = false;
					}
				}else {
					errorTime = 0;
					errorName = name;
				}
			}
		}*/
		
	}
}




