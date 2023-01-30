package streamApi.terminal;

import java.util.List;
import java.util.Optional;

public class ComplexityLanguageHW {
    public static void main(String[] args) {
        ProgrammingLanguage lang1 = new ProgrammingLanguage("Haskell", DifficultyLevel.HARD);
        ProgrammingLanguage lang2 = new ProgrammingLanguage("Python", DifficultyLevel.EASY);
        ProgrammingLanguage lang3 = new ProgrammingLanguage("Java", DifficultyLevel.MEDIUM);
        ProgrammingLanguage lang4 = new ProgrammingLanguage("C++", DifficultyLevel.HARD);
        ProgrammingLanguage lang5 = new ProgrammingLanguage("JS", DifficultyLevel.EASY);
        ProgrammingLanguage lang6 = new ProgrammingLanguage("Java2", DifficultyLevel.MEDIUM);

        List<ProgrammingLanguage> languages = List.of(lang1, lang2, lang3, lang4, lang5, lang6);

        DifficultyLevel level = DifficultyLevel.MEDIUM;

        Optional<ProgrammingLanguage> result = languages
                .stream()
                .filter(a -> a.getComplexity() == level)
                .findAny();
        System.out.println(result.get());
    }
}
