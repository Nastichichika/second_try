package com.nastichichika.second_try.repository;

import com.nastichichika.second_try.model.Course;
import com.nastichichika.second_try.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends CrudRepository<Course, Integer> {
    List<Course> findByTheme(String Theme);
    List<Course> findCoursesByIdteacher(int id_teacher);
    void deleteCoursesByIdteacher(int id_teacher);

}
