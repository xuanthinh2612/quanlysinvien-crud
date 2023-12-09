package demo.quanlysinhvien.controller;

import demo.quanlysinhvien.model.ClassGroup;
import demo.quanlysinhvien.model.Student;
import demo.quanlysinhvien.service.ClassService;
import demo.quanlysinhvien.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/")
public class StudentController {

    @Autowired
    StudentService studentService;

    @Autowired
    ClassService classService;

    @ModelAttribute("classList")
    public List<ClassGroup> getClassList() {
        return classService.findAll();
    }

    @GetMapping("")
    public String index(Model model) {
        List<Student> studentList = studentService.findAll();
        model.addAttribute("studentList", studentList);
        return ("studentList");
    }
    @GetMapping("student/new")
    public String newStudent(Model model) {
        model.addAttribute("student", new Student());
        return "studentForm";
    }

    @PostMapping("student/new")
    public String createStudent(@ModelAttribute("student") Student student, Model model) {
        try {
            Integer EMPTY_CLASS = 0;
            if (EMPTY_CLASS.equals(student.getClassId())) {
                return "studentForm";
            }
            studentService.save(student);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/";
    }

    @GetMapping("student/delete/{id}")
    public String deleteStudent(@PathVariable Integer id, Model model) {
        studentService.delete(id);
        return "redirect:/";
    }

    @GetMapping("student/detail/{id}")
    public String detailInfo(@PathVariable Integer id, Model model) {
        Student student = studentService.findById(id);
        model.addAttribute("student", student);
        return "studentDetail";
    }
}
