package pathTraversal;

import java.io.File;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PTTest10 {
  private final String BASE_DIRECTORY = "src";

  @PostMapping
  public void test(String filename) {
    try {
      int a = 0;
      String s = BASE_DIRECTORY + "qqq";
      File parent = new File("asd");
      new File(parent, filename).delete();
    } catch (Exception ex) {
      ex.printStackTrace();
    }
    System.out.print("sdfsf");
  }

  public String getvalue(String s) {
    return "rrr" + s + "aaa";
  }
}
