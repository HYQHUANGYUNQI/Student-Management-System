package com.example.demo.Controller;

import com.example.demo.CombinationEntity.StudentCourse;
import com.example.demo.CombinationEntity.StudentScore;
import com.example.demo.RowMapper.*;
import com.example.demo.entity.Formate;
import com.example.demo.entity.Student;
import com.example.demo.entity.Course;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController

@RequestMapping("/search")

public class SearchController {

    @Resource
    private JdbcTemplate jdbcTemplate;
    //根据学生姓名或学号查询学生基本信息
    @RequestMapping(value = "/SearchStudent", method = RequestMethod.GET)
    @ResponseBody
    public Object SearchStudent(@RequestParam(value = "sidorsname") String s){
        String sql = "SELECT * FROM student WHERE student.sid = '" + s + "'or student.sname='" + s + "'";
        List<Student> studentList = jdbcTemplate.query(sql, new StudentRowMapper());
        Formate<Student> dataformat = new Formate<Student>();
        dataformat.setTotal(studentList.size());
        dataformat.setRows(studentList);
        return dataformat;
    }
    //根据课程名称或课程编号查询课程基本信息
    @RequestMapping(value = "/SearchCourse", method = RequestMethod.GET)
    public Object SearchCourse(@RequestParam(value = "cidorcname") String c) {
        String sql = "SELECT * FROM course WHERE course.cid = '" + c + "'or course.cname ='" + c + "'";
        List<Course> courseList = jdbcTemplate.query(sql, new CourseRowMapper());
        return courseList;
    }

    //根据学生姓名或学号和课程名称或课程编号查询该生该课程的成绩。
    @RequestMapping(value = "/SearchScore", method = RequestMethod.GET)
    public <value> Object SearchScore(@RequestParam(value = "sidorsname") String s,
                                      @RequestParam(value = "cidorcname") String c){
        String sql = "SELECT s.sid, s.sname, c.cid, c.cname, sc.sel_year, sc.score FROM selectedcourse as sc, student as s, course as c WHERE (s.sname ='" + s +
                "'or s.sid = '" + s  +"')AND (c.cname ='"  + c + "'OR c.cid = '" + c + "')AND s.sid = sc.sid AND c.cid = sc.cid";
        List<StudentScore> scoreList = jdbcTemplate.query(sql, new StudentScoreRowMapper());
        Formate<StudentScore> dataformat = new Formate<StudentScore>();
        dataformat.setTotal(scoreList.size());
        dataformat.setRows(scoreList);
        return dataformat;
    }

    //查询选课情况（根据学生姓名，学号)
    @RequestMapping(value = "/SearchStudentCourse", method = RequestMethod.GET)
    public <value> Object SearchStudentCourse(@RequestParam(value = "info") String s){
        String sql = "select distinct s.sname, s.sid, c.cid, c.cname, sc.sel_year, sc.score from selectedcourse sc, student s, course c where (s.sid = '"
                    + s + "'OR s.sname = '" + s + "') AND s.sid = sc.sid AND c.cid = sc.cid";
        List<StudentCourse> studentCoursesList = jdbcTemplate.query(sql, new StudentCourseRowMapper());
        Formate<StudentCourse> dataformat = new Formate<StudentCourse>();
        dataformat.setTotal(studentCoursesList.size());
        dataformat.setRows(studentCoursesList);
        return dataformat;
    }
    //查询选课情况（根据学生姓名，学号)
    @RequestMapping(value = "/SearchSelectedCourse", method = RequestMethod.GET)
    public <value> Object SearchSelectedCourse(@RequestParam(value = "info") String s){
        String sql = "select distinct s.sname, s.sid, c.cid, c.cname, sc.sel_year, sc.score from selectedcourse sc, student s, course c where (c.cid = '"
                + s + "'OR c.cname = '" + s + "') AND s.sid = sc.sid AND c.cid = sc.cid";
        List<StudentCourse> studentCoursesList = jdbcTemplate.query(sql, new StudentCourseRowMapper());
        Formate<StudentCourse> dataformat = new Formate<StudentCourse>();
        dataformat.setTotal(studentCoursesList.size());
        dataformat.setRows(studentCoursesList);
        return dataformat;
    }
    //查询某学生的平均成绩
    @RequestMapping(value = "/SearchStudentAvgScore", method =  RequestMethod.GET)
    public <value> Object SearchStudentAvgScore(@RequestParam(value = "sidorsname") String s) {
        String sql = "select avg(sc.score) as avg from selectedcourse sc, student s, course c where (s.sname = '"
                   + s + "' or s.sid = '" + s + "') and s.sid = sc.sid and c.cid = sc.cid";
        double result = jdbcTemplate.queryForObject(sql,Double.class);
        return result;
    }
    //查询某班级某科的平均成绩
    @RequestMapping(value = "/SearchClazzAvgScore", method =  RequestMethod.GET)
    public <value> Object SearchClazzAvgScore(@RequestParam(value = "clazz") String clazz,
                                              @RequestParam(value = "cidorcname") String c) {
        String sql  = "select avg(sc.score) from selectedcourse sc, student s, course c where s.clazz = '"
                    + clazz + "' and (c.cid = '" + c + "'or c.cname = '" + c + "' )and s.sid = sc.sid and c.cid = sc.cid";
        double result =  jdbcTemplate.queryForObject(sql,Double.class);
        return result;
    }

