package com.martinc.demo.service.sale;

import com.martinc.demo.dto.SaleDTO;
import com.martinc.demo.dto.SaleDetailDTO;
import com.martinc.demo.mapper.SaleMapper;
import com.martinc.demo.model.Product;
import com.martinc.demo.model.Sale;
import com.martinc.demo.model.SaleDetail;
import com.martinc.demo.repository.ISaleRepository;
import com.martinc.demo.service.product.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SaleService implements ISaleService {

    private final ISaleRepository saleRepository;
    private final ProductService productService;
    private final SaleMapper saleMapper;

    @Override
    @Transactional
    public SaleDTO saveSale(SaleDTO saleDTO) {

        Sale saleEntity = saleMapper.toEntity(saleDTO);

        BigDecimal total = new BigDecimal(0);

        if (saleEntity.getSaleDetails() != null) {
            for (SaleDetail detail : saleEntity.getSaleDetails()) {

                productService.discountStockById(detail.getProduct().getId(), detail.getAmount());

                Long productId = detail.getProduct().getId();
                    Product realProduct = productService.getProductEntity(productId);

                    detail.setProduct(realProduct);
                    detail.setPrice(realProduct.getPrice());
                    detail.setSale(saleEntity);
                    total = total.add(detail.getPrice().multiply(new BigDecimal(detail.getAmount())));


            }
        }

        saleEntity.setTotal(total);
        Sale savedSale = saleRepository.save(saleEntity);
        return saleMapper.toDto(savedSale);

    }

    @Override
    public List<SaleDTO> sales() {
        return saleRepository.findAll().stream().map(saleMapper::toDto).toList();
    }

    @Override
    public SaleDTO getSale(Long id) {
        return saleRepository.findById(id)
                .map(saleMapper::toDto)
                .orElseThrow(() -> new RuntimeException("Sale not found " + id));
    }

    @Override
    public void deleteSale(Long id) {
        saleRepository.deleteById(id);
    }

    @Override
    @Transactional
    public SaleDTO updateSale(Long id, SaleDTO saleDTO) {
        Sale existingSale = saleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Sale not found " + id));

        saleMapper.updateEntityFromDto(saleDTO, existingSale);

        saleRepository.save(existingSale);
        return saleMapper.toDto(existingSale);
    }

    @Override
    public SaleDetailDTO saleDetail(Long id) {
        return null;
    }

    @Override
    public List<SaleDTO> saleDate(LocalDate date) {
        return saleRepository.findBySaleDate(date).stream().map(saleMapper::toDto).toList();
    }
}
