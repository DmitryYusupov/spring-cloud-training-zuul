package ru.yusdm.cloudtraining.uiservice.country;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.yusdm.cloudtraining.uiservice.country.service.CountryService;
import ru.yusdm.cloudtraining.zuul.common.dto.CountryDTO;

import java.util.ArrayList;

@Controller
@RequestMapping(value = "countries")
public class CountryController {

    private CountryService countryService;

    @Autowired
    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping
    public String getCountries(Model model) {
        model.addAttribute("countries", countryService.findAll());
        return "index :: content(page='countries', fragment='countriesPage')";
    }

    @PostMapping
    public String addCountry(Model model) {
        return "";
    }

    @GetMapping("/delete/{id}")
    public String deleteCountry(@PathVariable Long id) {
        countryService.deleteById(id);
        return "redirect:/countries";
    }


}
