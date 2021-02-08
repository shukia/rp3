package xxe;

import java.io.StringReader;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

public class PippoSlicedTest {

  private final XMLInputFactory xmlInputFactory;

  public PippoSlicedTest() {
    xmlInputFactory = buildXMLInputFactory();
  }

  public <T> T fromString(String content, Class<T> classOfT) {
    try (StringReader reader = new StringReader(content)) {
      JAXBContext jaxbContext = JAXBContext.newInstance(classOfT);

      XMLStreamReader xmlStreamReader = xmlInputFactory.createXMLStreamReader(reader);

      Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

      return (T) unmarshaller.unmarshal(xmlStreamReader);
    } catch (JAXBException | XMLStreamException e) {
      throw new RuntimeException(e);
    }
  }

  protected XMLInputFactory buildXMLInputFactory() {
    return XMLInputFactory.newFactory();
  }
}
