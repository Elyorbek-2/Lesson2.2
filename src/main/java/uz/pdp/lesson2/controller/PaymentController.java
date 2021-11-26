package uz.pdp.lesson2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.pdp.lesson2.entity.Payment;
import uz.pdp.lesson2.payload.PaymentDto;
import uz.pdp.lesson2.result.Result;
import uz.pdp.lesson2.service.PaymentService;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/payment")
public class PaymentController {
    @Autowired
    PaymentService paymentService;

    @GetMapping
    public ResponseEntity<?> get(){
        return ResponseEntity.ok(paymentService.get());
    }
    @GetMapping("/{id}")
    public ResponseEntity<?>getOne(@Valid @PathVariable Integer id){
        Payment payment = paymentService.getOne(id);
        return ResponseEntity.status(payment==null?400:200).body(payment);
    }
    @PostMapping
    public ResponseEntity<?> add(@Valid @RequestBody PaymentDto paymentDto){
        Result result = paymentService.add(paymentDto);
        return ResponseEntity.status(result.isSucces()?200:400).body(result);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?>edit(@Valid @PathVariable Integer id,@RequestBody PaymentDto paymentDto){
        Result result = paymentService.edit(id, paymentDto);
        return ResponseEntity.status(result.isSucces()?200:400).body(result);
    }
    @DeleteMapping("/{id]")
    public ResponseEntity<?> delete(@Valid @PathVariable Integer id){
        Result result = paymentService.delete(id);
        return ResponseEntity.status(result.isSucces()?200:400).body(result);
    }
}
