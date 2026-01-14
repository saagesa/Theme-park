package dao;

import databaza.DBConnection;
import model.Perdoruesi;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PerdoruesiDao {

    public List<Perdoruesi> getAllPerdoruesit() {
        List<Perdoruesi> perdoruesit = new ArrayList<>();
        String sql = "SELECT * FROM Perdoruesi";

        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Perdoruesi p = new Perdoruesi(
                        rs.getInt("PerdoruesId"),
                        rs.getString("Emri"),
                        rs.getString("Mbiemri"),
                        rs.getString("Emaili"),
                        rs.getString("Fjalekalimi"),
                        rs.getString("Telefoni")
                );
                perdoruesit.add(p);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return perdoruesit;
    }
}


    
