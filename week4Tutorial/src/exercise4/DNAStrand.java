package exercise4;

class DNAStrand {

    private String dna;

    DNAStrand(String dna) {
        this.dna = dna;
    }

    boolean isValidDNA() {
        for (int i = 0; i < dna.length(); i++) {
            if (dna.charAt(i) != 'A' && dna.charAt(i) != 'T' && dna.charAt(i) != 'C' && dna.charAt(i) != 'G')
                return false;
        }
        return true;
    }

    String complementWC() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < dna.length(); i++) {
            switch (dna.charAt(i)) {
                case 'A':
                    result.append("T");
                    break;
                case 'T':
                    result.append("A");
                    break;
                case 'C':
                    result.append("G");
                    break;
                case 'G':
                    result.append("C");
                    break;
            }
        }
        return result.toString();
    }

    String palindromeWC() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < complementWC().length(); i++) {
            result.insert(0, complementWC().charAt(i));
        }
        return result.toString();
    }

    boolean containsSequence(String seq) {
        return dna.contains(seq);
    }

    public String toString() {
        return dna;
    }
}
