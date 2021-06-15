# SEM6_PT_Projekt
### Baza danych oraz aplikacja wspomagająca pracę projektanta systemu telefonii internetowej

Wymagania dotyczące sprzętu i oprogramowania 
Najsłabsza specyfikacja komputera na której testowane było oprogramowanie (poprawne działanie aplikacji na słabszej specyfikacji nie jest pewne): 

•	System operacyjny: Windows 7 64-bit, <br />
•	Procesor: procesor o taktowaniu 1 GHz, <br />
•	Karta graficzna: Intel HD Graphics 4000,<br />
•	Pamięć RAM: 2 GB, <br />
•	Miejsce na dysku: 40 MB<br />
•	Java Development Kit 15.0.1, <br />
•	Java 8 Update 121.<br />

Aplikacja działa także na komputerach mających lepsze podzespoły od tych przedstawionych powyżej. 

Instalacja:

Aplikację należy pobrać ze strony jej poświęconej (https://github.com/Ania-Korpys/SEM6_PT_Projekt/tree/executable) poprzez kliknięcie przycisku „Code” → „Download ZIP”, a następnie rozpakować. Aplikacja i baza danych nie wymaga instalacji. Aby skorzystać z aplikacji należy uruchomić plik wykonywalny „VoIPAssistant.exe”. W celu poprawnego działania aplikacji plik wykonywalny „VoIPAssistant.exe” oraz plik bazy danych „SQLite_voip.db” muszą znajdować się w tym samym folderze. Przed uruchomieniem aplikacji należy upewnić się, iż posiadamy na komputerze zainstalowaną odpowiednią wersję środowiska Java (Java 8 Update 121 lub nowsza oraz Java Development Kit 15.0.1 lub nowsza). <br />


Instrukcja obsługi:

W celu znalezienia informacji o kodekach o pożądanych przez nas parametrach w dolnej części okna aplikacji należy wybrać odpowiednią opcję z listy lub wpisać wartość parametru (w zależności od rodzaju interesującego nas parametru). Użytkownik ma możliwość postawienia warunków dotyczących więcej niż jednego parametru. Uzupełnienie każdego z pól jest opcjonalne. Po ustaleniu kryteriów należy wcisnąć przycisk „Szukaj”, który spowoduje wyświetlenie się wyników spełniających ustalone kryteria.

W celu zresetowania wartości pól należy wcisnąć przycisk „Reset”. 

W celu zapisania wyświetlonych wyników w formie pliku o rozszerzeniu .txt należy wcisnąć przycisk „Zapisz”. Utworzony dzięki temu plik z wynikami znajduje się w tym samym folderze, w którym użytkownik przechowuje aplikację. 

W celu posortowania wyników rosnąco względem wartości danego parametru należy kliknąć na nagłówek interesującej użytkownika kolumny (w przypadku kolumny z wartościami liczbowymi zostanie ona posortowana od najmniejszej wartości do największej, w przypadku gdy interesująca użytkownika kolumna zawiera wartości tekstowe, kolumna zostanie posortowana od a do z). W celu posortowania wyników malejąco należy kliknąć nagłówek ponownie.  

W celu zmiany szerokości kolumny należy wcisnąć i przytrzymać lewy przycisk myszy na granicy pomiędzy dwoma interesującymi użytkownika kolumnami, a następnie przeciągnąć je w lewo lub w prawo. 

W celu zmian kolejności wyświetlanych kolumn należy wcisnąć i przytrzymać lewy przycisk myszy na nagłówku kolumny, a następnie przeciągnąć ją w lewo lub w prawo na interesującą użytkownika pozycję. 

W celu skorzystania z pomocy kontekstowej  użytkownik może skierować kursor myszy na nagłówek kolumny. Po krótkim czasie wyświetli mu się podpowiedź. Podobne podpowiedzi można uzyskać po skierowaniu kursora na przyciski „Szukaj”, „Zapisz”, „Reset” oraz listy z wyborem wartości parametrów. 
