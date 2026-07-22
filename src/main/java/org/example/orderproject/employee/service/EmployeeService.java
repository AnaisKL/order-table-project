package org.example.orderproject.employee.service;

import org.example.orderproject.employee.dto.EmployeeDTO;

import java.util.List;

public interface EmployeeService {

    // 전체 직원 조회
    List<EmployeeDTO> employeeList();

    // 직원 상세 조회
    EmployeeDTO employeeDetail(String employeeId);

    // 직원 등록
    int employeeInsert(EmployeeDTO employee);

    // 직원 수정
    int employeeUpdate(EmployeeDTO employee);

    // 직원 삭제
    int employeeDelete(String employeeId);

}