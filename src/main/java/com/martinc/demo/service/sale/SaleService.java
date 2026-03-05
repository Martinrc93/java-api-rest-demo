package com.martinc.demo.service.sale;

import com.martinc.demo.dto.SaleDTO;
import com.martinc.demo.mapper.SaleMapper;
import com.martinc.demo.model.Sale;
import com.martinc.demo.repository.ISaleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SaleService implements ISaleService{

    private final ISaleRepository saleRepository;
    private final SaleMapper saleMapper;


    @Override
    public SaleDTO saveSale(SaleDTO saleDTO) {

        Sale saleEntity = saleMapper.toEntity(saleDTO);
        saleRepository.save(saleEntity);
        return saleMapper.toDto(saleEntity);

    }

    @Override
    public List<SaleDTO> sales() {
        return List.of();
    }

    @Override
    public SaleDTO getSale(Long id) {
        return null;
    }

    @Override
    public void deleteSale(Long id) {

    }

    @Override
    public SaleDTO updateSale(Long id, SaleDTO saleDTO) {
        return null;
    }
}
