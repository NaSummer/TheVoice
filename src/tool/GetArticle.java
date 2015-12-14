package tool;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * @author Qiufan(Andy) Xu
 * @date CreateTime: 2015年10月25日 上午10:59:20
 * @version 1.0
 * @param
 */

public class GetArticle {

	private final String ARTICLES_PATH = "info/ArticleList.xml";
	
	private List<String> articleList;
	
	private DocumentBuilderFactory dbf;
	private DocumentBuilder db;
	private Document document;
	private NodeList docContent;
	private NodeList articles;

	/* Constructor */
	public GetArticle() {
		
		// open XML file
		try {			
			this.dbf = DocumentBuilderFactory.newInstance();
			this.db = dbf.newDocumentBuilder();
			this.document = db.parse(ARTICLES_PATH);
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// get articles group
		this.docContent = document.getChildNodes();
		this.articles = docContent.item(0).getChildNodes();
		
		this.articleList = new ArrayList<String>();

		// check articles in group one by one
		for (int i = 1; i < articles.getLength(); i += 2) {

			// get current article
			Node article = articles.item(i);
//			System.out.println(article.getTextContent()+"\n==============");
			
			// add article's title to articleList (item(1) store title)
			articleList.add(article.getChildNodes().item(1).getTextContent());
//			System.out.println(article.getChildNodes().item(1).getTextContent()+"\n==============");

//			/* ==================================================== */
//			// get current article's info group
//			NodeList articleInfoList = article.getChildNodes();
//
//			// check article info one by one
//			for (int j = 1; j < articleInfoList.getLength(); j += 2) {
//
//				// get current info
//				Node node = articleInfoList.item(j);
//				System.out.println(node.getTextContent()+"\n==============");
//
//				NodeList articleMetaList = node.getChildNodes();
//				int articleMetaListLength = articleMetaList.getLength();
//
//				for (int k = 1; k < articleMetaList.getLength(); k += 2) {
//					System.out.println(articleMetaList.item(k).getNodeName() + ":" + articleMetaList.item(k).getTextContent()+"\n==============");
//				}
//			}
//			/* ==================================================== */
		}
		System.out.println("Finish reading article list, there are " + articleList.size() + " articles.");
		
	}

	
	public List<String> getArticleList() {
		return articleList;
	}
	
	public String getArticleUrl(int articleNumber) {
		
		int articleRealPosition = articleNumber * 2 + 1;
		Node article = articles.item(articleRealPosition);
		NodeList urlInfo = article.getChildNodes().item(3).getChildNodes();
		
		/* http://mp.weixin.qq.com/s?__biz=MzI5OTEyMTU5MQ==&mid=400676320&idx=1&sn=ddd226225e1606b9c196c17dcf55277e#rd */
		StringBuilder url = new StringBuilder();
		url.append("http://mp.weixin.qq.com/s?__biz=" + urlInfo.item(1).getTextContent());
		url.append("==&mid=" + urlInfo.item(3).getTextContent());
		url.append("&idx=" + urlInfo.item(5).getTextContent());
		url.append("&sn=" + urlInfo.item(7).getTextContent());
		url.append("#rd");
		
		return url.toString();
	}
	
	/**
	 * 
	 * @param
	 * @return article content, if not exist, null
	 */
	public String getArticleUrl(String articleName) {
		if (articleList.contains(articleName)) {
			return getArticleUrl(articleList.indexOf(articleName));
		} else {
			return null;
		}
		
	}

}
