package org.example;
/**
 * Această clasă gestionează o pistă de aterizare sau decolare și este modelată prin genericitate,
 * astfel încât poate accepta fie avioane de tip WideBody, fie NarrowBody. Genericitatea va
 * asigura faptul că nu se va putea ca un avion de tip WideBody să fie programat pentru o pistă
 * ce acceptă doar NarrowBody și vice-versa.
 *
 * De asemenea, va asigura și faptul că nu se va
 * putea folosi clasa cu altceva în afară de obiecte de tip avion.
 *
 * Fiecare pistă va avea ca atribut un
 * ID (String) și o colecție internă care gestionează avioanele programate pentru să
 * aterizeze/decoleze de aici (care au statusul WAITING_FOR_TAKEOFF sau
 * WAITING_FOR_LANDING).
 *
 * Aceste colecții conțin avioane din tipul modelat de genericitate. De
 * asemenea, colecția va menține în mod eficient, ordinea de prioritate la decolare/aterizare. În
 * cazul unei piste de decolare, prioritatea se va face (crescător) în funcție de timpul dorit de
 * decolare al avioanelor. În cazul pistei de aterizare, prioritatea se va face în primul rând dacă
 * avionul este marcat ca având o urgență, și apoi în funcție de timpul dorit de aterizare. Modelați
 * aceste funcționalități într-o singură clasă, nu creați mai multe tipuri de clase pentru diferite tipuri
 * de piste. De exemplu, pe lângă folosirea genericității pentru a diferenția între WideBody și
 * NarrowBody, puteți da ca parametru în constructorul pistei un Comparator pentru diferența
 * de prioritizare dintre decolare/aterizare, cu care să se sorteze/mențină colecția. Clasa Runway
 * va avea o metodă pentru adăugarea unui avion în colecția de programare și o metodă
 * toString() care va returna o descriere a pistei (<ID>, urmat apoi pe cate o linie de
 * descrierea avioanelor programate pe această pistă, în ordinea priorității lor).
 */

import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;

public class Runway<T extends Airplane> {
    private String ID;
    private List<T> airplanes;  // De asemenea, va asigura și faptul că nu se va
                                // putea folosi clasa cu altceva în afară de obiecte de tip avion
    private Comparator<T> comparator; // o colecție internă care gestionează avioanele programate pentru să
                                      // aterizeze/decoleze de aici (care au statusul WAITING_FOR_TAKEOFF sau
                                      // WAITING_FOR_LANDING).

    public Runway(String ID, Comparator<T> comparator) {
        this.ID = ID;
        this.comparator = comparator;
        airplanes = new ArrayList<>();
    }

    public void createRunway(String ID, Utility utility, String airplaneType) {
        if (airplaneType.equals("WideBody")) {
            if (utility == Utility.landing) {
                Runway<WideBodyAirplane> runway = new Runway<>(ID, new LandingComparator());
            } else {
                Runway<WideBodyAirplane> runway = new Runway<>(ID, new TakeoffComparator());
            }
        } else {
            if (utility == Utility.landing) {
                Runway<NarrowBodyAirplane> runway = new Runway<>(ID, new LandingComparator());
            } else {
                Runway<NarrowBodyAirplane> runway = new Runway<>(ID, new TakeoffComparator());
            }
        }
    }

    public void addAirplane(T airplane) {
        airplanes.add(airplane);
        airplanes.sort(comparator);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(ID).append("\n");
        airplanes.forEach(airplane -> stringBuilder.append(airplane).append("\n"));
        return stringBuilder.toString();
    }
}
