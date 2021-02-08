package ldap;

import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;
import javax.servlet.http.HttpServletRequest;
import javax.naming.directory.DirContext;

public class LDAPTest6 {


  public boolean test(HttpServletRequest request, DirContext ctx)
      throws NamingException {

    String user;
    String pass = request.getParameter("pass");
    user = request.getParameter("user");
    String filter = "(&(uid=" + user + ")(userPassword=" + pass + "))";

    NamingEnumeration<SearchResult> results = ctx
        .search("ou=system", filter, new SearchControls());
    return results.hasMore();
  }

}