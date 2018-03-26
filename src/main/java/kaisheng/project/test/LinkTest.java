package kaisheng.project.test;

import org.apache.commons.codec.digest.DigestUtils;

import kaisheng.project.utils.Config;

public class LinkTest {
	class Data2 {
		String key;
		String name;
		int age;
		
		public Data2(){
			
		}
	}
	
	class CLType{
		Data2 data = new Data2();
		CLType nextNode;
	}
	
	public static void main(String[] args){
		LinkTest test = new LinkTest();
		Data2 data =test.new Data2();
		data.age = 13;
		data.name = "jiangdong";
		data.key = "24";
		
		CLType type = test.new CLType();
		String salt = Config.get("user.password.salt");
		String name = "123";
		String saltpassword = DigestUtils.md5Hex(salt + "000000");
		System.out.println(saltpassword);
	}
	
}
