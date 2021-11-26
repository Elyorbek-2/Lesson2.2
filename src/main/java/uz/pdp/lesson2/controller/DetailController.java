package uz.pdp.lesson2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.pdp.lesson2.entity.Detail;
import uz.pdp.lesson2.payload.DetailDto;
import uz.pdp.lesson2.result.Result;
import uz.pdp.lesson2.service.DetailService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/detail")
public class DetailController {
    @Autowired
    DetailService detailService;
    @GetMapping
    public ResponseEntity<?> get(){
        List<Detail> detailList = detailService.get();
        return ResponseEntity.ok(detailList);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?>getOne(@Valid @PathVariable Integer id){
        Detail detail = detailService.getOne(id);
        return ResponseEntity.status(detail==null?400:200).body(detail);
    }
    @PostMapping
    public ResponseEntity<?> add(@Valid @RequestBody DetailDto detailDto){
        Result add = detailService.add(detailDto);
        return ResponseEntity.status(add.isSucces()?200:400).body(add);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?>edit(@Valid @PathVariable Integer id,DetailDto detailDto){
        Result edit = detailService.edit(id, detailDto);
        return ResponseEntity.status(edit.isSucces()?200:400).body(edit);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?>delete(@Valid @PathVariable Integer id){
        Result delete = detailService.delete(id);
        return ResponseEntity.status(delete.isSucces()?200:400).body(delete);
    }
}

