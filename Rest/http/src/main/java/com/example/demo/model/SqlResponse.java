package com.example.demo.model;

public class SqlResponse {
    private String trackName;
    private String trackAlbum;
    private String trackArtist;
    private String trackGenre;
    private String message; // nowa zmienna na wiadomość

    // Gettery i settery dla wszystkich pól, w tym message
    public String getTrackName() {
        return trackName;
    }

    public void setTrackName(String trackName) {
        this.trackName = trackName;
    }

    public String getTrackAlbum() {
        return trackAlbum;
    }

    public void setTrackAlbum(String trackAlbum) {
        this.trackAlbum = trackAlbum;
    }

    public String getTrackArtist() {
        return trackArtist;
    }

    public void setTrackArtist(String trackArtist) {
        this.trackArtist = trackArtist;
    }

    public String getTrackGenre() {
        return trackGenre;
    }

    public void setTrackGenre(String trackGenre) {
        this.trackGenre = trackGenre;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
