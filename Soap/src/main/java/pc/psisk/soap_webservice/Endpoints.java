//klasa implementująca endpointy
package pc.psisk.soap_webservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import pc.psisk.soap_webservice.webservice.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.List;

@Endpoint
public class Endpoints {

    //dodanie obiektu klasy mikroserwis
    private final WebService service;

    //stworzenie konstruktora incjującego obiekt serwisu
    public Endpoints(WebService service) {
        this.service = service;
    }

    //endpoint do funkcji zamiany stopni na radiany
    @PayloadRoot(namespace = "http://psiskproj.com/webservice", localPart = "angleDegToRadRequest")
    @ResponsePayload
    public AngleDegToRadResponse angleDegToRadResponse(@RequestPayload AngleDegToRadRequest angleDegToRadRequest) {
        //pobranie wartości parametrów z zapytania
        double value = angleDegToRadRequest.getValue();
        //wykonanie funkcji zamiany
        double r_val = service.convertDegToRad(value);
        //utworzenie odpowiedzi
        AngleDegToRadResponse response = new AngleDegToRadResponse();
        //dodanie wartości parametrów do odpowiedzi
        response.setResult(r_val);
        return response;
    }

    //endpoint do funkcji zamiany radianów na stopnie
    @PayloadRoot(namespace = "http://psiskproj.com/webservice", localPart = "angleRadToDegRequest")
    @ResponsePayload
    public AngleRadToDegResponse angleRadToDegResponse(@RequestPayload AngleRadToDegRequest angleRadToDegRequest) {
        //pobranie wartości parametrów z zapytania
        double value = angleRadToDegRequest.getValue();
        //wykonanie funkcji zamiany
        double r_val = service.convertRadToDeg(value);
        //utworzenie odpowiedzi
        AngleRadToDegResponse response = new AngleRadToDegResponse();
        //dodanie wartości parametrów do odpowiedzi
        response.setResult(r_val);
        return response;
    }

    //endpoint do funkcji zamiany Celcjuszy na Fahrenheity
    @PayloadRoot(namespace = "http://psiskproj.com/webservice", localPart = "tempCelToFahrRequest")
    @ResponsePayload
    public TempCelToFahrResponse tempCelToFahrResponse(@RequestPayload TempCelToFahrRequest tempCelToFahrRequest) {
        //pobranie wartości parametrów z zapytania
        double value = tempCelToFahrRequest.getValue();
        //wykonanie funkcji zamiany
        double r_val = service.convertCelToFahr(value);
        //utworzenie odpowiedzi
        TempCelToFahrResponse response = new TempCelToFahrResponse();
        //dodanie wartości parametrów do odpowiedzi
        response.setResult(r_val);
        return response;
    }

    //endpoint do funkcji zamiany Fahrenheitów na Celcjusze
    @PayloadRoot(namespace = "http://psiskproj.com/webservice", localPart = "tempFahrToCelRequest")
    @ResponsePayload
    public TempFahrToCelResponse tempFahrToCelResponse(@RequestPayload TempFahrToCelRequest tempFahrToCelRequest) {
        //pobranie wartości parametrów z zapytania
        double value = tempFahrToCelRequest.getValue();
        //wykonanie funkcji zamiany
        double r_val = service.convertFahrToCel(value);
        //utworzenie odpowiedzi
        TempFahrToCelResponse response = new TempFahrToCelResponse();
        //dodanie wartości parametrów do odpowiedzi
        response.setResult(r_val);
        return response;
    }

    //endpoint do fukcji zwracania Hello World
    @PayloadRoot(namespace = "http://psiskproj.com/webservice", localPart = "helloWorldRequest")
    @ResponsePayload
    public HelloWorldResponse helloWorldResponse(@RequestPayload HelloWorldRequest helloWorldRequest) {
        //pobranie wartości parametrów z zapytania
        String cont = helloWorldRequest.getContent();
        String r_cont = "";
        //wykoanie funkcji wrócenia
        if (cont.equalsIgnoreCase("hello")) {
            r_cont = service.helloWorld();
        }
        //utworzenie odpowiedzi
        HelloWorldResponse response = new HelloWorldResponse();
        //dodanie wartości parametrów do odpowiedzi
        response.setResult(r_cont);
        return response;
    }

    //endpoint do fukcji pobrania informacji z bazy danych
    @PayloadRoot(namespace = "http://psiskproj.com/webservice", localPart = "sqlRequest")
    @ResponsePayload
    public SqlResponse sqlResponse(@RequestPayload SqlRequest sqlRequest) throws SQLException {
        //pobranie wartości parametrów z zapytania
        int trackId = Integer.parseInt(sqlRequest.getTrackId());
        List<String> list;
        //wykonanie fukcji pobierającej dane z bazy
        list = service.trackQuery(trackId);
        //przypisanie pobranych danych do zmiennych
        String tName = list.get(0);
        String tAlbum = list.get(1);
        String tArtist = list.get(2);
        String tGenre = list.get(3);

        //utworzenie odpowiedzi
        SqlResponse response = new SqlResponse();
        response.setTrackName(tName);
        response.setTrackAlbum(tAlbum);
        response.setTrackArtist(tArtist);
        response.setTrackGenre(tGenre);
        return response;
    }

    //deklaracja stałej ze ścieżką do folderu, w którym będą znajdować się pliki
    private static final String UPLOADED_FOLDER = "uploads/";
    //inicjalizacja loggera
    private static final Logger logger = LoggerFactory.getLogger(Endpoints.class);
    @PayloadRoot(namespace = "http://psiskproj.com/webservice", localPart = "uploadFileRequest")
    @ResponsePayload
    public UploadFileResponse uploadFileResponse(@RequestPayload UploadFileRequest uploadFileRequest) {
        //utworzenie odpowiedzi
        UploadFileResponse response = new UploadFileResponse();

        try {
            //pobranie ścieżki do folderu
            Path folderPath = Paths.get(UPLOADED_FOLDER);
            //sprawdzenie czy folder istnieje, jeżeli nie to utworzenie go
            if(!Files.exists(folderPath)){
                Files.createDirectories(folderPath);
            }

            //utworzenie pełnej sćieżki do przesyłanego pliku
            Path path = folderPath.resolve(uploadFileRequest.getFileName());
            //zapis danych pliku na podanej na ścieżce
            Files.write(path, uploadFileRequest.getFileData());

            //pobranie rozmiaru przesyłanego pliku
            long fileSize = Files.size(path);
            //utworzenie komunikatu o sukcesie z nazwą pliku oraz jego rozmiarem
            String message = String.format("File uploaded successfully: %s (Size: %d bytes)", uploadFileRequest.getFileName(), fileSize);
            //zalogowanie sukcesu
            logger.info(message);
            //dodanie wartości parametrów do odpowiedzi
            response.setMessage(message);
        } catch (IOException e) {
            //zalogowanie komunikatu błędu, jeżeli przesyłanie się nie uda
            logger.error("Failed to upload file: {}", e.getMessage());
            //otworzenie odpowiedzi o błędzie
            response.setMessage("Dile upload failed");
        }
        return response;
    }
}
