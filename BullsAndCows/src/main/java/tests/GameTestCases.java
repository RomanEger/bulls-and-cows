package tests;

import org.example.Game;
import org.example.Tuple;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameTestCases {

    @Test
    public void TestCount_4_0(){
        int[] arrBulls = new int[]{4, 3, 1, 2};
        Game game = new Game();
        int[] attempt = new int[]{4,3,1,2};
        Tuple<Integer, Integer> actualTuple = game.getBullsAndCows(arrBulls, attempt);
        Tuple<Integer, Integer> expectedTuple = new Tuple<>(4,0);
        assertEquals(expectedTuple, actualTuple);
    }

    @Test
    public void TestCount_0_0(){
        int[] arrBulls = new int[]{4, 3, 1, 2};
        Game game = new Game();
        int[] attempt = new int[]{5,6,7,8};
        Tuple<Integer, Integer> actualTuple = game.getBullsAndCows(arrBulls, attempt);
        Tuple<Integer, Integer> expectedTuple = new Tuple<>(0,0);
        assertEquals(expectedTuple, actualTuple);
    }
}
