package ru.yusdm.cloudtraining.uiservice.country;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("countries")
public class CountryController {

    private CountryFeignClient countryFeignClient;

    @Autowired
    public CountryController(CountryFeignClient countryFeignClient) {
    }

    @GetMapping("/")
    public String getCountries(Model model) {
        return "";
    }

    @PostMapping("/")
    public String addCountry(Model model){
        return "";
    }

    @PutMapping("/")
    public String updateCountry(Model model){
        return "";
    }

    @DeleteMapping("/{id}")
    public String deleteCountry(@PathVariable Long id){
        return "";
    }



}
