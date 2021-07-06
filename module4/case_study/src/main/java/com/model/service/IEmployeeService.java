package com.model.service;

import com.model.entity.employee.Division;
import com.model.entity.employee.EducationDegree;
import com.model.entity.employee.Employee;
import com.model.entity.employee.Position;

import java.util.List;

public interface IEmployeeService extends IGeneralService<Employee>{
    List<EducationDegree> educationDegreeList();
    List<Division> divisionList();
    List<Position> positionList();
    List<Employee> findAll();
}
