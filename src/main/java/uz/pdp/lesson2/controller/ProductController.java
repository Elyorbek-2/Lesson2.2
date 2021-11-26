package uz.pdp.lesson2.controller;

import org.aspectj.weaver.ResolvedPointcutDefinition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.pdp.lesson2.entity.Product;
import uz.pdp.lesson2.payload.ProductDto;
import uz.pdp.lesson2.result.Result;
import uz.pdp.lesson2.service.ProductService;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/product")
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping
    public ResponseEntity<?> get(){
        return ResponseEntity.ok(productService.get());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOne(@Valid @PathVariable Integer id){
        Product product = productService.getOne(id);
        return ResponseEntity.status(product==null?400:200).body(product);
    }

    @PostMapping
    public ResponseEntity<?> add(@Valid @RequestBody ProductDto productDto){
        Result result = productService.add(productDto);
        return ResponseEntity.status(result.isSucces()?200:400).body(result);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> edit(@Valid @PathVariable Integer id,@RequestBody ProductDto productDto){
        Result result = productService.edit(id, productDto);
        return ResponseEntity.status(result.isSucces()?200:400).body(result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@Valid @PathVariable Integer id){
        Result result = productService.delete(id);
        return ResponseEntity.status(result.isSucces()?200:400).body(result);
    }
}
