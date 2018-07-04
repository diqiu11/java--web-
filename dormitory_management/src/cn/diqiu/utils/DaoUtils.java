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
	
	//�õ�Db���ļ�·��
	private static String filepath;
	
	static{//�õ��ļ��������װ����
		filepath = DaoUtils.class.getClassLoader().getResource("Db.xml").getPath();
	}
	//saxreader��ȡDb�ļ�
	public static Document getDocument() throws DocumentException{//Document�����dom4j�ĵ���
		
		SAXReader reader = new SAXReader();//����һ��reader
		Document document = reader.read(new File(filepath));
		return document;
	}
	//д��Db�ļ�
	public static void Write2Xml(Document document) throws IOException{
		OutputFormat format = new OutputFormat();
		format.setEncoding("UTF-8");
		XMLWriter writer = new XMLWriter(new FileOutputStream(filepath) ,format);
		writer.write(document);
		writer.close();
	}
}
