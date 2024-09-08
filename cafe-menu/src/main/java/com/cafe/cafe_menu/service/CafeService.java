package com.cafe.cafe_menu.service;

import com.cafe.cafe_menu.dto.CafeDto;
import com.cafe.cafe_menu.entity.Cafe;

import java.util.List;

public interface CafeService {

    Cafe addCafe(CafeDto cafeDto);

    List<CafeDto> getAllCafes();
}
