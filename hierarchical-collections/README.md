# 📙 Zadanie: Hierarchiczne Kolekcje — instrukcja krok po kroku

Ten dokument prowadzi Cię **segment po segmencie** przez zadanie z pliku `Main.java`.
Odkomentowuj kolejne bloki **dopiero wtedy**, gdy poprzedni segment działa. Każdy poprawnie wykonany etap potwierdza napis w konsoli: `[#SEGMENT-X-OK]` ✅

---

## 🧭 Zasady pracy

* Pracujesz w repozytorium wygenerowanym przez **GitHub Classroom**.
* Kod źródłowy dopisujesz w nowych plikach i pakietach wskazanych poniżej.
* **Nie wklejaj gotowych rozwiązań** do `Main.java` — tam tylko odkomentowujesz linie kontrolne.
* W razie błędów kompilacji cofnij komentarz i popraw implementację.

---

## 🔧 Segment 1 — Model domenowy `Geography`

**Cel:** utworzyć klasę opisującą jednostkę geograficzną.

**Do zrobienia:**

* W pakiecie `model` utwórz klasę **`Geography`** z prywatnymi polami:
  `id`, `name`, `type`, `code`, `parentId` (zwróć uwagę: `parentId` może być **`null`** dla korzenia).
* Dodaj publiczne **gettery** i **settery** do powyższych pól.
* Uruchom projekt z odkomentowanym blokiem SEGMENT‑1 w `Main.java` — powinieneś zobaczyć `[SEGMENT-1-OK]`.

---

## 🧩 Segment 2 — Interfejs generyczny parsera

**Cel:** zdefiniować ogólny kontrakt do „zamiany” linii tekstu na obiekt.

**Do zrobienia:**

* W pakiecie `tools.abstractions` dodaj interfejs **`IParse<TResult>`**.
* Zdefiniuj w nim metodę przyjmującą jeden wiersz danych tekstowych i zwracającą obiekt typu `TResult` (np. „`parse(…)`”).
* Odkomentuj linie SEGMENT‑2 w `Main.java` i sprawdź, czy kompilacja przechodzi.

---

## 🌍 Segment 3 — Parser geografii

**Cel:** stworzyć parser danych dla obiektów `Geography`.

**Do zrobienia:**

* W pakiecie `tools.geographies` dodaj klasę **`GeographyParser`**.
* Niech **implementuje** `IParse<Geography>`.
* Metoda parsująca powinna **odczytać pola z jednej linii tekstu** pochodzącej z `SampleGeographiesData.data` i zwrócić poprawnie wypełnione `Geography`.
* Zadbaj, aby `parentId` poprawnie rozpoznawał brak wartości (np. puste pole/`null` → brak rodzica).
* Odkomentuj SEGMENT‑3 i sprawdź wynik.

---

## 📚 Segment 4 — Wczytanie listy geografii

**Cel:** przekształcić listę linii tekstu w listę obiektów `Geography`.

**Do zrobienia:**

* W `Main.java` odkomentuj pętlę tworzącą kolekcję geografii z `SampleGeographiesData.data`.
* Upewnij się, że **dla każdej linii** tworzony jest obiekt przy użyciu Twojego parsera, a wszystkie obiekty trafiają do listy.
* Po uruchomieniu powinien pojawić się `[SEGMENT-4-OK]`.

---

## 🌳 Segment 5 — Interfejs hierarchii (generyczny)

**Cel:** uogólnić pojęcie elementu w strukturze drzewiastej.

**Do zrobienia:**

* W pakiecie `model.abstractions` utwórz interfejs **`IHaveHierarchicalStructure<TItem>`**.
* Interfejs będzie reprezentował **dowolny element drzewa**, nie tylko geografię.
* Zaimplementuj ten interfejs w klasie `Geography`.

---

## 🧱 Segment 6 — Kontrakt elementu drzewa

**Cel:** doprecyzować metody wymagane od elementu hierarchii.

**Do zrobienia:**

* W interfejsie `IHaveHierarchicalStructure<TItem>` zdefiniuj metody:

  * ustawianie/odczyt rodzica (`setParent(…)`, `getParent()`),
  * dostęp do listy dzieci (`getChildren()` — **zwracaj nie-`null` listę**),
  * identyfikatory (`getId()`, `getParentId()`).
* Upewnij się, że `Geography` spełnia kontrakt (posiada pole na rodzica i kolekcję dzieci, inicjalizowaną tak, by nie było NPE).
* Uruchom SEGMENT‑6.

