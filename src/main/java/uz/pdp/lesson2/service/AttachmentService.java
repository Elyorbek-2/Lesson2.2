package uz.pdp.lesson2.service;

import com.sun.deploy.net.HttpResponse;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import uz.pdp.lesson2.entity.Attachment;
import uz.pdp.lesson2.entity.AttachmentContent;
import uz.pdp.lesson2.repository.AttachmentRepository;
import uz.pdp.lesson2.result.Result;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class AttachmentService {
    @Autowired
    AttachmentRepository attachmentRepository;
    public List<Attachment> get(){
        return attachmentRepository.findAll();
    }
    public Attachment getOne(Integer id){
        Optional<Attachment> optionalAttachment = attachmentRepository.findById(id);
        return optionalAttachment.orElse(null);
    }
    @SneakyThrows
    public Result add(MultipartHttpServletRequest request){
        Iterator<String> fileNames = request.getFileNames();
        MultipartFile file = request.getFile(fileNames.next());
        Attachment attachment1=new Attachment();
        assert file != null;
        attachment1.setContentType(file.getContentType());
        attachment1.setFileOriginalName(file.getOriginalFilename());
        attachment1.setSize(file.getSize());
        AttachmentContent attachmentContent=new AttachmentContent();
        attachmentContent.setBytes(file.getBytes());
        attachmentContent.setAttachment(attachment1);
        attachmentRepository.save(attachment1);
        return new Result("Bajarildi",true);
    }
    @SneakyThrows
    public Result edit(Integer id,MultipartHttpServletRequest request){
        Iterator<String> fileNames = request.getFileNames();
        MultipartFile file = request.getFile(fileNames.next());
        Optional<Attachment> optionalAttachment = attachmentRepository.findById(id);
        if (!optionalAttachment.isPresent())
            return new Result("Bunday id li attachment mavjud emas",false);
        Attachment attachment = optionalAttachment.get();
        assert file != null;
        attachment.setContentType(file.getContentType());
        attachment.setFileOriginalName(file.getOriginalFilename());
        attachment.setSize(file.getSize());
        AttachmentContent attachmentContent=new AttachmentContent();
        attachmentContent.setBytes(file.getBytes());
        attachmentContent.setAttachment(attachment);
        attachmentRepository.save(attachment);
        return new Result("Bajarildi",true);
    }
    public Result delete(Integer id){
        try {
            attachmentRepository.deleteById(id);
            return new Result("Bajarildi",true);
        } catch (Exception e) {
            return new Result("Bajarilmadi",false);
        }
    }
}
