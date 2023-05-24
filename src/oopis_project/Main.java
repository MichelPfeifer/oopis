package oopis_project;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Die Main-Klasse bekommt Kommandozeilenargumente übergeben und gibt den
 * Startstoß für das Programm.
 */

public class Main {

    /**
     * Main-Methode ist dafür zuständig, eine FastaManager Instanz zu erzeugen
     * und dessen Methoden (Parser und Writer) anzuwenden
     * @param args - Kommandozeilenargumente in Form eines String-Arrays
     */

    public static void main(String[] args) {
        try {
            // Control Statement
            if (args.length < 1) {
                System.out.println("Es wurde kein Argument übergeben");
                return;
            }

            // FastaManager Instance to start
            FastaManager manager = FastaManager.getInstance();

            // Check for upper and lower case
            SequenceType type = SequenceType.convertString(args[1]);
            if(type == null){
                System.out.println("Sequenztyp ungültig");
                return;
            }

            // Fasta File parsing and adding entries to Entry List
            manager.parseFastaFile(args[0], type.toString());
            // manager.parseFastaFile("C:/Users/pfeif/Desktop/fasta_test.txt", "DNA");

            // Fasta File writing
            // Method tbd
            manager.writeFastaFile(args[2]);

            // Get every entry from FastaManager instance manager
            ArrayList<FastaEntryDna> entries = manager.getDnaEntries();

            // Print attribute ID and sequence with for-loop from
            // every entry out of entries (DnaEntry example file)
            for (FastaEntryDna entry : entries) {
                System.out.println("ID: " + entry.getId());
                System.out.println("Sequence: " + entry.getSequence());
            }
        } catch(IOException e){
            System.out.println("Fehler");
        }
    }
}
