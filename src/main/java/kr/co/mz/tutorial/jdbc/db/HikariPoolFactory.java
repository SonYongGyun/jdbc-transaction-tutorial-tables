package kr.co.mz.tutorial.jdbc.db;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.Properties;
import javax.sql.DataSource;

public class HikariPoolFactory {

  public static void main(String[] args) throws SQLException, IOException {
    var dataSource = new HikariPoolFactory().createHikariDateSource();
    var connection = dataSource.getConnection();

    String sql = "select * from department";
    var preparedStatement = connection.prepareStatement(sql);
    var rs = preparedStatement.executeQuery();
    while (rs.next()) {
      System.out.println(rs.getString(1));
      System.out.println(rs.getString(2));
      System.out.println(rs.getString(3));
      System.out.println(rs.getString(4));
    }
  }

  //클래스패스 지금 이거 그려러니 하고넘어가기.  배포된걸 쓰니까 그런것.
  public DataSource createHikariDateSource() {
    var props = new Properties();
    InputStream is = null;
    try {
      is = getClass().getClassLoader().getResourceAsStream("db/hikari.properties");
      if (is == null) {
        System.out.println("Could not find 'db/hikari.properties' in the classpath");
      } else {
        props.load(is);
      }
    } catch (IOException ioe) {
      System.out.println("Could not load 'db/hikari.properties' from the classpath");
    } finally {
      if (is != null) {
        try {
          is.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }
    var config = new HikariConfig(props);
    var ds = new HikariDataSource(config);
    return ds;
  }


}
