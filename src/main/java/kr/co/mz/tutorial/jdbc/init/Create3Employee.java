package kr.co.mz.tutorial.jdbc.init;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import kr.co.mz.tutorial.jdbc.db.HikariPoolFactory;

public class Create3Employee {

  //불편하더라도 현실성있는데이터 넣는버릇 들이고 이게 불편하다면
  //이걸지원해주는
  private static final String INSERT = """
      INSERT INTO employee (
         employee_name,
         hire_date,
         department_id,
         manager_seq,
         created_by,
         modified_by
      )
      values (?,?,?,?,?,?)
      """;

  public static void main(String[] args) throws SQLException, IOException {
    var hkariPoolFactory = new HikariPoolFactory();
    var dataSource = hkariPoolFactory.createHikariDateSource();
    try (var connection = dataSource.getConnection()
    ) {
      var pst = connection.prepareStatement(INSERT);
      pst.setString(1, "SYG");
      pst.setDate(2, Date.valueOf("2023-06-01"));
      pst.setString(3, "A1001");
      pst.setString(4, "2");
      pst.setString(5, "admin");
      pst.setString(6, "admin");

      var rs = pst.executeUpdate();
      connection.commit();
      System.out.println("Excution result 1 means success: " + rs);

      pst.close();
    }


  }

}
