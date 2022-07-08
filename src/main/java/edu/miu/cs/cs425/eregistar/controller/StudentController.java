package edu.miu.cs.cs425.eregistar.controller;

import edu.miu.cs.cs425.eregistar.model.Student;
import edu.miu.cs.cs425.eregistar.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping(value = {"/eRegistrar/student/list"})
    public ModelAndView listStudents() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("students", studentService.getAllStudents());
        modelAndView.setViewName("student/list");
        return modelAndView;
    }

    @GetMapping(value = {"/eRegistrar/student/new"})
    public String displayNewStudentForm(Model model) {
        model.addAttribute("student", new Student());
        return "student/new";
    }

    @PostMapping(value = {"/eRegistrar/student/new"})
    public String addNewStudent(@Valid @ModelAttribute("student") Student student,
                                BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "student/new";
        }
        student = studentService.saveStudent(student);
        return "redirect:/eRegistrar/student/list";
    }

    @GetMapping(value = {"/eRegistrar/student/edit/{studentId}"})
    public String editStudent(@PathVariable Integer studentId, Model model) {
        Student student = studentService.getStudentById(studentId);
        if (student != null) {
            model.addAttribute("student", student);
            return "student/edit";
        }
        return "student/list";
    }

    @PostMapping(value = {"/eRegistrar/student/edit"})
    public String updateStudent(@Valid @ModelAttribute("student") Student student,
                                BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "student/edit";
        }
        student = studentService.saveStudent(student);
        return "redirect:/eRegistrar/student/list";
    }

    @GetMapping(value = {"/eRegistrar/student/delete/{studentId}"})
    public String deleteStudent(@PathVariable Integer studentId, Model model) {
        studentService.deleteStudentById(studentId);
        return "redirect:/eRegistrar/student/list";
    }

    @GetMapping("/searchStudent")
    public String searchStudent(@RequestParam(defaultValue = "") String name, Model model){
        model.addAttribute("students", studentService.findByFirstNameContainingIgnoreCase(name));
        List<Student> stList = studentService.findByFirstNameContainingIgnoreCase(name);
        System.out.println("from controller stslist...............");
        System.out.println(stList);
        return "student/list";
    }

}
