package com.lgd.framework;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;

import javax.lang.model.element.Element;
import javax.xml.transform.sax.SAXResult;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

public class BeanFactory {
    private Iterator<Element> iterator=null;
    private  static BeanFactory beanFactory=null;
    public static BeanFactory init(){
        synchronized (BeanFactory.class){
            if(beanFactory==null){
                beanFactory=new BeanFactory("bean.xml");
            }
        }
        return beanFactory;
    }

    public BeanFactory(String xml) {
        InputStream is=Thread.currentThread().getContextClassLoader().getResourceAsStream(xml);
        SAXReader reader = new SAXReader();
        try {
            Document document = reader.read(is);
            org.dom4j.Element rootElement = document.getRootElement();
            iterator=rootElement.elementIterator();
            is.close();
        } catch (IOException | DocumentException e) {
            e.printStackTrace();
        }
    }
    public Object getBean(String id){
        while (iterator.hasNext()){
            org.dom4j.Element bean= (org.dom4j.Element) iterator.next();
            String sid=bean.attributeValue("id");
            if(sid.equals(id)){
                String className=bean.attributeValue("class");
                try {
                    return Class.forName(className).newInstance();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
}
