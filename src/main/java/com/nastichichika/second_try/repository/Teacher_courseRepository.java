package com.nastichichika.second_try.repository;

import com.nastichichika.second_try.model.Course;
import com.nastichichika.second_try.model.course_teacher;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Teacher_courseRepository extends CrudRepository<course_teacher, Integer> {
}