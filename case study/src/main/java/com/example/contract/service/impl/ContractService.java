package com.example.contract.service.impl;

import com.example.contract.model.Contract;
import com.example.contract.repository.IContractRepository;
import com.example.contract.service.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractService implements IContractService {
    @Autowired
    private IContractRepository iContractRepository;
    @Override
    public List<Contract> findAll() {
        return iContractRepository.findAll();
    }

}
