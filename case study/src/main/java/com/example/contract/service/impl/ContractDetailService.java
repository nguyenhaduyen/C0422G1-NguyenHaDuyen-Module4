package com.example.contract.service.impl;

import com.example.contract.model.ContractDetail;
import com.example.contract.repository.IContractDetailRepository;
import com.example.contract.service.IContractDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContractDetailService implements IContractDetailService {
    @Autowired
    private IContractDetailRepository iContractDetailRepository;
    @Override
    public void addContractDetail(ContractDetail contractDetail) {
        iContractDetailRepository.save(contractDetail);
    }
}
