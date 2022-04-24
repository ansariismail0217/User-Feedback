package com.simplilearn.demo;

import java.sql.ResultSet;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class UserFeedbackDAO {

	@Autowired
	JdbcTemplate template;
	
	// setter method
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	
	public List<UserEntity> getUser() {
		return template.query("select * from feedback", new RowMapper<UserEntity>() {
			public UserEntity mapRow(ResultSet rs, int row) throws SQLException {
				UserEntity e = new UserEntity();
				e.setID(rs.getInt(1));
				e.setName(rs.getString(2));
				e.setFeedback(rs.getString(3));
				e.setDateAdded(rs.getDate(4));
				return e;
			}
		});
	}
	
	public int addUser(UserEntity user) {
		return template.update("INSERT INTO feedback (ID, name, feedback, date_added) VALUES(?,?,?,?)",
				new Object[] { user.getID(), user.getName(), user.getFeedback(), user.getDateAdded() });
	}
	
	public UserEntity getByName(String name) {
		UserEntity entity = template.queryForObject("select * from feedback where name=?",
				BeanPropertyRowMapper.newInstance(UserEntity.class), name);
		return entity;
	}
}
