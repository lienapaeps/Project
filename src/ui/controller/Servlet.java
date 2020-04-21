package ui.controller;

import domain.DomainException;
import domain.db.FilmDB;
import domain.model.Film;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/FilmInfo")
public class Servlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private FilmDB filmDB = new FilmDB();

    public Servlet() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String destination;

        String command = "home";
        if (request.getParameter("command") != null) {
            command = request.getParameter("command");
        }

        switch (command) {
            case "overview":
                destination = overview(request);
                break;
            case "add":
                destination = add(request, response);
                break;
            case "delete":
                destination = delete(request);
                break;
            case "deleteConfirmation":
                destination = deleteConfirmation(request);
                break;
            case "zoek":
                destination = zoek(request);
                break;
            default:
                destination = home(request);
        }
        request.getRequestDispatcher(destination).forward(request, response);
    }

    private String home(HttpServletRequest request) {
        request.setAttribute("langsteSpeelduur", filmDB.filmMetLangsteSpeelduur());
        return "index.jsp";
    }

    private String overview(HttpServletRequest request) {
        request.setAttribute("alleFilms", filmDB.vindAlle());
        return "overzicht.jsp";
    }

    private String add(HttpServletRequest request, HttpServletResponse response) {
        ArrayList<String> errors = new ArrayList<>();

        Film film = new Film();

        setTitel(film, request, errors);
        setGenre(film, request, errors);
        setSpeelduur(film, request, errors);
        setRating(film, request, errors);

        if (errors.size() == 0) {
            try {
                filmDB.voegToe(film);
                return overview(request);
            } catch (DomainException e) {
                errors.add(e.getMessage());
            }
        }
        request.setAttribute("errors", errors);
        return "voegToe.jsp";
    }

    private void setTitel(Film film, HttpServletRequest request, ArrayList<String> errors) {
        String titel = request.getParameter("titel");
        try {
            film.setTitel(titel);
            request.setAttribute("titelPreviousValue", titel);
        } catch (DomainException e) {
            errors.add(e.getMessage());
        }
    }

    private void setGenre(Film film, HttpServletRequest request, ArrayList<String> errors) {
        String genre = request.getParameter("genre");
        try {
            film.setGenre(genre);
            request.setAttribute("genrePreviousValue", genre);
        } catch (DomainException e) {
            errors.add(e.getMessage());
        }
    }

    private void setSpeelduur(Film film, HttpServletRequest request, ArrayList<String> errors) {
        String speelduur = request.getParameter("speelduur");
        try {
            film.setSpeelduur(Integer.parseInt(speelduur));
            request.setAttribute("speelduurPreviousValue", speelduur);
        } catch (NumberFormatException e) {
            errors.add("Vul een speelduur groter in dan 0.");
        } catch (DomainException e) {
            errors.add(e.getMessage());
        }
    }

    private void setRating(Film film, HttpServletRequest request, ArrayList<String> errors) {
        String rating = request.getParameter("rating");
        try {
            film.setRating(Integer.parseInt(rating));
            request.setAttribute("ratingPreviousValue", rating);
        } catch (NumberFormatException e) {
            errors.add("Vul een rating in tussen 0 en 10.");
        } catch (DomainException e) {
            errors.add(e.getMessage());
        }
    }

    private String delete(HttpServletRequest request) {
        return "deleteConfirmation.jsp";
    }

    private String deleteConfirmation(HttpServletRequest request) {
        if (request.getParameter("submit").equals("Zeker")) {
            String titel = request.getParameter("titel");
            filmDB.verwijder(filmDB.vind(titel));
            return overview(request);
        } else {
            return "index.jsp";
        }
    }

    private String zoek(HttpServletRequest request) {
        String titel = request.getParameter("titel");
        String destination = "";

        if (titel == null) {
            destination = "nietGevonden.jsp";
        } else {
            Film film = filmDB.vind(titel);
            if (film == null) {
                destination = "nietGevonden.jsp";
            } else {
                destination = "gevonden.jsp";
                request.setAttribute("film", film);
            }
        }
        return destination;
    }
}



