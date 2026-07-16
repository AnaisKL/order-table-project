package org.example.orderproject.employee.controller;

import lombok.RequiredArgsConstructor;
import org.example.orderproject.employee.dto.EmployeeDTO;
import org.example.orderproject.employee.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/employees")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    // 직원 목록
    @GetMapping("/list")
    public String employeeList(Model model){
        model.addAttribute("employeeList", employeeService.employeeList());
        return "employee/list";
    }

    // 등록 화면
    @GetMapping("/write")
    public String writeForm(Model model){
        model.addAttribute("employee", new EmployeeDTO());
        return "employee/write";
    }

    // 등록
    @PostMapping("/write")
    public String employeeInsert(EmployeeDTO employee){
        try {
            employeeService.employeeInsert(employee);
        } catch (Exception e) {
            // 중복 키 에러 등이 발생했을 때 에러 페이지 대신
            // 사용자에게 경고 처리를 하거나, 여기서는 안전하게 목록으로 리다이렉트 처리합니다.
            System.out.println("등록 실패 (중복 또는 유효하지 않은 데이터): " + e.getMessage());
            return "redirect:/employees/list?error=duplicate";
        }
        // 성공 시 무조건 목록 조회 URL로 이동시킵니다.
        return "redirect:/employees/list";
    }

    // 수정 화면
    @GetMapping("/edit/{employeeId}")
    public String updateForm(@PathVariable String employeeId, Model model){
        model.addAttribute("employee", employeeService.employeeDetail(employeeId));
        return "employee/update";
    }

    // 수정
    @PostMapping("/edit")
    public String employeeUpdate(@ModelAttribute("employee") EmployeeDTO employee){
        employeeService.employeeUpdate(employee);
        return "redirect:/employees/list";
    }

    // 삭제
    @GetMapping("/delete/{employeeId}")
    public String employeeDelete(@PathVariable String employeeId){
        employeeService.employeeDelete(employeeId);
        return "redirect:/employees/list";
    }
}