package oopis_project;

/**
 * Repräsentiert Aminosäure-Sequenzen und weist diesen spezifische Eigenschaften zu.
 * Beinhaltet zudem Methoden zur Berechnung von Parametern.
 */

public class FastaEntryAminoAcid extends FastaEntry{

    //Attributes
    private int length;
    private int aCount;
    private int rCount;
    private int nCount;
    private int dCount;
    private int cCount;
    private int qCount;
    private int eCount;
    private int gCount;
    private int hCount;
    private int iCount;
    private int lCount;
    private int kCount;
    private int mCount;
    private int fCount;
    private int pCount;
    private int sCount;
    private int tCount;
    private int wCount;
    private int yCount;
    private int vCount;

    // Constructor
    /**
     * Konstruktor weist bei Aufruf den Attributen der geerbten Superklasse Werte zu
     * Zählt Anzahl der einzelnen Aminosäuren in der AA-Sequenz und weist die Anzahl
     * zusätzlichen Objekten zu (über countElements()).
     * @param id - Header des FastaEntries
     * @param sequence - AA-Sequenz des FastaEntries
     * @param type - Sequenztyp (Peptide)
     */
    public FastaEntryAminoAcid(String id, String sequence, String type){
        super(id, sequence, type);
        this.length = sequence.length();
        this.rCount = countElements(sequence, 'R');
        this.aCount = countElements(sequence, 'A');
        this.nCount = countElements(sequence, 'N');
        this.dCount = countElements(sequence, 'D');
        this.cCount = countElements(sequence, 'C');
        this.qCount = countElements(sequence, 'Q');
        this.eCount = countElements(sequence, 'E');
        this.gCount = countElements(sequence, 'G');
        this.hCount = countElements(sequence, 'H');
        this.iCount = countElements(sequence, 'I');
        this.lCount = countElements(sequence, 'L');
        this.kCount = countElements(sequence, 'K');
        this.mCount = countElements(sequence, 'M');
        this.fCount = countElements(sequence, 'F');
        this.pCount = countElements(sequence, 'P');
        this.sCount = countElements(sequence, 'S');
        this.tCount = countElements(sequence, 'T');
        this.wCount = countElements(sequence, 'W');
        this.yCount = countElements(sequence, 'Y');
        this.vCount = countElements(sequence, 'V');
    }

    // Methods

    // Count Amino Acids
    /**
     * Zählt die Anzahl der einzelnen Aminosäuren in der AA-Sequenz
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

    /**
     * Soll den isoelektrischen Punkt anhand der Eigenschaften der übergebenen Peptidsequenz berechen
     * @return - Berechneter isoelektrischer Punkt
     */
    double calculateIsoelectricPoint(){
        return 0.0;
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



    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getaCount() {
        return aCount;
    }

    public void setaCount(int aCount) {
        this.aCount = aCount;
    }

    public int getrCount() {
        return rCount;
    }

    public void setrCount(int rCount) {
        this.rCount = rCount;
    }

    public int getnCount() {
        return nCount;
    }

    public void setnCount(int nCount) {
        this.nCount = nCount;
    }

    public int getdCount() {
        return dCount;
    }

    public void setdCount(int dCount) {
        this.dCount = dCount;
    }

    public int getcCount() {
        return cCount;
    }

    public void setcCount(int cCount) {
        this.cCount = cCount;
    }

    public int getqCount() {
        return qCount;
    }

    public void setqCount(int qCount) {
        this.qCount = qCount;
    }

    public int geteCount() {
        return eCount;
    }

    public void seteCount(int eCount) {
        this.eCount = eCount;
    }

    public int getgCount() {
        return gCount;
    }

    public void setgCount(int gCount) {
        this.gCount = gCount;
    }

    public int gethCount() {
        return hCount;
    }

    public void sethCount(int hCount) {
        this.hCount = hCount;
    }

    public int getiCount() {
        return iCount;
    }

    public void setiCount(int iCount) {
        this.iCount = iCount;
    }

    public int getlCount() {
        return lCount;
    }

    public void setlCount(int lCount) {
        this.lCount = lCount;
    }

    public int getkCount() {
        return kCount;
    }

    public void setkCount(int kCount) {
        this.kCount = kCount;
    }

    public int getmCount() {
        return mCount;
    }

    public void setmCount(int mCount) {
        this.mCount = mCount;
    }

    public int getfCount() {
        return fCount;
    }

    public void setfCount(int fCount) {
        this.fCount = fCount;
    }

    public int getpCount() {
        return pCount;
    }

    public void setpCount(int pCount) {
        this.pCount = pCount;
    }

    public int getsCount() {
        return sCount;
    }

    public void setsCount(int sCount) {
        this.sCount = sCount;
    }

    public int gettCount() {
        return tCount;
    }

    public void settCount(int tCount) {
        this.tCount = tCount;
    }

    public int getwCount() {
        return wCount;
    }

    public void setwCount(int wCount) {
        this.wCount = wCount;
    }

    public int getyCount() {
        return yCount;
    }

    public void setyCount(int yCount) {
        this.yCount = yCount;
    }

    public int getvCount() {
        return vCount;
    }

    public void setvCount(int vCount) {
        this.vCount = vCount;
    }
}
