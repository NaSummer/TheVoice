package tool;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * DOM生成与解析XML文档
 * @author Qiufan(Andy) Xu 
 * @date CreateTime: Dec 14, 2015 4:17:08 PM 
 * @version 1.0 
 * @param 
 */


public class Dom implements XmlDocument {
	private Document document;
	private String fileName;

	public Dom() {
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			this.document = builder.newDocument();
		} catch (ParserConfigurationException e) {
			System.out.println(e.getMessage());
		}
	}

	public void createXml(String fileName) {
		Element root = this.document.createElement("articles");
		this.document.appendChild(root);
		
		Element article = this.document.createElement("article");
		Element title = this.document.createElement("title");
		title.appendChild(this.document.createTextNode("丁宏亮"));
		article.appendChild(title);
		Element sex = this.document.createElement("sex");
		sex.appendChild(this.document.createTextNode("m"));
		article.appendChild(sex);
		Element age = this.document.createElement("age");
		age.appendChild(this.document.createTextNode("30"));
		article.appendChild(age);
		root.appendChild(article);
		TransformerFactory tf = TransformerFactory.newInstance();
		try {
			Transformer transformer = tf.newTransformer();
			DOMSource source = new DOMSource(document);
			transformer.setOutputProperty(OutputKeys.ENCODING, "gb2312");
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			PrintWriter pw = new PrintWriter(new FileOutputStream(fileName));
			StreamResult result = new StreamResult(pw);
			transformer.transform(source, result);
			System.out.println("生成XML文件成功!");
		} catch (TransformerConfigurationException e) {
			System.out.println(e.getMessage());
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (TransformerException e) {
			System.out.println(e.getMessage());
		}
	}

	public void parserXml(String fileName) {
		try {
			// open xml file
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document document = db.parse(fileName);
			
			// get articles group
			NodeList articles = document.getChildNodes();
			
			int articlesLength = articles.getLength();
			
			// check articles in group one by one
			for (int i = 0; i < articles.getLength(); i++) {
				
				// get current article
				Node article = articles.item(i);
				System.out.println(article.getTextContent());
				
				// get current article's info group
				NodeList articleInfoList = article.getChildNodes();
				System.out.println(articleInfoList.getLength());
				
				// check article info one by one
				for (int j = 0; j < articleInfoList.getLength(); j++) {
					
					// get current info
					Node node = articleInfoList.item(j);
					System.out.println(node.getTextContent());
					
					NodeList articleMetaList = node.getChildNodes();
					System.out.println(articleMetaList.getLength());
					
					for (int k = 0; k < articleMetaList.getLength(); k++) {
						System.out.println(articleMetaList.item(k).getNodeName() + ":" + articleMetaList.item(k).getTextContent());
					}
				}
			}
			System.out.println("XML解析完毕");
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (ParserConfigurationException e) {
			System.out.println(e.getMessage());
		} catch (SAXException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
}

