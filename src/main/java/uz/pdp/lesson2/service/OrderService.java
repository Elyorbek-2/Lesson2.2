package uz.pdp.lesson2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.jaxb.SpringDataJaxb;
import org.springframework.stereotype.Service;
import uz.pdp.lesson2.entity.Order;
import uz.pdp.lesson2.payload.OrderDto;
import uz.pdp.lesson2.repository.OrderRepository;
import uz.pdp.lesson2.repository.ProductRepository;
import uz.pdp.lesson2.result.Result;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    @Autowired
    OrderRepository orderRepository;
    ProductRepository productRepository;

    public List<Order> get(){
        return orderRepository.findAll();
    }

    public Order getOne(Integer id){
        Optional<Order> optionalOrder = orderRepository.findById(id);
        return optionalOrder.orElse(null);
    }

    public Result add(OrderDto orderDto){
        Order order=new Order();
        order.setName(orderDto.getName());
        order.setProduct(productRepository.findAll());
        orderRepository.save(order);
        return new Result("Bajarildi",true);
    }

    public Result edit(Integer id,OrderDto orderDto){
        Optional<Order> optionalOrder = orderRepository.findById(id);
        if (!optionalOrder.isPresent())
            return new Result("bunday id li order mavjud emas",false);
        Order order = optionalOrder.get();
        order.setName(orderDto.getName());
        order.setProduct(productRepository.findAll());
        orderRepository.save(order);
        return new Result("Bajarildi",true);
    }

    public Result delete(Integer id){
        try {
            orderRepository.deleteById(id);
            return new Result("Bajarildi",true);
        } catch (Exception e) {
            return new Result("Bajarilmadi",false);
        }
    }
}
