package yangsenxi.util;

import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

import javax.sql.DataSource;

import com.alibaba.druid.pool.DruidDataSourceFactory;

public class JDBCDurid {


    public static void main(String[] args) throws Exception {
        //1.从类路径下加载配置文件，获取一个输入流。如果不指定路径，默认是读取同一个包下资源文件
        InputStream inputStream = JDBCDurid.class.getResourceAsStream("/yangsenxi.properties");
        //2.使用Properties对象的方法将配置文件中属性加载到Properties对象中
        Properties properties = new Properties();
        //加载了配置文件中所有的属性
        properties.load(inputStream);
        //3.通过druid的工厂类创建连接池
        DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);

        //获取10个连接对象
        for (int i = 1; i <= 11; i++) {
            Connection connection = dataSource.getConnection();
            System.out.println("第" + i + "个连接对象：" + connection);
            //第3个连接关闭
            if (i==3) {
                connection.close();
            }
        }
    }


}
