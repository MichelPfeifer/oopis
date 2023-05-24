package oopis_project;

/**
 * Repräsentiert Sequenzen, welche nicht DNA-, RNA- oder Peptidsequenzen sind
 * und weist diesen spezifische Eigenschaften zu.
 * Beinhaltet zudem Methoden zur Berechnung von Parametern.
 */

public class FastaEntryAmbiguous extends FastaEntry{

    // Attributes
    private int length;

    // Constructor
    /**
     * Konstruktor weist bei Aufruf den Attributen der geerbten Superklasse Werte zu
     * Zählt Anzahl der einzelnen Nukleotide in der Sequenz und weist die Anzahl
     * zusätzlichen Objekten zu (über countElements()).
     * @param id - Header des FastaEntries
     * @param sequence - Sequenz des FastaEntries
     * @param type - Sequenztyp (AMBIGUOUS)
     */
    public FastaEntryAmbiguous(String id, String sequence, String type){
        super(id, sequence, type);
        this.length = sequence.length();
    }

    // Methods

    // Count Elements
    /**
     * Zählt die Anzahl der Elemente in der Sequenz
     * @param sequence - Enthält die Inputsequenz
     * @param element - Inputsequenz wird mit diesem Character abgeglichen. Soll
     *                  idealerweise Bestandteil der Sequenz sein.
     * @return - Gibt Integer zurück, welcher die Anzahl des Characters in der Sequenz
     * widerspiegelt
     */
    @Override
    int countElements(String sequence, char element){
        int count = 0;
        for(int i = 0; i < sequence.length(); i++){
            if(sequence.charAt(i) == element){
                count++;
            }
        }
        return count;
    }

    // Molecular Weight
    // tbd
    /**
     * Berechnet das Molekulargewicht der übergebenen Sequenz. Greift auf Attribute
     * der Klasse zurück
     * @return - Molekulargewicht
     */

    double calculateMolecularWeight(){
        return 0;
    }

    // Melting Temperature
    // tbd
    /**
     * Soll die Schmelztemperatur der an das Programm übergebenen Sequenzen
     * berechnen. Greift auf Attribute der FastaEntry-Klassen zurück (sequence)
     * @return - Berechnete Schmelztemperatur
     */
    double calculateMeltingTemperature(){
        return 0;
    }

    // Net Charge
    // tbd
    /**
     * Soll die Nettoladung der an das Programm übergebenen Sequenzen
     * berechnen. Greift auf Attribute der FastaEntry-Klassen zurück (sequence)
     * @return - Berechnete Nettoladung
     */
    int calculateNetCharge(){
        return 0;
    }

    // Translation
    // tbd
    /**
     * Übersetzt Sequenz in entsprechende andere Sequenz
     * @param sequence - Sequenz als String
     * @return - String der übersetzten Sequenz
     */
    String translate(String sequence){
        return null;
    }


    // Getter and Setter
    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }
}
