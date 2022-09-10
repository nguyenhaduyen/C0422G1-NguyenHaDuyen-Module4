package com.example.contract.repository;

import com.example.contract.model.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IContractRepository extends JpaRepository<Contract,Integer> {

}
