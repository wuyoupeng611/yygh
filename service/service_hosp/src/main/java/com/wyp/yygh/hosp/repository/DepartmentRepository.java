package com.wyp.yygh.hosp.repository;

import com.wyp.yygh.model.hosp.Department;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends MongoRepository<Department,String> {
    //通过医院code和部门code查询部门
    Department getDepartmentByHoscodeAndDepcode(String hoscode, String depcode);
}
