package ra.springthymeleaf.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ra.springthymeleaf.model.dto.StudentResponse;
import ra.springthymeleaf.model.entity.Mark;

import javax.persistence.TypedQuery;
import java.util.List;

@Component
public class StudentDao {

    @Autowired
    public SessionFactory sessionFactory;

    public void getAll(){
        Session session = sessionFactory.getCurrentSession();
        // viet native query
        List<Mark> list = session.createQuery("from Mark where student.id=:studentId", Mark.class).setParameter("studentId","A01").setFirstResult(0).setMaxResults(2).list();
        System.out.println(list);
    }
    // 10 item - limit 4 - 3 page
    /*
    * item 5
    * item 6
    * item 7
    * item 8
    * (page 2/3)
    * 1. Trang truoc
    * 2. trang sau
    * 0. Quay lai
    * */
}
