package com.model.entity.contract;

import lombok.Data;

import javax.persistence.*;
import java.util.List;


@Entity
public class ContractDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(nullable = false)
    private Contract contract;
    @ManyToOne
    @JoinColumn(nullable = false)
    private AttachService attachService;
    @Column(nullable = false)
    private Integer quantity;


    public ContractDetail() {
    }

    public ContractDetail(Long id, Contract contract, AttachService attachService, Integer quantity) {
        this.id = id;
        this.contract = contract;
        this.attachService = attachService;
        this.quantity = quantity;
    }

    public ContractDetail(Contract contract, AttachService attachService, Integer quantity) {
        this.contract = contract;
        this.attachService = attachService;
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public AttachService getAttachService() {
        return attachService;
    }

    public void setAttachService(AttachService attachService) {
        this.attachService = attachService;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
