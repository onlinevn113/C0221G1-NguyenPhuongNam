package com.model.entity.contract;
import javax.persistence.*;
import java.util.List;


@Entity
public class AttachService {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private Double cost;
    @Column(nullable = false)
    private Integer unit;
    private String status;
    @OneToMany(mappedBy = "id")
    private List<ContractDetail> contractDetail;

    public AttachService() {
    }

    public AttachService(Long id, String name, Double cost, Integer unit, String status, List<ContractDetail> contractDetail) {
        this.id = id;
        this.name = name;
        this.cost = cost;
        this.unit = unit;
        this.status = status;
        this.contractDetail = contractDetail;
    }

    public AttachService(String name, Double cost, Integer unit, String status, List<ContractDetail> contractDetail) {
        this.name = name;
        this.cost = cost;
        this.unit = unit;
        this.status = status;
        this.contractDetail = contractDetail;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public Integer getUnit() {
        return unit;
    }

    public void setUnit(Integer unit) {
        this.unit = unit;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<ContractDetail> getContractDetail() {
        return contractDetail;
    }

    public void setContractDetail(List<ContractDetail> contractDetail) {
        this.contractDetail = contractDetail;
    }
}
