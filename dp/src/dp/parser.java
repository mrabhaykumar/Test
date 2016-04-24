package dp;

import java.util.ArrayList;
import java.util.Scanner;

/*REQUEST_TYPE: GET or POST or PUT or DELETE, etc.
RELATIVE_URL: /main/index or / , etc.
IP: 111.119.206.2 or 127.0.0.1, etc.
REQUEST_FORMAT: JS or JSON or HTML or null/blank, etc. (Note: null/blank request format should be treated as HTML.)
RESPONSE_CODE: "200 OK" or "401 Unauthorized" or "422 Unprocessable Entity", etc */
public class parser {
	static int type = 0;
	static int url = 0;
	static int ip = 0;
	static int format= 0;
	static int code = 0;
	static ArrayList<String> store = new ArrayList<String>();
	public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		Scanner sc =  new Scanner(System.in);
		while(true) {
			String str = sc.nextLine();
			if(str.contains("Started")|| str.contains("Processing")||str.contains("Completed")){
				store.add(str);
			}
			if(str.equals("***************###############***************")) {
				 String type = sc.nextLine();
				 String url = sc.nextLine();
				 String ip = sc.nextLine();
				 String format = sc.nextLine();
				 String code  = sc.nextLine();
				 processline(type,url,ip,format,code);
				 break;
			}
				
		}
		System.out.println(type);
		System.out.println(url);
		System.out.println(ip);
		System.out.println(format);
		System.out.println(code);
	}
	public static void processline(String curType, String curUrl, String curIp, String curFormat, String curCode) {
		for(String line :store) {
			if(line.contains(curType))
				type++;
			if(line.contains(curUrl))
				url++;
			if(line.contains(curIp))
				ip++;
			if(line.contains(curFormat))
				format++;
			if(line.contains(curCode))
				code++;
		}
	}
}
