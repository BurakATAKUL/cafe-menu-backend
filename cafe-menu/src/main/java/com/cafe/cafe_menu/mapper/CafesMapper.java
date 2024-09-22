package com.cafe.cafe_menu.mapper;

import com.cafe.cafe_menu.dto.CafeDto;
import com.cafe.cafe_menu.entity.Cafe;

import java.util.Optional;
import java.util.stream.Collectors;

public class CafesMapper {

    public static CafeDto mapToCafeDto(Cafe cafe) {
        return new CafeDto(
                Optional.ofNullable(cafe.getId()), // Optional kullanarak id'yi aktar
                cafe.getName(),
                cafe.getAddress(),
                cafe.getPhone(),
                cafe.getBranches() != null ? cafe.getBranches().stream()
                        .map(BranchMapper::mapToBranchDto)
                        .collect(Collectors.toList()) : null
        );
    }

    public static Cafe mapToCafe(CafeDto cafeDto) {
        Cafe cafe = new Cafe();
        // Optional'dan değeri al ve set et
        cafe.setId(cafeDto.getId().orElse(null)); // Eğer id yoksa null döner
        cafe.setName(cafeDto.getName());
        cafe.setAddress(cafeDto.getAddress());
        cafe.setPhone(cafeDto.getPhone());

        if (cafeDto.getBranchDto() != null) {
            cafe.setBranches(
                    cafeDto.getBranchDto().stream()
                            .map(BranchMapper::mapToBranch)
                            .collect(Collectors.toList())
            );
        }

        return cafe;
    }
}
