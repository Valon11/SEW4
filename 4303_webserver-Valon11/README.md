# 4303_WebServer

## Aufgabe:
Implementiere einen einfachen/abgespeckten HTTP Server und einen grafischen Client (keinen Browser, sondern ein "Entwicklungstool")

### Anforderungen Web-Server:
- Webserver, welcher nur `HTTP GET` versteht (und keine Query Strings!)
- Folgende [HTTP Resonse Status Codes](https://developer.mozilla.org/de/docs/Web/HTTP/Status) sind zu implementieren und korrekt je Anwendungs-/Fehlerfall an den Client zu retournieren
  - 200: OK
  - 400: 400 Bad Request
  - 404 Not Found
- Der Server muss Text und Binärdateien unterstützen
  - teste den Server mit einerm richtigen Webbrowser
  - verwende dazu eine Webseite aus der ersten Klasse MEDT (inkl. CSS, JS und Bilder!)
- Verwende zur Konfiguration deines Servers ein Property-File, folgende Elemente sollen konfigurierbar sein:
  - Portnummer des Webservers (zum Testen)
  - Wurzelverzeichnis (web root) für das Webprojekt (erstelle dazu einen Ornder ```www``` in deinem IntelliJ Projekt
- wird keine Datei in der übergebenen URL vom Client angegeben, so ist nach der Datei `index.htm` im web root zu suchen und gegebenenfalls diese zu retournieren


### Anforderungen HTTP-Client:
- Implementiere einen einfachen JavaFX Webclient, der als "eine Art Debugger/Entwicklungswerkzeug" für einen Webserver verwendet werden kann
- Der User kann die URL eingeben
  - Client implementiert das HTTP Protokoll
  - nimmt Verbindung mit Server auf und holt sich eine HTML Datei
  - Kommunikation mit dem Server ist im grafischen Client anzuzeigen (Textausgabe)
