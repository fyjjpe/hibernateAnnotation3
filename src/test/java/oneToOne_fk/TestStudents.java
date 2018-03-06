package oneToOne_fk;

import com.oneToOne_bfk.IdCard;
import com.oneToOne_bfk.Students;
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
        //1.生成一个身份证对象
        IdCard card = new IdCard("123456789987654321","张无忌");
        //2.再生成学生对象
        Students s = new Students(card,"男",new Date(),"太极拳");
        //3.先保存身份证对象
        session.save(card);
        //4.再保存学生对象
        session.save(s);
        tx.commit();
        HibernateUtil.colseSession(session);
    }

}
