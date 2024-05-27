package tests;

import org.example.Bulls;
import org.example.Game;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameTestCases {

    @Test
    public void Test1(){
        int[] arrBulls = new int[]{4, 3, 1, 2};
        Bulls bulls = new Bulls(arrBulls, true);
        Game game = new Game();
        int result = game.gameVsBot(bulls);
        assertEquals(0, result);
    }
}
