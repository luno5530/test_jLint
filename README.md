# 2. Übung zur Vorlesung Algorithmen

## 1 - Einfach verkettete Listen

In dieser Aufgabe sollen Sie eine einfach verkettete Liste implementieren.

- Implementieren Sie die Klassen `Node` und `SLList` sowie die Methoden `isEmpty`, `get` und `add` aus der Vorlesung.

- Implementieren Sie die Methode `size` mit Hilfe eines zusätzlichen Attributes, das die Anzahl der Elemente in der Liste speichert.

- Implementieren Sie eine Methode `naiveSize`, welche die Anzahl der Elemente in der Liste zurückliefert ohne das Attribut zu nutzen.

- Verändern Sie Ihre Implementierung so, dass eine `IndexOutOfBoundsException` geworfen wird, wenn eine der Methoden auf einen nicht validen Index zugreift.

- Überlegen Sie sich, wie Sie die Klasse `SLList` um eine `remove`-Methode, wie sie im abstrakten Datentyp Liste definiert ist, erweitern können.
Fertigen Sie eine Zeichnung an, die zeigt, wie die Struktur der einfach verketteten Liste durch diese Methode verändert wird.
Ihre Zeichnung sollte wie die entsprechende Zeichnung für die Methode `add` im Skript verschiedene Fälle berücksichtigen.
Laden Sie ein Bild Ihrer Zeichnung im Ordner `images` hoch.

- Implementieren Sie auf Grundlage Ihrer Zeichnung die `remove`-Methode in der Klasse `SLList`.

## 2 - Gemeinsame Schnittstelle

- Implementieren Sie ein _Interface_ `List`, das die Methoden einer Liste zur Verfügung stellt.

- Machen Sie Ihre Klasse `SLList` zu einer Instanz des _Interface_ `List`.

- Machen Sie Ihre Klasse `ArrayList` ebenfalls zu einer Instanz des _Interface_ `List`, indem Sie eine `remove`-Methode implementieren.
  Ihre Methode muss das Array nicht verkleinert, selbst wenn dies beim Entfernen eines Elementes möglich wäre.
