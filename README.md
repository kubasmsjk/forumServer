# forumServer
 
forumServer to server aplikacji webowej w technologi Java przy użyciu Spring Boot oraz Hibernate.  
Projekt powstał w ramach zajęć Programowanie aplikacji biznesowych w oparciu o platformę Java.

## Podstawowe funkcje aplikacji: 
*	przeglądanie/dodawanie/edycja/usuwanie tematów/postów,
*	możliwość moderowania tematów/postów,
*	możliwość obserwowania wybranych tematów z powiadamianiem poprzez e-mail,
*	uwierzytelnianie - przy pomocy Jwt Baerer token.

## Autorzy:
* Jakub Mieczkowski ([@kubasmsjk]( https://github.com/kubasmsjk))
* Bartosz Kraśniewski ([@bartekrul]( https://github.com/bartekrul))
* Rafał Ciupek ([@Rav2408]( https://github.com/Rav2408))

## Instrukcja uruchomienia:
Aby uruchomić projekt należy połączyć się z instancją bazy danych postgres. 
Dane do połączenia należy zmienić w pliku application.yml :
 
### application.yml 
datasource:
   * url: jdbc:postgresql://localhost:5432/forum_database
   * username: postgres
   * password: admin

### Serwer pocztowy
* docker run -p 1080:1080 -p 1025:1025 maildev/maildev
* Do uruchamiania serwera pocztowego należy pobrać dockera oraż w powershellu wpisać powyższą komendę, która na podstawie obrazu stworzy kontener. Należy następnie w przeglądarce wejśc na http://localhost:1080/#/

Następnie budujemy aplikacje przy pomocy polecenia:
* mvn clean install

I uruchamiamy ją przy pomocy polecenia
* mvn spring-boot:run