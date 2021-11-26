package uz.pdp.lesson2.service;

import org.hibernate.engine.jdbc.cursor.spi.RefCursorSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.lesson2.entity.Order;
import uz.pdp.lesson2.entity.Payment;
import uz.pdp.lesson2.entity.User;
import uz.pdp.lesson2.payload.PaymentDto;
import uz.pdp.lesson2.repository.OrderRepository;
import uz.pdp.lesson2.repository.PaymentRepository;
import uz.pdp.lesson2.repository.UserRepository;
import uz.pdp.lesson2.result.Result;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentService {
    @Autowired
    PaymentRepository paymentRepository;
    OrderRepository orderRepository;
    UserRepository userRepository;
    public List<Payment> get(){
        return paymentRepository.findAll();
    }
    public Payment getOne(Integer id){
        Optional<Payment> optionalPayment = paymentRepository.findById(id);
        return optionalPayment.orElse(null);
    }
    public Result add(PaymentDto paymentDto){
        Optional<Order> optionalOrder = orderRepository.findById(paymentDto.getOrderId());
        if (!optionalOrder.isPresent())
            return new Result("Bunday id li order topilmadi",false);
        Optional<User> optionalUser = userRepository.findById(paymentDto.getUserId());
        if (!optionalUser.isPresent())
            return new Result("bunday id li user topilmadi",false);
        Payment payment=new Payment();
        payment.setOrder(optionalOrder.get());
        payment.setUser(optionalUser.get());
        payment.setTotalSumm(paymentDto.getTotalSumm());
        payment.setResult(paymentDto.isResult());
        paymentRepository.save(payment);
        return new Result("Bajarildi",true);
    }
    public Result edit(Integer id,PaymentDto paymentDto){
        Optional<Order> optionalOrder = orderRepository.findById(paymentDto.getOrderId());
        if (!optionalOrder.isPresent())
            return new Result("Bunday id li order topilmadi",false);
        Optional<User> optionalUser = userRepository.findById(paymentDto.getUserId());
        if (!optionalUser.isPresent())
            return new Result("bunday id li user topilmadi",false);
        Optional<Payment> optionalPayment = paymentRepository.findById(id);
        if (!optionalPayment.isPresent())
            return new Result("Bunday id li payment topilmadi",false);
        Payment payment = optionalPayment.get();
        payment.setOrder(optionalOrder.get());
        payment.setUser(optionalUser.get());
        payment.setTotalSumm(paymentDto.getTotalSumm());
        payment.setResult(paymentDto.isResult());
        paymentRepository.save(payment);
        return new Result("Bajarildi",true);
    }
    public Result delete(Integer id){
        try {
            paymentRepository.deleteById(id);
            return new Result("Bajarildi",true);
        } catch (Exception e) {
            return new Result("Bajarilmadi",false);
        }
    }
}
