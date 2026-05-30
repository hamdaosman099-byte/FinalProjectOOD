# DA121A Final Project 2026

> Couse: DA121A - Object-Oriented Design
>

# Sustainable Product & Recycling Management System

## Projektbeskrivning
Ett konsolbaserat Java-progrema för att hantera produkter och material, beräkna miljöpåverkan och ge återvinningsråd. Systemet är buggt med lagerarkitektur och implementerar Stratergy-designmönstret för att möjliggöra flexibla och utbytbara beräkningmetoder.

## How to run

1. Öppna projektet i terminalen
2. Skriv:
   mvn compile
3. Kör sedan:
   mvn exec:java

## Group members and roles
| Namn | Roll | Ansvar |

| Angela | Kravanalys | Kravdokumentation, testning, acceptance criteria |

| Hamda | Git-ansvarig | Versionshantering, branch-strategi, CI-konfiguration |

## Working process and Git flow
- main-branch är skyddad
- Allt arbete sker i feature branches (t.ex. `feature/readme-setup`)
- Commits är små och fokuserade
- Merges sker via pull requests

## Domänbegrepp
- **Product** - produkt med namn, kategori, livslängd och material
- **Material** - material med miljöpåverkan och återvinningsråd
- **Category** - produktkategori
- **Lifespan** - beräknad livslängd
- **ImpactCalculationStrategy** - strategi för miljöberäkning

## Funktionella krav
1. Skapa produkter med namn, kategori, livslängd och material
2. Lista produkter
3. Visa detaljerad produktinformation
4. Definiera material med namn, miljöpåverkan och återvinningsråd
5. Material ska kunna återanvändas i flera produkter
6. Beräkna total miljöpåverkan
7. Minst två utbytbara beräkningsstrategier
8. Ge återvinningsråd baserat på material

## Icke-funktionella krav
1. Lagerarkitektur (Presentation, Application, Domain)
2. Separation mellan UI och affärslogik
3. Strategy Pattern implementerad
4. JUnit-tester för domänlogik
5. CI med automatiska tester
6. Professionell Git-workflow
7. Dokumentation med UML-diagram

## Arkitekturöversikt
Systemet är uppdelat i tre lager med tydliga ansvarområden. Beroanden flödar endast nedåt då presentation beror på application, application beror på domain. Domänlagret känner aldrig till lagren ovanför.

### Presentationlager
ConsoleUI.java - driver hela huvudloopen. Anropar menu.showMenu() och menu.readChoice(), sen diregeras valet vidare via handleChoice(int choice)

Menu.java - ansvarar enbart för att skriva ut menyalternativ och läsa användarens val via Scanner. 

### Applikationlager 
Productservice.java - denna koordinerar all operationer. Håller två ArrayList samlingar (products och material) samt en referens till aktiv ImpactStrategy. Metoder t.ex createProduct(), findProductByName() , calculateProductImpact() och så vidare.

### Domänlager 
Product.java - innehpller name, category, estimatiedLifespan och en List<Material. Metoder : addMaterial(Material m) och getMaterials()

Material.java - innehåller name, impactValue, recyclingCategpry pch recyclingInstuctioner.
Metoder : getImpactValue() och getRecyclingGuidance()

ImpactStratergy.java - gränssnitt med en metod double calculateImpact(Product product). Implementeras av SimpleSumStragery och WieghtedByÖifespanStragery.


## Stragery
Vi använder stragery möndtret för att möjliggöta flexibel beräkning av miljöpåverkan Olika stratergier kan bytas ut under körning utan att ändra det övriga systermet.

Den aktiva strategin lagras i ProductServise som ett fält i private ImpactStratergy Stragery.

### SimpleSumStragery 
Finns i domain/SimpleSumStrategy.java. Loopar Igenom product.getMaterials() och adderar varje m.getImpactValue() till en löpande summa. Används när man vill ha enkelt poäng utan justeringar.

### WeightedBytLifespanStrategy
FInns i domain/SimpleSumStrategy.java. Loopar igenom product.getMaterials() och adderar varje m.getImpactValue(). Tillämpar en vikt innan multicering.Om livsLängd < 2 vikten 1.5, 2-10 vikt 1.0, livslängd >10  vikt 0.5. Anvönds nör man vill ha ett poänd som tar hänsyn till hur länge produkten håller.


## Länkar till diagram
I denna hittar du länkar till 
- Uml
- Stratergymönster
- SequenceDiagram
https://docs.google.com/document/d/1C4JcScSQJNpn2JLH-IP6vdh6POTsgL7e3MAAba71T28/edit?usp=sharing
  
