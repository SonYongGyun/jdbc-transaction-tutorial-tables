package kr.co.mz.tutorial.jdbc.dto;

import java.sql.Timestamp;

public class DepartmentDto {

  private long seq;
  private String department_id;
  private String department_name;
  private String location;
  private int employee_count;
  private String created_by;
  private Timestamp created_time;
  private String modified_by;
  private Timestamp modified_time;

}
