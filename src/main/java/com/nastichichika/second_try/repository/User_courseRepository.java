package com.nastichichika.second_try.repository;

import com.nastichichika.second_try.model.User_course;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface User_courseRepository extends CrudRepository<User_course, Integer> {
    List<User_course> findUser_coursesByIdcourse(int id);
    List<User_course> findUser_coursesByIduser(int id);
    void deleteByIdcourseAndIduser(int idcourse, int idusr);

}