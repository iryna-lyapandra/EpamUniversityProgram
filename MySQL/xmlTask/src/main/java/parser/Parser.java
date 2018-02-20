package parser;


import comparator.CandyComparator;
import filechecker.ExtensionChecker;
import model.Candy;
import parser.dom.DOMParserUser;
import parser.sax.SAXParserUser;
import parser.stax.StAXReader;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;

public class Parser {

  public static void main(String[] args) {
    File xml = new File("src\\main\\resources\\xml\\candiesXML.xml");
    File xsd = new File("src\\main\\resources\\xml\\candiesXSD.xsd");

    if (checkIfXML(xml) && checkIfXSD(xsd)) {
//            SAX
      printList(SAXParserUser.parseCandies(xml, xsd), "SAX");

//            StAX
      printList(StAXReader.parseCandies(xml, xsd), "StAX");

//            DOM
      printList(DOMParserUser.getCandiesArrayList(xml, xsd), "DOM");
    }
  }

  private static boolean checkIfXSD(File xsd) {
    return ExtensionChecker.isXSD(xsd);
  }

  private static boolean checkIfXML(File xml) {
    return ExtensionChecker.isXML(xml);
  }

  private static void printList(ArrayList<Candy> candies, String parserName) {
    Collections.sort(candies, new CandyComparator());
    System.out.println(parserName);
    for (Candy candy : candies) {
      System.out.println(candy);
    }
  }

}
