# PSISK_PROJECT
# Badanie wydajności wybranych technologii wykorzystywanych w architekturze mikroserwisowej

## Wstęp
Architektura mikroserwisowa zyskuje na popularności dzięki swojej elastyczności, skalowalności i możliwości łatwego zarządzania poszczególnymi komponentami aplikacji. W ramach tej pracy zbadamy wydajność wybranych technologii komunikacyjnych stosowanych w tej architekturze, mianowicie SOAP oraz REST API.

## SOAP
SOAP (Simple Object Access Protocol) to protokół komunikacyjny wykorzystywany do przekazywania informacji pomiędzy różnymi aplikacjami. Jest oparty na języku XML i działa na zasadzie klient-serwer, gdzie klient wysyła zapytanie HTTP z informacjami na temat tego, czego oczekuje od serwera. Serwer odbiera to zapytanie, przetwarza je i wysyła odpowiedź zawierającą poszukiwane przez klienta dane.

### Struktura SOAP
Struktura danych w protokole SOAP opiera się na hierarchicznych elementach XML. Każde żądanie i odpowiedź przekazywane za pomocą SOAP składa się z trzech części: nagłówka, ciała zawierającego komunikat oraz stopki. Dane są pakietowane w formacie XML i wysyłane z użyciem protokołu HTTP.

### Mechanizmy bezpieczeństwa
SOAP dostarcza kompleksowych mechanizmów bezpieczeństwa:
- Podpisywanie cyfrowe
- Szyfrowanie danych
- Uwierzytelnianie
- Zarządzanie uprawnieniami
- Ochrona przed atakami

### Zalety i wyzwania SOAP
Zalety:
1. Interoperacyjność
2. Bezpieczeństwo
3. Rozszerzalność
4. Bezstanowość
5. Obsługa różnych protokołów transportowych
6. Wszechstronność

Wyzwania:
1. Złożoność
2. Wydajność
3. Kompatybilność
4. Rozmiar danych
5. Skalowalność

## REST API
REST (Representational State Transfer) to styl architektury oprogramowania, który definiuje zestaw zasad dla tworzenia rozproszonych systemów. RESTful API (Application Programming Interface) umożliwia komunikację między klientami a serwerami za pomocą standardowych protokołów sieciowych, takich jak HTTP.

### Architektura REST
Architektura REST skupia się na zasobach, reprezentacjach zasobów, interakcjach klienta-serwer oraz bezstanowości. Zasoby są identyfikowane za pomocą URI (Uniform Resource Identifier) i manipulowane za pomocą standardowych operacji HTTP, takich jak GET, POST, PUT i DELETE. Każdy zasób może mieć różne reprezentacje, takie jak XML, JSON lub HTML, które są przesyłane między klientem a serwerem.

### Zastosowanie REST API
RESTful API znajduje zastosowanie w różnych obszarach:
- Tworzenie interfejsów użytkownika w aplikacjach internetowych
- Integracja systemów
- Rozwijanie mikroserwisów
- Tworzenie aplikacji mobilnych

### Wyzwania związane z REST API
Wyzwania:
- Złożoność konfiguracji
- Bezpieczeństwo
- Zarządzanie wersjami
- Wydajność

## Badania
Do badania wydajności mikroserwisów z wykorzystaniem protokołów SOAP i REST API użyto programu JMeter. Za każdym razem w pierwszej kolejności odbywał się pomiar 5 próbek a następnie 100.

### Program JMeter
Apache JMeter to narzędzie do testowania wydajności aplikacji. Umożliwia symulację ruchu sieciowego, testowanie aplikacji webowych oraz monitorowanie wydajności serwerów. JMeter pozwala na tworzenie różnych scenariuszy testowych, generowanie raportów i analizowanie wyników.

### Kabel
Kabel Scharck CAT 6a U/FTP (Unshielded Foiled Twisted Pair) to wysokiej jakości przewód, przeznaczony do transmisji danych w zaawansowanych sieciach komputerowych. Oferuje przepustowość do 10 Gbps przy maksymalnej częstotliwości 500 MHz, co sprawia, że jest idealny do aplikacji wymagających wysokiej szybkości transmisji danych, takich jak serwery, switchy i inne urządzenia sieciowe.

