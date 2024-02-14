package org.klozevitz.lesson_15_mvc.services;

import lombok.RequiredArgsConstructor;
import org.klozevitz.lesson_15_mvc.dao.IRepoDepartment;
import org.klozevitz.lesson_15_mvc.exceptions.RecordNotFoundException;
import org.klozevitz.lesson_15_mvc.model.Department;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DaoDepartment {
    private final IRepoDepartment repo;

    public List<Department> findAll() {
        return (List<Department>) repo.findAll();
    }

    public Department findById(Integer id) {
        return repo.findById(id).orElseThrow(RecordNotFoundException::new);
    }

    public Department save(Department department) {
        return repo.save(department);
    }

    public Department update(Department department) {
        return null;
    }

    public Department delete(Integer id) {
        return null;
    }
}
