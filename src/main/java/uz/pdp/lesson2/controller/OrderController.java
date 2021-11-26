package uz.pdp.lesson2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.pdp.lesson2.entity.Order;
import uz.pdp.lesson2.payload.OrderDto;
import uz.pdp.lesson2.result.Result;
import uz.pdp.lesson2.service.OrderService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/order")
public class OrderController {
    @Autowired
    OrderService orderService;

    @GetMapping
    public ResponseEntity<?> get() {
        return ResponseEntity.ok(orderService.get());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOne(@Valid @PathVariable Integer id){
        Order order = orderService.getOne(id);
        return ResponseEntity.status(order==null?400:200).body(order);
    }
    @PostMapping
    public ResponseEntity<?>add(@Valid @RequestBody OrderDto orderDto){
        Result result = orderService.add(orderDto);
        return ResponseEntity.status(result.isSucces()?200:400).body(result);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> edit(@Valid @PathVariable Integer id,@RequestBody OrderDto orderDto){
        Result result = orderService.edit(id, orderDto);
        return ResponseEntity.status(result.isSucces()?200:400).body(result);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@Valid @PathVariable Integer id){
        Result result = orderService.delete(id);
        return ResponseEntity.status(result.isSucces()?200:400).body(result);
    }
}
