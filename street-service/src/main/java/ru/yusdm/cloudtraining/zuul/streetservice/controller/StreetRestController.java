package ru.yusdm.cloudtraining.zuul.streetservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.yusdm.cloudtraining.zuul.common.dto.StreetDTO;
import ru.yusdm.cloudtraining.zuul.streetservice.model.Street;
import ru.yusdm.cloudtraining.zuul.streetservice.service.StreetLocalService;
import ru.yusdm.cloudtraining.zuul.streetservice.utils.DtoModelConverter;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.springframework.http.HttpStatus.OK;
import static ru.yusdm.cloudtraining.zuul.streetservice.utils.DtoModelConverter.dtoToModel;
import static ru.yusdm.cloudtraining.zuul.streetservice.utils.DtoModelConverter.modelToDTO;

@RestController
@RequestMapping("/streets")
public class StreetRestController {

    private StreetLocalService streetService;

    @Autowired
    public StreetRestController(StreetLocalService streetService) {
        this.streetService = streetService;
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StreetDTO> update(@RequestBody StreetDTO streetDTO) {
        Street street = streetService.save(dtoToModel(streetDTO));
        return new ResponseEntity<>(modelToDTO(street), OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteById(@PathVariable long id) {
        streetService.deleteById(id);
        return new ResponseEntity(OK);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StreetDTO> save(@RequestBody StreetDTO streetDTO) {
        Street street = streetService.save(dtoToModel(streetDTO));
        return new ResponseEntity<>(modelToDTO(street), OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StreetDTO> getById(@PathVariable long id) {
        Optional<Street> street = streetService.findById(id);
        return street.map(c -> ResponseEntity.ok().body(modelToDTO(c))).
                orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/query")
    public ResponseEntity<List<StreetDTO>> find(@RequestParam("city_id") Long cityId) {
        if (cityId != null) {
            List<StreetDTO> streets = streetService.findAllByCityId(cityId)
                    .stream().map(DtoModelConverter::modelToDTO).collect(Collectors.toList());
            return new ResponseEntity<>(streets, OK);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/deletebycityid")
    public ResponseEntity deleteByCountryId(@RequestParam("city_id") long cityId) {
        streetService.deleteByCityId(cityId);
        return new ResponseEntity(OK);
    }


}
