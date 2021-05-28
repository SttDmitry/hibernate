package com.geekbrains.Controllers;

import com.geekbrains.Services.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/product")
public class ProductController {
    private ProductsService productsService;

    @Autowired
    public void setProductsService(ProductsService productsService) {
        this.productsService = productsService;
    }

    @RequestMapping("/showAllProducts")
    public String showAllProducts(Model uiModel) {
        uiModel.addAttribute("productsList", productsService.getProducts());
        uiModel.addAttribute("maxPriced", productsService.findProductsWithMaxPrice());
        uiModel.addAttribute("lowPriced", productsService.findProductsWithMinPrice());
        return "products";
    }

}
