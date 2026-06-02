package com.dao;

import java.sql.*;
import com.model.Patient;
import com.util.DBUtil;

public class PatientDao {

    // INSERT Patient
    public int addPatient(Patient p) {
        int generatedId = 0;

        try {
            Connection con = new DBUtil().getConnectionData();

            String sql = "INSERT INTO patient(name, phone) VALUES(?, ?)";
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            ps.setString(1, p.getName());
            ps.setString(2, p.getPhone());

            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                generatedId = rs.getInt(1);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return generatedId;
    }

    // GET Patient by ID
    public Patient getPatientById(int id) {
        Patient p = null;

        try {
        		Connection con = new DBUtil().getConnectionData();
            String sql = "SELECT * FROM patient WHERE id=?";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                p = new Patient(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("phone")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return p;
    }
}