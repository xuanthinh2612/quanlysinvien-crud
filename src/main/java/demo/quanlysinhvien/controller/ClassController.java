package demo.quanlysinhvien.controller;

import demo.quanlysinhvien.model.ClassGroup;
import demo.quanlysinhvien.service.ClassService;
import demo.quanlysinhvien.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/class")
public class ClassController {

    @Autowired
    private ClassService classService;

    @Autowired
    private StudentService studentService;

    @GetMapping("")
    public String index(Model model){
        model.addAttribute("classList", classService.findAll() );
        return "classList";
    }

    @GetMapping("/new")
    public String newClass(Model model){
        ClassGroup classGroup = new ClassGroup();
        model.addAttribute("classGroup", classGroup);
        return "newClass";
    }

    @PostMapping("/new")
    public String createNewClass(@ModelAttribute ClassGroup classGroup, Model model) {
        classService.save(classGroup);
        return "redirect:/class";
    }

    @GetMapping("/delete/{id}")
    public String deleteClassGroup(@PathVariable Integer id, Model model) {
        classService.delete(id);
        return "redirect:/class";
    }
}
