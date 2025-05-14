package net.starbasic.am.dic;

import net.starbasic.am.dic.data.*;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class TermController {
    private final TermService service;

    public TermController(TermService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String index(@RequestParam(required = false) String q, Model model) {
        model.addAttribute("terms", q == null ? service.getAllTerms() : service.search(q));
        return "index";
    }

    @GetMapping("/add")
    public String addForm(Model model) {
        model.addAttribute("termin", new Term());
        return "add";
    }

    @PostMapping("/add")
    public String addTerm(@ModelAttribute("termin") Term termin) {
        service.addTerm(termin);
        return "redirect:/";
    }
}
