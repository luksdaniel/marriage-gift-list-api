package com.lucasbatista.projects.controller;

import com.lucasbatista.projects.entity.Gift;
import com.lucasbatista.projects.exceptions.EntityValidationExceptionHandler;
import com.lucasbatista.projects.service.GiftService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"/gift"})
public class GiftController extends EntityValidationExceptionHandler {
    private final GiftService giftService;

    @Autowired
    public GiftController(GiftService giftService) {
        this.giftService = giftService;
    }

    @GetMapping
    public ResponseEntity<List<Gift>> getAll() {
        return new ResponseEntity<>(this.giftService.getAll(), HttpStatus.OK);
    }

    @GetMapping({"/{id}"})
    public ResponseEntity<Gift> getById(@PathVariable("id") String id) {
        return new ResponseEntity<>(this.giftService.getById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Gift> save(@RequestBody @Valid Gift gift) {
        return new ResponseEntity<>(this.giftService.save(gift), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Gift> update(@RequestBody @Valid Gift gift) {
        return new ResponseEntity<>(this.giftService.update(gift), HttpStatus.OK);
    }

    @PatchMapping({"/buy/{id}"})
    public ResponseEntity<Gift> buy(@PathVariable("id") String id) {
        return new ResponseEntity<>(this.giftService.buy(id), HttpStatus.OK);
    }

    @PatchMapping({"/cancel-buy/{id}"})
    public ResponseEntity<Gift> cancelBuy(@PathVariable("id") String id) {
        return new ResponseEntity<>(this.giftService.cancelBuy(id), HttpStatus.OK);
    }
}
