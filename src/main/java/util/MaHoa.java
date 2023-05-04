package util;

import java.security.MessageDigest;
import org.apache.commons.codec.binary.Base64;

public class MaHoa{

	//str là cái cần đi mả hóa
	public static String toSHA1(String str){
		// Một chuỗi ngẫu nhiên nào đó cộng thêm vảo password để cho password phức tạp thêm
		String salt = "cakcbakcba@#kca;b";
		String result = null;
		str = str + salt;

		try{
			byte[] dataBytes = str.getBytes("UTF-8");
			MessageDigest md = MessageDigest.getInstance("SHA-1");
			result = Base64.encodeBase64String(md.digest(dataBytes));
		}catch(Exception e){
			e.printStackTrace();
		}
		return result;
	}


	public static void main(String[] args) {
		System.out.println(toSHA1("0362685068SonyXperia1Mark2"));
	}

}

