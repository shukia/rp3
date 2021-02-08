package osi;


import java.io.IOException;
import javax.servlet.http.HttpServletRequest;

public class OSITest3 {
    private static String command = "mkdir";


    public void test(HttpServletRequest request) throws IOException, InterruptedException{
        String data = request.getParameter("data");
        /* POTENTIAL FLAW: command injection */
        Process process = Runtime.getRuntime().exec(command + data);
        process.waitFor();
    }
}