package com.cafe.cafe_menu.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Optional;

@Getter
@Setter
public class CafeDto {
    private Optional<Long> id;
    private String name;
    private String address;
    private String phone;
    private List<BranchDto> branchDto;

    public CafeDto(Optional<Long> id,String name, String address, String phone, List<BranchDto> branchDto ){
        this.id = id;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.branchDto = branchDto;

    }

}
