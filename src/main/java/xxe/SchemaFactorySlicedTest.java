package xxe;

import org.xml.sax.SAXParseException;
import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.IOException;
import java.io.StringReader;
import java.net.URL;

public class SchemaFactorySlicedTest {
    // WS app example
    private static final String SAML_SCHEMA_METADATA = "saml/saml-schema-metadata-2.0.xsd";

    private SchemaFactorySlicedTest() {}

    public static boolean validateXmlWithSchemaUrl(String xmlInput) throws IOException {
        try (StringReader stringReader = new StringReader(xmlInput)) {
            URL schemaUrl = SchemaFactorySlicedTest.class.getClassLoader().getResource(SAML_SCHEMA_METADATA);
            Source metadataFile = new StreamSource(stringReader);
            SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = schemaFactory.newSchema(schemaUrl);
            schema.newValidator().validate(metadataFile);
            return true;
        } catch (SAXParseException e) {
            throw new IOException("SAML Metadata validation failed");
        } catch (Exception e) {
            throw new IOException("SAML File Writing - Internal Server Error");
        }
    }

}
