package cn.easybuy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class BaseDaoImpl {
	protected Connection connection = null;
	protected PreparedStatement pstmt = null;

	public BaseDaoImpl(Connection connection) {
		this.connection = connection;
	}

	public int executeUpdate(String sql, Object[] param) {
		int num = 0;
		PreparedStatement pstmt = null;
		try {
			pstmt = connection.prepareStatement(sql);
			if (param != null) {
				for (int i = 0; i < param.length; i++) {
					pstmt.setObject(i + 1, param[i]);
				}
			}
			num = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return num;
	}

	public ResultSet executeQuery(String sql, Object[] param) {
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		try {
			pstmt = connection.prepareStatement(sql);
			rs = pstmt.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}

	public int executeInsert(String sql, Object[] param) {
		Long id = 0L;
		try {
			pstmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			for (int i = 0; i < param.length; i++) {
				pstmt.setObject(i + 1, param[i]);
			}
			pstmt.executeUpdate();
			ResultSet rs = pstmt.getGeneratedKeys();
			if (rs.next()) {
				id = rs.getLong(1);
				System.out.println("数据主键：" + id);
			}

		} catch (Exception e) {
			e.printStackTrace();
			id = null;
		}

		return id.intValue();
	}

	//释放资源
	public boolean closeResource(){
		if(pstmt != null){
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
		}
		return true;
	}
	
	public boolean closeResource(ResultSet reSet){
		if(reSet != null){
			try {
				reSet.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}
		}
		return true;
	}
}
