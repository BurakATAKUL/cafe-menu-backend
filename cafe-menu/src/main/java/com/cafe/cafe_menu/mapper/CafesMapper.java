package com.cafe.cafe_menu.mapper;

import com.cafe.cafe_menu.dto.CafeDto;
import com.cafe.cafe_menu.entity.Cafe;

public class CafesMapper {

    public static CafeDto mapToCafeDto(Cafe cafe) {
        return new CafeDto(
                cafe.getName(),
                cafe.getAddress()
        );
    }

    public static Cafe mapToCafe(CafeDto cafeDto) {
        return new Cafe(
                cafeDto.getName(),
                cafeDto.getAddress()
        );
    }
}

