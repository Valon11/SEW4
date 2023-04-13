# 4001_FileConverterFX

## Konvertierungsprogramm  CSV <-> binär <-> ObjectStream

### Erläuterungen
Von moderner Software wird erwartet, dass sie Daten in möglichst vielen Formaten exportieren bzw. importieren kann.
Für den Austausch von Tabellen stellt das CSV-Format oftmals den kleinsten gemeinsamen Nenner der beteiligten Systeme dar.
Dieses wird von vielen Tabellenkalkualtionen gelesen und geschrieben. 
Auch Individualsoftware nutzt das CSV-Format sehr häufig für den Datenaustausch mit anderen Systemen für den Import bzw. 
Export.

Im reinen Java-Umfeld besteht darüber hinaus die Möglichkeit, Daten binär als DataStream bzw. direkt als ObjectStream zu 
speichern bzw. zu übertragen. 

Beiden Varianten ist gemeinsam, dass die Erzeugung und fehleranfällige Auswertung von Texten (Parsen) entfällt und das
Bitmuster der Werte weitgehend unverändert gespeichert/geladen wird. Der Aufbau der beteiligten Klassen 
(Pupil, School, …) muss ident sein und die Reihenfolge der Variablen/Datentypen (Integer, Pupil, …) ist beim 
Schreiben/Lesen penibelst einzuhalten.

### Auftrag
- Erstelle ein Java-Konvertierungsprogramm für Schülerlisten, das aus wahlweise aus CSV-/DataStream-/ObjectStream-Objekten lesen 
  bzw. in diese schreiben kann. 
- Verwende folgende Dateiendungen:
    - .csv für CSV Dateien
    - .dst für Binärdaten (DataStream)
    - .ost für ObjektStreams
- Das Programm soll eine grafische Schnittstelle (GUI) haben, welche mittel JavaFX zu realisieren ist
    - Überlege dir, wie der User entscheiden kann, welche Dateien er liest und in welche er schreibt
    - zur Auswahl der Quell- und Zieldatei ist ein FileChooser zu verwenden
    - Sofern der Dateityp csv ist, soll der User das Spaltentrennzeichen wählen können (tab, semicolon, period, …).
- Als Eingabedatei kann Schuelerliste_20131003-shuffled.csv benutzt werden. 
- Die Spaltenüberschriften können zur Vereinfachung ignoriert werden.
- Speichere intern die Daten in möglichst gut geeigneten Collections von Schulklassen mit darin enthaltenen Schülern.
    - Aus diesem Datenbestand ist zu exportieren bzw. in diesen zu importieren 