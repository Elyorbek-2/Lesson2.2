package uz.pdp.lesson2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import uz.pdp.lesson2.entity.Attachment;
import uz.pdp.lesson2.result.Result;
import uz.pdp.lesson2.service.AttachmentService;

import javax.validation.Valid;
import java.util.List;

@RestController("/api/attachment")
public class AttachmentController {
    @Autowired
    AttachmentService attachmentService;
    @GetMapping
    public ResponseEntity<?> get(){
        List<Attachment> attachments = attachmentService.get();
        return ResponseEntity.ok(attachments);
    }
    @GetMapping("/{id]")
    public ResponseEntity<?> getOne(@Valid @PathVariable Integer id){
        Attachment attachment = attachmentService.getOne(id);
        return ResponseEntity.status(attachment==null?400:200).body(attachment);
    }
    @PostMapping
    public ResponseEntity<?> add(@Valid MultipartHttpServletRequest request){
        Result result = attachmentService.add(request);
        return ResponseEntity.status(result.isSucces()?200:400).body(result);
    }
    @PutMapping("/{id]")
    public ResponseEntity<?> edit(@Valid @PathVariable Integer id,MultipartHttpServletRequest request){
        Result result = attachmentService.edit(id, request);
        return ResponseEntity.status(result.isSucces()?200:400).body(result);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@Valid @PathVariable Integer id){
        Result delete = attachmentService.delete(id);
        return ResponseEntity.status(delete.isSucces()?200:400).body(delete);
    }

}
