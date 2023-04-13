# 4403_Trankaktionen_PreparedStatements_Blobs

## Aufgabe:
Ergänze das Blogbeispiel:


- Bilder:
  - Dein Blog soll jetzt zusätzlich Bilder unterstützen, diese sollen als BLOBs in der DB gespeichert werden.
  - Pro Blogeintrag soll ein Bild gespeichert werden können
  - Erstelle dafür eine neue DB Tabelle, sowie entsprechende Methoden zum Ein- und Auslesen von Bildern aus der DB (zu einem bestimmten Blogeintrag)

- Transaktionen:
  - Verwende Transaktionen beim Erstellen eines Blogeintrages (inkl. Bild)
  
- PreparedStatements: 
  - einzelne Blogposts sollen anhand der UserID abgefragt werden
  - erstelle mehrere Abfragen für unterschiedliche User, um dies zu testen
