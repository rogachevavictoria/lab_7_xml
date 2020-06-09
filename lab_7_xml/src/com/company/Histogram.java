package com.company;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

 public class Histogram
{
   public static void main (String[] args) {
       try {
           int count;
           File fXmlFile = new File("stats.xml");
           DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
           DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
           Document doc = dBuilder.parse(fXmlFile);
           doc.getDocumentElement().normalize();
           System.out.println(doc.getDocumentElement().getNodeName() + " Stats: ");
           NodeList nList = doc.getElementsByTagName("stat");
           for (int temp = 0; temp < nList.getLength(); temp++) {
               Node nNode = nList.item(temp);
               if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                   Element eElement = (Element) nNode;
                   count = 0;
                   System.out.print(eElement.getElementsByTagName("sname").item(0).getTextContent() + "   | ");
                   count = Integer.parseInt(eElement.getElementsByTagName("snum").item(0).getTextContent());
                   while (count != 0) {
                       System.out.print("[]");
                       count--;
                   }
                   System.out.println();
               }
           }
       } catch (Exception e) {
           e.printStackTrace();
       }
   }}


