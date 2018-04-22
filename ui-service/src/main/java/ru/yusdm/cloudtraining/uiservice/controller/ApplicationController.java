package ru.yusdm.cloudtraining.uiservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.yusdm.cloudtraining.uiservice.service.ApplicationService;
import ru.yusdm.cloudtraining.zuul.common.dto.CountryDTO;

@Controller
@RequestMapping(value = "/countries")
public class ApplicationController {

    private ApplicationService countryService;

    @Autowired
    public ApplicationController(ApplicationService countryService) {
        this.countryService = countryService;
    }

    @GetMapping
    public String getCountries(Model model) {
        model.addAttribute("countries", countryService.findAll());
        return "index :: content(page='countries', fragment='countriesFragment')";
    }

    @GetMapping("/delete/{id}")
    public String deleteCountry(@PathVariable Long id) {
        countryService.deleteById(id);
        return "redirect:/countries";
    }

    @GetMapping("/{id}")
    public String getCountryInfo(@PathVariable Long id, Model model) {
        ResponseEntity<CountryDTO> response = countryService.getById(id);
        if (HttpStatus.NOT_FOUND.equals(response.getStatusCode())) {
            model.addAttribute("error", "Not found country!");
        } else {
            model.addAttribute("country", response.getBody());
        }
        return "index :: content(page='country', fragment='countryFragment')";
    }
}
