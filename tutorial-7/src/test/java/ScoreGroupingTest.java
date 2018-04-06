import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class ScoreGroupingTest {
    // TODO Implement me!
    // Increase code coverage in ScoreGrouping class
    // by creating unit test(s)!
    private static final Map<String, Integer> SCORES = new HashMap<String, Integer>() {
        {
            put("Alice", 12);
            put("Bob", 15);
            put("Charlie", 11);
            put("Delta", 15);
            put("Emi", 15);
            put("Foxtrot", 11);
        }
    };

    @Test
    public void testGroupingByNumber() {
        assertEquals(ScoreGrouping.groupByScores(SCORES).toString(),
                "{11=[Charlie, Foxtrot], 12=[Alice], 15=[Emi, Bob, Delta]}");
    }
}