package com.example.contract.service;

import com.example.contract.model.Contract;
import com.example.dto.ContractPage;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IContractService {
    Page<ContractPage> showListConTract(Pageable pageable);

}
