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

        return saleRepository.findAll().stream().map(saleMapper::toDto).toList();

    }

    @Override
    public SaleDTO getSale(Long id) {
        return saleRepository.findById(id).map(saleMapper::toDto).orElseThrow(() -> new RuntimeException("Sale not found " + id));
    }

    @Override
    public void deleteSale(Long id) {
        saleRepository.deleteById(id);
    }

    @Override
    public SaleDTO updateSale(Long id, SaleDTO saleDTO) {

        Sale existingSale = saleRepository.findById(id).orElseThrow(() -> new RuntimeException("Sale not found " + id));
        saleMapper.updateEntityFromDto(saleDTO, existingSale);
        saleRepository.save(existingSale);
        return saleMapper.toDto(existingSale);

    }
}
