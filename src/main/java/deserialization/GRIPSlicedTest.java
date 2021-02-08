package deserialization;

import org.apache.commons.io.IOUtils;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.converters.reflection.PureJavaReflectionProvider;
import java.io.Reader;
import java.io.StringReader;


public class GRIPSlicedTest {

    public class Project {

        protected final XStream xstream = new XStream(new PureJavaReflectionProvider());

        public void open(String projectXml) {
            open(new StringReader(projectXml));
        }

        void open(Reader reader) {
            this.xstream.fromXML(reader);
        }
    }
}

class HttpPipelineSwitcher {
    private final GRIPSlicedTest.Project project;

    HttpPipelineSwitcher(GRIPSlicedTest.Project project) {
        this.project = project;
    }

    protected void handleIfPassed(HttpServletRequest request) throws IOException {
        project.open(new String(IOUtils.toByteArray(request.getInputStream()), "UTF-8"));
    }
}