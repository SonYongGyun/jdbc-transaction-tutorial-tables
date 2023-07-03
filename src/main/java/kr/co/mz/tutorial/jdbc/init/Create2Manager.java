package kr.co.mz.tutorial.jdbc.init;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import kr.co.mz.tutorial.jdbc.db.HikariPoolFactory;

public class Create2Manager {

  public static final String INSERT = """
      INSERT INTO manager (
        manager_name,
        manager_position,
        department_id,
        created_by,
        modified_by
      ) VALUES (?,?,?,?,?);
      """;

  public static void main(String[] args) throws IOException, SQLException {
    var hkariPoolFactory = new HikariPoolFactory();
    var dataSource = hkariPoolFactory.createHikariDateSource();
    try (var connection = dataSource.getConnection()) {
      var pst = connection.prepareStatement(INSERT);
      pst.setString(1, "SYG");
      pst.setDate(2, Date.valueOf("2023-06-01"));
      pst.setString(3, "A1001");
      pst.setString(4, "admin");
      pst.setString(5, "admin");

      var rs = pst.executeUpdate();
      connection.commit();
      System.out.println("Excution result 1 means success: " + rs);
      pst.close();
    }
  }

}
