package com.example.demo.Controller;

import com.example.demo.RowMapper.StudentRowMapper;
import com.example.demo.entity.Student;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.sql.ResultSet;import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *  * @author oyc
 * <p>
 *  * @Description: 用户控制类
 * <p>
 *  * @date 2018/7/8 22:10
 * <p>
 *  
 */

@RestController
@RequestMapping("/jdbc")

public class JdbcController {
    @Resource
    private JdbcTemplate jdbcTemplate;

    @RequestMapping(value = "/showdata", method = RequestMethod.GET)
    @ResponseBody
    public Object showData(@RequestParam(value = "data") int s, @RequestParam(value = "data1", required = false) String s1) {
        return s;
    }






    @RequestMapping(value = "/studentlist", method = RequestMethod.GET)
    public Object getUserList(ModelMap map) {
        String sql = "SELECT * FROM student";
        List<Student> studentList = jdbcTemplate.query(sql, new StudentRowMapper());

        return studentList;
    }

}