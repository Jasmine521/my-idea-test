package com.sax;

import org.w3c.dom.NamedNodeMap;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.InputStream;

public class Main {
    public static void main(String[] args) throws Exception {
        SAXParserFactory.newInstance().newSAXParser().parse(Main.class.getResourceAsStream("/book.xml"),new MyHandler());
    }
}

class MyHandler extends DefaultHandler{
    public void startDocument() throws SAXException{
        print("start document");
    }

    public void endDocument() throws SAXException{
        print("end document");
    }

    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        print("start element: ",localName,qName);
        int i = 0;
        while(attributes.getValue(i)!=null){
            print("attribute: ",attributes.getValue(i++));
        }
    }

    public void endElement(String uri,String localName,String qName) throws SAXException{
        print("end element: ",localName,qName);
    }

    public void characters(char[] ch,int start,int length)throws SAXException{
        print("characters: ",new String(ch,start,length));
    }

    public void error(SAXParseException e) throws SAXException{
        print("error: ",e);
    }

    void print(Object... objects){
        for(Object obj : objects){
            System.out.print(obj);
            System.out.print(" ");
        }
        System.out.println();
    }
}