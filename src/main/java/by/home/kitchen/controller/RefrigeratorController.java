package by.home.kitchen.controller;

import by.home.kitchen.domain.*;
import by.home.kitchen.service.IProductLiquidService;
import by.home.kitchen.service.IProductLooseService;
import by.home.kitchen.service.IProductPieceService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class RefrigeratorController {
    private final String LIST_OF_DISHES = "DishesList";
    private final String LIST_OF_DISHES_ADD = "DishesAddList";
    private final String LIST_OF_DISHES_EDIT = "DishesEditList";
    private final IProductLiquidService iProductLiquidService;
    private final IProductLooseService iProductLooseService;
    private final IProductPieceService iProductPieceService;


    @GetMapping("/dishes")
    public String getListOfDishes(Model model) {
        List<ProductLiquidDto> productLiquids = iProductLiquidService.findAll();
        List<ProductLooseDto> productLooses =  iProductLooseService.findAll();
        List<ProductPieceDto> productPieces =  iProductPieceService.findAll();
        model.addAttribute("productLiquids", productLiquids);
        model.addAttribute("productLooses", productLooses);
        model.addAttribute("productPieces", productPieces);
        return LIST_OF_DISHES;
    }
//
//    @GetMapping("/dishesAdd")
//    public String setDishes() {
//        return LIST_OF_DISHES_ADD;
//    }
//
//    @PostMapping("/dishesAdd")
//    public String setSaveDishes(@Valid ProductDto productDto, BindingResult bindingResult) {
//        if (bindingResult.hasErrors()) {
//            return LIST_OF_DISHES_ADD;
//        }
////      Product product =   iProductService.save(conversionService.convert(productDto, Product.class));
//        iProductService.save(productDto);
//        return LIST_OF_DISHES;
//    }
//
//    @PostMapping("/edit/dishes/{id}")
//    public String editDishes(@PathVariable("id") Integer id, Model model) {
//        model.addAttribute("product", iProductService.getAllProductDtoById(id));
//        return LIST_OF_DISHES_EDIT;
//    }
//
//    @PostMapping("/save/dishes/{id}/")
//    public String saveDishes(@PathVariable("id") Integer id, @Valid ProductDto productDto,
//                             BindingResult bindingResult, Model model) {
//        if (bindingResult.hasErrors()) {
//            model.addAttribute("product", iProductService.getAllProductDtoById(id));
//            return LIST_OF_DISHES_EDIT;
//        }
//        iProductService.editProduct(productDto, id);
//        return "redirect:/dishes";
//    }
}
