package oneToMany_fk;

import com.oneToMany_fk.ClassRoom;
import com.oneToMany_fk.Students;
import com.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.Test;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by yuanjie.fang on 2018/3/1.
 */
public class TestStudents {

    //输出表结构
    @Test
    public void testSchemaExport() {
        Configuration config = new Configuration().configure();
        ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();
        SessionFactory sessionFactory = config.buildSessionFactory(serviceRegistry);
        SchemaExport export = new SchemaExport(config);
        export.create(true, true);
    }

    @Test
    public void addStudents(){
        Session session = HibernateUtil.getSession();
        Transaction tx = session.beginTransaction();
        //先创建班级对象
        ClassRoom c1 = new ClassRoom("C001","软件工程");
        ClassRoom c2 = new ClassRoom("C002","网络工程");
        //创建学生对象
        Students s1 = new Students("张三","男",new Date(),"计算机专业");
        Students s2 = new Students("李四","女",new Date(),"计算机专业");
        Students s3 = new Students("王五","男",new Date(),"计算机专业");
        Students s4 = new Students("赵六","男",new Date(),"计算机专业");
        Set<Students> set1 = new HashSet<Students>();
        set1.add(s1);
        set1.add(s2);
        Set<Students> set2 = new HashSet<Students>();
        set2.add(s3);
        set2.add(s4);

        c1.setStus(set1);
        c2.setStus(set2);
        //先保存学生
        session.save(s1);
        session.save(s2);
        session.save(s3);
        session.save(s4);
        //再保存班级
        session.save(c1);
        session.save(c2);
        tx.commit();
        HibernateUtil.colseSession(session);
    }

}
