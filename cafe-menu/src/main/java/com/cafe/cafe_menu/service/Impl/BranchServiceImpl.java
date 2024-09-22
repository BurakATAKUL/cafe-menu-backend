package com.cafe.cafe_menu.service.Impl;

import com.cafe.cafe_menu.dto.BranchDto;
import com.cafe.cafe_menu.entity.Branch;
import com.cafe.cafe_menu.entity.Cafe;
import com.cafe.cafe_menu.repository.BranchRepository;
import com.cafe.cafe_menu.repository.CafeRepository;
import com.cafe.cafe_menu.service.BranchService;
import org.springframework.stereotype.Service;

@Service
public class BranchServiceImpl implements BranchService {

    private final BranchRepository branchRepository;
    private final CafeRepository cafeRepository;  // Cafe repository'yi de ekledik

    public BranchServiceImpl(BranchRepository branchRepository, CafeRepository cafeRepository) {
        this.branchRepository = branchRepository;
        this.cafeRepository = cafeRepository;
    }

    @Override
    public Branch addBranch(BranchDto branchDto) {
        try {
            Cafe cafe = cafeRepository.findById(branchDto.getCafe())
                    .orElseThrow(() -> new RuntimeException("Cafe not found"));

            Branch branch = new Branch();
            branch.setName(branchDto.getName());
            branch.setLocation(branchDto.getLocation());
            branch.setContact(branchDto.getContact());
            branch.setCafe(cafe);

            return branchRepository.save(branch);
        } catch (Exception e) {
            e.printStackTrace();  // Hata mesajını konsolda gösterir
            throw e;
        }
    }




}
