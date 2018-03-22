# Collatzovo zaporedje

Collatzovo zaporedje tvorimo na sledeč način. Začnemo z nekim naravnim številom n, ki ga nato delimo z 2, če je sodo, ali pa pomnožimo s 3 in prištejemo 1, če je liho. Postopek ponavljamo, dokler ne pridemo do števila 1 (v tem primeru stvar ni več zanimiva, saj se začno ponavljati števila 1, 4, 2, 1, 4, 2, 1, ...). Primer zaporedja, ki se začne z 6, je tako 6, 3, 10, 5, 16, 8, 4, 2, 1. Collatzova domneva, ki trdi, da za poljubno naravno število njegovo Collatzovo zaporedje sčasoma doseže 1, je še vedno nerešena.

    Sestavi funkcijo, ki izračuna dolžino Collatzovega zaporedja, ki se začne s številom n.
    Sestavi funkcijo, ki izračuna največji člen v Collatzovem zaporedju, ki se začne s številom n.
    Sestavi funkcijo, ki izpiše vse člene Collatzovega zaporedja, ki se začne s številom n.

# Razcep naravnega števila

Sestavi funkcijo, ki sprejme naravno število n > 1 in izpiše njegov razcep na prafaktorje. Izpis naj se popolnoma ujema s tistim v spodnjih primerih: urejen naj bo naraščajoče po prafaktorjih in brez eksponentov, ki so enaki 1. Okoli * in = naj bo natanko en presledek.

1024 = 2ˆ10

5761665 = 3ˆ3 * 5 * 7ˆ2 * 13 * 67

# Poudarjanje znakov

Sestavi funkcijo, ki sprejme niz in vrne nov poudarjen niz, v katerem so vsi znaki ločeni z dodatnim presledkom, vse male črke pa predelane v velike. Pazite, da se nov niz ne konča s presledkom. Iz niza "Zadnja novica" bi tako dobili niz "Z A D N J A   N O V I C A".

Sestavi funkcijo, ki sprejme niz in vrne nov niz, v katerem so vse besede, označene z znakoma *, zapisane z velikimi črkami. Iz niza "Zadnja *novica* danes!" bi dobili niz "Zadnja NOVICA danes!". Označenih besed je lahko več, če zaključna zvezdica manjka, pa naj bo  poudarjeno vso besedilo do konca niza.
# Odvod polinoma

Polinome predstavimo s tabelo koeficientov, pri čemer element z indeksom i predstavlja koeficient ob xi (med drugim torej prazna tabela predstavlja ničelni polinom).

Sestavi funkcijo, ki za dani polinom, predstavljen s tabelo koeficientov, vrne njegov n-ti odvod. Poskrbi, da bo funkcijo možno poklicati tudi brez parametra n. V tem primeru naj vrne prvi odvod.

Nekaj primerov: odvod polinoma {1, 2, 3} je polinom {2, 6}, drugi odvod polinoma {4, -1, 2, 0, 1} je polinom {4, 0, 12}, odvod polinoma {1} pa je ničelni polinom {}.
# Vse se začne z ena

Vedno se vse začne z "1". Pa se vprašajmo, kaj vidimo v tem nizu. Eno enko seveda, torej "11". Kaj pa vidimo v tem nizu? Dve enki, torej "21". Kaj pa v tem zadnjem nizu? Eno dvojko in eno enko, torej "1211". Pa zdaj? Eno enko, eno dvojko in dve enki, torej "111221". Pa zdaj?

Sestavi funkcijo, ki bo sestavila in vrnila tabelo, ki bo vsebovala prvih n členov opisanega zaporedja. Členi zaporedja naj bodo nizi (in ne števila).
# Množenje matrik

Sestavi funkcijo, ki zmnoži dve matriki:

public static double[][] zmnozi(double[][] a, double[][] b)

Če matrik ni mogoče zmnožiti, naj funkcija vrne null. Glavni program naj preizkusi, ali funkcija pravilno deluje.
