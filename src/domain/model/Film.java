package domain.model;

import domain.DomainException;

public class Film {
    private String titel, genre;
    private int speelduur, rating;

    public Film(){}

    public Film(String titel){
        setTitel(titel);
    }

    public Film(String titel, String genre, int speelduur, int rating){
        setTitel(titel);
        setGenre(genre);
        setSpeelduur(speelduur);
        setRating(rating);
    }

    public String getTitel(){
        return titel;
    }
    public String getGenre(){
        return genre;
    }
    public int getSpeelduur(){
        return speelduur;
    }
    public int getRating(){
        return rating;
    }
    public void setTitel(String titel){
        if (titel == null || titel.trim().isEmpty()){
            throw new DomainException("Vul een titel in.");
        }
        this.titel = titel;
    }
    public void setGenre(String genre){
        if (genre == null || genre.trim().isEmpty()){
            throw new DomainException("Kies een genre.");
        }
        this.genre = genre;
    }
    public void setSpeelduur(int speelduur){
        if(speelduur <= 0){
            throw new DomainException("Vul een speelduur groter in dan 0.");
        }
        this.speelduur = speelduur;
    }
    public void setRating(int rating){
        if(rating < 0 || rating > 10){
            throw new DomainException("Vul een rating in tussen 0 en 10.");
        }
        this.rating = rating;
    }
    public String getInfo(){
        return getTitel() + ", " + getGenre() + ", " + getSpeelduur() + " minuten, " + getRating() + "/10";
    }
    public boolean heeftTitel(String titel) {
        return titel.equals(this.getTitel());
    }
}
