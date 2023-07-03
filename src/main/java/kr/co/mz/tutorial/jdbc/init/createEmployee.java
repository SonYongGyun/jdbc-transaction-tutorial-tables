package kr.co.mz.tutorial.jdbc.init;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import kr.co.mz.tutorial.jdbc.db.HikariPoolFactory;

public class createEmployee {

  //불편하더라도 현실성있는데이터 넣는버릇 들이고 이게 불편하다면
  //이걸지원해주는
  private static final String INSERT = """
      INSERT INTO employee (
          employee_name,
          hire_date,
          department_id,
          created_by,
          modified_by,
      )
      values (?,?,?,?,?)
      """;

  public static void main(String[] args) throws SQLException, IOException {
    var dataSource = HikariPoolFactory.createHikariDateSource();
    var connection = dataSource.getConnection();
    var pst = connection.prepareStatement(INSERT);
    pst.setString(1, "SYG");
    pst.setDate(2, Date.valueOf("2023-06-01"));
    pst.setString(3, "B2B");
    pst.setString(4, "admin");
    pst.setString(5, "admin");

    var rs = pst.executeUpdate();
    System.out.println("Excution result 1 means success: " + rs);


  }

}
