package app.sanketbhat.jokelibrary;

import org.junit.Test;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

public class JokeTellerTest {

    @Test
    public void getRandomJokeTest() {
        JokeTeller jokeTeller = new JokeTeller();
        String joke = jokeTeller.getRandomJoke();
        assertNotNull(joke);
        assertNotEquals(joke, "");
        System.out.println("MyTest: Java library test" + joke);
    }
}