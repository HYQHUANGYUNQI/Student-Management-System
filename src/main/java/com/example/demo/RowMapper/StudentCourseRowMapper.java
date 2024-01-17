package com.example.demo.RowMapper;

import com.example.demo.CombinationEntity.StudentCourse;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentCourseRowMapper implements RowMapper<StudentCourse> {

    @Override
    public StudentCourse mapRow(ResultSet rs, int i) throws SQLException {
        StudentCourse stu_course = new StudentCourse();
        stu_course.setSid(rs.getString("sid"));
        stu_course.setSname(rs.getString("sname"));
        stu_course.setCid(rs.getString("cid"));
        stu_course.setCname(rs.getString("cname"));
        stu_course.setSel_year(rs.getInt("sel_year"));
        stu_course.setScore(rs.getInt("score"));
        return stu_course;
    }
}
