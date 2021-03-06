package domain.db;

import domain.DomainException;
import domain.model.Film;

import java.util.ArrayList;

public class FilmDB {
    private ArrayList<Film> films = new ArrayList<>();

    public FilmDB(){
        this.voegToe(new Film("Spider-Man: Far From Home", "Fantasy", 129, 9));
        this.voegToe(new Film("Parasite", "Drama", 132, 8));
        this.voegToe(new Film("Cars 3", "Animatie", 109, 7));
    }

    public void voegToe(Film film){
        if (heeftFilm(film)){
            throw new DomainException("Deze film bestaat al.");
        }else {
            films.add(film);
        }
    }

    public boolean heeftFilm(Film film){
        for (Film f: films){
            if (film.getTitel().equals(f.getTitel())){
                return true;
            }
        }
        return false;
    }

    public Film filmMetLangsteSpeelduur(){
        if(films.get(0) == null){
            throw new DomainException("Er zijn nog geen films toegevoegd aan de lijst.");
        }
        Film speelduur = films.get(0);
        for(Film f:films){
            if(speelduur.getSpeelduur() < f.getSpeelduur()){
                speelduur = f;
            }
        }
        return speelduur;
    }

    public Film vind(String titel) {
        for (Film film : films) {
            if (film.heeftTitel(titel)) {
                return film;
            }
        }return null;
    }

    public ArrayList<Film> vindAlle(){
        return films;
    }

    public boolean verwijder(Film film){
        return films.remove(film);
    }
}
