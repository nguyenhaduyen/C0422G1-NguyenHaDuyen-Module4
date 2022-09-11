package com.example.contract.model;

import com.example.contract.model.AttachFacility;
import com.example.contract.model.Contract;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table (name = "contract_detail")
public class ContractDetail {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "contract_detail_id")
    private int idContractDetail;
    @Column(name = "quantity")
    private int quantity;

    @ManyToOne
    @JoinColumn (name = "contract_id", referencedColumnName = "contract_id")
    private Contract contract;

    @ManyToOne
    @JoinColumn (name = "attach_facility_id", referencedColumnName = "attach_facility_id")
    private AttachFacility attachFacility;
}
