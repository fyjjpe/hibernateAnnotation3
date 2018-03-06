package manyToMany_fk;


import com.manyToMany_fk.Students;
import com.manyToMany_fk.Teachers;
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
        //创建教师对象
        Teachers t1 = new Teachers("t001","张老师");
        Teachers t2 = new Teachers("t002","李老师");
        Teachers t3 = new Teachers("t003","陈老师");
        Teachers t4 = new Teachers("t004","刘老师");

        //创建学生对象
        Students s1 = new Students("张三","男",new Date(),"计算机专业");
        Students s2 = new Students("李四","女",new Date(),"计算机专业");
        Students s3 = new Students("王五","男",new Date(),"计算机专业");
        Students s4 = new Students("赵六","男",new Date(),"计算机专业");
        Set<Teachers> set1 = new HashSet<Teachers>();
        set1.add(t1);
        set1.add(t2);
        Set<Teachers> set2 = new HashSet<Teachers>();
        set2.add(t3);
        set2.add(t4);
        Set<Teachers> set3 = new HashSet<Teachers>();
        set3.add(t1);
        set3.add(t3);
        set3.add(t4);
        Set<Teachers> set4 = new HashSet<Teachers>();
        set4.add(t2);
        set4.add(t3);
        set4.add(t4);

        s1.setTeachers(set1);
        s2.setTeachers(set2);
        s3.setTeachers(set3);
        s4.setTeachers(set4);
        //先保存教师
        session.save(t1);
        session.save(t2);
        session.save(t3);
        session.save(t4);

        //再保存学生
        session.save(s1);
        session.save(s2);
        session.save(s3);
        session.save(s4);

        tx.commit();
        HibernateUtil.colseSession(session);
    }

}
