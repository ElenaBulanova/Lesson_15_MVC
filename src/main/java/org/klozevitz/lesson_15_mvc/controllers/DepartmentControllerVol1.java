package org.klozevitz.lesson_15_mvc.controllers;

import lombok.RequiredArgsConstructor;
import org.klozevitz.lesson_15_mvc.model.Department;
import org.klozevitz.lesson_15_mvc.services.DaoDepartment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequiredArgsConstructor
@Controller
@RequestMapping("/admin/department")
public class DepartmentController {
    private final DaoDepartment daoDepartment;

    @GetMapping
    public String departments(Model model) {
        model.addAttribute("departments", daoDepartment.findAll());
        return "departments";
    }

    @PostMapping
    public String add(String name, String note, @RequestParam(required = false) Integer parentId) {
        Department department = Department.builder()
                .name(name)
                .note(note)
                .build();
        if (parentId != null) {
            department.setParentDpt(daoDepartment.findById(parentId));
        }
        daoDepartment.save(department);
        return "redirect:/admin/department";
    }
}
