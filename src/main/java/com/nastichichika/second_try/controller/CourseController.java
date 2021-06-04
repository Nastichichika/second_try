package com.nastichichika.second_try.controller;

import com.nastichichika.second_try.model.Course;
import com.nastichichika.second_try.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    CourseRepository courseRepository;

    @GetMapping("/list")
    public ResponseEntity<List<Course>> getAllCourses() {
        try {
            List<Course> courses = new ArrayList<Course>();

            courseRepository.findAll().forEach(courses::add);

            if (courses.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(courses, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/list/{theme}")
    public ResponseEntity<List<Course>> findByProgress(@PathVariable("theme") String theme) {
        try {
            List<Course> courses = courseRepository.findByTheme(theme);

            if (courses.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(courses, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/list/teacher/{id_teacher}")
    public ResponseEntity<List<Course>> getById_teache(@PathVariable("id_teacher") int id_teacher) {
        try {
            List<Course> courses = courseRepository.findCoursesByIdteacher(id_teacher);
            if (courses.isEmpty()) {
                return new ResponseEntity<>(courses, HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(courses, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<Course> getCourseById(@PathVariable("id") int id) {
        Optional<Course> courseData = courseRepository.findById(id);

        return courseData.map(course -> new ResponseEntity<>(course, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/create")
    @PreAuthorize("hasAuthority('TEACHER')")
    public ResponseEntity<Course> createUser(@RequestBody Course course) {
        try {
            Course _course = courseRepository
                    .save(new Course(course.getTitle(), course.getText(),  course.getTheme(),
                            course.getId_teacher()));
            return new ResponseEntity<>(_course, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PutMapping("/update/{id}")
    @PreAuthorize("hasAuthority('TEACHER')")
    public ResponseEntity<Course> updateUser(@PathVariable("id") int id, @RequestBody Course course) {
        Optional<Course> tutorialData = courseRepository.findById(id);
        if (tutorialData.isPresent()) {
            Course _course = tutorialData.get();
            _course.setText(course.getText());
            return new ResponseEntity<>(courseRepository.save(_course), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasAuthority('TEACHER')")
    public ResponseEntity<HttpStatus> deleteTutorial(@PathVariable("id") int id) {
        try {
            courseRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping("/teacher/{id}")
    @PreAuthorize("hasAuthority('TEACHER')")
    public ResponseEntity<HttpStatus> deleteTutorialByTeacher(@PathVariable("id") int id) {
        try {
            courseRepository.deleteCoursesByIdteacher(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
