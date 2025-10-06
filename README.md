# 🌍 Projekt: Hierarchiczne Kolekcje w Javie

### 🎯 Cel projektu

Celem tego zadania jest **zrozumienie i praktyczne zastosowanie typów generycznych (ang. generics)** w języku Java poprzez budowę prostego systemu reprezentującego **struktury hierarchiczne** (np. geograficzne, organizacyjne, rodzinne).

Projekt wprowadza kolejne koncepcje krok po kroku — każdy segment kodu w pliku `Main.java` prowadzi Cię przez kolejne etapy implementacji. Twoim zadaniem jest **odkomentowywanie fragmentów** i **uzupełnianie kodu** tak, aby wszystkie testy segmentowe (`[SEGMENT-X-OK]`) przechodziły pomyślnie ✅.

---

### 🧩 Zakres projektu

W trakcie realizacji zadania:

1. Utworzysz klasę modelu danych `Geography`, opisującą jednostkę geograficzną (np. kraj, region, miasto).
2. Zaimplementujesz **interfejs generyczny `IParse<TResult>`**, który pozwoli zamieniać dane tekstowe na obiekty.
3. Utworzysz parser `GeographyParser`, przekształcający dane tekstowe w obiekty klasy `Geography`.
4. Zdefiniujesz **interfejs generyczny dla struktur hierarchicznych** – `IHaveHierarchicalStructure<TItem>`.
5. Wykorzystasz go w `Geography` oraz dodatkowej klasie `Person` (do testów generyczności).
6. Zaimplementujesz **builder hierarchii** (`HierarchyBuilder<TItem>`), który łączy elementy w strukturę drzewiastą.
7. Stworzysz **nawigator hierarchii** (`Hierarchy<TItem>`), pozwalający wyszukiwać elementy po identyfikatorze.

Każdy etap zakończony poprawnym działaniem potwierdzony jest komunikatem w konsoli w stylu:

```
[SEGMENT-5-OK]
```

---

### 🧠 Wiedza, którą zdobędziesz

* definiowanie i implementowanie **interfejsów generycznych**,
* ograniczanie typów za pomocą `extends`,
* budowanie **hierarchii obiektów** przy użyciu relacji rodzic–dziecko,
* praca z kolekcjami (`List`, `Map`),
* tworzenie uniwersalnych struktur działających dla różnych typów danych,
* podstawy metodyki **Test Driven Development (TDD)**.

---

### 🧪 Testowanie i ocena

Każdy segment kodu w `Main.java` zawiera test w formie komunikatu.
Zadanie jest przygotowane do automatycznego sprawdzania na **GitHub Classroom** — każdy poprawnie przechodzący segment to 1 punkt 💯.

> 💡 Wskazówka: Buduj kod iteracyjnie — **odkomentuj kolejny segment dopiero wtedy**, gdy poprzedni działa.

---

### 🌐 Kontekst i przykład

Struktury hierarchiczne występują często w rzeczywistych systemach informatycznych, np.:

* 📍 struktury geograficzne (kontynent → kraj → region → miasto),
* 🧬 drzewa genealogiczne (rodzic → dziecko),
* 🏢 hierarchie organizacyjne (firma → dział → zespół → pracownik).

Twoim zadaniem jest stworzenie **uniwersalnego mechanizmu**, który może działać dla wszystkich powyższych przypadków — wystarczy zmiana typu generycznego!

---

### 🚀 Efekt końcowy

Po ukończeniu projektu:

* zbudujesz i zrozumiesz **pełną strukturę hierarchiczną** w Javie,
* przetestujesz ją na dwóch niezależnych typach (`Geography`, `Person`),
* uzyskasz komunikat końcowy w konsoli:

```
Udało się !! Wszystko działa :)
[SEGMENT-11-OK]
```

