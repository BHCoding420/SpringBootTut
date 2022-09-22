package com.springbootstart.Springbootstart.service;

import com.springbootstart.Springbootstart.controller.DepartmentController;
import com.springbootstart.Springbootstart.entity.Department;
import com.springbootstart.Springbootstart.error.DepartmentNotFoundException;
import com.springbootstart.Springbootstart.repository.DepartmentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements  DepartmentService{

    @Autowired
    private DepartmentRepository departmentRepository;

    private final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);

    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> fetchDepartmentList() {
        return departmentRepository.findAll();
    }

    @Override
    public Department fetchDepartmentById(Long departmentId) throws DepartmentNotFoundException {
        Optional<Department> department =
                departmentRepository.findById(departmentId);
        LOGGER.info("department not here");
        if(!department.isPresent())
        {
            LOGGER.info("department not present");
            throw new DepartmentNotFoundException("Department not available");
        }
        return department.get();
    }

    @Override
    public void deleteDepartmentById(Long departmentId) {
        departmentRepository.deleteById(departmentId);
    }

    @Override
    public Department updateDepartment(Long departmentId, Department department) {
        Department depDB = departmentRepository.findById(departmentId).get();

        if(Objects.nonNull(department.getDepartmentName()) && !"".equalsIgnoreCase((department.getDepartmentName())))
        {
            depDB.setDepartmentName(department.getDepartmentName());

        }
        if(Objects.nonNull(department.getDepartmentCode()) && !"".equalsIgnoreCase((department.getDepartmentCode())))
        {
            depDB.setDepartmentCode(department.getDepartmentCode());

        }
        if(Objects.nonNull(department.getDepartmentAddress()) && !"".equalsIgnoreCase((department.getDepartmentAddress())))
        {
            depDB.setDepartmentAddress(department.getDepartmentAddress());

        }
        return departmentRepository.save(depDB);
    }
}
