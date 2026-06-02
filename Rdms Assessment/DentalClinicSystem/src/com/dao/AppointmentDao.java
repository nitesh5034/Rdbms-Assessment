package com.dao;

import java.sql.*;
import com.model.Appointment;
import com.util.DBUtil;


public class AppointmentDao {

    // INSERT Appointment
    public int addAppointment(Appointment a) {
        int generatedId = 0;

        try {
            Connection con = new DBUtil().getConnectionData();

            String sql = "INSERT INTO appointment(patient_id, service, date, cost) VALUES(?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            ps.setInt(1, a.getPatientId());
            ps.setString(2, a.getService());
            ps.setString(3, a.getDate());
            ps.setDouble(4, a.getCost());

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
}