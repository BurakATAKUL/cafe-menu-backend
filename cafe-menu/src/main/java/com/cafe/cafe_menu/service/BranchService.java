package com.cafe.cafe_menu.service;

import com.cafe.cafe_menu.dto.BranchDto;
import com.cafe.cafe_menu.entity.Branch;

public interface BranchService {
    Branch addBranch(BranchDto branchDto);
}
