package com.ttcscn.database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.ttcscn.entity.Menu;

@Repository
public class DatabaseOrderCoffee{
	
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	//Lấy danh sách menu
	public void getListMenu() {
		String sql = "SELECT * FROM menu";
		
		List<Menu> arrMenu = jdbcTemplate.query(sql, new RowMapper<Menu>() {

			public Menu mapRow(ResultSet rs, int rowNum) throws SQLException {
				Menu menu = new Menu();
				menu.setMaThucUong(rs.getString("maThucUong").trim());
				menu.setTenThucUong(rs.getString("tenThucUong").trim());
				menu.setDonGia(rs.getDouble("donGia"));
				menu.setHinhAnh("");
				menu.setGhiChu("");
				return menu;
			}
			
		});
		
		for(Menu mn : arrMenu) {
			System.out.println(mn.toString());
		}
	}
	
}
