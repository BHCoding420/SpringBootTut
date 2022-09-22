package com.springbootstart.Springbootstart.service;

import com.springbootstart.Springbootstart.entity.Department;
import com.springbootstart.Springbootstart.error.DepartmentNotFoundException;

import java.util.List;

public interface DepartmentService {

        public Department saveDepartment(Department department);

        public List<Department> fetchDepartmentList();

        public  Department fetchDepartmentById(Long departmentId) throws DepartmentNotFoundException;

        public void deleteDepartmentById(Long departmentId);

        public  Department updateDepartment(Long departmentId, Department department);
}
