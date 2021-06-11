package com.example.demo.controller;

import com.example.demo.model.Kommune;
import com.example.demo.model.Sogn;
import com.example.demo.service.KommuneService;
import com.example.demo.service.SognService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class KommuneController {

    @Autowired
    private KommuneService kommuneService;

    @Autowired
    private SognService sognService;

    //Display list of kommuner
    @GetMapping("/")
    public String index(Model model, Model model1) {
      model.addAttribute("kommuneliste", kommuneService.getAllKommuner());
      model.addAttribute("sognliste", sognService.getAllSogn());
      return "index";
    }

    /*
    @RequestMapping(value = "ny_kommune", method = RequestMethod.GET)
    public String showNewKommuneForm(Model model) {
        Kommune kommune = new Kommune();
        model.addAttribute("Kommune",kommune);
        return "ny_kommune";
    }
     */

    @GetMapping("/showNewKommuneForm")
    public String showNewKommuneForm(Model model) {
        Kommune kommune = new Kommune();
        model.addAttribute("Kommune",kommune);
        return "ny_kommune";
    }



    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable (value = "id") long id, Model model) {
        // Get Sogn from the service
        Sogn sogn = sognService.getSognById(id);

        // Set Sogn as a model attribute
        model.addAttribute("sogn", sogn);
        return "update_sogn";
    }

    @GetMapping("/showNewSognForm")
    public String showNewSognForm(Model model) {
        Sogn sogn = new Sogn();
        model.addAttribute("sogn",sogn);
        return "ny_sogn";
    }

    @GetMapping("/deleteSogn/{id}")
    public String deleteSogn(@PathVariable (value = "id") long id) {
        // Call delete Sogn method
        this.sognService.deleteSognById(id);
        return "redirect:/";
    }

    @GetMapping("/deleteKommune/{id}")
    public String deleteKommunde(@PathVariable (value = "id") long id) {
        // Call delete Sogn method
        this.kommuneService.deleteKommuneById(id);
        return "redirect:/";
    }


    @PostMapping("/saveKommune")
    public String SaveKommune(@ModelAttribute("kommune") Kommune kommune){
        // Gem Kommune til database
        kommuneService.saveKommune(kommune);
        return "redirect:/";
    }

    @PostMapping("/saveSogn")
    public String SaveSogn(@ModelAttribute("sogn") Sogn sogn){
        // Gem Kommune til database
        sognService.saveSogn(sogn);
        return "redirect:/";
    }

}
