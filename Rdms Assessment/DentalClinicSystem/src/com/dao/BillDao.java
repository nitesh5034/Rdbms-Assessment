package com.dao;

import java.sql.*;
import com.model.Bill;
import com.util.DBUtil;

public class BillDao {

    // INSERT Bill
    public void addBill(Bill b) {

        try {
            Connection con = new DBUtil().getConnectionData();

            String sql = "INSERT INTO bill(appointment_id, treatment_cost, tax, medicine_cost, discount, total) VALUES(?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, b.getAppointmentId());
            ps.setDouble(2, b.getTreatmentCost());
            ps.setDouble(3, b.getTax());
            ps.setDouble(4, b.getMedicineCost());
            ps.setDouble(5, b.getDiscount());
            ps.setDouble(6, b.getTotal());

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}