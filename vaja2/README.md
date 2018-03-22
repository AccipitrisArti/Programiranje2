# Število besed

Sestavi funkcijo, ki sprejme ime datoteke in izpiše število besed v datoteki. Besede so poljubna zaporedja znakov, ločena z enim ali več presledki. Presledki so lahko tudi na začetku in na koncu vrstic. Funkcijo nato dopolni, da bo na izhodno datoteko, katere ime tudi dobi kot parameter, še izpisala vse besede, vsako v svojo vrsto.
# Predor

Dana je datoteka s podatki o prometu skozi predor Golovec za en dan. V vsaki vrstici sta najprej dve celi števili s in t, nato pa še niz r. Števili s in t predstavljata sekundo v dnevu, ko je vozilo vstopilo oz. izstopilo iz predora, r pa predstavlja registrsko tablico vozila. Predpostaviš lahko, da je vozilo vstopilo in izstopilo v istem dnevu in da velja 0 ≤ s < t < 86400. Predor Golovec je dolg 622 m, omejitev hitrosti pa je 80 km/h.

Sestavi funkcijo, ki sprejme ime datoteke s podatki in ime datoteke, v katero boš zapisal izhodne rezultate. Funkcija naj iz vhodne datoteke (tukaj je primer takšne datoteke) prebere podatke in najde vsa vozila, ki so gotovo vozila prehitro, torej tista vozila, katerih povprečna hitrost je bila nad omejitvijo. V izhodno datoteko naj za vsako vozilo, ki je kršilo omejitev, napiše njegovo registrsko tablico in povprečno hitrost (na dve decimalni mesti natančno, za decimalni simbol uporabi piko). Funkcija naj vrne število vseh kršiteljev.
# Frekvence besed

Sestavi funkcijo, ki bo za datoteko z danim imenom preštela, kolikokrat se na njej pojavijo posamezne besede. Presledkov in ločil ne štej k besedam. Funkcija naj vrne slovar, katerega ključi bodo besede, vrednosti pa število pojavitev.

Funkcijo dopolni tako, da besed, ki jih dobi zapisane v neki množici, pri štetju ne bo upoštevala. Pred klicem funkcije napolni množico z besedami iz neke druge datoteke, kjer je vsaka beseda zapisana v svoji vrstici. Primer takšne datoteke dobite tukaj (vir: CLARIN.SI).

Sestavi funkcijo, ki bo za parameter dobila slovar, kakšnega vrne prejšnja funkcija. Sestavi in vrne naj vektor besed iz slovarja, urejen padajoče po frekvencah.

Sestavi tudi funkcijo main, ki bo poklicala prejšnji dve funkciji in izpisala besede v istem vrstnem redu, kot si sledijo v vektorju, skupaj z njihovimi frekvencami.

Program preizkusi na primeru kakšnega romana, npr. Hiša Marije Pomočnice.
