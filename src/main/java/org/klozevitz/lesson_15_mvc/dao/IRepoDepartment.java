package org.klozevitz.lesson_15_mvc.dao.department;

import org.klozevitz.lesson_15_mvc.model.Department;
import org.springframework.data.repository.CrudRepository;

public interface IRepoDepartment extends CrudRepository<Department, Integer> {
}