package org.example.orderproject.employee.dto;

import lombok.Data;

@Data
public class EmployeeDTO {

    // 직원번호(사번)
    private String employeeId;

    // 직원 이름
    private String name;

    // 부서
    private String department;

    // 연락처
    private String contact;

}
