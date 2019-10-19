package com.vladolium.odinmodel.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.querydsl.core.BooleanBuilder;
import com.vladolium.odinmodel.domain.Products;
import com.vladolium.odinmodel.domain.QProducts;
import com.vladolium.odinmodel.repository.ProductsRepository;
import com.vladolium.odinmodel.service.ProductsService;

@Service
@Transactional
public class ProductsServiceImpl implements ProductsService {

    private ProductsRepository productsRepository;

    @Autowired
    public void setProductsRepository(ProductsRepository productsRepository) {
	this.productsRepository = productsRepository;
    }

    // covers create & update
    @Override
    public Products createUpdate(Products products) {
	return productsRepository.save(products);
    }

    @Override
    public Products readOneById(Long id) {
	return productsRepository.getOne(id);
    }

    @Override
    public Products readOneByProductCode(String productCode) {
	return productsRepository.findByProductCodeEquals(productCode);
    }

    @Override
    public Iterable<Products> readAll() {
	return productsRepository.findAll();
    }

    @Override
    public Page<Products> readAllPagination(Pageable page) {
	return productsRepository.findAll(page);
    }

    @Override
    public Iterable<Products> readAllByProductLinesId(Long productLinesId) {
	return productsRepository.findByProductLinesIdEquals(productLinesId);
    }

    @Override
    public Page<Products> readAllByProductLinesId(Long productLinesId, Pageable page) {
	return productsRepository.findByProductLinesIdEquals(productLinesId, page);
    }

    @Override
    public Iterable<Products> search(

	    Long productLinesId, String productVendor, Double msrp, String productName, String productScale,
	    String productDescription, Integer quantityInStock, String productCode, Double buyPrice

    ) {
	BooleanBuilder where = dynamicWhere(

		productLinesId, productVendor, msrp, productName, productScale, productDescription, quantityInStock,
		productCode, buyPrice

	);
	return productsRepository.findAll(where);
    }

    @Override
    public Page<Products> searchPagination(Pageable page,

	    Long productLinesId, String productVendor, Double msrp, String productName, String productScale,
	    String productDescription, Integer quantityInStock, String productCode, Double buyPrice

    ) {
	BooleanBuilder where = dynamicWhere(

		productLinesId, productVendor, msrp, productName, productScale, productDescription, quantityInStock,
		productCode, buyPrice

	);
	return productsRepository.findAll(where, page);
    }

    public BooleanBuilder dynamicWhere(

	    Long productLinesId, String productVendor, Double msrp, String productName, String productScale,
	    String productDescription, Integer quantityInStock, String productCode, Double buyPrice

    ) {
	QProducts qProducts = QProducts.products;

	BooleanBuilder where = new BooleanBuilder();

	if (productLinesId != null) {
	    where.and(qProducts.productLines.id.eq(productLinesId));
	}
	if (productVendor != null) {
	    where.and(qProducts.productVendor.containsIgnoreCase(productVendor));
	}
	if (msrp != null) {
	    where.and(qProducts.msrp.eq(msrp));
	}
	if (productName != null) {
	    where.and(qProducts.productName.containsIgnoreCase(productName));
	}
	if (productScale != null) {
	    where.and(qProducts.productScale.containsIgnoreCase(productScale));
	}
	if (productDescription != null) {
	    where.and(qProducts.productDescription.eq(productDescription));
	}
	if (quantityInStock != null) {
	    where.and(qProducts.quantityInStock.eq(quantityInStock));
	}
	if (productCode != null) {
	    where.and(qProducts.productCode.containsIgnoreCase(productCode));
	}
	if (buyPrice != null) {
	    where.and(qProducts.buyPrice.eq(buyPrice));
	}

	return where;
    }

    @Override
    public void deleteOneById(Long id) {
	Products currentProducts = productsRepository.getOne(id);
	Iterable<Products> listOfProducts = productsRepository
		.findByProductLinesIdEquals(currentProducts.getProductLines().getId());
	Long size = listOfProducts.spliterator().getExactSizeIfKnown();
	if (size == 1) {
	    return;
	} else {
	    productsRepository.deleteById(id);
	}
    }

//Code between start and end will not be removed during generation.
//Start of user code for this serviceImpl
//End of user code
}
