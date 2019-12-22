# Budjetointisovellus
Sovelluksen avulla käyttäjä voi tarkastella omaa kulutustaan kuukausi ja vuositasolla. Käyttäjä voi syöttää tulonsa ja menonsa sovellukseen, jonka jälkeen sovellus kertoo paljon budjetista on käytettävissä.


### Dokumentaatio

* [Työaikakirjanpito](https://github.com/veliblesku/ot-harjoitustyo2019s/blob/master/dokumentaatio/tyoaikakirjanpito.md)
* [Vaatimusmäärittely](https://github.com/veliblesku/ot-harjoitustyo2019s/blob/master/dokumentaatio/vaatimusmaarittely.md)
* [Arkkitehtuurikuvaus](https://github.com/veliblesku/ot-harjoitustyo2019s/blob/master/dokumentaatio/arkkitehtuuri.md)
* [Käyttöohje](https://github.com/veliblesku/ot-harjoitustyo2019s/blob/master/dokumentaatio/kayttoohje.md)

### Komentorivikomennot

## Testaus

Testit suoritetaan komennlla
```
mvn test
```

Testikattavuusraportti komennolla
```
mvn test jacoco:report
```


## Releaset
* [Viikko 5](https://github.com/veliblesku/ot-harjoitustyo2019s/releases/tag/viikko5)

## Jarin generointi
```
mvn package
```

## Checkstyle
[checkstyle.html]()
```
mvn jxr:jxr checkstyle:checkstyle
```

## Ohjelman voi ajaa komentoriviltä komennolla

* mvn compile exec:java -Dexec.mainClass=budjetointisovellus.budjetointisovellus.domain.MainForTesting

