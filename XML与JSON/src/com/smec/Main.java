package com.smec;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.InputStream;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

public class Main {
    public static void main(String[] args) throws Exception {
        InputStream input = Main.class.getResourceAsStream("/book.xml");
        //解析并获取Document对象：
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document doc = db.parse(input);
        printNode((Node) doc, 0);
    }

    static void printNode(Node n, int indent) throws ParserConfigurationException {
        for (int i = 0; i < indent; i++) {
            System.out.println(' ');
        }
        switch (n.getNodeType()) {
            case Node.DOCUMENT_NODE:
                System.out.println("Document: " + n.getNodeName());
                break;
            case Node.ELEMENT_NODE:
                System.out.println("Element: " + n.getNodeName() + " Attr: ");
                break;
            case Node.TEXT_NODE:
                System.out.println("Text: " + n.getNodeName() + " = " + n.getNodeValue());
                break;
            case Node.ATTRIBUTE_NODE:
                System.out.println("Attr: " + n.getNodeName() + " = " + n.getNodeValue());
                break;
            case Node.CDATA_SECTION_NODE:
                System.out.println("CDATA: " + n.getNodeName() + " = " + n.getNodeValue());
                break;
            default:
                System.out.println("NodeType: " + n.getNodeType() + ", NodeName: " + n.getNodeName());
        }
//        DocumentBuilder x = DocumentBuilderFactory.newInstance().newDocumentBuilder();
//        Document y = x.parse(Main.class.getResourceAsStream("file"));
        for (Node child = (Node) n.getFirstChild(); child != null; child = (Node) child.getNextSibling()) {
            if (child.hasAttributes()) {
                NamedNodeMap as = child.getAttributes();
                for (int i = 0; i < as.getLength(); i++) {
                    printNode(as.item(i), indent + 1);
                }
            }
            printNode(child, indent + 1);
        }
    }
}
