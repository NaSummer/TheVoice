package transfer;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Qiufan(Andy) Xu 
 * @date CreateTime: Oct 10, 2015 12:54:34 PM 
 * @version 1.2 
 * @param 
 */

public class Packet implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5700862865311793811L;
	
	/* Packet Type */
	public final static int PULSE = 0;
	public final static int PULSE_BACK = 1;
	
	public final static int SIGN_IN = 2;
	public final static int SIGN_UP = 3;
	public final static int AUTH_SUCCESSFUL = 4;
	public final static int AUTH_FAIL = 5;
	
	public final static int LOGOUT = 6;
	public final static int LOGOUT_SUCCESSFUL = 7;
	
	public final static int ASK_ARTICLE_LIST = 8;
	public final static int ARTICLE_LIST = 9;
	
	public final static int ASK_ARTICLE_URL = 10;
	public final static int ARTICLE_URL = 11;
	
	public final static int CREARE_ARTICLE = 12;
	public final static int CREARE_ARTICLE_SUCCESS = 13;
	
	public final static int TIME_OUT = 14;

	
	
	public final int TYPE;
	public final String USERNAME;
	
	/* Multi-Purpose-Variable */
	protected String str1; // login, register
	protected String[] strArr;
	
	
	/* Constructor */
	public Packet(int type, String username) {
		this.TYPE = type;
		this.USERNAME = username;
	}
	
	
	
	/* =====================set======================= */
	/**
	 * login and register
	 * @param 
	 * @return 
	 */
	public boolean setPassword(String password) {
		str1 = password;
		return true;
	}
	
	
	/**
	 * 
	 * @param 
	 * @return 
	 */
	public boolean setArticleList(List<String> list) {
//		strArr = (String[]) list.toArray();
		strArr = new String[list.size()];
		int i = 0;
		for (String string : list) {
			strArr[i] = string;
			i++;
		}
		return true;
	}
	
	/**
	 * 
	 * @param 
	 * @return 
	 */
	public boolean setArticleUrl(String string) {
		this.str1 = string;
		return true;
	}
	
	/**
	 * 
	 * @param 
	 * @return 
	 */
	public boolean setArticleNumber(int number) {
		this.str1 = number + "";
		return true;
	}
	
	/*============get===========*/
	
	/**
	 * getPassword
	 * @param 
	 * @return 
	 */
	public String getPassword() {
		return str1;
	}
	
	/**
	 * 
	 * @param 
	 * @return 
	 */
	public List<String> getArticleList() {
		List<String> articleList = new ArrayList<String>();
		for (int i = 0; i < strArr.length; i++) {
			articleList.add(strArr[i]);
		}
		return articleList;
	}
	
	/**
	 * 
	 * @param 
	 * @return 
	 */
	public String getArticleUrl() {
		return str1;
	}
	
	public int getArticleNumber() {
		return Integer.parseInt(str1);
	}
	
}
