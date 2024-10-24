
package com.java.school.PhoneShop.Service;

import com.java.school.PhoneShop.Entity.Brand;

public interface BrandService { //main brand
    Brand create(Brand brand);
    Brand getById(Integer id);
    Brand update(Integer id, Brand brandUpdate);
	
}
