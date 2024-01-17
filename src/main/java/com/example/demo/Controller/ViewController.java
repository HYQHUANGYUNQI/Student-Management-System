package com.example.demo.Controller;

import com.example.demo.RowMapper.CourseRowMapper;
import com.example.demo.RowMapper.SelcourseRowMapper;
import com.example.demo.RowMapper.StudentRowMapper;
import com.example.demo.entity.Course;
import com.example.demo.entity.Formate;
import com.example.demo.entity.SelectedCourse;
import com.example.demo.entity.Student;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/view")
public class ViewController {
    @Resource
    private JdbcTemplate jdbcTemplate;
    //显示所有学生基本信息
    @RequestMapping(value = "/StudentView",method = RequestMethod.GET)
    @ResponseBody
    public Object StudentView () {
        String sql = "select * from student";
        List<Student> studentList = jdbcTemplate.query(sql, new StudentRowMapper());
        Formate<Student> dataformat = new Formate<Student>();
        dataformat.setTotal(studentList.size());
        dataformat.setRows(studentList);
        return dataformat;
    }

    //显示所有课程基本信息
    @RequestMapping(value = "/CourseView",method = RequestMethod.GET)
    @ResponseBody
    public Object CourseView () {
        String sql = "select * from course";
        List<Course> courseList = jdbcTemplate.query(sql, new CourseRowMapper());
        Formate<Course> dataformat = new Formate<Course>();
        dataformat.setTotal(courseList.size());
        dataformat.setRows(courseList);
        return dataformat;
    }

    //显示所有选课基本信息
    @RequestMapping(value = "/SelectedCourseView",method = RequestMethod.GET)
    @ResponseBody
    public Object SelectedCourseView () {
        String sql = "select * from selectedcourse";
        List<SelectedCourse> selectedcourseList = jdbcTemplate.query(sql, new SelcourseRowMapper());
        Formate<SelectedCourse> dataformat = new Formate<SelectedCourse>();
        dataformat.setTotal(selectedcourseList.size());
        dataformat.setRows(selectedcourseList);
        return dataformat;
    }

    //    //根据学生姓名或学号查询学生基本信息
    //    @RequestMapping(value = "/SarchStudent", method = RequestMethod.GET)
    //    public Object SearchStudent(@RequestParam(value = "sidorsname") String s){
    //        String sql = "SELECT * FROM student WHERE student.sid = '" + s + "'or student.sname='" + s + "'";
    //        List<Student> studentList = jdbcTemplate.query(sql, new StudentRowMapper());
    //        return studentList;
    //    }

}
