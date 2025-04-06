package com.project.hospital_managemnet_system_E4.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.hospital_managemnet_system_E4.dto.Branch;
import com.project.hospital_managemnet_system_E4.dto.BranchHead;
import com.project.hospital_managemnet_system_E4.dto.Owner;
import com.project.hospital_managemnet_system_E4.repo.BranchHeadRepo;
@Repository
public class BranchHeadDao {

	@Autowired
	BranchHeadRepo branchHeadRepo;
	
	
	public BranchHead saveBranchHead(BranchHead branchHead)  {
		return branchHeadRepo.save(branchHead);
	}
	
	public BranchHead updateBranchHeadById(int oldBranchHeadId, BranchHead newBranchHead) {
		newBranchHead.setBranchHeadId(oldBranchHeadId);
		return saveBranchHead(newBranchHead);
	}
	
	public BranchHead fetchBranchHeadById(int branchHeadId) {
		Optional<BranchHead> branchHead = branchHeadRepo.findById(branchHeadId);
		if (branchHead.isEmpty()) {
			return null;
		} 
		else {
			return branchHead.get();
		}
	}
	
	public BranchHead deleteBranchHeadById(int branchHeadId) {
		BranchHead branchHead=fetchBranchHeadById(branchHeadId);
		branchHeadRepo.delete(branchHead);
		return branchHead;
	}
	
	public List<BranchHead> fetchAllBranchHead(){
		return branchHeadRepo.findAll();
	}
}
