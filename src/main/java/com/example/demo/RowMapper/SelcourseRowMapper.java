package com.example.demo.RowMapper;

import com.example.demo.CombinationEntity.StudentCourse;
import com.example.demo.entity.SelectedCourse;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SelcourseRowMapper implements RowMapper<SelectedCourse> {

    @Override
    public SelectedCourse mapRow(ResultSet rs, int i) throws SQLException {
        SelectedCourse sel_course = new SelectedCourse();
        sel_course.setSid(rs.getString("sid"));
        sel_course.setCid(rs.getString("cid"));
        sel_course.setSel_year(rs.getInt("Sel_year"));
        sel_course.setScore(rs.getInt("score"));
        return sel_course;
    }
}
