package osi;

import java.io.IOException;
import java.util.UUID;
import javax.servlet.http.HttpServletRequest;

public class OSITest9 {

  public void runCommand(HttpServletRequest request) throws IOException, InterruptedException {
    String input1 = request.getParameter("input1");
    String input2 = request.getParameter("input2");
    test(input1, input2);
//  injection:  input1 = "&&rm -rf /", input2 = "*"
  }

  public void test(String data1, String data2) throws IOException, InterruptedException {
    String osCommand;
    String uuid = UUID.randomUUID().toString();
    if (System.getProperty("os.name").toLowerCase().contains("win")) {
      /* running on Windows */
      osCommand = "c:\\WINDOWS\\SYSTEM32\\cmd.exe /c dir ";
    } else {
      /* running on non-Windows */
      osCommand = "/bin/ls ";
    }

    /* POTENTIAL FLAW: command injection */
    Process process = Runtime.getRuntime().exec(osCommand + data1 + data2);
    process.waitFor();
  }
}
