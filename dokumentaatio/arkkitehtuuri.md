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