Kabel Scharck CAT 6a U/FTP charakteryzuje się konstrukcją Unshielded Foiled Twisted Pair, gdzie każda para przewodów jest owinięta folią aluminiową. Takie rozwiązanie znacząco zwiększa odporność na zakłócenia elektromagnetyczne (EMI) i przesłuchy (crosstalk), co jest istotne w środowiskach o wysokim poziomie zakłóceń. Zewnętrzny płaszcz kabla wykonany z wytrzymałego tworzywa gwarantuje ochronę przed uszkodzeniami mechanicznymi i wpływami środowiska, co jest szczególnie ważne w przypadku instalacji wymagających trwałości.

### Stanowisko Badawcze
Stanowisko badawcze pozwala na przeprowadzenie bezpośrednich testów wydajnościowych, pomiarów przepustowości oraz analizę zachowania sieci przy użyciu różnych protokołów i konfiguracji. Stanowisko składa się z dwóch komputerów połączonych bezpośrednio za pomocą kabla krosowanego CAT 6, co umożliwia przesył danych z maksymalną przepustowością do 10 Gbps przy częstotliwości do 500 MHz. 

![Wizualizacja stanowiska badawczego](grafiki/topologia_rysunek.jpg)

Takie połączenie jest idealne do testowania aplikacji sieciowych, serwerów oraz innych urządzeń sieciowych w kontrolowanym środowisku. Testy przeprowadzane na tym stanowisku dostarczają cennych danych na temat opóźnień, przepustowości oraz odporności na zakłócenia, co jest kluczowe dla rozwoju i optymalizacji nowoczesnych rozwiązań sieciowych.

![Zdjęcie stanowiska badawczego](grafiki/topologia_zdjecie.jpg)

Na zdjęciu można zobaczyć faktyczne ustawienie sprzętu używanego w eksperymentach. Dwa laptopy wyposażone w oprogramowanie JMeter umożliwiają dokładne monitorowanie i analizę przesyłanych danych, co jest nieocenione w badaniach nad efektywnością sieci komputerowych.

### Badanie dla poszczególnych protokołów

#### Badanie wydajności mikroserwisów za pomocą HTTP

W ramach badania wydajności mikroserwisów za pomocą protokołu HTTP, przeprowadzono testy wydajności dla różnych typów danych, w tym INT, STRING, SQL i LF, używając protokołów REST i SOAP. Wyniki są przedstawione w tabelach i wykresach poniżej.

##### INT (HTTP)
| Protocol | Sample Time (ms) | Bytes | Sent Bytes | Latency | Connect Time (ms) |
|----------|------------------|-------|------------|---------|-------------------|
| rest     | 3.8              | 234   | 155        | 3.4     | 0.2               |
| soap     | 11.4             | 530   | 484.2      | 11.2    | 0.4               |
| rest     | 4.25             | 233.71| 155        | 4.18    | 0.03              |
| soap     | 8.32             | 529.14| 484.42     | 8.3     | 0.02              |

![Wykres przedstawiający wyniki badania mikroserwisu dla INT](grafiki/http_INT.jpg)

*Interpretacja:* REST wykazuje niższy czas odpowiedzi i niższą latencję w porównaniu do SOAP, co sugeruje większą efektywność REST w lekkich operacjach HTTP.

##### STRING (HTTP)
| Protocol | Sample Time (ms) | Bytes | Sent Bytes | Latency | Connect Time (ms) |
|----------|------------------|-------|------------|---------|-------------------|
| rest     | 5                | 166   | 196        | 5       | 0.4               |
| soap     | 8.8              | 518   | 489        | 8.8     | 0.6               |
| rest     | 1.28             | 165.71| 196        | 1.28    | 0.01              |
| soap     | 8.74             | 518   | 489        | 8.68    | 0.02              |

![Wykres przedstawiający wyniki badania mikroserwisu dla STRING](grafiki/http_string.jpg)

*Interpretacja:* REST ponownie osiąga lepsze wyniki niż SOAP, co podkreśla jego przydatność dla prostych transakcji danych.

##### SQL (HTTP)
| Protocol | Sample Time (ms) | Bytes | Sent Bytes | Latency | Connect Time (ms) |
|----------|------------------|-------|------------|---------|-------------------|
| rest     | 20.8             | 348   | 133        | 20.4    | 0.4               |
| soap     | 18.33            | 626.67| 473.17     | 18.33   | 0.5               |
| rest     | 22.855           | 347.71| 133        | 22.81   | 0.02              |
| soap     | 16.42            | 629.68| 473.65     | 16.39   | 0.04              |

