package pathTraversal;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
public class PTVoluTest3 {
  private final String BASE_DIRECTORY = "src";

  @PostMapping
  public void test(String filename) {
    try {
      int a = 0;
      String s = BASE_DIRECTORY + "qqq" + filename + getvalue("abc");
      FileOutputStream fos = new FileOutputStream(s);
      fos.write("abcd".getBytes());
    } catch (Exception ex) {
      ex.printStackTrace();
    }
    System.out.print("sdfsf");
  }

  public String getvalue(String s) {
    return "rrr" + s + "aaa";
  }

}
