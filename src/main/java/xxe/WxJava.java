package xxe;

import java.io.StringReader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.InputSource;

public class WxJava {

  private static final Charset CHARSET = StandardCharsets.UTF_8;

  private static final ThreadLocal<DocumentBuilder> BUILDER_LOCAL =
      new ThreadLocal<DocumentBuilder>() {
        @Override
        protected DocumentBuilder initialValue() {
          try {
            final DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            factory.setExpandEntityReferences(false);
            return factory.newDocumentBuilder();
          } catch (ParserConfigurationException exc) {
            throw new IllegalArgumentException(exc);
          }
        }
      };

  protected byte[] aesKey;
  protected String token;
  protected String appidOrCorpid;

  public WxJava() {}

  public WxJava(String token, String encodingAesKey, String appidOrCorpid) {
    this.token = token;
    this.appidOrCorpid = appidOrCorpid;
  }

  static String extractEncryptPart(String xml) {
    try {
      DocumentBuilder db = BUILDER_LOCAL.get();
      Document document = db.parse(new InputSource(new StringReader(xml)));

      Element root = document.getDocumentElement();
      return root.getElementsByTagName("Encrypt").item(0).getTextContent();
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }
}
