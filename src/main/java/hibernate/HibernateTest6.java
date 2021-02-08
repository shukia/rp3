package hibernate;

import javax.servlet.http.HttpServletRequest;
import org.hibernate.Session;
import org.hibernate.SessionFactory;


public class HibernateTest6 {

  public void hibernateTest6(HttpServletRequest request) {
    String id = request.getParameter("id");
    SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    Session session = sessionFactory.openSession();
    session.getTransaction().begin();
    String hql = "UPDATE Employee set salary = 100 WHERE id = " + id;
    session.createQuery(hql);
    session.getTransaction().commit();
    session.close();
  }
}
