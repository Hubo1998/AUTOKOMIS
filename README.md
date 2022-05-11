# Autokomis
Aplikacja Zaliczeniowa na przedmiot Programowanie w języku JAVA.

Jest to aplikacja konsolowa w której możemy zagrać w autokomis. Gra jest wieloosobowa, każdy gracz może wykonać jeden ruch w kolejce.

Na początku gry podajemy wartości startowe, ilość graczy oraz ich imiona i ilość pieniędzy na start.  
![image](https://user-images.githubusercontent.com/64363554/167837062-ca177f8f-c4d1-4be4-bbc8-d56ec8afd5e3.png)  
Następnie zaczyna się gra, na górze widzimy czyj ruch aktualnie się wykonuje i ile dany gracz ma na koncie pieniędzy.  
![image](https://user-images.githubusercontent.com/64363554/167837313-bf959c4c-a60b-4eaa-a5a8-00fcb552d3df.png)  
Każdy gracz ma tą samą bazę pojazdów do kupienia oraz początkowych klientów, przy kupieniu reklamy generują się nowi klienci dla każdego gracza. Baza klientów i samochodów generuje się losowo i automatycznie.

Gracz może wykonać określone czynności:
- Kupić samochód (Każdy samochód ma różne defekty, od tego zależy jego cena. Zawsze jest również odejmowane 2% wartości podatku VAT)
- Kupić reklamę (Powiększa się baza klientów o większym budżecie)   
Można wybrać pomiędzy reklamą w gazecie (koszt 1000 - od 0 do 5 nowych klientów) i reklamą w internecie (koszt 250 - pewny 1 klient)
- Wybrać mechanika u którego naprawia samochód (Im droższy tym większa szansa powowdzenia)  
![image](https://user-images.githubusercontent.com/64363554/167839005-bdc25480-65fc-4d1c-9512-c720a6457489.png)  
- Naprawić samochód - po naprawię zwiększa się wartość auta.  
![image](https://user-images.githubusercontent.com/64363554/167840432-994d0b17-a0c7-432d-891f-cb4afd90d3b2.png)  
- Sprzedać samochód klientowi
- Zawsze możemy sprawdzić stan auta, zarówno przed zakupem jak i w garażu.
- Sprawdzić historię transakcji sprzedaży

Gra kończy się w momencie zarobienia określonej kwoty pieniędzy, celem jest dokonanie tego w jak najmniejszej ilości ruchów.
