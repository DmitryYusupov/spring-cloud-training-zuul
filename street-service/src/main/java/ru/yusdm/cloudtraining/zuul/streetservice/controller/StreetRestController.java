package ru.yusdm.cloudtraining.zuul.streetservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.yusdm.cloudtraining.zuul.common.dto.StreetDTO;
import ru.yusdm.cloudtraining.zuul.streetservice.model.Street;
import ru.yusdm.cloudtraining.zuul.streetservice.service.StreetService;
import ru.yusdm.cloudtraining.zuul.streetservice.utils.DtoModelConverter;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static ru.yusdm.cloudtraining.zuul.streetservice.utils.DtoModelConverter.dtoToModel;
import static ru.yusdm.cloudtraining.zuul.streetservice.utils.DtoModelConverter.modelToDTO;

@RestController
@RequestMapping("/streets")
public class StreetRestController {

    private StreetService streetService;

    @Autowired
    public StreetRestController(StreetService streetService) {
        this.streetService = streetService;
    }

    @PutMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StreetDTO> update(@RequestBody StreetDTO streetDTO) {
        Street street = streetService.save(dtoToModel(streetDTO));
        return new ResponseEntity<>(modelToDTO(street), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteById(@PathVariable Long id) {
        streetService.deleteById(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StreetDTO> save(@RequestBody StreetDTO streetDTO) {
        Street street = streetService.save(dtoToModel(streetDTO));
        return new ResponseEntity<>(modelToDTO(street), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<StreetDTO> getById(@PathVariable Long id) {
        Street street = streetService.findById(id).orElse(null);
        return Optional.ofNullable(street).map(c -> ResponseEntity.ok().body(modelToDTO(c))).
                orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/")
    public ResponseEntity<List<StreetDTO>> findAll() {
        List<StreetDTO> streets = streetService.findAll().stream().map(DtoModelConverter::modelToDTO).collect(Collectors.toList());
        return new ResponseEntity<>(streets, HttpStatus.OK);
    }


}
