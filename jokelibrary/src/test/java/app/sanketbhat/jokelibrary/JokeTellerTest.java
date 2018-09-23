package app.sanketbhat.jokelibrary;

import org.junit.Test;

import static org.junit.Assert.*;

public class JokeTellerTest {

    @Test
    public void getRandomJokeTest() {
        JokeTeller jokeTeller = new JokeTeller();
        String joke = jokeTeller.getRandomJoke();
        assertNotNull(joke);
        assertNotEquals(joke, "");
        System.out.println(joke);
    }
}