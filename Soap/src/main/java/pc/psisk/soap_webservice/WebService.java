//klasa webservice, zawiera funkcje webservice
package pc.psisk.soap_webservice;

import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class WebService {

    //funkcja przeliczająca stopnie na radiany
    public double convertDegToRad(double deg) {
        return Math.toRadians(deg);
    }
    //funkcja przeliczająca radiany na stopnie
    public double convertRadToDeg(double rad) {
        return Math.toDegrees(rad);
    }
    //funckja przeliczająca Celcjudze na Fahreinheity
    public double convertCelToFahr(double cel) {
        return (cel * 9 / 5) + 32;
    }
    //funkcja przeliczająca Fahrenheity na Celcjusze
    public double convertFahrToCel(double fahr) {
        return (fahr - 32) * 5 / 9;
    }
    //funkcja zwracająca napis
    public String helloWorld() {
        return "Hello World!";
    }
    //funkcja łącząca się z bazą danych i pobierająca z niej dane
    public List<String> trackQuery(int id) throws SQLException {
        List<String> list = new ArrayList<String>();
        //ustanowienie połączenia z bazą
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/chinook", "root", "");
        //stworzenie deklaracji
        Statement statement = conn.createStatement();
        //wykonaie zapytania 
        ResultSet rs = statement.executeQuery("SELECT t.Name, a.Title, ar.Name, g.Name from track t join album a on a.AlbumId = t.AlbumId join artist ar on a.ArtistId = ar.ArtistId join genre g on g.GenreId = t.GenreId where t.TrackId ="+id+";");
        //przypisanie wyników zapytania do tablicy
        while(rs.next()) {
            list.add(rs.getString(1));
            list.add(rs.getString(2));
            list.add(rs.getString(3));
            list.add(rs.getString(4));
        }
        return list;
    }
}
