package oopis_project;

public enum SequenceType {
    DNA,
    RNA,
    PEPTIDE,
    AMBIGUOUS;

    // Upper and lower case
    public static SequenceType convertString(String inputString){
        for(SequenceType type : SequenceType.values()){
            if(type.name().equalsIgnoreCase(inputString)) {
                return type;
            }
        }
        return null;
    }
}
