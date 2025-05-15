package net.starbasic.am.dic;

import net.starbasic.am.dic.data.*;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/terms")
public class TermController {
    private final TermService service;

    public TermController(TermService service) {
        this.service = service;
    }

    // Головна сторінка (список)
    @GetMapping("/")
    public String list(Model model) {
        model.addAttribute("terms", service.getAllTerms());
        return "terms/list";
    }

    // Перегляд терміна
    @GetMapping("/{id}")
    public String view(@PathVariable Long id, Model model) {
        Term termDef = service.getTermById(id);
        model.addAttribute("termDef", termDef);
        return "terms/view";
    }

    // Створення
    @GetMapping("/add")
    public String addForm(Model model) {
        model.addAttribute("termDef", new Term());
        return "terms/add";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute("termDef") Term termDef) {
        service.addTerm(termDef);
        return "redirect:/terms/";
    }

    // Редагування
    @GetMapping("/{id}/edit")
    public String editForm(@PathVariable Long id, Model model) {
        model.addAttribute("termDef", service.getTermById(id));
        return "terms/edit";
    }

    @PostMapping("/{id}/edit")
    public String update(@PathVariable Long id, @ModelAttribute("termDef") Term updatedTerm) {
        Term existing = service.getTermById(id);
        existing.setTerm(updatedTerm.getTerm());
        existing.setDefinition(updatedTerm.getDefinition());
        service.addTerm(existing);
        return "redirect:/terms/";
    }

    // Видалення
    @GetMapping("/{id}/delete")
    public String deleteConfirm(@PathVariable Long id, Model model) {
        model.addAttribute("termDef", service.getTermById(id));
        return "terms/delete";
    }

    @PostMapping("/{id}/delete")
    public String delete(@PathVariable Long id) {
        service.deleteById(id);
        return "redirect:/terms/";
    }
}