![Wykres przedstawiający wyniki badania mikroserwisu dla SQL](grafiki/http_SQL.jpg)

*Interpretacja:* SOAP wykazuje ogólnie niższą latencję i czas odpowiedzi w porównaniu do REST, co może sugerować, że dla bardziej złożonych zapytań bazy danych SOAP jest bardziej odpowiedni, zapewniając stabilniejsze i szybsze przetwarzanie danych.

##### LF (HTTP)
| Protocol | Sample Time (ms) | Bytes | Sent Bytes | Latency | Connect Time (ms) |
|----------|------------------|-------|------------|---------|-------------------|
| rest     | 27.8             | 237   | 980155.6   | 25.8    | 6                 |
| soap     | 68.2             | 583   | 1306775    | 68.2    | 1.6               |
| rest     | 15.25            | 208   | 980146.01  | 15.02   | 1.28              |
| soap     | 74.61            | 583   | 1306775    | 74.51   | 0.08              |

![Wykres przedstawiający wyniki badania mikroserwisu dla LF](grafiki/http_LF.jpg)

*Interpretacja:* REST okazuje się być znacznie bardziej efektywny w zakresie czasu odpowiedzi i latencji w porównaniu do SOAP. Mimo większych rozmiarów przesyłanych danych, REST demonstruje lepszą wydajność, co jest kluczowe przy transmisji dużych objętości danych.

#### Badanie wydajności mikroserwisów za pomocą HTTPS

W ramach badań przeprowadzono testy wydajności mikroserwisów korzystających z protokołów REST i SOAP za pośrednictwem HTTPS. Analiza wyników wskazuje na różnice w czasach odpowiedzi oraz przesyłanych danych między oboma protokołami.

##### INT (HTTPS)
| Protocol | Sample Time (ms) | Bytes | Sent Bytes | Latency | Connect Time (ms) |
|----------|------------------|-------|------------|---------|-------------------|
| rest     | 15.2             | 234   | 155        | 15.2    | 9.4               |
| soap     | 22.0             | 529.8 | 484.4      | 22.0    | 14.6              |
| rest     | 3.08             | 233.71| 155        | 2.9     | 0.48              |
| soap     | 7.54             | 529.28| 484.51     | 7.49    | 0.56              |

![INT HTTPS Results](grafiki/https_INT.png)

*Interpretacja:* REST wykazuje lepszą wydajność w szyfrowanych połączeniach, co jest istotne dla aplikacji wymagających szybkiej i bezpiecznej komunikacji.

##### STRING (HTTPS)
| Protocol | Sample Time (ms) | Bytes | Sent Bytes | Latency | Connect Time (ms) |
|----------|------------------|-------|------------|---------|-------------------|
| rest     | 9                | 166   | 196        | 9       | 7                 |
| soap     | 20               | 518   | 489        | 20      | 14.2              |
| rest     | 1.48             | 165.71| 196        | 1.48    | 0.35              |
| soap     | 5.91             | 518   | 489        | 5.87    | 0.67              |

![STRING HTTPS Results](grafiki/https_STRING.png)

*Interpretacja:* REST ponownie osiąga lepsze wyniki niż SOAP, podkreślając swoją skuteczność w szybkich odpowiedziach nawet w bezpiecznych połączeniach.

##### SQL (HTTPS)
| Protocol | Sample Time (ms) | Bytes | Sent Bytes | Latency | Connect Time (ms) |
|----------|------------------|-------|------------|---------|-------------------|
| rest     | 34.8             | 348   | 133        | 34.8    | 9.2               |
| soap     | 39.4             | 625.4 | 473.8      | 39.4    | 15.6              |
| rest     | 20.58            | 347.71| 133        | 20.57   | 0.48              |
| soap     | 15.60            | 626.96| 473.66     | 15.58   | 0.72              |

![SQL HTTPS Results](grafiki/https_SQL.png)

*Interpretacja:* W przypadku zapytań SQL, różnice w wydajności między REST a SOAP są mniejsze, ale REST nadal utrzymuje przewagę w szybkości odpowiedzi.

