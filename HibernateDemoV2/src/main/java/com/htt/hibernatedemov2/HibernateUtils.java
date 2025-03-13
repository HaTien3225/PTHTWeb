package com.htt.hibernatedemov2;

import com.htt.pojo.Category;
import com.htt.pojo.Product;
import java.util.Properties;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 *
 * @author admin
 */
public class HibernateUtils {

    private static final SessionFactory FACTORY;

    static {
        Configuration conf = new Configuration();

        // Tạo đối tượng ServiceRegistry từ Hibernate 6.x
        Properties props = new Properties();
       props.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
        props.put("hibernate.connection.driver_class", "com.mysql.cj.jdbc.Driver");
        props.put("hibernate.connection.url", "jdbc:mysql://localhost:3306/saledb"); // Đảm bảo URL chính xác
        props.put("hibernate.connection.username", "root");  // Tên đăng nhập chính xác
        props.put("hibernate.connection.password", "root");  // Mật khẩu chính xác
        props.put("hibernate.show_sql", "true");  // Hiển thị SQL trong log

        conf.setProperties(props);

        // Đảm bảo rằng các lớp Entity được thêm vào
        conf.addAnnotatedClass(Category.class);
         conf.addAnnotatedClass(Product.class);

        // Xây dựng SessionFactory với ServiceRegistry
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(conf.getProperties()).build();
        FACTORY = conf.buildSessionFactory(serviceRegistry);
    }

    /**
     * @return the FACTORY
     */
    public static SessionFactory getFACTORY() {
        return FACTORY;
    }

}
