1. [Introduzione](#introduzione)

  - [Informazioni sul progetto](#informazioni-sul-progetto)

  - [Abstract](#abstract)

  - [Scopo](#scopo)

1. [Analisi](#analisi)

  - [Analisi del dominio](#analisi-del-dominio)

  - [Analisi dei mezzi](#analisi-dei-mezzi)

  - [Analisi e specifica dei requisiti](#analisi-e-specifica-dei-requisiti)

  - [Use case](#use-case)

  - [Pianificazione](#pianificazione)

1. [Progettazione](#progettazione)

  - [Design dell’architettura del sistema](#design-dell’architettura-del-sistema)

  - [Design dei dati e database](#design-dei-dati-e-database)

1. [Implementazione](#implementazione)

1. [Test](#test)

  - [Protocollo di test](#protocollo-di-test)

  - [Risultati test](#risultati-test)

  - [Mancanze/limitazioni conosciute](#mancanze/limitazioni-conosciute)

1. [Consuntivo](#consuntivo)

1. [Conclusioni](#conclusioni)

  - [Sviluppi futuri](#sviluppi-futuri)

  - [Considerazioni personali](#considerazioni-personali)

1. [Sitografia](#sitografia)

1. [Allegati](#allegati)


## Introduzione

### Informazioni sul progetto

  - Questo progetto è stato realizzato dall'allievo: <br>
        - Marco Lorusso
    <br>Mentre i docenti che avranno il ruolo di clienti/capo azienda sono: <br>
        - Luca Muggiasca, <br>
        - Geo Petrini
  - Scuola d'arti e mestieri Trevano, Informatica, modulo 306

  -   Il progetto è stato iniziato il  03.09.2019 e finirà il 20.12.2019


### Abstract

  Il documento seguente conterrà tutto ciò che riguarda il progetto "Snow flake",
  dall'analisi, alla progettazione, all'implementazione, ai test e alle conclusioni.
  Il progetto è stato creato completamente a scopi didattici, si poteva fare sia in java che in javascript, e consiste nel fare un programma dove con un triangolo di base, l'utente inserisce dei punti nel frame, si potranno salvare e caricare da un file, spostare e eliminare, una volta finito, tramite il bottone 'genera' si genererà un fiocco di neve. Infine con un bottone apposito si potrà scaricare il .jar dell'applicativo. Tutto questo deve essere documentato in questa documentazione e nel sito web, dove ci sarà il download dell'applicativo.


### Scopo

  Lo scopo di questo progetto è completamente didattico, mi aiuterà a entrare nel
  mondo dei progetti singoli, e mi metterà alla prova con il linguaggio di programmazione java. <br>
  Il progetto consiste nel fare un'applicativo con java, che permette di creare
  un fiocco di neve. Partendo da un triangolo pieno e con dei punti taglio fatti
  col mouse, si tolgono alcune parti del triangolo e inseguito verrà generato
  il fiocco di neve.


## Analisi

### Analisi del dominio

  Il contesto del prodotto, è completamente scolastico, il progetto è creato da
  una specifica consegnata dai professori, con lo scopo di imparare a fare dei
  progetti e a migliorare la conoscenza con il linguaggio di programmazione java.

  Oltre a scopo didattico, non ci trovo un vero contesto dove usarlo.

  Per adoperare con il codice del programma bisogna sapere almeno un minimo di java.

### Analisi e specifica dei requisiti

  |**ID**|**Nome**			|**Priorità**|**Vers**|**Note** |
  |------|-------------|------------|--------|---------|
  |Req-01|L'applicativo deve essere scritto in java.|1|1.0|...|
  |Req-02|Bisogna creare un sito con descrizione software.|1|1.0|...|
  |Req-03|Deve essere possibile scaricare il software|1|1.0|...|
  |Req-04|I tagli nel triangolo devono poter essere fatti con il mouse.|1|1.0|...|
  |Req-05|Deve essere possibile resettare i punti registrati.|1|1.0|...|
  |Req-06|Si possono rimuovere o spostare i punti.|2|1.0|...|
  |Req-07|Ci deve essere un tasto genera, che crea il fiocco di neve e visualizza l'anteprima.|1|1.0|...|
  |Req-08|La generazione del fiocco di neve finale può avvenire in tempo reale.|2|1.0|...|
  |Req-09|Si deve poter salvare il fiocco di neve.|1|1.0|...|
  |Req-10|Si devono poter salvare i punti di taglio del fiocco per permettere modifiche o rigenerazioni future.|1|1.0|...|
  |Req-11|Il salvataggio del lavoro deve essere fatto in formato PNG o SVG.|1|1.0|...|
  |Req-12|Il salvataggio deve avere dimensioni definite dall'utente.|1|1.0|...|
  |Req-13|Deve esserci un'interfaccia grafica.|1|1.0|...|
  |Req-14|L'area di lavoro deve essere un triangolo.|1|1.0|...|
  |Req-15|La finestra deve essere ridimensionabile e sarà di minio 1024x768.|1|1.0|...|
  |Req-16|Nel sito ci deve essere la lista dei requisiti, JRE, guida con screenshots.|1|1.0|...|
  |Req-17|Il salvataggio in vettoriale, dev'essere della dimensione corrente, di 500 o di 1000.|1|1.0|...|
  |Req-18|Per il salvataggio l'utente deve vedere una schermata per scegliere il formato.|1|1.0|...|



### Use case

Questo programma è stato creato a scopo didattico, dunque non ha scopi di utilizzo,
tranne se viene ottimizzato, potrebbe diventare un gioco dove, con la creazione
del fiocco di neve si procede per un perscorso, dove bisogna fare vari obbiettivi.

### Pianificazione
![Gant preventivo 1](image/Gant_Preventivo_SnowFlake.JPG)
<br><br>
![Gant preventivo 2](image/Gant_Preventivo_SnowFlake_2.JPG)
<br><br>
![Gant preventivo 3](image/Gant_Preventivo_SnowFlake_3.JPG)
### Analisi dei mezzi

Questo programma verrà creato con il linguaggio di programmazione java, la versione che uso è la 12.0.2, mentre come compilatore/editore, uso netBeans versione 11.1.
L'unico requisito è quello di installare la piattaforma java(JRE) per eseguire
il .jar.


## Progettazione

### Design dell’architettura del sistema

Questo è il diagramma delle classi(UML), ho deciso di farlo su 3 classi, la classe poligono che contiene una lista di punti e crea il poligono grazie ad i punti. <br>
Una classe SnowFlake che contiene da 0 a infiti poligoni, da questa classe si possono salvare/caricare i punti, e salvare lo screen del panel in formato svg.<br>
Infine c'è la classe SnowFrame, che contiene 3 pannelli con l'interfaccia grafica (bottoni, titolo e panel).

![Uml delle classi](image/snowFlakeUML.svg)

### Design delle interfacce
Ho scelta un'interfaccia molto colorata. Il colore azzurro di sfondo che va a
richiamare il tema del fiocco di neve, e qualche colore con cui sta bene, tipo
il giallo/arancio e il rosso.

![Diagramma di flusso](image/screenSnowFlake.JPG)

### Design procedurale
Ho fatto un diagramma di flusso per mostrare i vari passaggi dell'applicativo.
Il diagramma rispecchia praticamente tutta la struttura che ho realmente, tranne
per la generazione del fiocco di neve.

![Diagramma di flusso](image/flowDiagram.svg)


## Implementazione

In questo screen si può notare il metodo che uso per aggiungere i punti al frame, metodo che viene richiamato quando si clicca col mouse, si aggiungono dei punti alla lista di punti, finchè non si clicca ad una distanza di 8 pixel dal primo punto che si ha fatto, in modo che si chiude il poligono.

![Metodo aggiunta punti](image/metodoAddPoint.jpg)

Questo metodo invece serve a salvare i punti che si sono fatti.
praticamente si crea uno stringBuilder, in modo che si possono aggiungere elementi tranquillamente, senza sovrascriverli.
Per ogni poligono, viene salvato dentro lo stringBuilder le coordinate x e y(prese dal metodo printPoint, nella classe Poligono), e quando finisce un poligono, va a capo per far capire che il poligono è finito.

![Metodo salva punti](image/metodoSavePoint.jpg)

![Metodo stampa punti](image/metodoPrintPoint.jpg)



## Test

### Protocollo di test



|Test Case      | TC-01                               |
|---------------|--------------------------------------|
|**Nome**       |Aggiunta di punti nel frame |
|**Riferimento**|REQ-04                               |
|**Descrizione**|Provare ad aggiungere punti e controllare se si vedono e si creano i tagli.|
|**Procedura**     |Clicco col mouse in vari punti del frame, faccio un punto all'esterno del triangolo e due all'interno.|
|**Risultati attesi** |I punti sia all'esterno che all'interno del triangolo creano dei tagli. |

|Test Case      | TC-02                               |
|---------------|--------------------------------------|
|**Nome**       |Resetto punti |
|**Riferimento**|REQ-05                         |
|**Descrizione**|Provare a resettare i punti e i poligoni, cliccando il bottone per il reset.|
|**Procedura**     |Creo un paio di poligoni,alcuni con tanti punti e altri con pochi, infine fare altri punti senza chiudere il poligono, inseguito cliccare il bottone del reset e vedere se si eliminano tutti i punti.|
|**Risultati attesi** |I punti e i poligoni si resettano correttamente. |

|Test Case      | TC-03                               |
|---------------|--------------------------------------|
|**Nome**       |Spostare punti |
|**Riferimento**|REQ-06                         |
|**Descrizione**|Provare a spostare i punti trascinando un punto dal centro del triangolo all'esterno.|
|**Procedura**     |Clicco col mouse nel mezzo del triangolo e provo subito dopo a trascinarlo fuori, e creo un poligono per vedere se si è veramente spostato.|
|**Risultati attesi** |I punti si spostano correttamente e si crea il poligono con la nuova posizione del punto. |

|Test Case      | TC-04                               |
|---------------|--------------------------------------|
|**Nome**       |Salvare punti |
|**Riferimento**|REQ-10                         |
|**Descrizione**|Provare a fare vari punti e poligoni e cliccare il bottone per salvare i punti.|
|**Procedura**   |Clicco in varie parti del frame, sia dentro che fuori, e chiudo vari frame, inseguito clicco il bottone "save Point" e controllo il file per vedere se ci sono i giusti poligoni.|
|**Risultati attesi** |Una volta salvati i punti, se si apre il file si noteranno i vari poligoni divisi da degli spazi. |

|Test Case      | TC-05                               |
|---------------|--------------------------------------|
|**Nome**       |Sito web|
|**Riferimento**|REQ-02/REQ-03                         |
|**Descrizione**|Apro il sito web, controllo se ci sono tutte le descrizioni e controllo se c'è la possibilità di scaricare il software.|
|**Procedura**   |Apro il sito, guardo tutte le parti del sito, provo a scaricare il software con l'apposito bottone e provo ad aprire il download.|
|**Risultati attesi** |Il sito contiene tutto il necessario e il download funzionerà correttamente. |

|Test Case      | TC-06                               |
|---------------|--------------------------------------|
|**Nome**       |Generazione fiocco di neve|
|**Riferimento**|REQ-07/REQ-08                         |
|**Descrizione**|Creo vari poligoni con un bel po' di punti, e controllo se c'è l'animazione in anteprima, e se si genera il fiocco di neve.|
|**Procedura**   |Clicco in varie parti del frame, chiudo vari poligoni con diversi punti, guardo se c'è un'anteprima e inseguito clicco il tasto genera e aspetto che si crei un frame con il fiocco di neve.|
|**Risultati attesi** |Non si genera il fiocco di neve, e non c'è l'anteprima. |

|Test Case      | TC-07                               |
|---------------|--------------------------------------|
|**Nome**       |Salvataggio fiocco di neve|
|**Riferimento**|REQ-09/REQ-11                         |
|**Descrizione**|Clicco in varie parti del frame, creo vari poligoni, genero il fiocco di neve e lo salvo.|
|**Procedura**   |Clicco col mouse in varie parti del triangolo, chiudo tutti i poligoni, clicco sul tasto genera, e infine clicco sul tasto salva.|
|**Risultati attesi** |Visto che non si genera il fiocco di neve non si potrà salvare il fiocco di neve finale, però si può salvare in formato svg il triangolo con i poligoni tagliati. |

|Test Case      | TC-08                                |
|---------------|--------------------------------------|
|**Nome**       |Ridimensionamento finestra, responsive|
|**Riferimento**|REQ-15|
|**Descrizione**|Ridimensionare la finestra e controllare se la dimensione minima è 1024x768 e se è responsive il triangolo ed i punti.|
|**Procedura**   |Apro l'applicativo creo dei punti nel frame, e dei poligoni, inseguito provo a ridimensionare la finestra a meno di 1024x768 e controllo se sia tutto responsive.|
|**Risultati attesi** |La dimensione minima è 1024x768, si può ridimensionare, ma solo il triangolo è responsive, i punti e i poligoni non lo sono. |

### Risultati test
| Test Case |Esito test|
|-------|--------|
| TC-01 | Passato|
| TC-02 | Passato|
| TC-03 | Passato|
| TC-04 | Passato|
| TC-05 | Passato|
| TC-06 | Bocciato|
| TC-07 | Parzialmente passato|
| TC-08 | Passato|


### Mancanze/limitazioni conosciute

Non sono riuscito a fare la generazione del fiocco di neve e perciò neanche l'animazione in tempo reale. Questo a causa di

Descrizione con motivazione di eventuali elementi mancanti o non
completamente implementati, al di fuori dei test case. Non devono essere
riportati gli errori e i problemi riscontrati e poi risolti durante il
progetto.

## Consuntivo

Consuntivo del tempo di lavoro effettivo e considerazioni riguardo le
differenze rispetto alla pianificazione (cap 1.7) (ad esempio Gannt
consuntivo).

## Conclusioni

Quali sono le implicazioni della mia soluzione? Che impatto avrà?
Cambierà il mondo? È un successo importante? È solo un’aggiunta
marginale o è semplicemente servita per scoprire che questo percorso è
stato una perdita di tempo? I risultati ottenuti sono generali,
facilmente generalizzabili o sono specifici di un caso particolare? ecc

### Sviluppi futuri

  Questo prodotto può essre migliorato molto, e può portare ad un prodotto finale molto carino. Si potrebbero implementare varie migliorie e creare nuovi frame con altre funzionalità.

### Considerazioni personali
  In questo progetto ho imparato nuovi approcci del linguaggio di programmazione java, nuovi metodi. Inoltre ho migliorato le mie competenze sia riguardo ai progetti, sia riguardo a java sia riguardo i progetti. Inizialmente pensavo di non poter riuscire a fare molto, ma col passare del tempo, suddividendo i problemi e pensadoci su, sono riuscito a fare più di quanto pensassi.

### Sitografia

1.  URL del sito (se troppo lungo solo dominio, evt completo nel
    diario),

2.  Eventuale titolo della pagina (in italico),

3.  Data di consultazione (GG-MM-AAAA).

**Esempio:**

-   http://standards.ieee.org/guides/style/section7.html, *IEEE
    Standards Style Manual*, 07-06-2008.

## Allegati

Elenco degli allegati, esempio:

-   Diari di lavoro

-   Codici sorgente/documentazione macchine virtuali

-   Istruzioni di installazione del prodotto (con credenziali
    di accesso) e/o di eventuali prodotti terzi

-   Documentazione di prodotti di terzi

-   Eventuali guide utente / Manuali di utilizzo

-   Mandato e/o Qdc

-   Prodotto

-   …
