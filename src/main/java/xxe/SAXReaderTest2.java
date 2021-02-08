package xxe;

import java.io.StringReader;
import javax.servlet.http.HttpServletRequest;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.xml.sax.InputSource;

public class SAXReaderTest2 {
  public String getXml(HttpServletRequest request) {
    String xmlStr = request.getParameter("xmlStr");
    String result = unsafe(xmlStr);
    if(result != null) {
      return result;
    }
    return "XML error";
  }

  private String unsafe(String xmlString)
  {
    try {
      Document document = new SAXReader().read(new InputSource(new StringReader(xmlString)));
      Element root = document.getRootElement();
      return root.getText();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }
}
