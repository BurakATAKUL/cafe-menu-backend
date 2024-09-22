package com.cafe.cafe_menu.mapper;

import com.cafe.cafe_menu.dto.BranchDto;
import com.cafe.cafe_menu.entity.Branch;

public class BranchMapper {

    public static BranchDto mapToBranchDto(Branch branch) {
        return new BranchDto(
                branch.getName(),
                branch.getLocation(),
                branch.getCafe(),
                branch.getContact()
        );

    }

    public static Branch mapToBranch(BranchDto branchDto) {

        return new Branch(
                branchDto.getName(),
                branchDto.getLocation(),
                branchDto.getCafe(),
                branchDto.getContact()
        );

    }

}
