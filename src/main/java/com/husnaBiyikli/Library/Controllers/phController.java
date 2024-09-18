package com.husnaBiyikli.Library.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import com.husnaBiyikli.Library.Entitys.publishingHouses;
import com.husnaBiyikli.Library.Services.publishingHouseService;

import jakarta.validation.Valid;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/houses")
public class phController {

    @Autowired
    private publishingHouseService publishingHouseService;

    public phController(publishingHouseService publishingHouseService) {
        this.publishingHouseService = publishingHouseService;
    }

    @GetMapping("/gethouse")
    public String getAll(Model model) {
        model.addAttribute("phs", publishingHouseService.getAllHouses());
        return "publishinghouses";
    }

    @GetMapping("/addhouse")
    public String addHouse(Model model, publishingHouses house) {
        model.addAttribute("newHouse", house);
        return "addHouse";
    }

    @PostMapping("/savehouse")
    public String saveHouse(@Valid @ModelAttribute("newHouse") publishingHouses house, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "addHouse";
        } else {
            publishingHouseService.saveHouse(house);
            return "redirect:/houses/gethouse";
        }
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable Long id, Model model) {
        model.addAttribute("updatePH", publishingHouseService.getHouseById(id));
        return "updateHouse";
    }

    @PostMapping("/updateHouse")
    public String updateHouse(@ModelAttribute("updatePH") publishingHouses ph, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "updateHouse";
        } else {
            publishingHouseService.saveHouse(ph);
            return "redirect:/houses/gethouse";
        }
    }
}