---

## 👤 Segment 7 — Weryfikacja generyczności na `Person`

**Cel:** sprawdzić, czy Twoje interfejsy są rzeczywiście ogólne.

**Do zrobienia:**

* W `Main.java` **odkomentuj zdefiniowaną klasę `Person`** (na końcu pliku) oraz linie SEGMENT‑7.
* Upewnij się, że `Person` spełnia interfejs i kod się kompiluje.
* Po uruchomieniu oczekuj `[SEGMENT-7-OK]`.

---

## 🧭 Segment 8 — Budowanie drzewa (builder)

**Cel:** z gotowej listy elementów złożyć strukturę rodzic–dziecko.

**Do zrobienia:**

* W pakiecie `tools` utwórz klasę **`HierarchyBuilder<TItem>`** z ograniczeniem typu: `TItem` **implementuje** `IHaveHierarchicalStructure<TItem>`.
* Zapewnij w klasie trzy operacje:

  1. przyjęcie kolekcji elementów,
  2. **zbudowanie powiązań** rodzic–dziecko na podstawie `parentId`,
  3. udostępnienie **korzenia** (element z `parentId == null`).
* Odkomentuj SEGMENT‑8 i upewnij się, że otrzymujesz korzeń całej hierarchii (np. „world” dla geografii).

> 🧩 Wskazówka: Podczas budowania hierarchii warto krótką walidacją wykrywać brak rodzica, wielu korzeni lub pętle — nie jest to obowiązkowe, ale pomaga w diagnozie błędów danych.

---

## 🔁 Segment 9 — Builder działa dla innego typu

**Cel:** potwierdzić generyczność na przykładzie `Person`.

**Do zrobienia:**

* Utwórz builder dla `Person` i zasil go przykładową listą `Person.sample`.
* Zbuduj hierarchię i **sprawdź warunki** weryfikacyjne (metoda pomocnicza w `Person`).
* Po sukcesie zobaczysz `[SEGMENT-9-OK]`.

---

## 🔎 Segment 10 — Nawigacja po drzewie

**Cel:** mieć możliwość wyszukiwania elementu po `id`.

**Do zrobienia:**

* W pakiecie `tools` utwórz klasę **`Hierarchy<TItem>`** ograniczoną tak jak builder.
* Zapewnij możliwość ustawienia **korzenia** oraz wyszukania elementu **po identyfikatorze** (np. przeszukiwanie wszerz lub w głąb).
* Uruchom SEGMENT‑10 i upewnij się, że odnajdziesz wskazany element z danych geograficznych (ID podany w `Main.java`).

---

## 🧪 Segment 11 — Ostateczny test na `Person`

**Cel:** powtórzyć wyszukiwanie z poprzedniego segmentu dla `Person`.

**Do zrobienia:**

* Zbuduj hierarchię `Person`, ustaw korzeń i wyszukaj osobę o **konkretnym `id`** podanym w `Main.java`.
* Po poprawnym wyniku zobaczysz komunikat końcowy oraz `[SEGMENT-11-OK]`.

---

## 📏 Kryteria zaliczenia

* Każdy segment przechodzi **bez błędów kompilacji** i zapewnia oczekiwany komunikat `SEGMENT-X-OK`.
* Implementacje są **generyczne** (nie zależą „na sztywno” od `Geography`).
* Elementy hierarchii nie powodują wyjątków (np. `NullPointerException` przy `getChildren()`).

---

## 🛠️ Najczęstsze potknięcia i wskazówki

* **NPE w `getChildren()`** → inicjalizuj kolekcję dzieci od razu (np. pustą listą).
* **Błędny `parentId`** → traktuj brak wartości jako korzeń; upewnij się, że nie przypisujesz rodzica samemu sobie.
* **Wiele korzeni** → to sygnał problemu w danych; wybierz jeden lub zgłoś błąd (opcjonalnie — według uznania).
* **Niedopasowanie parsera do danych** → dopasuj logikę parsowania do konkretnego formatu `SampleGeographiesData` (separator, kolejność pól, reprezentacja braku wartości).

---

## ✅ Co powinieneś zobaczyć na końcu

W konsoli kończy się komunikatem informującym o powodzeniu i wszystkimi znacznikami segmentów w stylu:
`Udało się !! Wszystko działa :)`
`[SEGMENT-11-OK]`

---
