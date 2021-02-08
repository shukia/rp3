package xss;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class XssMultiLineSink {

    // snippet from Comcast cmb CQSQueueMessagesPageServlet

    public void sink(String name, HttpServletRequest request, HttpServletResponse response) {
        String userId = request.getParameter("userId");
        String queueName = request.getParameter("queueName");
        int numberOfShards = 1;
        int shard = 0;
        try {
            response.setContentType("text/html");
            PrintWriter out = ((HttpServletResponse)null).getWriter();
            if (numberOfShards > 1) {
                out.println(
                        "<form id='frm2' action=\"/webui/cqsuser/message/?userId="
                                + userId
                                + "&queueName="
                                + queueName
                                + "\" method=POST>");
                out.println(
                        "<tr><td>Shard: <select name='shard' onChange='document.getElementById(\"frm2\").submit();'>");
                for (int i = 0; i < numberOfShards; i++) {
                    out.print("<option value='" + i + "'");
                    if (shard == i) {
                        out.print(" selected");
                    }
                    out.println(">" + i + "</option>");
                }
                out.println("</form></select></td></tr></table></p>");
            } else {
                out.println("</table></p>");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}