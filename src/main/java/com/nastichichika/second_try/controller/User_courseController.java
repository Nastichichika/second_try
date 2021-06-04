package com.nastichichika.second_try.controller;

import java.util.ArrayList;
import java.util.List;

import com.nastichichika.second_try.model.Course;
import com.nastichichika.second_try.model.User_course;
import com.nastichichika.second_try.repository.CourseRepository;
import com.nastichichika.second_try.repository.UserRepository;
import com.nastichichika.second_try.model.User;
import com.nastichichika.second_try.repository.User_courseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/connection")
public class User_courseController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    User_courseRepository user_courseRepository;

    @Autowired
    CourseRepository courseRepository;

    @PostMapping("/create")
    public ResponseEntity<User_course> createData(User_course user_course) {
        try {
            User_course _user_course = user_courseRepository
                    .save(new User_course(user_course.getIduser(),
                            user_course.getIdcourse()));
            return new ResponseEntity<>(_user_course, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/courses/user/{id}")
    public ResponseEntity<List<Course>> getCoursesByUsr(@PathVariable("id") int id) {
        try {
            List<User_course> listIdCourses = user_courseRepository.findUser_coursesByIduser(id);
            List<Course> courses = new ArrayList<>();
            for(int i = 0; i < listIdCourses.size(); i++) {
                courses.add(courseRepository.findById(listIdCourses.get(i).getIdcourse()).get());
            }
            return new ResponseEntity<>(courses, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/users/course/{id}")
    public ResponseEntity<List<User>> geUsrByCourse(@PathVariable("id") int id) {
        try {
            List<User_course> listIdCourses = user_courseRepository.findUser_coursesByIdcourse(id);
            List<User> users = new ArrayList<>();
            for(int i = 0; i < listIdCourses.size(); i++) {
                users.add(userRepository.findById(listIdCourses.get(i).getIduser()).get());
            }
            return new ResponseEntity<>(users, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    @DeleteMapping("/delete")
    public ResponseEntity<List<Course>> delete(User_course user_course) {
        try {

            user_courseRepository.deleteByIdcourseAndIduser(8, 10);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
