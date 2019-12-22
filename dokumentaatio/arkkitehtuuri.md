# Arkkitehtuurikuvaus


### Käyttöliittymä
Käyttöliittymä koostuu kolmesta eri näkymästä:

* Rekisteröityminen
* Kirjautuminen 
* Budjetoiminen

Jokainen näkymä on toteutettu Scene oliona. Stagessa näkyvissä vain yksi näkymä kerrallaan. 

Näkymän koodi sijaitsee: budjetointisovellus.ui.BudgetingUI .

Käyttöliittymä toteuttaa jonkin verran toiminnallisuuksia, mikä on huono. Suurin osa kuitenkin logiikasta on toteutettu UserService-luokan kautta.



### Sovelluslogiikka



Budjetointisovelluksen luokka- ja pakkauskaavio:

![alt text](https://github.com/veliblesku/ot-harjoitustyo2019s/blob/master/dokumentaatio/arkkitehtivalmis.png "Logo Title Text 1")



### Tietojen talletuksesta

Tiedot tallennetaan jpa-repositoryn avulla omaan tietokantaan. Tietokanta luodaan ohjelman ensimmäisen käynnistyksen yhteydessä sovellushakemiston juureen.  Java Persistance API standardia noudattava jpa-repository noudattaa Object-relational mapping tekniikkaa. 

Käyttäjät tallennetaan User-olioina, jotka pitävät sisällään listan tuloista ja menoista.
Oliot tallettuvat omiin tietokantatauluihin. IncomeRepository hoitaa income-olioiden talletuksesta, kun taas ExpenseRepository hoitaa expense-olioiden talletuksen omaan tietokantatauluunsa. 
Olioille generoidaan id ohjelman avulla.

USERS
ID, name, password, List<Expense>, List<Income>

EXPENSES
ID, name, amount, user

INCOMES
ID, name, amount, user


### Toiminnallisuudet

Tässä hieman sovelluksen pääasiallisia toiminnalisuuksia. Yleisesti ottaen käyttöliittymässä tapahtuvat tapahtumat ovat luotu buttonListener olioiden avulla, jolloin käyttöliittymässä olevaa nappia painaessa tapahtuu määritelty toiminnallisuus. Alemapana listattu ohjelmatason tapahtumia kyseisten toiminnallisuuksien toteutuessa.

#### Käyttäjän rekisteröityminen

Sovelluksen käynnistyessä on mahdollisuus rekisteröityä "create new user" panikkeen takaa.
Kun tekstikenttiin syötetään halutut arvot ja painetaan painiketta "create" sovellus käynnistää seuraavanlaisen toiminnon:

![alt text](https://github.com/veliblesku/ot-harjoitustyo2019s/blob/master/dokumentaatio/rekisteroityminen.png)


#### Käyttäjän kirjautuminen

Kirjautuessa tapahtuma käynnistetään "login" painikkeella. Tällöin tapahtuu seuraavaa.

![alt text](https://github.com/veliblesku/ot-harjoitustyo2019s/blob/master/dokumentaatio/kayttajankirjautuminen.png)

Kun kirjautuminen on onnistunut asetetaan käyttöliittymässä näkymä "budgetingScene".

#### Tulojen ja menojen lisääminen
Käyttäjä voi lisätä tuloja sisäänkirjauduttuaan. Kun käyttäjä lisää uuden menon tai tulon, lisätään näkymän alapuolella olevaan listaan. Tässä on käytetty käyttöliittymän omaa ObservatedList oliota, jonka avulla listaa voidaan päivittää reaaliajassa.

![alt text](https://github.com/veliblesku/ot-harjoitustyo2019s/blob/master/dokumentaatio/addIncomeExpenses.png)



### Ohjelman puutteet

Ohjelmassa on paljon puutteita. Osa sovelluslogiikasta käytännössä toteutetaan käyttöliittymän puolella mikä on aivan turhaa. Kuitenkin kaikki tietokantakyselyt ovat ulkoistettu service luokalle. Käyttöliittymä on myös toteutettu kankeasti yhtenä palikkana, mikä on myös huono. FXML-määrittely olisi ollut parempi.

Ohjelmassa on jäänyt toteuttamatta Budget-luokka, mikä alunperin oli tarkoituksena. Budget luokalla tuli olla paremmat toiminnallisuudet budgettien laskemiseen ja niiden esittämiseen. JPA-Repositoryn ja hibernate välinen kommunikointi kuitenkin tyssäsi useampien listojen käsittelyn ansiosta, jonka takia ohjelmaa on jouduttu ns. suoraviivaistamaan. 
