package com.springbootstart.Springbootstart.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PositiveOrZero;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Department {



    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @PositiveOrZero
    private Long departmentId;
    
    @NotBlank(message="Please add department name")
    @Length(max = 10,min = 0)
    private String departmentName;
    private String departmentAddress;
    private String departmentCode;



    @Override
    public String toString() {
        return "Department{" +
                "departmentId=" + departmentId +
                ", departmentName='" + departmentName + '\'' +
                ", departmentAddress='" + departmentAddress + '\'' +
                ", departmentCode='" + departmentCode + '\'' +
                '}';
    }
}
