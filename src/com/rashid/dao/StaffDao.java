package com.rashid.dao;

import com.rashid.model.Staff;
import com.rashid.util.DbUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rashid on 23.05.2015.
 */
public class StaffDao {
    private Connection connection;

    public StaffDao() {
        connection = DbUtil.getConnection();
    }

    public void addStaff(Staff staff) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("insert into staff(indexNum,surname,name,patronymic," +
                            "dob,idPost,idRank,idSubdiv,contractDate,contractPeriond) " +
                            "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            // Parameters start with 1
            preparedStatement.setInt(1, staff.getIndexNum());
            preparedStatement.setString(2, staff.getSurname());
            preparedStatement.setString(3, staff.getName());
            preparedStatement.setString(4, staff.getPatronymic());
            preparedStatement.setDate(5, new java.sql.Date(staff.getDob().getTime()));
            preparedStatement.setInt(6, staff.getIdPost());
            preparedStatement.setInt(7, staff.getIdRank());
            preparedStatement.setInt(8, staff.getIdSubdiv());
            preparedStatement.setDate(9, new java.sql.Date(staff.getContractDate().getTime()));
            preparedStatement.setInt(10, staff.getContractPeriond());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteStaff(int id) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("delete from staff where id=?");
            // Parameters start with 1
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateStaff(Staff staff) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("update staff set indexNum=?,surname=?,name=?,patronymic=?," +
                            "dob=?,idPost=?,idRank=?,idSubdiv=?,contractDate=?,contractPeriond=?" +
                            "where id=?");
            // Parameters start with 1
            preparedStatement.setInt(1, staff.getIndexNum());
            preparedStatement.setString(2, staff.getSurname());
            preparedStatement.setString(3, staff.getName());
            preparedStatement.setString(4, staff.getPatronymic());
            preparedStatement.setDate(5, new java.sql.Date(staff.getDob().getTime()));
            preparedStatement.setInt(6, staff.getIdPost());
            preparedStatement.setInt(7, staff.getIdRank());
            preparedStatement.setInt(8, staff.getIdSubdiv());
            preparedStatement.setDate(9, new java.sql.Date(staff.getDob().getTime()));
            preparedStatement.setInt(10, staff.getContractPeriond());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Staff> getAllStaff() {
        List<Staff> staffs = new ArrayList<Staff>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from staff");

            while (rs.next()) {
                Staff staff = new Staff();
                staff.setId(rs.getInt("id"));
                staff.setIndexNum(rs.getInt("indexNum"));
                staff.setSurname(rs.getString("surname"));
                staff.setName(rs.getString("name"));
                staff.setPatronymic(rs.getString("patronymic"));
                staff.setDob(rs.getDate("dob"));
                staff.setIdPost(rs.getInt("idPost"));
                staff.setIdRank(rs.getInt("idRank"));
                staff.setIdSubdiv(rs.getInt("idSubdiv"));
                staff.setContractDate(rs.getDate("contractDate"));
                staff.setContractPeriond(rs.getInt("contractPeriond"));
                staffs.add(staff);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return staffs;
    }

    public Staff getStaffById(int id) {
        Staff staff = new Staff();
        try {
            PreparedStatement preparedStatement = connection.
                    prepareStatement("select * from staff where id=?");
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                staff.setId(rs.getInt("id"));
                staff.setIndexNum(rs.getInt("indexNum"));
                staff.setSurname(rs.getString("surname"));
                staff.setName(rs.getString("name"));
                staff.setPatronymic(rs.getString("patronymic"));
                staff.setDob(rs.getDate("dob"));
                staff.setIdPost(rs.getInt("idPost"));
                staff.setIdRank(rs.getInt("idRank"));
                staff.setIdSubdiv(rs.getInt("idSubdiv"));
                staff.setContractDate(rs.getDate("contractDate"));
                staff.setContractPeriond(rs.getInt("contractPeriond"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return staff;
    }
}
