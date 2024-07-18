package yangsenxi.util;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import javax.sql.DataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
public class JDBCUtils {
	
	//声明连接池对象
    private static DataSource dataSource;

    //使用静态，是类加载的时候就创建连接池
    static{
        try {
            //读取配置文件
            InputStream inputStream = JDBCUtils.class.getClassLoader().getResourceAsStream("/yangsenxi.properties");
            //获取Properties对象，加载到该对象中
            Properties properties = new Properties();
            //获取配置文件
            properties.load(inputStream);
            //创建druid工厂
            dataSource = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //获取数据库连接
    public static Connection getConn() throws SQLException {
        return dataSource.getConnection();
    }


    /**
     * 关闭连接
     * 查询调用这个方法
     */
    public static void close(Connection connection, Statement statement, ResultSet resultSet) {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (statement != null) {
                statement.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public static void close(Connection connection, PreparedStatement pr) {
        try {
            if (pr != null) {
                pr.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 关闭连接
     * 增删改没有结果集
     */
    public static void close(Connection connection, Statement statement) {
        //直接调用上面的方法
        close(connection, statement, null);
    }

}
