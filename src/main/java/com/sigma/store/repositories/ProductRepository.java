package com.sigma.store.repositories;

import com.sigma.store.dtos.ProductSummary;
import com.sigma.store.dtos.ProductSummaryDTO;
import com.sigma.store.dtos.ProductSummaryRecord;
import com.sigma.store.entities.Category;
import com.sigma.store.entities.Product;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;

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

    List<Product> findFirst5ByNameLikeOrderByPriceDesc(String name);

    //Find products whose prices are in given range and sort by name
//    List<Product> findByPriceBetweenOrderByName(BigDecimal min, BigDecimal max);
    //SQL or JPQL
    @Query(value = "Select * from products p where p.price between :min and :max order by p.name", nativeQuery = true)
    List<Product> findProducts(@Param("min") BigDecimal min, @Param("max") BigDecimal max);

    @Query("Select p from Product p where p.price between :min and :max order by p.name")
    List<Product> findProducts2(@Param("min") BigDecimal min, @Param("max") BigDecimal max);

    @Query("select p from Product p join p.category where p.price between :min and :max order by p.name")
    List<Product> findProducts3(@Param("min") BigDecimal min, @Param("max") BigDecimal max);

    @Query("select count(p) from Product p where p.price between :min and :max")
    long countProducts(@Param("min") BigDecimal min, @Param("max") BigDecimal max);

    @Modifying
    @Query("update Product p set p.price = :newPrice where p.category.id = :categoryId")
    void updatePriceByCategory(BigDecimal newPrice, Byte categoryId);


    @Query("select p from Product p where p.category = :category")
    List<ProductSummaryDTO> findProductsCategory(@Param("category") Category category);
}