package xxe;

import java.io.StringReader;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;

public class TraccarSlicedTest {

  private DocumentBuilder documentBuilder;
  private XPath xPath;
  private XPathExpression messageExpression;

  public TraccarSlicedTest() {
    try {
      documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
      xPath = XPathFactory.newInstance().newXPath();
      messageExpression = xPath.compile("//messageList/message");
    } catch (ParserConfigurationException | XPathExpressionException e) {
      throw new RuntimeException(e);
    }
  }

  protected void decode(String xmlString) throws Exception {
    Document document = documentBuilder.parse(new InputSource(new StringReader(xmlString)));
  }
}
