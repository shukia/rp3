package xxe;

import java.io.StringReader;
import java.io.StringWriter;
import javax.servlet.http.HttpServletRequest;
import javax.xml.transform.sax.SAXTransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

public class SAXTransformerFactoryTest3 {
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
      StreamSource source = new StreamSource(new StringReader(xmlString));
      StringWriter writer = new StringWriter();
      StreamResult target = new StreamResult(writer);
      ((SAXTransformerFactory) SAXTransformerFactory.newInstance()).newTransformer().transform(source, target);
      return writer.toString();
    } catch (Exception e) {
      e.printStackTrace();
    }

    return null;
  }
}
