import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.EnumSet;
import java.util.function.Function;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class PangramCheckerTest {

    private PangramChecker pangramChecker;

    public PangramCheckerTest(Function<String, Boolean> strategy) {
        this.pangramChecker = new PangramChecker(strategy);
    }

    @Parameters(name = "Strategy -> {0}")
    public static EnumSet<PangramChecker.StrategyE> getEnums() {
        return EnumSet.allOf(PangramChecker.StrategyE.class);
    }

    @Test
    public void emptySentenceIsNotPangram() {
        assertFalse(pangramChecker.isPangram(""));
    }

    @Test
    public void perfectLowerCasePhraseIsPangram() {
        assertTrue(pangramChecker.isPangram("abcdefghijklmnopqrstuvwxyz"));
    }

    @Test
    public void phraseWithOnlyLowerCaseIsPangram() {
        assertTrue(pangramChecker.isPangram("the quick brown fox jumps over the lazy dog"));
    }

    @Test
    public void phraseMissingCharacterXIsNotPangram() {
        assertFalse(pangramChecker.isPangram("a quick movement of the enemy will jeopardize five gunboats"));
    }

    @Test
    public void phraseMissingCharacterHIsNotPangram() {
        assertFalse(pangramChecker.isPangram("five boxing wizards jump quickly at it"));
    }

    @Test
    public void phraseWithUnderscoresIsPangram() {
        assertTrue(pangramChecker.isPangram("the_quick_brown_fox_jumps_over_the_lazy_dog"));
    }

    @Test
    public void phraseWithNumbersIsPangram() {
        assertTrue(pangramChecker.isPangram("the 1 quick brown fox jumps over the 2 lazy dogs"));
    }

    @Test
    public void phraseWithMissingLettersReplacedByNumbersIsNotPangram() {
        assertFalse(pangramChecker.isPangram("7h3 qu1ck brown fox jumps ov3r 7h3 lazy dog"));
    }

    @Test
    public void phraseWithMixedCaseAndPunctuationIsPangram() {
        assertTrue(pangramChecker.isPangram("\"Five quacking Zephyrs jolt my wax bed.\""));
    }

    @Test
    public void caseInsensitivePhraseIsNotPangram() {
        assertFalse(pangramChecker.isPangram("the quick brown fox jumps over with lazy FX"));
    }
}
