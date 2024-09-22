package com.cafe.cafe_menu.service.Impl;

import com.cafe.cafe_menu.Exeptions.ResoruceNotFoundException;
import com.cafe.cafe_menu.dto.CafeDto;
import com.cafe.cafe_menu.entity.Cafe;
import com.cafe.cafe_menu.mapper.CafesMapper;
import com.cafe.cafe_menu.repository.CafeRepository;
import com.cafe.cafe_menu.service.CafeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

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
        cafe.setPhone(cafeDto.getPhone());

        // Şubeleri ekleyebilirsiniz, eğer varsa
        // Eğer cafeDto'da branch bilgisi varsa, buraya ekleme işlemleri yapılabilir

        return cafeRepository.save(cafe);
    }

    @Override
    public List<CafeDto> getAllCafes() {
        List<Cafe> cafeList = cafeRepository.findAll();
        cafeList.forEach(cafe -> System.out.println("Cafe: " + cafe.getName() + ", " + cafe.getAddress()));

        return cafeList.stream()
                .map((cafe) -> CafesMapper.mapToCafeDto(cafe))
                .collect(Collectors.toList());
    }


    @Override
   public CafeDto updateCafe(Long cafeId,  CafeDto updatedCafe) {

        Cafe cafe = cafeRepository.findById(cafeId).orElseThrow(
                () -> new ResoruceNotFoundException("Cafe is not exists with given id: " + cafeId)
        );
        cafe.setName(updatedCafe.getName());
        cafe.setAddress(updatedCafe.getAddress());
        cafe.setPhone(updatedCafe.getPhone());
        Cafe updateCafeObj = cafeRepository.save(cafe);

        return CafesMapper.mapToCafeDto(updateCafeObj);


   }

    @Override
    public void deleteCafe(Long cafeId) {
        Cafe cafe = cafeRepository.findById(cafeId).orElseThrow(
                () ->  new RuntimeException("Cafe is not exists with given id: " + cafeId)
        );
        cafeRepository.deleteById(cafeId);
    }

    @Override
    public CafeDto getCafeById(Long cafeId) {
        Cafe cafe = cafeRepository.findById(cafeId)
                .orElseThrow(() -> new RuntimeException("Cafe is not exists with given id: " + cafeId));


        return CafesMapper.mapToCafeDto(cafe);
    }


}
