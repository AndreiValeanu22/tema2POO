# Proiect Java: Sistem de Gestionare a Avioanelor și Pistelor

## 1. Scenariul practic

Acesta este un sistem care gestionează avioanele și pistele de aterizare/decolare. Sistemul include diverse tipuri de avioane (WideBody și NarrowBody) și permite gestionarea programărilor pe piste de aterizare sau decolare, în funcție de prioritatea avioanelor. Pistele sunt definite generic pentru a accepta tipuri de avioane diferite și pentru a menține ordinea de prioritate a decolării sau aterizării avioanelor.

### Arhitectura sistemului:

- **Clasa `Airplane`**: Reprezintă un avion cu detalii precum modelul, ID-ul zborului, locațiile de plecare și destinație, statusul decolării și timpii dorit și real de decolare.
- **Clasele derivate `NarrowBodyAirplane` și `WideBodyAirplane`**: Reprezintă avioanele de tip Narrow Body și Wide Body, fiecare cu numărul de motoare.
- **Clasa `Runway`**: Gestionează o pistă de aterizare sau decolare, care poate accepta doar avioane de un anumit tip (WideBody sau NarrowBody), și asigură ordonarea lor în funcție de prioritatea decolării sau aterizării.
- **Enum-urile `Status` și `Utility`**: Reprezintă statusul avionului și utilitatea pistei (aterizare sau decolare).

### Diagrama bloc a sistemului:
[Airplane] --(Date avion)--> [Status zbor]
[Runway] --(Gestionare avioane)--> [Airplane] --(Programare pe pistă)

## 2. Funcționarea sistemului

Sistemul permite gestionarea programărilor de decolare și aterizare ale avioanelor pe piste, ținând cont de tipul de avion (NarrowBody sau WideBody) și de statusul său.

### Detalii funcționalități:
- **Clasa `Airplane`**: Stochează detalii despre fiecare avion, cum ar fi modelul, ID-ul zborului, plecarea și destinația. Statusul decolării este setat la `WAITING_FOR_TAKEOFF` implicit.
- **Clasele derivate `NarrowBodyAirplane` și `WideBodyAirplane`**: Permite detalierea avioanelor în funcție de numărul de motoare.
- **Clasa `Runway`**: Permite adăugarea unui avion pe pistă și ordonarea acestora în funcție de priorități. Pistele de decolare sunt ordonate crescător în funcție de timpul dorit de decolare, iar pistele de aterizare țin cont de urgență și timpul dorit de aterizare.
- **Comenzi și fișiere de intrare**: Clasa `Main` citește comenzile din fișierele de intrare și le procesează, creând piste și programând avioane.

## 3. Lista componente necesare

- **Java Development Kit (JDK)**: Versiunea 8 sau mai mare
- **IDE**: Oricare editor Java (de exemplu, IntelliJ IDEA, Eclipse)
- **Fișiere de intrare și ieșire**: Sistemul se bazează pe fișierele de intrare din `src/main/resources/` pentru a primi comenzile și pentru a scrie rezultatele într-un format specificat.
