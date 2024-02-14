package org.klozevitz.lesson_15_mvc.services;

import lombok.RequiredArgsConstructor;
import org.klozevitz.lesson_15_mvc.dao.IRepoProfession;
import org.klozevitz.lesson_15_mvc.exceptions.RecordNotFoundException;
import org.klozevitz.lesson_15_mvc.model.Department;
import org.klozevitz.lesson_15_mvc.model.Profession;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProfessionService {
    private final IRepoProfession repo;
    public List<Profession> findAll() {
        return (List<Profession>) repo.findAll();
    }

    public Profession findById(Integer id) {
        return repo.findById(id).orElseThrow(RecordNotFoundException::new);
    }

    public Profession save(Profession profession) {
        return repo.save(profession);
    }

    public Profession update(Profession profession) {
        return null;
    }

    public Profession delete(Integer id) {
        //Profession profession = findById(id);
        repo.deleteById(id);
        return null;
    }

}
