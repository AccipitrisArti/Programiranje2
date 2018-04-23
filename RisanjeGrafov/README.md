# Vaja3
Enostaven graf je množica točk (vozlišč), pri čemer so nekateri pari točk lahko med seboj povezani. Za predstavitev posamezne točke definiramo razred Tocka, ki lahko poleg imena točke in množice sosednih točk vsebuje še druge podatke o točki (koordinate, barvo, vrednost, ...), ki pa jih zaenkrat ne bomo potrebovali. Ime točke mora enolično določati točko v grafu in je lahko kateregakoli tipa (število, niz, ...). Za predstavitev grafa definiramo razred Graf, ki vsebuje slovar, katerega ključi so imena točk, vrednost posameznega ključa pa je točka s tem imenom.

Sestavi razrede Tocka, Graf in Test. Prvi je namenjen opisu posamezne točke, drugi opisu celotnega grafa, tretji pa preverjanju delovanja prvih dveh.

Razred Tocka naj vsebuje:

    komponenti ime in sosedi
    konstruktor, ki ustvari točko z danim imenom in brez sosedov
    metodo stopnja, ki vrne število sosednjih točk

Razred Graf naj vsebuje:

    komponento tocke (slovar)
    konstruktor, ki sestavi graf brez točk
    metodo tocka, ki vrne točko z danim imenom
    metodo povezava, ki preveri, ali obstaja povezava med danima točkama

    metodo dodajTocko, ki grafu doda dano točko, če točke s tem imenom še ni v grafu
    metodo dodajPovezavo, ki grafu doda povezavo med danima točkama, če sta točki različni in še nista povezani
    metodo odstraniPovezavo, ki iz grafa odstrani povezavo med danima točkama
    metodo odstraniTocko, ki iz grafa odstrani dano točko, še prej pa vse povezave, ki imajo eno krajišče v tej točki

    statično metodo prazen, ki ustvari in vrne nov prazen graf na n točkah
    statično metodo cikel, ki ustvari in vrne nov cikel na n točkah
    statično metodo poln, ki ustvari in vrne nov poln graf na n točkah
    statično metodo polnDvodelen, ki ustvari in vrne nov poln dvodelen graf na n + m točkah

    metodo povezan, ki preveri, ali je graf povezan
    metodo steviloKomponent, ki prešteje, iz koliko povezanih komponent je sestavljen graf

    metodo izpis, ki v pregledni obliki izpiše, katere točke so v grafu in s katerimi točkami so povezane

Razred Test naj vsebuje:

    statično metodo main, ki preveri delovanje metod iz prejšnjih razredov
# Vaja4
Program iz prejšnjih vaj bomo dopolnili tako, da bo možno graf tudi narisati.

1. Razredu Tocka dodaj realni komponenti x in y. Konstruktor naj njuni vrednosti nastavi na 0.

2. Razredu Graf dodaj metodo razporedi, ki bo točke grafa enakomerno razporedila na krožnico s središčem v točki (x, y) polmera r.

3. Sestavi razred Platno, na katerega bomo risali graf. To bo podrazred razreda JPanel. Vsebuje naj:

    komponenti sirina in visina, ki določata velikost platna
    komponento graf, ki določa, kateri graf je narisan na platnu
    konstruktor, ki nastavi začetne vrednosti komponent (širino in višino dobi za parameter, graf nastavi na null)
    metodo narisi(Graf g), ki nastavi nov graf za risanje
    metodo getPreferredSize(), ki vrne nov objekt razreda Dimension, ki določa velikost platna
    metodo paintComponent(Graphics g), ki nariše graf na grafični objekt g (najprej povezave, nato še točke)

4. Sestavi razred Okno, ki bo podrazred razreda JFrame. Vsebuje naj:

    komponento platno
    konstruktor, ki nastavi naslov okna in platno, na katerega bomo risali (platno je treba vstaviti v okno)

5. Dopolni metodo main v razredu Test, tako da bo odprla novo okno, v katerem bo narisala nek graf.
