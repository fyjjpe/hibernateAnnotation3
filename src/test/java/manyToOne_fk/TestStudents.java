package manyToOne_fk;

import com.manyToOne_fk.ClassRoom;
import com.manyToOne_fk.Students;
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
        s1.setClassRoom(c1);
        s2.setClassRoom(c1);
        s3.setClassRoom(c2);
        s4.setClassRoom(c2);
        session.save(c1);
        session.save(c2);
        session.save(s1);
        session.save(s2);
        session.save(s3);
        session.save(s4);
        tx.commit();
        HibernateUtil.colseSession(session);
    }

}
