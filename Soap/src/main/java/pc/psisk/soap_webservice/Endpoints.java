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

    private final WebService service;

    public Endpoints(WebService service) {
        this.service = service;
    }

    @PayloadRoot(namespace = "http://psiskproj.com/webservice", localPart = "angleDegToRadRequest")
    @ResponsePayload
    public AngleDegToRadResponse angleDegToRadResponse(@RequestPayload AngleDegToRadRequest angleDegToRadRequest) {
        double value = angleDegToRadRequest.getValue();
        double r_val = service.convertDegToRad(value);
        AngleDegToRadResponse response = new AngleDegToRadResponse();
        response.setResult(r_val);
        return response;
    }

    @PayloadRoot(namespace = "http://psiskproj.com/webservice", localPart = "angleRadToDegRequest")
    @ResponsePayload
    public AngleRadToDegResponse angleRadToDegResponse(@RequestPayload AngleRadToDegRequest angleRadToDegRequest) {
        double value = angleRadToDegRequest.getValue();
        double r_val = service.convertRadToDeg(value);
        AngleRadToDegResponse response = new AngleRadToDegResponse();
        response.setResult(r_val);
        return response;
    }

    @PayloadRoot(namespace = "http://psiskproj.com/webservice", localPart = "tempCelToFahrRequest")
    @ResponsePayload
    public TempCelToFahrResponse tempCelToFahrResponse(@RequestPayload TempCelToFahrRequest tempCelToFahrRequest) {
        double value = tempCelToFahrRequest.getValue();
        double r_val = service.convertCelToFahr(value);
        TempCelToFahrResponse response = new TempCelToFahrResponse();
        response.setResult(r_val);
        return response;
    }

    @PayloadRoot(namespace = "http://psiskproj.com/webservice", localPart = "tempFahrToCelRequest")
    @ResponsePayload
    public TempFahrToCelResponse tempFahrToCelResponse(@RequestPayload TempFahrToCelRequest tempFahrToCelRequest) {
        double value = tempFahrToCelRequest.getValue();
        double r_val = service.convertFahrToCel(value);
        TempFahrToCelResponse response = new TempFahrToCelResponse();
        response.setResult(r_val);
        return response;
    }

    @PayloadRoot(namespace = "http://psiskproj.com/webservice", localPart = "helloWorldRequest")
    @ResponsePayload
    public HelloWorldResponse helloWorldResponse(@RequestPayload HelloWorldRequest helloWorldRequest) {
        String cont = helloWorldRequest.getContent();
        String r_cont = "";
        if (cont.equalsIgnoreCase("hello")) {
            r_cont = service.helloWorld();
        }
        HelloWorldResponse response = new HelloWorldResponse();
        response.setResult(r_cont);
        return response;
    }

    @PayloadRoot(namespace = "http://psiskproj.com/webservice", localPart = "sqlRequest")
    @ResponsePayload
    public SqlResponse sqlResponse(@RequestPayload SqlRequest sqlRequest) throws SQLException {
        int trackId = Integer.parseInt(sqlRequest.getTrackId());
        List<String> list;
        list = service.trackQuery(trackId);
        String tName = list.get(0);
        String tAlbum = list.get(1);
        String tArtist = list.get(2);
        String tGenre = list.get(3);

        SqlResponse response = new SqlResponse();
        response.setTrackName(tName);
        response.setTrackAlbum(tAlbum);
        response.setTrackArtist(tArtist);
        response.setTrackGenre(tGenre);
        return response;
    }

    private static final String UPLOADED_FOLDER = "uploads/";
    private static final Logger logger = LoggerFactory.getLogger(Endpoints.class);
    @PayloadRoot(namespace = "http://psiskproj.com/webservice", localPart = "uploadFileRequest")
    @ResponsePayload
    public UploadFileResponse uploadFileResponse(@RequestPayload UploadFileRequest uploadFileRequest) {
        UploadFileResponse response = new UploadFileResponse();

        try {
            Path folderPath = Paths.get(UPLOADED_FOLDER);
            if(!Files.exists(folderPath)){
                Files.createDirectories(folderPath);
            }

            Path path = folderPath.resolve(uploadFileRequest.getFileName());
            Files.write(path, uploadFileRequest.getFileData());

            long fileSize = Files.size(path);
            String message = String.format("File uploaded successfully: %s (Size: %d bytes)", uploadFileRequest.getFileName(), fileSize);
            logger.info(message);
            response.setMessage(message);
        } catch (IOException e) {
            logger.error("Failed to upload file: {}", e.getMessage());
            response.setMessage("Dile upload failed");
        }
        return response;
    }
}
