package kr.co.mz.tutorial.jdbc.transaction;

public class NewEmployeeTransaction {

  /*
  부서 3개. 매니저 3명. 직원 8명

  scenario 1
  1. 부서는 있다고 가정.
  2. 매니저도 있다고 가정.
  3. 신입의 부서와 매니저를 배치.
  4. 부서의 count 1 증가.

  scenario 2
  1. 기존의 매니저가 퇴사
  2. 매니저 퇴사 후 제일 적은 수를 관리하고 있는 매니저에게 퇴사한 매니저 담당 사원들을 배치. 최대한 골고루 담당 할 수 있도록.
  3. 각 부서별 인원 수정.


   */
  public static void main(String[] args) {

  }
}
