package com.example.demo.RowMapper;

import com.example.demo.entity.Course;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CourseRowMapper implements RowMapper<Course> {

    @Override
    public Course mapRow(ResultSet rs, int i) throws SQLException {
        Course course = new Course();
        course.setCid(rs.getString("cid"));
        course.setCname(rs.getString("cname"));
        course.setTname(rs.getString("tname"));
        course.setCredit(rs.getString("credit"));
        course.setSuit_grade(rs.getString("suit_grade"));
        course.setCanc_year(rs.getString("canc_year"));
        return course;
    }
}
