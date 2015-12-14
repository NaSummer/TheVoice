package tool;

/**
 * ����XML�ĵ�����������Ľӿ�
 * @author Qiufan(Andy) Xu 
 * @date CreateTime: Dec 14, 2015 4:08:30 PM 
 * @version 1.0 
 * @param 
 */

public interface XmlDocument {
	/**
	 * Create XML Document
	 * 
	 * @param fileName
	 *            File full path name
	 */
	public void createXml(String fileName);

	/**
	 * Parser XML Document
	 * 
	 * @param fileName
	 *            File full path name
	 */
	public void parserXml(String fileName);
}