package com.sigma.store.repositories;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.sigma.store.entities.Product;

public interface ProductRepository extends CrudRepository<Product, Long> {

    // * Spring will automatically generate the SQL statements for us
    // * Select * from products where name = ?

    // * String
    List<Product> findByName(String name);

    List<Product> findByNameLike(String name);

    List<Product> findByNameNotLike(String name);

    List<Product> findByNameContaining(String name);

    List<Product> findByNameStartingWith(String name);

    List<Product> findByNameEndingWith(String name);

    List<Product> findByNameEndingWithIgnoreCase(String name);

    // * Numbers

    List<Product> findByPrice(BigDecimal price);

    List<Product> findByPriceGreaterThan(BigDecimal price);

    List<Product> findByPriceGreaterThanEqual(BigDecimal price);

    List<Product> findByPriceLessThan(BigDecimal price);

    List<Product> findByPriceLessThanEqual(BigDecimal price);

    List<Product> findByPriceBetween(BigDecimal min, BigDecimal max);

    //Null
    List<Product> findByDescriptionNull();
    List<Product> findByDescriptionNotNull();

    //Multiple Conditions
    List<Product> findByDescriptionNullAndNameNull();

    //Sort(Order By)
    List<Product> findByNameOrderByPriceDesc(String name);

    //LIMIT/TOP

    List<Product> findTop5ByNameOrderByPriceAsc(String name);
    List<Product> findFirst5ByNameLikeOrderByPriceDesc5ByNameLikeOrderByPriceDesc(String name);


}