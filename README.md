# DA121A Final Project 2026
Course: DA121A - Object-Oriented Design

# Sustainable Product & Recycling Management System

## Projektbeskrivning
Ett konsolbaserat Java-program för att hantera produkter och material, beräkna miljöpåverkan och ge återvinningsråd.  
Systemet är byggt med lagerarkitektur och implementerar Strategy-designmönstret för att möjliggöra flexibla och utbytbara beräkningsmetoder.

## Group members and roles
| Namn   | Roll         | Ansvar                                   |
|--------|--------------|------------------------------------------|
| Angela | Kravanalys   | Kravdokumentation, testning, acceptance criteria |
| Hamda  | Git-ansvarig | Versionshantering, branch-strategi, CI-konfiguration |

## Working process and Git flow
- main-branch är skyddad  
- Allt arbete sker i feature branches (t.ex. feature/readme-setup)  
- Commits är små och fokuserade  
- Merges sker via pull requests  

## Domänbegrepp
- Product – produkt med namn, kategori, livslängd och material  
- Material – material med miljöpåverkan och återvinningsråd  
- Category – produktkategori  
- Lifespan – beräknad livslängd  
- ImpactCalculationStrategy – strategi för miljöberäkning  

## Funktionella krav
- Skapa produkter med namn, kategori, livslängd och material  
- Lista produkter  
- Visa detaljerad produktinformation  
- Definiera material med namn, miljöpåverkan och återvinningsråd  
- Material ska kunna återanvändas i flera produkter  
- Beräkna total miljöpåverkan  
- Minst två utbytbara beräkningsstrategier  
- Ge återvinningsråd baserat på material  

## Icke-funktionella krav
- Lagerarkitektur (Presentation, Application, Domain)  
- Separation mellan UI och affärslogik  
- Strategy Pattern implementerat  
- JUnit-tester för domänlogik  
- CI med automatiska tester  
- Professionell Git-workflow  
- Dokumentation med UML-diagram  

## Arkitekturöversikt
Systemet är uppdelat i tre lager med tydliga ansvarsområden.  
Beroenden flödar endast nedåt, där presentation beror på application och application beror på domain.  
Domänlagret känner aldrig till lagren ovanför.

### Presentationlager
- ConsoleUI.java – driver huvudloopen och hanterar användarinput  
- Menu.java – ansvarar för att visa meny och läsa användarens val  

### Applikationslager
- ProductService.java – koordinerar alla operationer.  
  Håller listor av produkter och material samt aktuell strategi.  
  Innehåller metoder som createProduct(), findProductByName() och calculateProductImpact()

### Domänlager
- Product.java – innehåller name, category, estimatedLifespan och en lista av material  
- Material.java – innehåller name, impactValue, recyclingCategory och recyclingInstruction  
- ImpactStrategy.java – interface för beräkning av impact  

## Strategy
Vi använder Strategy-mönstret för att möjliggöra flexibel beräkning av miljöpåverkan.  
Olika strategier kan bytas ut under körning utan att påverka resten av systemet.

Den aktiva strategin lagras i ProductService som ett fält.

### SimpleSumStrategy
Loopar igenom product.getMaterials() och adderar varje materials impactValue till en summa.  
Används när man vill ha en enkel total påverkan.

### WeightedByLifespanStrategy
Loopar igenom product.getMaterials() och multiplicerar varje materials impactValue med en vikt beroende på produktens livslängd.  

- Livslängd < 2 → vikt 1.5  
- Livslängd 2–10 → vikt 1.0  
- Livslängd > 10 → vikt 0.5  

Används när man vill ta hänsyn till hur länge produkten håller.

## Testing
JUnit-tester har implementerats för domänlogik.

Testerna täcker:
- Flera material  
- Tom produkt  
- Ett material  

Alla tester körs med Maven (mvn test) och måste passera innan merge.

## Refactoring
Kod har refaktorerats för att förbättra struktur och läsbarhet.

Exempel:
- Extraherad metod i SimpleSumStrategy för att separera beräkningslogik

Tester användes som säkerhetsnät under refactoringen.

## Länkar till diagram

I denna hittar du länkar till

Uml

Stratergymönster

SequenceDiagram https://docs.google.com/document/d/1C4JcScSQJNpn2JLH-IP6vdh6POTsgL7e3MAAba71T28/edit?usp=sharing
