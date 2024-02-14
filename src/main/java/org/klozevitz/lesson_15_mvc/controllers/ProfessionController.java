package org.klozevitz.lesson_15_mvc.controllers;

import lombok.RequiredArgsConstructor;
import org.klozevitz.lesson_15_mvc.model.Profession;
import org.klozevitz.lesson_15_mvc.services.ProfessionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin/profession")
public class ProfessionController {
    private final ProfessionService profService;

    private void generateProfessions() {
        profService.save(new Profession("Руководитель отдела", "Руководитель отдела"));
        profService.save(new Profession("Старший бухгалтер", "Старший бухгалтер"));
        profService.save(new Profession("Бухгалтер" , "Бухгалтер"));
        profService.save(new Profession("Frontend-разработчик", "Frontend-разработчик"));
        profService.save(new Profession("Backend-программист", "Backend-программист"));
        profService.save(new Profession("Тестировщик", "Тестировщик"));
        profService.save(new Profession("Маркетолог", "Маркетолог"));
        profService.save(new Profession("Web-дизайнер", "Web-дизайнер"));
        profService.save(new Profession("Диспетчер call-центра", "Диспетчер call-центра"));
        profService.save(new Profession("Мененджер по продажам", "Мененджер по продажам"));
        profService.save(new Profession("Офис-мененджер", "Офис-мененджер"));
    }
    @GetMapping
    public String professions(Model model) {
//        generateProfessions();
        Profession prof = new Profession();
        model.addAttribute("profession", prof);
        model.addAttribute("professions", profService.findAll());
        return "professions";
    }
    @GetMapping("/{id}")
    public String getEditPage(Model model, @PathVariable String id) {
        model.addAttribute("profession", profService.findById(Integer.parseInt(id)));
        model.addAttribute("professions", profService.findAll());
        return "professions";
    }
    @PostMapping
    public String add(Profession profession) {
        profService.save(profession);
        return "redirect:/admin/profession";
    }
    @PostMapping("/{id}" )
    public String update(Profession profession) {
        //System.out.println(model.);
        System.out.println("profession = " + profession);
        Profession profToUpdate = profService.findById(profession.getId());
        update(profToUpdate, profession);
        profService.save(profToUpdate);
        return "redirect:/admin/profession";
    }

    private void update(Profession pDb, Profession pUpdated) {
        pDb.setName(pUpdated.getName());
        pDb.setNote(pUpdated.getNote());
    }

    @GetMapping("/delete/{id}")
    public String getEditPageAfterDelete(Model model, @PathVariable String id) {
        Profession profToDelete = profService.findById(Integer.parseInt(id));
//        System.out.println("profToDelete = " + profToDelete);
        profService.delete(profToDelete.getId());
        Profession prof = new Profession();
        model.addAttribute("profession", prof);
        model.addAttribute("professions", profService.findAll());

        return "professions";
    }



}
