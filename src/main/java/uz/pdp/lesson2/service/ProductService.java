package uz.pdp.lesson2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.lesson2.entity.Category;
import uz.pdp.lesson2.entity.Payment;
import uz.pdp.lesson2.entity.Product;
import uz.pdp.lesson2.payload.ProductDto;
import uz.pdp.lesson2.repository.CategoryRepository;
import uz.pdp.lesson2.repository.PaymentRepository;
import uz.pdp.lesson2.repository.ProductRepository;
import uz.pdp.lesson2.result.Result;

import javax.management.relation.RelationSupport;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;
    CategoryRepository categoryRepository;
    PaymentRepository paymentRepository;

    public List<Product> get(){
        return productRepository.findAll();
    }

    public Product getOne(Integer id){
        Optional<Product> optionalProduct = productRepository.findById(id);
        return optionalProduct.orElse(null);
    }

    public Result add(ProductDto productDto){
        Optional<Category> optionalCategory = categoryRepository.findById(productDto.getCategoryId());
        if (!optionalCategory.isPresent())
            return new Result("Bunday id li category mavjud emas",false);
        Optional<Payment> optionalPayment = paymentRepository.findById(productDto.getPaymentId());
        if (!optionalPayment.isPresent())
            return new Result("Bunday id li payment topilmadi",false);
        Product product=new Product();
        product.setName(productDto.getName());
        product.setIncomePrice(productDto.getIncomePrice());
        product.setSalePrice(productDto.getSalePrice());
        product.setPayment(optionalPayment.get());
        product.setCategory(optionalCategory.get());
        productRepository.save(product);
        return new Result("Bajarildi",true);
    }
    public Result edit(Integer id,ProductDto productDto){
        Optional<Category> optionalCategory = categoryRepository.findById(productDto.getCategoryId());
        if (!optionalCategory.isPresent())
            return new Result("Bunday id li category mavjud emas",false);
        Optional<Payment> optionalPayment = paymentRepository.findById(productDto.getPaymentId());
        if (!optionalPayment.isPresent())
            return new Result("Bunday id li payment topilmadi",false);
        Optional<Product> optionalProduct = productRepository.findById(id);
        if (!optionalProduct.isPresent())
            return new Result("Bunday id li product topiladi",false);
        Product product = optionalProduct.get();
        product.setName(productDto.getName());
        product.setIncomePrice(productDto.getIncomePrice());
        product.setSalePrice(productDto.getSalePrice());
        product.setPayment(optionalPayment.get());
        product.setCategory(optionalCategory.get());
        productRepository.save(product);
        return new Result("Bajarildi",true);
    }
    public Result delete(Integer id){
        try {
            productRepository.deleteById(id);
            return new Result("Bajarildi",true);
        } catch (Exception e) {
            return new Result("Bajarilmadi",false);
        }
    }

}
