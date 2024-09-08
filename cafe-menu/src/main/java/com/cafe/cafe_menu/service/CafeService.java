package com.cafe.cafe_menu.service;

import com.cafe.cafe_menu.dto.CafeDto;
import com.cafe.cafe_menu.entity.Cafe;

public interface CafeService {

    Cafe addCafe(CafeDto cafeDto);
}
