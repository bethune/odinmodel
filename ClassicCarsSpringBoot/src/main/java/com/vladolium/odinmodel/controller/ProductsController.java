package com.vladolium.odinmodel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vladolium.odinmodel.domain.OrderDetails;
import com.vladolium.odinmodel.domain.Products;
import com.vladolium.odinmodel.service.OrderDetailsService;
import com.vladolium.odinmodel.service.ProductsService;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api/products")
public class ProductsController {

    private ProductsService productsService;

    @Autowired
    public void setProductsService(ProductsService productsService) {
	this.productsService = productsService;
    }

    @PostMapping("")
    public Products createOne(@RequestBody Products products) {
	return productsService.createUpdate(products);
    }

    @PutMapping("/{id}")
    public Products updateOneById(@PathVariable Long id, @RequestBody Products products) {
	Products current = productsService.readOneById(id);
	current.setProductLines(products.getProductLines());

	current.setBuyPrice(products.getBuyPrice());

	current.setProductCode(products.getProductCode());

	current.setProductScale(products.getProductScale());

	current.setProductDescription(products.getProductDescription());

	current.setMsrp(products.getMsrp());

	current.setProductName(products.getProductName());

	current.setProductVendor(products.getProductVendor());

	current.setQuantityInStock(products.getQuantityInStock());

	return productsService.createUpdate(current);
    }

    @PutMapping("/productCode={productCode}")
    public Products updateOneByProductCode(@PathVariable String productCode, @RequestBody Products products) {
	Products current = productsService.readOneByProductCode(productCode);
	current.setProductLines(products.getProductLines());

	current.setBuyPrice(products.getBuyPrice());

	current.setProductCode(products.getProductCode());

	current.setProductScale(products.getProductScale());

	current.setProductDescription(products.getProductDescription());

	current.setMsrp(products.getMsrp());

	current.setProductName(products.getProductName());

	current.setProductVendor(products.getProductVendor());

	current.setQuantityInStock(products.getQuantityInStock());

	return productsService.createUpdate(current);
    }

    @GetMapping("/{id}")
    public Products readOneById(@PathVariable Long id) {
	return productsService.readOneById(id);
    }

    @GetMapping("/productCode={productCode}")
    public Products readOneByProductCode(@PathVariable String productCode) {
	return productsService.readOneByProductCode(productCode);
    }

    @GetMapping("")
    public Iterable<Products> readAll() {
	return productsService.readAll();
    }

    @GetMapping("/page={pageNumber}/perPage={perPageNumber}")
    public Page<Products> readAllPagination(@PathVariable Integer pageNumber, @PathVariable Integer perPageNumber) {
	Pageable page = PageRequest.of(pageNumber, perPageNumber);
	return productsService.readAllPagination(page);
    }

    private OrderDetailsService orderDetailsService;

    @Autowired
    public void setOrderDetailsService(OrderDetailsService orderDetailsService) {
	this.orderDetailsService = orderDetailsService;
    }

    @GetMapping("/{productsId}/orderDetails")
    public Iterable<OrderDetails> readAllOrderDetailsByProductsId(@PathVariable Long productsId) {
	return orderDetailsService.readAllByProductsId(productsId);
    }

    @GetMapping("/{productsId}/orderDetails/page={pageNumber}/perPage={perPageNumber}")
    public Page<OrderDetails> readAllOrderDetailsByProductsIdPagination(@PathVariable Integer pageNumber,
	    @PathVariable Integer perPageNumber, @PathVariable Long productsId) {
	Pageable page = PageRequest.of(pageNumber, perPageNumber);
	return orderDetailsService.readAllByProductsId(productsId, page);
    }

    @GetMapping("/productCode={productsProductCode}/orderDetails")
    public Iterable<OrderDetails> readAllOrderDetailsByProductsProductCode(@PathVariable String productsProductCode) {
	return orderDetailsService.readAllByProductsProductCode(productsProductCode);
    }

    @GetMapping("/productCode={productsProductCode}/orderDetails/page={pageNumber}/perPage={perPageNumber}")
    public Page<OrderDetails> readAllOrderDetailsByProductsProductCodePagination(@PathVariable Integer pageNumber,
	    @PathVariable Integer perPageNumber, @PathVariable String productsProductCode) {
	Pageable page = PageRequest.of(pageNumber, perPageNumber);
	return orderDetailsService.readAllByProductsProductCode(productsProductCode, page);
    }

    @GetMapping("/search")
    public Iterable<Products> search(

	    @RequestParam(value = "productLinesId", required = false) Long productLinesId,

	    @RequestParam(value = "buyPrice", required = false) Double buyPrice,
	    @RequestParam(value = "productCode", required = false) String productCode,
	    @RequestParam(value = "productScale", required = false) String productScale,
	    @RequestParam(value = "productDescription", required = false) String productDescription,
	    @RequestParam(value = "msrp", required = false) Double msrp,
	    @RequestParam(value = "productName", required = false) String productName,
	    @RequestParam(value = "productVendor", required = false) String productVendor,
	    @RequestParam(value = "quantityInStock", required = false) Integer quantityInStock

    ) {
	return productsService.search(

		productLinesId,

		buyPrice, productCode, productScale, productDescription, msrp, productName, productVendor,
		quantityInStock

	);
    }

    @GetMapping("/search/page={pageNumber}/perPage={perPageNumber}")
    public Page<Products> searchPagination(@PathVariable Integer pageNumber, @PathVariable Integer perPageNumber,

	    @RequestParam(value = "productLinesId", required = false) Long productLinesId,

	    @RequestParam(value = "buyPrice", required = false) Double buyPrice,
	    @RequestParam(value = "productCode", required = false) String productCode,
	    @RequestParam(value = "productScale", required = false) String productScale,
	    @RequestParam(value = "productDescription", required = false) String productDescription,
	    @RequestParam(value = "msrp", required = false) Double msrp,
	    @RequestParam(value = "productName", required = false) String productName,
	    @RequestParam(value = "productVendor", required = false) String productVendor,
	    @RequestParam(value = "quantityInStock", required = false) Integer quantityInStock

    ) {
	Pageable page = PageRequest.of(pageNumber, perPageNumber);

	return productsService.searchPagination(page,

		productLinesId,

		buyPrice, productCode, productScale, productDescription, msrp, productName, productVendor,
		quantityInStock

	);
    }

    @DeleteMapping("/{id}")
    public void deleteOneById(@PathVariable Long id) {
	productsService.deleteOneById(id);
    }

//Code between start and end will not be removed during generation.
//Start of user code for this controller
//End of user code
}
