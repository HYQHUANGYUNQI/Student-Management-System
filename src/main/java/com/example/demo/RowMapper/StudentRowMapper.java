package com.example.demo.RowMapper;

import com.example.demo.entity.Student;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentRowMapper implements RowMapper<Student> {

    @Override
    public Student mapRow(ResultSet rs, int i) throws SQLException {
        Student student = new Student();
        student.setSid(rs.getString("sid"));
        student.setSname(rs.getString("sname"));
        student.setSex(rs.getString("sex"));
        student.setEn_age(rs.getInt("En_age"));
        student.setEn_year(rs.getInt("En_year"));
        student.setClazz((rs.getString("clazz")));
        return student;
    }
}
