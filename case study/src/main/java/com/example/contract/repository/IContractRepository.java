package com.example.contract.repository;

import com.example.contract.model.Contract;
import com.example.dto.ContractPage;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IContractRepository extends JpaRepository<Contract, Integer> {
    @Query(value = "SELECT \n" +
            "    f.facility_name AS facilityName,\n" +
            "    c.customer_name AS customerName,\n" +
            "    ct.contract_id AS id,\n" +
            "    ct.start_date AS startDate,\n" +
            "    ct.end_date AS endDate,\n" +
            "    ct.deposit,\n" +
            "    ((IFNULL(SUM(cd.quantity * af.price), 0) + f.cost)) AS total\n" +
            "FROM\n" +
            "    contract ct\n" +
            "        LEFT JOIN\n" +
            "    facility f ON ct.facility_id = f.facility_id\n" +
            "        LEFT JOIN\n" +
            "    contract_detail cd ON ct.contract_id = cd.contract_id\n" +
            "        LEFT JOIN\n" +
            "    attach_facility af ON cd.attach_facility_id = af.attach_facility_id\n" +
            "        LEFT JOIN\n" +
            "    customer c ON ct.customer_id = c.customer_id\n" +
            "GROUP BY ct.contract_id",
            nativeQuery = true, countQuery = "select count(*) from contract")
    Page<ContractPage> showListConTract(Pageable pageable);

}
