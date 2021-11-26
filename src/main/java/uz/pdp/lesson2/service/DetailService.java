package uz.pdp.lesson2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.lesson2.entity.Detail;
import uz.pdp.lesson2.entity.Measurement;
import uz.pdp.lesson2.payload.DetailDto;
import uz.pdp.lesson2.repository.DetailRepository;
import uz.pdp.lesson2.repository.MeasurementRepository;
import uz.pdp.lesson2.result.Result;

import java.util.List;
import java.util.Optional;

@Service
public class DetailService {
    @Autowired
    DetailRepository detailRepository;
    MeasurementRepository measurementRepository;
    public List<Detail> get(){
        return detailRepository.findAll();
    }
    public Detail getOne(Integer id){
        Optional<Detail> optionalDetail = detailRepository.findById(id);
        return optionalDetail.orElse(null);
    }
    public Result add(DetailDto detailDto){
        Optional<Measurement> optionalMeasurement = measurementRepository.findById(detailDto.getMeasurementId());
        if (!optionalMeasurement.isPresent())
            return new Result("Bunday id li measurement topilmadi",false);
        Detail detail=new Detail();
        detail.setActive(detailDto.isActive());
        detail.setAmount(detailDto.getAmount());
        detail.setName(detailDto.getName());
        detail.setMeasurement(optionalMeasurement.get());
        detailRepository.save(detail);
        return new Result("Bajarildi",true);
    }
    public Result edit(Integer id,DetailDto detailDto){
        Optional<Measurement> optionalMeasurement = measurementRepository.findById(detailDto.getMeasurementId());
        if (!optionalMeasurement.isPresent())
            return new Result("Bunday id li ,easurement topilmadi",false);
        Optional<Detail> optionalDetail = detailRepository.findById(id);
        if (!optionalDetail.isPresent())
            return new Result("Bunday id li detail topilmadi",false);
        Detail detail = optionalDetail.get();
        detail.setActive(detailDto.isActive());
        detail.setAmount(detailDto.getAmount());
        detail.setName(detailDto.getName());
        detail.setMeasurement(optionalMeasurement.get());
        detailRepository.save(detail);
        return new Result("Bajarildi",true);
    }
    public Result delete(Integer id){
        try {
            detailRepository.deleteById(id);
            return new Result("Bajarildi",true);
        } catch (Exception e) {
            return new Result("Bajarilmadi",false);
        }
    }
}
