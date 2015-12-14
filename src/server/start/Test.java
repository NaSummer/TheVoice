package server.start;

import tool.GetArticle;

/**
 * @author Qiufan(Andy) Xu 
 * @date CreateTime: Dec 14, 2015 4:26:52 PM 
 * @version 1.0 
 * @param 
 */

public class Test {

	public static void main(String[] args) {
		GetArticle articleTool = new GetArticle();
		System.out.println(articleTool.getArticleList());
		for (int i = 0; i < articleTool.getArticleList().size(); i++) {
			System.out.println(articleTool.getArticleList().get(i) + "\n" + articleTool.getArticleUrl(i));
			System.out.println();
		}
	}

}
