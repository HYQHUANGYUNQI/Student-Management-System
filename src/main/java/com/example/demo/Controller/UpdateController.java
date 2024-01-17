package com.example.demo.Controller;
import com.example.demo.RowMapper.StudentRowMapper;
import com.example.demo.entity.Course;
import com.example.demo.entity.Formate;
import com.example.demo.entity.SelectedCourse;
import com.example.demo.entity.Student;
import com.example.demo.util.ResponseDTO;
import org.springframework.expression.spel.ast.NullLiteral;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.swing.*;
import java.util.HashMap;
import java.util.List;


@RestController

@RequestMapping("/update")
public class UpdateController {
    @Resource
    private JdbcTemplate jdbcTemplate;

    //插入学生
    @RequestMapping(value = "/InsertStudent", method = RequestMethod.GET)
    public Object InsertStudent (@RequestParam(value = "sid") String sid,
                                 @RequestParam(value = "sname") String sname,
                                 @RequestParam(value = "sex") String sex,
                                 @RequestParam(value = "en_age") int en_age,
                                 @RequestParam(value = "en_year") int en_year,
                                 @RequestParam(value = "clazz") String clazz) {
        Student student = new Student();
        String sql = "INSERT INTO student (sid, sname, sex, en_age, en_year, clazz) VALUES (?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, sid, sname, sex, en_age, en_year, clazz);
        return "插入成功";
    }

    //插入课程
    @RequestMapping(value = "/InsertCourse", method = RequestMethod.GET)
    public Object InsertCourse (@RequestParam(value = "cid") String cid,
                                 @RequestParam(value = "cname") String cname,
                                 @RequestParam(value = "tname") String tname,
                                 @RequestParam(value = "credit") String credit,
                                 @RequestParam(value = "suit_grade") String suit_grade,
                                 @RequestParam(value = "canc_year",required = false, defaultValue = "NULL") String canc_year) {
        Course course = new Course();
        String sql = "INSERT INTO course (cid, cname, tname, credit, suit_grade, canc_year) VALUES (?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, cid, cname, tname, credit, suit_grade, canc_year);
        return "插入成功";
    }

    //插入选课
    @RequestMapping(value = "/InsertSelectedCourse", method = RequestMethod.GET)
    public Object InsertSelectedCourse (@RequestParam(value = "sid") String sid,
                                        @RequestParam(value = "cid") String cid,
                                        @RequestParam(value = "sel_year") int sel_year,
                                        @RequestParam(value = "score" ) int score ){
        SelectedCourse selectedCourse = new SelectedCourse();
        String sql = "INSERT INTO selectedcourse (sid, cid, sel_year, score) VALUES (?, ?, ?, ?)";
        int result = jdbcTemplate.update(sql, sid, cid, sel_year, score);
        System.out.println(result);
        if (result > 0) {
            return "插入成功";
        }
        else {
            return "插入失败";
        }

    }
    //删除学生
    @RequestMapping(value = "/DeleteStudent", method = RequestMethod.GET)
    @ResponseBody
    public Object DeleteStudent (@RequestParam(value = "sid") String s) {
        Student student = new Student();
        String sql = "DELETE FROM student where sid = ?";
        int result = jdbcTemplate.update(sql, s);
        if (result > 0){
            return "删除成功";
        }else{
            return "删除失败";
        }
    }
    //删除课程
    @RequestMapping(value = "/DeleteCourse", method = RequestMethod.GET)
    public Object DeleteCourse (@RequestParam(value = "cid") String c) {
        Course course = new Course();
        String sql = "DELETE FROM course where cid = ?";
        int result = jdbcTemplate.update(sql, c);
        Formate<Course> dataformat = new Formate<Course>();
        dataformat.setTotal(0);
        dataformat.setRows(null);
        if (result > 0) {
            return "删除成功";
        }
        else {
            return "删除失败";
        }
    }
    //删除选课信息
    @RequestMapping(value = "/DeleteSelectedCourse", method = RequestMethod.GET)
    public Object DeleteSelectedCourse (@RequestParam(value = "sid") String s,
                                        @RequestParam(value = "cid") String c){
        SelectedCourse selectedCourse = new SelectedCourse();
        String sql = "DELETE FROM selectedcourse where sid = ? AND  cid = ?";
        int result = jdbcTemplate.update(sql, s, c);
        if (result > 0) {
            return "删除成功";
        }
        else {
            return "删除失败";
        }
    }
    //修改学生信息
    @RequestMapping(value = "/UpdateStudent", method = RequestMethod.GET)
    public Object UpdateStudent (@RequestParam(value = "sid2") String sid2,
                                 @RequestParam(value = "sname") String sname,
                                 @RequestParam(value = "sex") String sex,
                                 @RequestParam(value = "en_age") Integer en_age,
                                 @RequestParam(value = "en_year") Integer en_year,
                                 @RequestParam(value = "clazz") String clazz,
                                 @RequestParam(value = "sid1") String sid1) {
        String sql = "update student s set s.sid = ?, s.sname = ?, s.sex = ?, s.en_age = ?, s.en_year = ?, s.clazz = ?  where s.sid = ?";
        int result = jdbcTemplate.update(sql, sid2, sname, sex, en_age, en_year, clazz, sid1);
        if (result > 0) {
            return "修改成功";
        }
        else {
            return "修改失败";
        }
    }
    //修改课程信息
    @RequestMapping(value = "/UpdateCourse", method = RequestMethod.GET)
    public Object UpdateCourse (@RequestParam (value = "cid2") String cid2,
                                @RequestParam (value = "cname") String cname,
                                @RequestParam (value = "tname") String tname,
                                @RequestParam (value = "credit") String credit,
                                @RequestParam (value = "suit_grade") String suit_grade,
                                @RequestParam (value = "canc_year") String canc_year,
                                @RequestParam (value = "cid1") String cid1) {
        String sql = "update course c set c.cid = ?, c.cname = ?, c.tname = ?, c.credit = ?, c.suit_grade = ?, c.canc_year = ?  where c.cid = ?";
        int result = jdbcTemplate.update(sql, cid2, cname, tname, credit, suit_grade, canc_year, cid1);
        if (result > 0) {
            return "修改成功";
        }
        else {
            return "修改失败";
        }
    }
    //修改选课信息
    @RequestMapping(value = "/UpdateSelectedCourse", method = RequestMethod.GET)
    public Object UpdateSelectedCourse (@RequestParam (value = "sel_year") Integer sel_year,
                                        @RequestParam (value = "score") Integer score,
                                        @RequestParam (value = "sid") String sid,
                                        @RequestParam (value = "cid") String cid) {
        String sql = "update selectedcourse sc set sc.sel_year = ?, sc.score = ? where sc.sid =  ? and sc.cid = ?";
        int result = jdbcTemplate.update(sql, sel_year, score, sid, cid);
        if (result > 0) {
            return "修改成功";
        }
        else {
            return "修改失败";
        }
    }

}

//insert into student(sid, sname, sex, en_age, en_year, class)
//values
//("3017000001", "张三", "男", 18, 2017, "软工二班"),
    //@RequestMapping(value = "/SearchStudent", method = RequestMethod.GET)
    //public Object SearchStudent(@RequestParam(value = "sidorsname") String s){
    //    String sql = "SELECT * FROM student WHERE student.sid = '" + s + "'or student.sname='" + s + "'";
    //    List<Student> studentList = jdbcTemplate.query(sql, new StudentRowMapper());
    //    return studentList;
    //}
