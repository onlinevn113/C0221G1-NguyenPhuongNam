package com.model.entity;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Getter
@Setter
public class CustomerType {
    @Id
    private Long id;
    private String name;
    @OneToMany(mappedBy = "id")
    List<Customer> customerList;
}
