package kr.co.mz.tutorial.jdbc.dto;

import java.sql.Timestamp;

public class EmployeeDto {

  private long seq;
  private String employee_name;
  private Timestamp hire_date;
  private String department_id;
  private long manager_seq;
  private String created_by;
  private Timestamp created_time;
  private String modified_by;
  private Timestamp modified_time;

  public long getSeq() {
    return seq;
  }

  public void setSeq(long seq) {
    this.seq = seq;
  }

  public String getEmployee_name() {
    return employee_name;
  }

  public void setEmployee_name(String employee_name) {
    this.employee_name = employee_name;
  }

  public Timestamp getHire_date() {
    return hire_date;
  }

  public void setHire_date(Timestamp hire_date) {
    this.hire_date = hire_date;
  }

  public String getDepartment_id() {
    return department_id;
  }

  public void setDepartment_id(String department_id) {
    this.department_id = department_id;
  }

  public long getManager_seq() {
    return manager_seq;
  }

  public void setManager_seq(long manager_seq) {
    this.manager_seq = manager_seq;
  }

  public String getCreated_by() {
    return created_by;
  }

  public void setCreated_by(String created_by) {
    this.created_by = created_by;
  }

  public Timestamp getCreated_time() {
    return created_time;
  }

  public void setCreated_time(Timestamp created_time) {
    this.created_time = created_time;
  }

  public String getModified_by() {
    return modified_by;
  }

  public void setModified_by(String modified_by) {
    this.modified_by = modified_by;
  }

  public Timestamp getModified_time() {
    return modified_time;
  }

  public void setModified_time(Timestamp modified_time) {
    this.modified_time = modified_time;
  }
}
