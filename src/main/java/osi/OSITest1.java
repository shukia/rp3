package osi;


import java.io.IOException;
import javax.servlet.http.HttpServletRequest;

public class OSITest1 {
    public void test(HttpServletRequest request) throws IOException, InterruptedException{
        String data = request.getParameter("data");
        String osCommand;
        if(System.getProperty("os.name").toLowerCase().contains("win"))
        {
            /* running on Windows */
            osCommand = "c:\\WINDOWS\\SYSTEM32\\cmd.exe /c dir ";
        }
        else
        {
            /* running on non-Windows */
            osCommand = "/bin/ls ";
        }

        /* POTENTIAL FLAW: command injection */
        Process process = Runtime.getRuntime().exec(osCommand + data);
        process.waitFor();
    }
}