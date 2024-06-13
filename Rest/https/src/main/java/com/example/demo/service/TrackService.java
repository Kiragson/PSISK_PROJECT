package com.example.demo.service;

import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Service
public class TrackService {

    public List<String> trackQuery(int id) throws SQLException {
        List<String> list = new ArrayList<>();
        Connection conn = null;
        Statement statement = null;
        ResultSet rs = null;

        try {
            // Nawiązanie połączenia z bazą danych
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/chinook", "root", "root");

            // Sprawdzenie, czy połączenie zostało nawiązane
            if (conn == null) {
                throw new SQLException("Failed to connect to the database.");
            }

            statement = conn.createStatement();
            rs = statement.executeQuery("SELECT t.Name, a.Title, ar.Name, g.Name FROM track t " +
                    "JOIN album a ON a.AlbumId = t.AlbumId " +
                    "JOIN artist ar ON a.ArtistId = ar.ArtistId " +
                    "JOIN genre g ON g.GenreId = t.GenreId " +
                    "WHERE t.TrackId =" + id);

            // Sprawdzenie, czy zapytanie zwróciło wyniki
            if (!rs.isBeforeFirst()) {
                throw new SQLException("No data found for Track ID: " + id);
            }

            while (rs.next()) {
                list.add(rs.getString(1));
                list.add(rs.getString(2));
                list.add(rs.getString(3));
                list.add(rs.getString(4));
            }
        } catch (SQLException e) {
            // Logowanie błędu (możesz użyć loggera, np. SLF4J)
            e.printStackTrace();
            throw e;
        } finally {
            // Zamknięcie zasobów
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return list;
    }
}
