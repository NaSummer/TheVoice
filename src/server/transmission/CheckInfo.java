package server.transmission;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author Qiufan(Andy) Xu 
 * @date CreateTime: Oct 10, 2015 4:56:25 PM 
 * @version 1.0 
 * @param 
 */

class CheckInfo {
	
	public CheckInfo() {
		
	}
	
	/*  */
	public boolean isInfoRight(String username, String password) {
		try {
			BufferedReader br = preReadUserInfo();
			String[] tmpInfo = null;
			
			/* read whole BufferedReader */
			String tmpStr = br.readLine();
			while (tmpStr!=null) {
				/* split */
				tmpInfo = tmpStr.split("=");
				if (tmpInfo[0].equals(username)) {
					if (tmpInfo[1].equals(password)) {
						return true;
					} else {
						return false;
					}
				}
				tmpStr = br.readLine();
			}
			return false;
		} catch (IOException e) {
			System.err.println("Fail to read userinfo from file.");
//			e.printStackTrace();
			return true;
		}
	}
	
	public boolean isUserExisted(String username) {
		try {
			BufferedReader br = preReadUserInfo();
			
			/* read whole BufferedReader */
			String tmpStr = br.readLine();
			while (tmpStr!=null) {
				// check name
				tmpStr = tmpStr.substring(0, tmpStr.indexOf('='));
				if (tmpStr.equals(username)) {
					return true;
				}
				tmpStr = br.readLine();
			}
			return false;
		} catch (IOException e) {
			System.err.println("Fail to read userinfo from file.");
//			e.printStackTrace();
			return true;
		}
	}
	
	public void writeUserInfo(String username, String password) {
		File file = new File("info/userinfo.info");
		
		/* if file does not exist, create the new file */
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				System.err.println("Fail to create new file (userinfo)");
//				e.printStackTrace();
			}
		}
		
		/* Use FileWriter and BufferWriter to write file */
		try {
			FileWriter fileWriter = new FileWriter(file, true);// use "true" to write the new after the original
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			bufferedWriter.write(username + "=" + password + "\n");
			bufferedWriter.flush();
			bufferedWriter.close();
//			fileWriter.flush();
			fileWriter.close();
		} catch (IOException e) {
			System.err.println("Fail to write file");
//			e.printStackTrace();
		}
		
	}
	
	/* link buffered reader to the file */
	private BufferedReader preReadUserInfo() {
		
		/* if folder does not exist, create the new folder */
		File folder = new File("info");
		if (!folder.exists()) {
			folder.mkdir();
		}
		
		File file = new File("info/userinfo.info");
	
		/* if file does not exist, create the new file */
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				System.err.println("Fail to create new file (userinfo)");
//				e.printStackTrace();
				return null;
			} 
		}
		
		/* read File */
		try {
			return new BufferedReader(new FileReader(file));
		} catch (FileNotFoundException e) {
			System.err.println("Fail to read Userinfo");
//			e.printStackTrace();
			return null;
		}
	}
	
	
}
