package kr.co.mz.tutorial.jdbc.init;

import java.io.IOException;
import java.sql.SQLException;
import kr.co.mz.tutorial.jdbc.db.HikariPoolFactory;

public class Create1Department {

  public static final String INSERT = """
      INSERT INTO department (
           department_id,
           department_name,
           location,
           employee_count,
           created_by,
           modified_by
      ) VALUES (?,?,?,?,?,?);
      """;

  public static void main(String[] args) throws IOException, SQLException {
    var hkariPoolFactory = new HikariPoolFactory();
    var dataSource = hkariPoolFactory.createHikariDateSource();
    try (var connection = dataSource.getConnection()) {
      var pst = connection.prepareStatement(INSERT);
      pst.setString(1, "A12");
      pst.setString(2, "B2B");
      pst.setString(3, "6th");
      pst.setInt(4, 1);
      pst.setString(5, "admin");
      pst.setString(6, "admin");

      var rs = pst.executeUpdate();
      connection.commit();
      System.out.println("Execution result 1 means success: " + rs);
      pst.close();
    }
  }

}
