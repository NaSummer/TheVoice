package tool;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * @author Qiufan(Andy) Xu
 * @date CreateTime: 2015年10月25日 上午10:59:20
 * @version 1.0
 * @param
 */

public class GetArticle {

	private final String FOLDER_PATH = "article";
	private File folder;
	private List<String> articleList;

	/* Constructor */
	public GetArticle() {
		folder = new File(FOLDER_PATH);
		if (!folder.exists()) {
			folder.mkdir();
		}
		articleList = Arrays.asList(folder.list());
	}

	/**
	 * 
	 * @param
	 * @return
	 */
	public List<String> getArticleList() {
		return articleList;
	}
	
	/**
	 * 
	 * @param 
	 * @return 
	 */
	public String getArticle(int articleNumber) {
		return getArticle(articleList.get(articleNumber));
	}
	
	/**
	 * 
	 * @param
	 * @return article content, if not exist, null
	 */
	public String getArticle(String articleName) {
		if (articleList.contains(articleName)) {

			File file = new File(FOLDER_PATH + "/" + articleName);

			/* read File */
			try {
				BufferedReader br = new BufferedReader(new FileReader(file));
				StringBuilder sb = new StringBuilder();
				String tmpStr;
				tmpStr = br.readLine();
				while (tmpStr != null) {
					sb.append(br.readLine());
					sb.append("\n");
					tmpStr = br.readLine();
				}
				br.close();
				return sb.toString();
			} catch (FileNotFoundException e) {
				System.err.println("[tool_GetArticle_getArticle]Fail to read Article");
				return null;
				// e.printStackTrace();
			} catch (IOException e) {
				System.err.println("[tool_GetArticle_getArticle]Fail to read Article");
				return null;
				// e.printStackTrace();
			} 

		} else {
			return null;
		}
		
	}

}
