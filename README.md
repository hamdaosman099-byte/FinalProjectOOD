# DA121A Final Project 2026

> Couse: DA121A - Object-Oriented Design
>

# Sustainable Product & Recycling Management System

## Project description
Ett konsolbaserat program som hanterar produkter och material, beräknar miljöpåverkan och ger återvinningsråd.

## Group members and roles
| Namn | Roll | Ansvar |

|------|------|--------|

| Angela | Kravanalys | Kravdokumentation, testning, acceptance criteria |

| Makram | Domänmodell | UML-diagram, klassdesign, domänlogik |

| Hamda | Git-ansvarig | Versionshantering, branch-strategi, CI-konfiguration |

## Working process and Git flow
- main-branch är skyddad
- Allt arbete sker i feature branches (t.ex. `feature/readme-setup`)
- Commits är små och fokuserade
- Merges sker via pull requests

## Domain concepts (candidate concepts)
- **Product** - produkt med namn, kategori, livslängd och material
- **Material** - material med miljöpåverkan och återvinningsråd
- **Category** - produktkategori
- **Lifespan** - beräknad livslängd
- **ImpactCalculationStrategy** - strategi för miljöberäkning

## Functional requirements
1. Skapa produkter med namn, kategori, livslängd och material
2. Lista produkter
3. Visa detaljerad produktinformation
4. Definiera material med namn, miljöpåverkan och återvinningsråd
5. Material ska kunna återanvändas i flera produkter
6. Beräkna total miljöpåverkan
7. Minst två utbytbara beräkningsstrategier
8. Ge återvinningsråd baserat på material

## Non-functional requirements
1. Lagerarkitektur (Presentation, Application, Domain)
2. Separation mellan UI och affärslogik
3. Strategy Pattern implementerad
4. JUnit-tester för domänlogik
5. CI med automatiska tester
6. Professionell Git-workflow
7. Dokumentation med UML-diagram
