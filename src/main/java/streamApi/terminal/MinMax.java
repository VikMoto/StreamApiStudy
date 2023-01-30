package streamApi.terminal;

import streamApi.introduction.Main;

import java.util.List;
import java.util.Optional;

public class MinMax {
    public static void main(String[] args) {
        ProgrammingLanguage lang1 = new ProgrammingLanguage("Haskell", DifficultyLevel.HARD);
        ProgrammingLanguage lang2 = new ProgrammingLanguage("Python", DifficultyLevel.EASY);
        ProgrammingLanguage lang3 = new ProgrammingLanguage("Java", DifficultyLevel.MEDIUM);
        ProgrammingLanguage lang4 = new ProgrammingLanguage("C++", DifficultyLevel.HARD);
        ProgrammingLanguage lang5 = new ProgrammingLanguage("JS", DifficultyLevel.EASY);

        List<ProgrammingLanguage> languages = List.of(lang1, lang2, lang3, lang4, lang5);

        Optional<ProgrammingLanguage> result = languages.stream().max(MinMax::compareHard);
        System.out.println(result.get());
    }
    public static int compareHard(ProgrammingLanguage a, ProgrammingLanguage b) {
        /**
         * ordinal() - Returns the ordinal of this enumeration constant (its position in its enum
         * declaration, where the initial  constant is assigned an ordinal of zero). Most programmers
         * will have no use for this method. It is designed for use by sophisticated enum-based data
         * structures, such as java.util.EnumSet and java.util.EnumMap.
         * */

        if (a.getComplexity().ordinal() > b.getComplexity().ordinal()) {
            return 1;
        }
        if (a.getComplexity().ordinal() < b.getComplexity().ordinal()) {
            return -1;
        }
        return Integer.compare(a.getName().length(), b.getName().length());
    }

}
enum DifficultyLevel {
    EASY, MEDIUM, HARD;
}
class ProgrammingLanguage {
    private String name;
    private DifficultyLevel complexity;
    public ProgrammingLanguage(String name, DifficultyLevel complexity) {
        super();
        this.name = name;
        this.complexity = complexity;
    }
    public String getName() {
        return name;
    }
    public DifficultyLevel getComplexity() {
        return complexity;
    }
    @Override
    public String toString() {
        return "ProgrammingLanguage [name=" + name + ", complexity=" + complexity + "]";
    }
}