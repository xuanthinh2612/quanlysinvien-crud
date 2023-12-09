package demo.quanlysinhvien.service;

import demo.quanlysinhvien.model.ClassGroup;
import demo.quanlysinhvien.model.Student;
import demo.quanlysinhvien.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    ClassService classService;

    @Override
    public Student save(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public void delete(Integer studentId) {
        studentRepository.deleteById(studentId);
    }

    @Override
    public List<Student> findAll() {
        List<Student> studentList = studentRepository.findAll();
        for (Student student : studentList) {
            ClassGroup classGroup = classService.findById(student.getClassId());
            student.setClassName(classGroup.getClassName());
        }
        return studentList;
    }

    @Override
    public Student findById(Integer studentId) {
        Student student = studentRepository.findById(studentId).orElse(null);
        if (!ObjectUtils.isEmpty(student)) {
            ClassGroup classGroup = classService.findById(student.getClassId());
            student.setClassName(classGroup.getClassName());
        }
        return student;
    }
}
