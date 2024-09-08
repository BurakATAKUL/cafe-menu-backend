package com.cafe.cafe_menu.service.Impl;

import com.cafe.cafe_menu.dto.CafeDto;
import com.cafe.cafe_menu.entity.Cafe;
import com.cafe.cafe_menu.repository.CafeRepository;
import com.cafe.cafe_menu.service.CafeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CafeServiceImpl implements CafeService {

    private final CafeRepository cafeRepository;

    @Autowired
    public CafeServiceImpl(CafeRepository cafeRepository) {
        this.cafeRepository = cafeRepository;
    }

    @Override
    public Cafe addCafe(CafeDto cafeDto) {
        Cafe cafe = new Cafe();
        cafe.setName(cafeDto.getName());
        cafe.setAddress(cafeDto.getAddress());

        // Şubeleri ekleyebilirsiniz, eğer varsa
        // Eğer cafeDto'da branch bilgisi varsa, buraya ekleme işlemleri yapılabilir

        return cafeRepository.save(cafe);
    }

    // Diğer metodlar burada olabilir
}
