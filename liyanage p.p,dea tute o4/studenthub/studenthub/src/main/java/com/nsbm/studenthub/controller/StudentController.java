package com.nsbm.studenthub.controller;

import com.nsbm.studenthub.entity.Student;
import com.nsbm.studenthub.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService service;

    @PostMapping
    public Student create(@RequestBody Student s) {
        return service.save(s);
    }

    @GetMapping
    public Page<Student> getAll(@RequestParam int page,
                                @RequestParam int size,
                                @RequestParam String sortBy) {
        return service.getAll(page, size, sortBy);
    }

    @GetMapping("/{id}")
    public Student getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PutMapping("/{id}")
    public Student update(@PathVariable Long id, @RequestBody Student s) {
        return service.update(id, s);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
