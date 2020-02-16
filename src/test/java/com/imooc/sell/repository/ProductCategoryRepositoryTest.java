package com.imooc.sell.repository;

import com.imooc.sell.dataobject.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryRepositoryTest {

    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    @Test
    public void findOneTest(){
        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryId(1);
        Example<ProductCategory> example = Example.of(productCategory);
        Optional<ProductCategory> optionalProductCategory = productCategoryRepository.findOne(example);
        if (optionalProductCategory.isPresent()){
            ProductCategory result = optionalProductCategory.get();
            System.out.println(result.toString());
        }
    }


    @Test
    @Transactional
    public void saveTest(){
        ProductCategory productCategory = new ProductCategory("男生最爱",5);
        ProductCategory result = productCategoryRepository.save(productCategory);
//        Assert.assertNotEquals(null,result);
        Assert.assertNotNull(result);
    }


    @Test
    public void findByCategoryTypeInTest(){
        List<Integer> list = Arrays.asList(2,3,4);
        List<ProductCategory> productCategoryList = productCategoryRepository.findByCategoryTypeIn(list);
        Assert.assertNotEquals(0,productCategoryList.size());
    }
}