package pathTraversal;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PTVoluTest2 {
  private final String BASE_DIRECTORY = "src";

  @PostMapping
  public void test(String filename) {
    try {
      int a = 0;
      String s = BASE_DIRECTORY + "qqq";
      Path p = Paths.get(filename);
      new File(p.toFile(), s).delete();
    } catch (Exception ex) {
      ex.printStackTrace();
    }
    System.out.print("sdfsf");
  }

  public String getvalue(String s) {
    return "rrr" + s + "aaa";
  }
}
