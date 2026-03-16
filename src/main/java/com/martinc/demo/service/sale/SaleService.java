package com.martinc.demo.service.sale;

import com.martinc.demo.dto.ProductDTO;
import com.martinc.demo.dto.SaleDTO;
import com.martinc.demo.dto.SaleDetailDTO;
import com.martinc.demo.mapper.SaleMapper;
import com.martinc.demo.model.Product;
import com.martinc.demo.model.Sale;
import com.martinc.demo.model.SaleDetail;
import com.martinc.demo.repository.IProductRepository;
import com.martinc.demo.repository.ISaleRepository;
import com.martinc.demo.service.product.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SaleService implements ISaleService {

    private final ISaleRepository saleRepository;
    private final SaleMapper saleMapper;
    private final ProductService productService;


    @Override
    @Transactional
    public SaleDTO saveSale(SaleDTO saleDTO) {
        
        Sale saleEntity = saleMapper.toEntity(saleDTO);
/*
        if (saleEntity.getSaleDetails() != null) {
            for (SaleDetail detail : saleEntity.getSaleDetails()) {
                if (detail.getProduct() != null && detail.getProduct().getId() != null) {
                    Product productFromDb = productRepository.findById(detail.getProduct().getId())
                            .orElseThrow(() -> new RuntimeException("Product not found with id: " + detail.getProduct().getId()));
                    
                    detail.setProduct(productFromDb);
                    detail.setPrice(productFromDb.getPrice());
                }
                detail.setSale(saleEntity);
            }
        }
*/

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

        if (existingSale.getSaleDetails() != null) {
            for (SaleDetail detail : existingSale.getSaleDetails()) {
                 if (detail.getPrice() == null && detail.getProduct() != null && detail.getProduct().getId() != null) {
                      ProductDTO productFromDb = productService.getProduct(detail.getProduct().getId());

                      detail.setPrice(productFromDb.price());
                 }
                 detail.setSale(existingSale);
            }
        }

        saleRepository.save(existingSale);
        return saleMapper.toDto(existingSale);
    }

    @Override
    public SaleDetailDTO saleDetail(Long id) {
        return null;
    }
}
