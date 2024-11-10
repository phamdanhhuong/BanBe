package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import beans.BanBe;
import services.connectDB;

public class BanBeDao {
	public static List<BanBe> getListBanBe() {
		List<BanBe> kq = new ArrayList<BanBe>();
		String sql = "select * from ThongTin";
		try {
			Connection db = connectDB.connectDB();
			PreparedStatement state = db.prepareStatement(sql);
			ResultSet rs = state.executeQuery();
			while(rs.next()) {
				kq.add(new BanBe(rs.getInt(1),  rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5), rs.getString(6)));
			}
			db.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return kq;
	}
	
	public static BanBe getBanBe(int id) {
		BanBe kq = null;
		String sql = "select * from ThongTin where id = "+id;
		try {
			Connection db = connectDB.connectDB();
			PreparedStatement state = db.prepareStatement(sql);
			ResultSet rs = state.executeQuery();
			while(rs.next()) {
				kq =new BanBe(rs.getInt(1),  rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5), rs.getString(6));
			}
			db.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return kq;
	}
	
	public static boolean themBan(String hoVaTen, int sdt, String email, String linkSocial, String diaChi) {
		//String sql = "INSERT INTO ThongTin (hoVaTen, sdt, email, linkSocial, diaChi) VALUES (?, ?, ?, ?, ?)";
		String sql = "{CALL themThongTin(?, ?, ?, ?, ?)}";
		try {
			Connection db = connectDB.connectDB();
			PreparedStatement state = db.prepareStatement(sql);
			state.setNString(1, hoVaTen);
			state.setInt(2, sdt);
			state.setNString(3, email);
			state.setNString(4, linkSocial);
			state.setNString(5, diaChi);
			state.execute();
			db.close();
			return true;
		} catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}
	
	public static boolean suaBan(String hoVaTen, int sdt, String email, String linkSocial, String diaChi, int id) {
		String sql = "UPDATE ThongTin SET hoVaTen = ?, sdt = ? , email = ?, linkSocial = ?, diaChi = ? WHERE id = "+id;
		try {
			Connection db = connectDB.connectDB();
			PreparedStatement state = db.prepareStatement(sql);
			state.setNString(1, hoVaTen);
			state.setInt(2, sdt);
			state.setNString(3, email);
			state.setNString(4, linkSocial);
			state.setNString(5, diaChi);
			state.execute();
			db.close();
			return true;
		} catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}
	
	public static boolean xoaBAn(int id) {
		String sql = "Delete from ThongTin WHERE id = "+id;
		try {
			Connection db = connectDB.connectDB();
			PreparedStatement state = db.prepareStatement(sql);
			state.execute();
			db.close();
			return true;
		} catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}
}
