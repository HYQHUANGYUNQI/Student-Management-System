package com.example.demo.RowMapper;

import com.example.demo.CombinationEntity.StudentScore;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentScoreRowMapper implements RowMapper<StudentScore> {

    @Override
    public StudentScore mapRow(ResultSet rs, int i) throws SQLException {
        StudentScore stu_score= new StudentScore();
        stu_score.setSid(rs.getString("sid"));
        stu_score.setSname(rs.getString("sname"));
        stu_score.setCid(rs.getString("cid"));
        stu_score.setCname(rs.getString("cname"));
        stu_score.setSel_year(rs.getInt("sel_year"));
        stu_score.setScore(rs.getInt("score"));
        return stu_score;
    }
}
