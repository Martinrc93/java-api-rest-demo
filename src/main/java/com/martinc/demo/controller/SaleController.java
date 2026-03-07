package com.martinc.demo.controller;

import com.martinc.demo.dto.SaleDTO;
import com.martinc.demo.service.sale.ISaleService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sales")
@AllArgsConstructor
public class SaleController {

    private  final ISaleService saleService;

    @GetMapping("/id")
    public SaleDTO getSale(@PathVariable Long id){
        return saleService.getSale(id);
    }

    @GetMapping("/list")
    public List<SaleDTO> listSale(){
        return saleService.sales();
    }

    @PostMapping("/create")
    public SaleDTO createSale(@RequestBody SaleDTO saleDTO){
        return saleService.saveSale(saleDTO);
    }

    @PutMapping("/update/")
    public SaleDTO updateSale(@RequestBody Long id, @RequestBody SaleDTO saleDTO){
        return saleService.updateSale(id, saleDTO);
    }

    @DeleteMapping("/delete/")
    public void deleteSale(@RequestBody Long id){
        saleService.deleteSale(id);
    }

}
