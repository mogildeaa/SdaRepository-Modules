import com.sda.concentration.BotPlayer;
import com.sda.concentration.Referee;
import org.junit.Test;

public class TestBot {

    @Test
    public void test1() {
        BotPlayer player2 = new BotPlayer("Calculator");
        Referee botArbistru = new Referee(4, player2);
        botArbistru.play();
    }
}
