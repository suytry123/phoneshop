
package com.java.school.phoneshop.service;

import com.java.school.phoneshop.entity.Color;

public interface ColorService { //main brand
    Color create(Color color);
    Color getById(Long id);
   
}
