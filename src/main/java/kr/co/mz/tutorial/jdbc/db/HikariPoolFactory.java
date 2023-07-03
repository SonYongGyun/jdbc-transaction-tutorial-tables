package kr.co.mz.tutorial.jdbc.db;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;
import javax.sql.DataSource;

public class HikariPoolFactory {

  public static void main(String[] args) throws SQLException, IOException {
    var dataSource = createHikariDateSource();
    var connection = dataSource.getConnection();

    String sql = "show tables";
    var preparedStatement = connection.prepareStatement(sql);
    var rs = preparedStatement.executeQuery();
    while (rs.next()) {
      System.out.println(rs.getString(1));
    }
  }

  public static Properties loadProperties() throws IOException {
    var properties = new Properties();//클래스패스 지금 이거 그려러니 하고넘어가기.  배포된걸 쓰니까 그런것.
    try (var is = HikariPoolFactory.class.getClassLoader().getResourceAsStream("db/hikari.properties")) {
      //위의 경로는 살수로

      properties.load(is);
    }

    return properties;
  }

  public static DataSource createHikariDateSource() throws IOException {//히카리풀은 원래 스로우하면안됨.
    var properties = loadProperties();
    HikariConfig config = new HikariConfig(properties);
    return new HikariDataSource(config);
  }
}
