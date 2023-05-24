package oopis_project;

// Imports
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Die FastaManager-Klasse besitzt die Parser- und Writer-Methode für Fasta-Dateien
 * als Input. Sie erzeugt mit der Parser-Methode Instanzen der Fasta-Entry Klassen,
 * um diese zu verwalten. Mit der Writer-Methode soll sie Berechnungen an den
 * Fasta-Dateien in separate Dateien schreiben und speichern.
 */

public class FastaManager {


    // Single private static class variable
    private static FastaManager managerInstance;

    // Attributes
    private ArrayList<FastaEntryDna> dnaEntries;
    private ArrayList<FastaEntryRna> rnaEntries;
    private ArrayList<FastaEntryAminoAcid> aaEntries;
    private ArrayList<FastaEntryAmbiguous> ambEntries;


    /**
     * Der FastaManager Konstruktor bekommt keine Argumente übergeben und erzeugt
     * beim Aufruf vier separate Array Listen, welche Objekte der jeweiligen
     * FastaEntry-Klasse speichern und verwalten.
     */
    // Constructor
    private FastaManager(){
        dnaEntries = new ArrayList<>();
        rnaEntries = new ArrayList<>();
        aaEntries = new ArrayList<>();
        ambEntries = new ArrayList<>();
    }

    /**
     * Die parseFastaFile Methode bekommt als Input einen filepath zu einer Fasta-
     * Inputdatei und liest diese ein. Dabei wird für jeden einzelnen Fasta-
     * Eintrag (FastaEntry) ein separates FastaEntry-Objekt erzeugt. Die Parser-Methode
     * bedient sich bei der Erzeugung dieser Objekte an der Factory-Klasse
     * FastaEntryFactory.
     * @param filepath - Input filepath der Fasta-Datei. Sollte der Methode
     *                 mit Slashes anstatt Backslashes übergeben werden
     * @param sequenceType - Zur Differenzierung, welche FastaEntry-Objekte später
     *                     erzeugt werden soll. Akzeptable Werte: "DNA", "RNA,
     *                     "PEPTIDE", "AMBIGUOUS"
     * @throws IOException - Falls falsche Inputparameter (bspw. ungültiger filepath)
     *                     übergeben werden.
     */
    // Parse method
    public void parseFastaFile(String filepath, String sequenceType) throws IOException {
        try {
            // Open filepath
            File file = new File(filepath);
            // Scanner
            Scanner scanner = new Scanner(file);
            // Header
            String header = "";
            // StringBuilder to perform some actions on Strings
            StringBuilder sequence = new StringBuilder();

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.startsWith(">")) {
                    if (!header.isEmpty() && sequence.length() > 0) {
                        FastaEntry entry = FastaEntryFactory.createFastaEntry(header, sequence.toString(), sequenceType);
                        if (entry instanceof FastaEntryDna){
                            dnaEntries.add((FastaEntryDna) entry);
                        } else if(entry instanceof FastaEntryRna){
                            rnaEntries.add((FastaEntryRna) entry);
                        } else if(entry instanceof FastaEntryAminoAcid){
                            aaEntries.add((FastaEntryAminoAcid) entry);
                        } else if(entry instanceof FastaEntryAmbiguous){
                            ambEntries.add((FastaEntryAmbiguous) entry);
                        }
                        sequence = new StringBuilder();
                    }
                    // Update header
                    header = line.substring(1).trim();
                    //sequence = new StringBuilder();
                } else {
                    sequence.append(line.trim());
                }
            }
            if (!header.isEmpty() && sequence.length() > 0) {
                FastaEntry entry = FastaEntryFactory.createFastaEntry(header, sequence.toString(), sequenceType);

                if (entry instanceof FastaEntryDna){
                    dnaEntries.add((FastaEntryDna) entry);
                } else if(entry instanceof FastaEntryRna){
                    rnaEntries.add((FastaEntryRna) entry);
                } else if(entry instanceof FastaEntryAminoAcid){
                    aaEntries.add((FastaEntryAminoAcid) entry);
                } else if(entry instanceof FastaEntryAmbiguous){
                    ambEntries.add((FastaEntryAmbiguous) entry);
                }
            }
            scanner.close();
        }
        catch(FileNotFoundException e){
            System.out.println("File not found: " + filepath);
        }
    }

    /**
     * Die Writer-Methode schreibt alle Berechnungen die an FastaEntry-Objekten
     * durchgeführt werden, in eine separate Datei und speichert diese Ergebnisse
     * ab.
     * @param outputPath - Gibt den Output-Pfad an, in welchem die oben genannten
     *                   Berechnungen gespeichert werden sollen
     */
    // Write method
    public void writeFastaFile(String outputPath){
        // tbd
    }

    // static getInstance Method (Singleton Pattern)
    public static FastaManager getInstance(){
        if(managerInstance == null){
            managerInstance = new FastaManager();
        }
        return managerInstance;
    }

    // Getter and Setter
    public ArrayList<FastaEntryDna> getDnaEntries() {
        return dnaEntries;
    }

    public void setDnaEntries(ArrayList<FastaEntryDna> dnaEntries) {
        this.dnaEntries = dnaEntries;
    }

    public ArrayList<FastaEntryRna> getRnaEntries() {
        return rnaEntries;
    }

    public void setRnaEntries(ArrayList<FastaEntryRna> rnaEntries) {
        this.rnaEntries = rnaEntries;
    }

    public ArrayList<FastaEntryAminoAcid> getAaEntries() {
        return aaEntries;
    }

    public void setAaEntries(ArrayList<FastaEntryAminoAcid> aaEntries) {
        this.aaEntries = aaEntries;
    }

    public ArrayList<FastaEntryAmbiguous> getAmbEntries() {
        return ambEntries;
    }

    public void setAmbEntries(ArrayList<FastaEntryAmbiguous> ambEntries) {
        this.ambEntries = ambEntries;
    }
}
