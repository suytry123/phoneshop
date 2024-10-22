
package com.java.school.PhoneShop.Repository;

import com.java.school.PhoneShop.Entity.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Integer>{
    
}