##### LF (HTTPS)
| Protocol | Sample Time (ms) | Bytes | Sent Bytes | Latency | Connect Time (ms) |
|----------|------------------|-------|------------|---------|-------------------|
| rest     | 103.4            | 237   | 980153.8   | 103.4   | 58.4              |
| soap     | 179.8            | 583   | 1306775    | 179.8   | 34.8              |
| rest     | 43.92            | 208   | 980147.9   | 43.62   | 5.88              |
| soap     | 161.52           | 583   | 1306775    | 161.35  | 6.03              |

![LF HTTPS Results](grafiki/https_LF.png)

*Interpretacja:* Dla dużych plików, REST wykazuje znacznie lepszą wydajność, co jest kluczowe przy obsłudze dużych wolumenów danych w bezpiecznym środowisku.
##### Wnioski dla HTTPS
W ramach badań przeprowadzono testy wydajności mikroserwisów korzystających
z protokołów REST i SOAP za pośrednictwem HTTPS. Analiza wyników wskazuje
na różnice w czasach odpowiedzi oraz przesyłanych danych między oboma protokołami.
Protokół REST w wersji HTTPS, podobnie jak w przypadku HTTP, generalnie
osiągał lepsze wyniki niż SOAP. REST wykazywał mniejsze czasy odpowiedzi oraz
mniejszą latencję, co podkreśla jego efektywność w szyfrowanych połączeniach. Wynika
to z mniejszego narzutu, który REST wprowadza, dzięki czemu jest bardziej odpowiedni
dla aplikacji wymagających szybkich odpowiedzi i mniejszych opóźnień, nawet
w bezpiecznych połączeniach.
Dla danych typu INT i STRING, REST API wyraźnie przewyższał SOAP, osiągając
krótsze czasy odpowiedzi i mniejsze latencje. W przypadku bardziej złożonych
operacji, takich jak zapytania SQL, różnice były mniej wyraźne, ale REST nadal utrzymywał
przewagę w większości przypadków. Dla dużych plików (LF), REST API także
wykazał znacznie lepszą wydajność w porównaniu z SOAP, co jest istotne przy przesyłaniu
dużych objętości danych.

#### Zestawienie pomiarów dla poszczególnych typów

##### INT
Wyniki dla INT pokazują wyraźne różnice między protokołami REST i SOAP pod względem czasu odpowiedzi i latencji.

![Wykres przedstawiający wyniki badania mikroserwisów INT](grafiki/INT.png)

##### STRING
Dla typu danych STRING, REST wykazał lepszą wydajność niż SOAP, co podkreśla jego skuteczność w szybkich transakcjach.

![Wykres przedstawiający wyniki badania mikroserwisów STRING](grafiki/STRING.png)

##### SQL
W przypadku zapytań SQL, wyniki były bardziej zrównoważone, ale zazwyczaj REST miał lepszą wydajność w porównaniu do SOAP.

![Wykres przedstawiający wyniki badania mikroserwisów SQL](grafiki/SQL.png)

##### LF
Dane dotyczące dużych plików (LF) pokazały, że REST jest znacznie bardziej efektywny w zakresie zarządzania dużymi wolumenami danych.

![Wykres przedstawiający wyniki badania mikroserwisów LF](grafiki/LF.png)




#### Wnioski do eksperymentu
Na podstawie przeprowadzonych badań można stwierdzić, że zarówno SOAP, jak i REST API mają swoje zalety i wady. REST API charakteryzuje się krótszym czasem odpowiedzi i mniejszymi opóźnieniami, co czyni go bardziej wydajnym w zastosowaniach wymagających szybkich odpowiedzi. SOAP oferuje lepsze mechanizmy bezpieczeństwa i niezawodność, co może być kluczowe w aplikacjach wymagających wysokiego poziomu bezpieczeństwa i integralności danych.

### Analiza i interpretacja
REST generalnie zapewnia szybsze odpowiedzi niż SOAP we wszystkich testowanych typach danych, szczególnie w bezpiecznym środowisku HTTPS, gdzie różnice w wydajności są najbardziej zauważalne. Oba protokoły wykazują pewne pogorszenie wydajności przy przejściu z HTTP na HTTPS, jednak REST utrzymuje bardziej stabilne i bliższe poziomy wydajności między tymi protokołami, co sugeruje lepsze radzenie sobie z narzutem szyfrowania.


