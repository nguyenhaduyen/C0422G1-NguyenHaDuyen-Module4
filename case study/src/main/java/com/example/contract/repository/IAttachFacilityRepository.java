package com.example.contract.repository;

import com.example.contract.model.AttachFacility;
import com.example.dto.AttachFacilityDto;
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

    @Query(value = "select af.attach_facility_name as attachFacilityName,\n" +
            "af.attach_facility_id as attachFacilityId,\n" +
            "af.price,\n" +
            "af.status,\n" +
            "af.unit,\n" +
            "sum(ct.quantity) as quantity\n" +
            "from contract_detail ct\n" +
            "left join attach_facility af\n" +
            "on ct.attach_facility_id = af.attach_facility_id\n" +
            "where ct.contract_id =:id" +
            "group by ct.contract_detail_id;", nativeQuery = true)
    List<AttachFacilityDto> showQuantity(@Param("id") int id);
}
