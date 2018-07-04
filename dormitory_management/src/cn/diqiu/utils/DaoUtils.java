package cn.diqiu.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

public class DaoUtils {
	
	//拿到Db的文件路径
	private static String filepath;
	
	static{//得到文件的类和类装载器
		filepath = DaoUtils.class.getClassLoader().getResource("Db.xml").getPath();
	}
	//saxreader读取Db文件
	public static Document getDocument() throws DocumentException{//Document类存在dom4j文档中
		
		SAXReader reader = new SAXReader();//创建一个reader
		Document document = reader.read(new File(filepath));
		return document;
	}
	//写入Db文件
	public static void Write2Xml(Document document) throws IOException{
		OutputFormat format = new OutputFormat();
		format.setEncoding("UTF-8");
		XMLWriter writer = new XMLWriter(new FileOutputStream(filepath) ,format);
		writer.write(document);
		writer.close();
	}
}
