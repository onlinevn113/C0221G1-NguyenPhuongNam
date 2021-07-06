package com.model.dto;

import com.model.entity.contract.AttachService;
import com.model.entity.contract.Contract;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
@Data
public class ContractDetailDto {
    private Long id;
    private Contract contract;
    private AttachService attachService;
    @NotNull
    private Integer quantity;

}
