package sql;

import java.io.File;
import java.io.UnsupportedEncodingException;
//import java.lang.reflect.Parameter;
import java.net.URLDecoder;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.omg.Dynamic.Parameter;

/**
 * 从xml文件中读取参数
 */

public class FromXml {

	File file;
	SAXReader reader;

	public FromXml() {
		reader = new SAXReader();
		file = new File("c:\\UrlAndTime.xml");
	}

	public String getUrl() {

		Document doc;
		String foo = null;
		try {
			doc = reader.read(file);
			Element root = doc.getRootElement();
			foo = root.elementText("url");
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		return foo;
	}

	public int getTime() {

		Document doc;
		int time = 20;
		try {
			doc = reader.read(file);
			Element root = doc.getRootElement();
			time = Integer.parseInt(root.elementText("time"));
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		return time;
	}

}