    //查询某班级总的平均成绩
    @RequestMapping(value = "/SearchClazzAvgTotalScore", method =  RequestMethod.GET)
    public <value> Object SearchClazzAvgTotalScore(@RequestParam(value = "clazz") String clazz) {
        String sql  =  "select avg(sc.score) from selectedcourse sc, student s, course c where s.clazz = '" + clazz + "'";
        double result =  jdbcTemplate.queryForObject(sql,Double.class);
        return result;
    }

//    //查询某班级的成绩
//    @RequestMapping(value = "/SearchClazzScore", method =  RequestMethod.GET)
//    public <value> Object SearchClazzScore(@RequestParam(value = "clazz") String clazz) {
//        String sql = ""
//    }


    //sql = "select avg(sc.score) from selectedcourse sc, student s, course c where s.clazz = '" + clazz + "'";

    //查询课程的平均成绩
    @RequestMapping(value = "/SearchCourseAvgScore", method = RequestMethod.GET)
    public <value> Object SearchCourseAvgScore(@RequestParam(value = "cnameorcid") String c) {
        String  sql = "select avg(sc.score) from course c, selectedcourse sc where c.cid = sc.cid and c.cid = '" + c + "'";
        double result = jdbcTemplate.queryForObject(sql, Double.class);
        return result;
    }
    //获得满分的人数
    @RequestMapping(value = "/SearchAA", method = RequestMethod.GET)
    public <value> int SearchAA(@RequestParam(value = "cnameorcid") String c) {
        String sql = "select count(*) from course c, selectedcourse sc where c.cid = '" + c + "'and c.cid = sc.cid and  sc.score = 100";
        int result = jdbcTemplate.queryForObject(sql, int.class);
        return result;
    }


    //获得90 - 99分的人数
    @RequestMapping(value = "/SearchA", method = RequestMethod.GET)
    public <value> int SearchA(@RequestParam(value = "cnameorcid") String c) {
        String sql = "select count(*) from course c, selectedcourse sc where c.cid = '" + c + "'and c.cid = sc.cid and sc.score >= 90 and sc.score < 100";
        int result = jdbcTemplate.queryForObject(sql, int.class);
        return result;
    }

    //获取80 - 89分的人数
    @RequestMapping(value = "/SearchB", method = RequestMethod.GET)
    public <value> int SearchB(@RequestParam(value = "cnameorcid") String c) {
        String sql = "select count(*) from course c, selectedcourse sc where c.cid = '" + c + "'and c.cid = sc.cid and sc.score >= 80 and sc.score < 90";
        int result = jdbcTemplate.queryForObject(sql, int.class);
        return result;
    }

    //获取70 - 79分的人数
    @RequestMapping(value = "/SearchC", method = RequestMethod.GET)
    public <value> int SearchC(@RequestParam(value = "cnameorcid") String c) {
        String sql = "select count(*) from course c, selectedcourse sc where c.cid = '" + c + "'and c.cid = sc.cid and sc.score >= 70 and sc.score < 79";
        int result = jdbcTemplate.queryForObject(sql, int.class);
        return result;
    }

    //获取60 - 69分的人数
    @RequestMapping(value = "/SearchD", method = RequestMethod.GET)
    public <value> int SearchD(@RequestParam(value = "cnameorcid") String c) {
        String sql = "select count(*) from course c, selectedcourse sc where c.cid = '" + c + "'and c.cid = sc.cid and sc.score >= 60 and sc.score < 69";
        int result = jdbcTemplate.queryForObject(sql, int.class);
        return result;
    }

    //获取不及格的人数
    @RequestMapping(value = "/SearchE", method = RequestMethod.GET)
    public <value> int SearchE(@RequestParam(value = "cnameorcid") String c) {
        String sql = "select count(*) from course c, selectedcourse sc where c.cid = '" + c + "'and c.cid = sc.cid and sc.score < 60";
        int result = jdbcTemplate.queryForObject(sql, int.class);
        return result;
    }

}