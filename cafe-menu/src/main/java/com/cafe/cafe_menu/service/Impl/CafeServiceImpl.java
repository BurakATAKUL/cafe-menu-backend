package com.cafe.cafe_menu.service.Impl;

import com.cafe.cafe_menu.dto.CafeDto;
import com.cafe.cafe_menu.entity.Cafe;
import com.cafe.cafe_menu.mapper.CafesMapper;
import com.cafe.cafe_menu.repository.CafeRepository;
import com.cafe.cafe_menu.service.CafeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public List<CafeDto> getAllCafes() {
        List<Cafe> cafeList = cafeRepository.findAll();
        cafeList.forEach(cafe -> System.out.println("Cafe: " + cafe.getName() + ", " + cafe.getAddress()));

        return cafeList.stream()
                .map(CafesMapper::mapToCafeDto)
                .toList();
    }

    // Diğer metodlar burada olabilir
}
