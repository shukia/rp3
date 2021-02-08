package hibernate;

import javax.servlet.http.HttpServletRequest;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

public class HibernateTest5 {

  public void hibernateTest5(HttpServletRequest request) {
    String id = request.getParameter("id");
    Query query;
    SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    Session session = sessionFactory.openSession();
    session.getTransaction().begin();
    String hql = "UPDATE Employee set salary = 100 WHERE id = " + id;
    query = session.createQuery(hql);
    session.getTransaction().commit();
    session.close();
  }
}
