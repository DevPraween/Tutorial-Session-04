package com.nsbm.studenthub.service;

import com.nsbm.studenthub.entity.Student;
import com.nsbm.studenthub.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository repo;

    public Student save(Student s) {
        return repo.save(s);
    }

    public Page<Student> getAll(int page, int size, String sortBy) {
        return repo.findAll(PageRequest.of(page, size, Sort.by(sortBy)));
    }

    public Student getById(Long id) {
        return repo.findById(id).orElseThrow();
    }

    public Student update(Long id, Student s) {
        Student st = getById(id);
        st.setName(s.getName());
        st.setEmail(s.getEmail());
        st.setBatch(s.getBatch());
        st.setGpa(s.getGpa());
        return repo.save(st);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}
