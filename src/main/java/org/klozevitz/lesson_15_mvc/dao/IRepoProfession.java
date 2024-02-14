package org.klozevitz.lesson_15_mvc.dao;


import org.klozevitz.lesson_15_mvc.model.Profession;
import org.springframework.data.repository.CrudRepository;

public interface IRepoProfession extends CrudRepository<Profession, Integer> {
}
