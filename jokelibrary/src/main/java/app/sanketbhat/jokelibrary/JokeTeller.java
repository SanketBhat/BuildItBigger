package app.sanketbhat.jokelibrary;

public class JokeTeller {
    private static final String[] JOKES = {
            "Why do cows have bells? Because their horns don't work",
            "What is the difference between Ignorance and apathy? I don't know and I don't care",
            "A lot of people cry when they cut onions. The trick is not to form an emotional bond.",
            "Alcohol is a perfect solvent: It dissolves marriages, families and careers.",
            "Maybe if we start telling people the brain is an app they will start using it.",
            "My email password has been hacked. That's the third time I've had to rename the cat.",
            "Do not argue with an idiot. He will drag you down to his level and beat you with experience.",
            "War does not determine who is right, but only who left.",
            "A bus station where a bus stops. A train station is where a train stops. On my desk, I have work station."
    };

    public String getRandomJoke() {
        int randomPosition = (int) (Math.random() * JOKES.length);
        return JOKES[randomPosition];
    }
}
