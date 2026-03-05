package com.martinc.demo.service.sale;

import com.martinc.demo.dto.SaleDTO;
import java.util.List;

public interface ISaleService{

    SaleDTO saveSale(SaleDTO saleDTO);

    List<SaleDTO> sales();

    SaleDTO getSale(Long id);

    void deleteSale(Long id);

    SaleDTO updateSale(Long id, SaleDTO saleDTO);

}
