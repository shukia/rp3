package xxe;

import java.io.StringReader;
import javax.servlet.http.HttpServletRequest;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;
import org.xml.sax.InputSource;

public class SAXBuilderTest2 {

  public String getXml(HttpServletRequest request) {
    String xmlStr = request.getParameter("xmlStr");
    String result = unsafe(xmlStr);
    if(result != null) {
      return result;
    }
    return "XML parse error";
  }

  private String unsafe(String xmlString)
  {
    try {
      Document document = new SAXBuilder().build(new InputSource(new StringReader(xmlString)));
      Element root = document.getRootElement();
      return root.getText();
    } catch (Exception e) {
      e.printStackTrace();
    }

    return null;
  }
}
