package org.example.orderproject.employee.service;

import lombok.RequiredArgsConstructor;
import org.example.orderproject.employee.dto.EmployeeDTO;
import org.example.orderproject.employee.mapper.EmployeeMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeMapper employeeMapper;

    @Override
    public List<EmployeeDTO> employeeList() {
        return employeeMapper.employeeList();
    }

    @Override
    public EmployeeDTO employeeDetail(String employeeId) {
        return employeeMapper.employeeDetail(employeeId);
    }

    @Override
    public int employeeInsert(EmployeeDTO employee) {
        return employeeMapper.employeeInsert(employee);
    }

    @Override
    public int employeeUpdate(EmployeeDTO employee) {
        return employeeMapper.employeeUpdate(employee);
    }

    @Override
    public int employeeDelete(String employeeId) {
        return employeeMapper.employeeDelete(employeeId);
    }
}