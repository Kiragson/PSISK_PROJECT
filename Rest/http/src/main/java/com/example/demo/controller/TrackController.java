package com.example.demo.controller;

import com.example.demo.model.SqlResponse;
import com.example.demo.service.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/api/tracks")
public class TrackController {

    @Autowired
    private TrackService trackService;

    @GetMapping("/{id}")
    public SqlResponse getTrackDetails(@PathVariable int id) throws SQLException {
        List<String> list = trackService.trackQuery(id);

        SqlResponse response = new SqlResponse();
        response.setTrackName(list.get(0));
        response.setTrackAlbum(list.get(1));
        response.setTrackArtist(list.get(2));
        response.setTrackGenre(list.get(3));

        // Dodanie wiadomości "obsługa sql"
        response.setMessage("obsługa sql");

        return response;
    }
}
