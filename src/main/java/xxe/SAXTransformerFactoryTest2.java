package xxe;

import java.io.StringReader;
import java.io.StringWriter;
import javax.servlet.http.HttpServletRequest;
import javax.xml.transform.Transformer;
import javax.xml.transform.sax.SAXTransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

public class SAXTransformerFactoryTest2 {
  public String getXml(HttpServletRequest request) {
    String xmlStr = request.getParameter("xmlStr");
    String result = unsafe(xmlStr);

    if(result != null) {
      return result;
    }

    return "XML error";
  }

  private String unsafe(String xmlString) {

    try {
      Transformer transformer = ((SAXTransformerFactory) SAXTransformerFactory.newInstance()).newTransformer();
      StreamSource source = new StreamSource(new StringReader(xmlString));
      StringWriter writer = new StringWriter();
      StreamResult target = new StreamResult(writer);
      transformer.transform(source, target);
      return writer.toString();
    } catch (Exception e) {
      e.printStackTrace();
    }

    return null;
  }
}
