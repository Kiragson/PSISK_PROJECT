package pc.psisk.soap_webservice;

import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class WebService {

    public double convertDegToRad(double deg) {
        return Math.toRadians(deg);
    }
    public double convertRadToDeg(double rad) {
        return Math.toDegrees(rad);
    }
    public double convertCelToFahr(double cel) {
        return (cel * 9 / 5) + 32;
    }
    public double convertFahrToCel(double fahr) {
        return (fahr - 32) * 5 / 9;
    }
    public String helloWorld() {
        return "Hello World!";
    }
    public List<String> trackQuery(int id) throws SQLException {
        List<String> list = new ArrayList<String>();
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/chinook", "root", "");
        Statement statement = conn.createStatement();
        ResultSet rs = statement.executeQuery("SELECT t.Name, a.Title, ar.Name, g.Name from track t join album a on a.AlbumId = t.AlbumId join artist ar on a.ArtistId = ar.ArtistId join genre g on g.GenreId = t.GenreId where t.TrackId ="+id+";");
        while(rs.next()) {
            list.add(rs.getString(1));
            list.add(rs.getString(2));
            list.add(rs.getString(3));
            list.add(rs.getString(4));
        }
        return list;
    }
}
