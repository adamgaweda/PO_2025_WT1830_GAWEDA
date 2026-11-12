# PO_2025_WT1830_GAWEDA – Symulacja Świata Zwierząt (oolab)

Projekt realizowany w ramach laboratoriów z przedmiotu **Programowanie Obiektowe** na Wydziale Informatyki AGH (wtorek 18:30).

Projekt przedstawia wielowątkową symulację poruszania się zwierząt na dwuwymiarowej mapie w środowisku wirtualnym z obsługą interfejsu konsolowego oraz graficznego (GUI w JavaFX).

---

## 📋 Spis treści

- [Funkcjonalności](#-funkcjonalności)
- [Architektura i struktura projektu](#-architektura-i-struktura-projektu)
- [Wykorzystane wzorce i techniki](#-wykorzystane-wzorce-i-techniki)
- [Wymagania systemowe](#-wymagania-systemowe)
- [Instrukcja instalacji i uruchomienia](#-instrukcja-instalacji-i-uruchomienia)
- [Testy](#-testy)
- [Struktura katalogów](#-struktura-katalogów)

---

## ✨ Funkcjonalności

- **Wirtualny świat 2D**:
  - `RectangularMap` – zamknięta mapa o stałych wymiarach prostokąta.
  - `GrassField` – otwarta mapa o dynamicznie dopasowujących się granicach, na której rośnie określona liczba kępek trawy.
- **Symulacja zwierząt**:
  - Zwierzęta posiadają pozycję `(x, y)` oraz orientację (kierunki świata: Północ, Południe, Wschód, Zachód).
  - Interpretacja poleceń ruchu (do przodu, do tyłu, skręt o 90° w lewo/prawo) z parsowaniem argumentów (`OptionsParser`).
  - Wykrywanie kolizji ze zwierzętami i ograniczeniami mapy.
- **Wielowątkowość**:
  - `SimulationEngine` umożliwia równoległe uruchamianie wielu instancji symulacji w osobnych wątkach lub przy użyciu puli wątków (`ExecutorService`).
- **Wizualizacja**:
  - **Konsola**: Rysowanie stanu planszy w terminalu (`ConsoleMapDisplay`, `MapVisualizer`).
  - **Graficzny interfejs (JavaFX)**: Dynamiczny widok planszy rysowany na `Canvas` w oparciu o layout FXML (`simulation.fxml`) oraz kontroler `SimulationPresenter`.

---

## 🏛 Architektura i struktura projektu

Projekt zorganizowany jest w module `oolab` z podziałem na pakiety:

- **`agh.ics.oop`**:
  - `World` – punkt wejścia aplikacji konsolowej.
  - `OptionsParser` – parser ciągów znaków na kierunki ruchu (`MoveDirection`).
  - `Simulation` – klasa symulacji implementująca `Runnable`.
  - `SimulationEngine` – silnik do zarządzania i asynchronicznego uruchamiania symulacji.
- **`agh.ics.oop.model`**:
  - `Vector2d` – niemutowalny wektor dwuwymiarowy ze wsparciem operacji wektorowych (`add`, `subtract`, `precedes`, `follows`, `upperRight`, `lowerLeft`).
  - `MapDirection` – enum reprezentujący 4 kierunki geograficzne.
  - `MoveDirection` – enum określający ruch (FORWARD, BACKWARD, LEFT, RIGHT).
  - `Animal` – model zwierzęcia implementujący `WorldElement`.
  - `Grass` – model kępki trawy implementujący `WorldElement`.
  - `WorldMap` & `AbstractWorldMap` – interfejs oraz klasa bazowa logiki mapy.
  - `RectangularMap`, `GrassField` – konkretne implementacje map.
  - `Boundary` – rekord wyznaczający rogi prostokąta obejmującego elementy mapy.
  - `MapChangeListener` – interfejs nasłuchujący zmian na mapie (wzorzec Obserwator).
- **`agh.ics.oop.model.util`**:
  - `MapVisualizer` – formatowanie mapy do postaci tekstowej.
  - `RandomPositionGenerator` – losowe rozmieszczanie elementów bez kolizji.
  - `IncorrectPositionException` – wyjątek sygnalizujący nieprawidłowe położenie.
- **`agh.ics.oop.presenter` & `agh.ics.oop.model.application`**:
  - `SimulationApp` – klasa bazowa aplikacji JavaFX.
  - `WorldGUI` – launcher aplikacji okienkowej.
  - `SimulationPresenter` – kontroler JavaFX (`simulation.fxml`) obsługujący renderowanie planszy na `Canvas` i reakcję na zdarzenia.

---

## 💡 Wykorzystane wzorce i techniki

1. **Wzorzec Obserwator (Observer Pattern)**:
   - Klasy mapy (`AbstractWorldMap`) informują zarejestrowanych słuchaczy (`MapChangeListener`) o zmianie pozycji zwierząt.
   - Wykorzystywany zarówno przez widok konsolowy (`ConsoleMapDisplay`), jak i GUI (`SimulationPresenter`).
2. **Wielowątkowość i asynchroniczność**:
   - `Simulation` jako `Runnable`.
   - `SimulationEngine` z obsługą wątków (`Thread.join()`, `Executors.newFixedThreadPool`).
   - Bezpieczna synchronizacja widoku z wątkiem JavaFX (`Platform.runLater`).
3. **Hermetyzacja i polimorfizm**:
   - Wspólny interfejs `WorldElement` dla `Animal` i `Grass`.
   - Klasa abstrakcyjna `AbstractWorldMap` redukująca duplikację logiki dla różnych typów map.
4. **Separacja interfejsu (MVC / Presenter)**:
   - Deklaratywny widok FXML oddzielony od logiki prezentera i modelu.

---

## 🛠 Wymagania systemowe

- **Java JDK**: wersja 21 lub nowsza (projekt wspiera toolchain Java 21-25)
- **Gradle**: wersja 8.x (lub użycie dołączonego wrappera `gradlew`)
- System operacyjny: Windows / Linux / macOS

---

## 🚀 Instrukcja instalacji i uruchomienia

### 1. Klonowanie repozytorium
```bash
git clone https://github.com/adamgaweda/PO_2025_WT1830_GAWEDA.git
cd PO_2025_WT1830_GAWEDA/oolab
```

### 2. Budowanie projektu
```bash
# Na systemie Windows:
gradlew build

# Na systemach Linux/macOS:
./gradlew build
```

### 3. Uruchomienie aplikacji
Aplikację konsolową można uruchomić za pomocą zadania Gradle:
```bash
gradlew run
```

Uruchomienie interfejsu graficznego (JavaFX):
```bash
gradlew run --args="f b r l"
```
*(lub uruchomienie klasy `WorldGUI` / `SimulationApp` bezpośrednio ze środowiska IDE)*

---

## 🧪 Testy

Projekt posiada zestaw testów jednostkowych napisanych przy użyciu biblioteki **JUnit 5**.

Aby uruchomić testy:
```bash
cd oolab
gradlew test
```
Raport z wykonania testów generowany jest w katalogu `oolab/build/reports/tests/test/index.html`.

---

## 📁 Struktura katalogów

```text
PO_2025_WT1830_GAWEDA/
├── .gitignore
├── README.md
└── oolab/
    ├── build.gradle
    ├── settings.gradle
    ├── gradlew
    ├── gradlew.bat
    └── src/
        ├── main/
        │   ├── java/agh/ics/oop/
        │   │   ├── World.java
        │   │   ├── Simulation.java
        │   │   ├── SimulationEngine.java
        │   │   ├── OptionsParser.java
        │   │   ├── model/
        │   │   │   ├── Animal.java
        │   │   │   ├── Grass.java
        │   │   │   ├── RectangularMap.java
        │   │   │   ├── GrassField.java
        │   │   │   └── ...
        │   │   ├── presenter/
        │   │   │   └── SimulationPresenter.java
        │   │   └── model/application/
        │   │       ├── SimulationApp.java
        │   │       └── WorldGUI.java
        │   └── resources/
        │       └── simulation.fxml
        └── test/
            └── java/agh/ics/oop/
                ├── Vector2dTest.java
                └── model/MapDirectionTest.java
```

---

## 👤 Autor
- **Adam Gawęda** (Wydział Informatyki AGH)
