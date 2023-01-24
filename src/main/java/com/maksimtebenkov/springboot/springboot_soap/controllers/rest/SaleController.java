package com.maksimtebenkov.springboot.springboot_soap.controllers.rest;

import com.maksimtebenkov.springboot.springboot_soap.controllers.exeption.NoSuchObjectExсeption;
import com.maksimtebenkov.springboot.springboot_soap.controllers.exeption.SaleIncorrectData;
import com.maksimtebenkov.springboot.springboot_soap.entity.Sale;
import com.maksimtebenkov.springboot.springboot_soap.services.SaleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class SaleController {
    private final SaleService saleService;

    @RequestMapping("/sale/")
    public ResponseEntity<List<Sale>> findAll() {
        return ResponseEntity.ok(saleService.findAll());
    }


    @PutMapping("/sale")
    public Sale updateSale(@RequestBody Sale sale) {
        saleService.saveSale(sale);
        return sale;
    }

    @GetMapping("/sale/{id}")
    public Sale getSale(@PathVariable int id) {
        Sale sale = saleService.getSale(id);
        if (sale == null) {
            throw new NoSuchObjectExсeption("There are no sale with id = " + id +" in Database");
        }
        return sale;
    }

    @PostMapping("/sale")
    public Sale addNewSale(@RequestBody Sale sale) {
        saleService.saveSale(sale);
        return sale;
    }


    @DeleteMapping("/sale/{id}")
    public String deleteSale(@PathVariable int id) throws NoSuchObjectExсeption {
        Sale sale = saleService.getSale(id);
        if (sale == null) {
            throw new NoSuchObjectExсeption("There are no sale with id = " + id +" in Database");
        }
        saleService.deleteSale(id);
        return "Customer with ID = " + id + " was deleted";
    }

    @ExceptionHandler
    public ResponseEntity<SaleIncorrectData> handleExeption(NoSuchObjectExсeption exception){
        SaleIncorrectData data = new SaleIncorrectData();
        data.setInfo(exception.getMessage());
        return new ResponseEntity<>(data, HttpStatus.NOT_FOUND);
    }


}
