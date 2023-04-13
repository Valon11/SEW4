# 4305_AirPort

## Aufgabe:
Entwickle auf Basis von 4304_NetworkProtocols eine Flughafenverwaltung.

Sowohl Server als auch Clients können als Konsolenanwendung implementiert werden.

### Server
Der Server verwaltet die Flugzeuge in einer zentralen Collection.
- mehrere Clients können gleichzeitig mit dem Server kommunizieren
- die Kommunikation erfolgt über das eigens definierte Protokoll
- der Zugriff auf die Collection ist vor gleichzeitigem Zugriff zu schützen

### Client
- baut Verbindung mit Server auf Port 6400 auf
- mehrere Clients können theoretisch gleichzeitig auf den Server zugreifen

### Protokoll
Definiere ein Netwzerk Protokoll, welches folgende Kommandos unterstützt:
- "ADD": pflegt ein neues Flugzeug in den Bestand ein
- "DEL name": löscht das Flugzeug mit dme Namen "name"
- "GET name": liest die verfügbaren Daten des Flugzeugs mit dem Namen "name"
- "GETALL": liest alle gespeicherten Flugzeuge aus
- "QUIT": beendet die Netzwerkverbindung
