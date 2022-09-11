package com.example.contract.repository;

import com.example.contract.model.AttachFacility;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface IAttachFacilityRepository extends JpaRepository<AttachFacility,Integer> {
    @Query (value = "SELECT \n" +
            "    af.*\n" +
            "FROM\n" +
            "    contract ct\n" +
            "        JOIN\n" +
            "    contract_detail cd ON ct.contract_id = cd.contract_id\n" +
            "        JOIN\n" +
            "    attach_facility af ON cd.attach_facility_id = af.attach_facility_id\n" +
            "WHERE\n" +
            "    ct.contract_id = :id", nativeQuery = true)
    List<AttachFacility> showAttachFacility(@Param("id") int id);
}
