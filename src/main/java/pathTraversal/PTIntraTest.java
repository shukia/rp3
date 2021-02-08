package pathTraversal;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;

@RestController
public class PTIntraTest {
  private final String BASE_DIRECTORY = "src";

  @PostMapping
  public void test(HttpServletRequest request) {
    try {
      String path = getFilePath(BASE_DIRECTORY,request);
      FileOutputStream fos = new FileOutputStream(path);
      fos.write("abcd".getBytes());
    } catch (Exception ex) {
      ex.printStackTrace();
    }
    System.out.print("sdfsf");
  }

  public String getFilePath(String baseDirPath, HttpServletRequest request) {
    return baseDirPath + File.separator + request.getParameter("filename");
  }

}
