package deserialization;

import org.xml.sax.helpers.XMLReaderFactory;

import java.io.IOException;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class DeserializationTest1 {

    public void test(File file) throws IOException, ClassNotFoundException {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));
        XMLReaderFactory xmlParser = (XMLReaderFactory) in.readObject();
        XMLReaderFactory xmlParser_two = (XMLReaderFactory) xmlParser;
        in.close();
    }
}