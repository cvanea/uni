package exercise4;

public class DNAStrandTester {

    public static void main(String[] args) {

        DNAStrand s1 = new DNAStrand("ACGGTC");
        DNAStrand s2 = new DNAStrand("ATTGCCATAC");

        summarise(s1);
        summarise(s2);

        System.out.println(s2.containsSequence("CC"));

        DNAStrand s3 = new DNAStrand("ATTGCCATDAC");

        summarise(s3);
    }

    public static void summarise(DNAStrand dna) {
        System.out.println("Original DNA Sequence: " + dna);
        if (dna.isValidDNA()) {
            System.out.println("Is valid");
            System.out.println("Complement: " + dna.complementWC());
            System.out.println("WC Palindrome: " +
                dna.palindromeWC());
        } else {
            System.out.println("Not Valid DNA");
        }
    }
}
