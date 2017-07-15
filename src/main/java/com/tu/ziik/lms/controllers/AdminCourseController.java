package com.tu.ziik.lms.controllers;

import com.tu.ziik.lms.model.admin.course.Course;
import com.tu.ziik.lms.model.admin.course.CourseCategory;
import com.tu.ziik.lms.service.SecurityService;
import com.tu.ziik.lms.service.admin.course.AdminCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * Created by ahmadjawid on 12/23/16.
 */

@Controller
public class AdminCourseController {

    @Autowired
    private AdminCourseService adminCourseService;

    @Autowired
    SecurityService securityService;


    @RequestMapping(value = "/admin/course/list", method = RequestMethod.GET)
    public String listCourses(Model model){

        String username = securityService.findAuthenticatedUsername();

        model.addAttribute("courses", adminCourseService.findAllCoursesByUsername(username));
        return "admin/course/course-list";
    }


    @RequestMapping(value = "/admin/course/add", method = RequestMethod.GET)
    public String addCourse(Model model){

        model.addAttribute("course", new Course());
        //model.addAttribute("category", new CourseCategory());
        model.addAttribute("categories", adminCourseService.findAllCategories());
        return "admin/course/add";
    }


    @RequestMapping(value = "/admin/course/add", method = RequestMethod.POST)
    public String addCourse(@ModelAttribute("course") Course course){

        String username = securityService.findAuthenticatedUsername();
        adminCourseService.saveCourse(course, username);
        return "redirect:/admin/course/list";
    }


    @RequestMapping(value ="/admin/course/categories", method = RequestMethod.GET)
    public String listCategories(Model model){
        model.addAttribute("categories", adminCourseService.findAllCategories());

        return "admin/course/category-list";
    }


    @RequestMapping(value = "/admin/course/add-category", method = RequestMethod.POST)
    public String addCategory(@ModelAttribute ("courseCategory") CourseCategory courseCategory, RedirectAttributes redirect){

        System.out.println(courseCategory.getName());

        if (!adminCourseService.categoryExists(courseCategory.getName())){
            adminCourseService.saveCategory(courseCategory);
            redirect.addFlashAttribute("success", "Category '" +
                    courseCategory.getName() + "' was added successfully.");
        }else {
            redirect.addFlashAttribute("error", "Category '" + courseCategory.getName() +"' already exists.");
        }

        return "redirect:/admin/course/add";
    }
}
