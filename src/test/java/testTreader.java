import TraderDefender.FraudDetectionResult;
import TraderDefender.FraudDetector;
import TraderDefender.Trader;
import TraderDefender.Transaction;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class testTreader {

    private FraudDetector detector = new FraudDetector();

    @Test
    public void testTreadFalse() {
        FraudDetectionResult fraudDetectionResult = new FraudDetectionResult(null, false);
        Trader trader = new Trader("Goblin", "Rome", "Italy");
        Transaction transaction = new Transaction(trader, 5000);
        assertEquals(detector.isFraud(transaction).isFraud(), fraudDetectionResult.isFraud());
    }

    @Test
    public void testTreadTrue() {
        FraudDetectionResult fraudDetectionResult = new FraudDetectionResult("Name", true);
        Trader trader = new Trader("Pokemon", "Rome", "Italy");
        Transaction transaction = new Transaction(trader, 5000);
        assertEquals(detector.isFraud(transaction).getRuleName(), fraudDetectionResult.getRuleName());
        assertEquals(detector.isFraud(transaction).isFraud(), fraudDetectionResult.isFraud());
    }

    @Test
    public void testAmountTrue() {
        FraudDetectionResult fraudDetectionResult = new FraudDetectionResult("Amount", true);

        Trader trader = new Trader("Goblin", "Rome", "Italy");
        Transaction transaction = new Transaction(trader, 1000001);
    }

    @Test
    public void testCitySydneyTrue(){
        FraudDetectionResult fraudDetectionResult = new FraudDetectionResult("City", true);
        Trader trader = new Trader("Goblin", "Sydney", "Italy");
        Transaction transaction = new Transaction(trader, 10000);
        assertEquals(detector.isFraud(transaction).getRuleName(), fraudDetectionResult.getRuleName());
        assertEquals(detector.isFraud(transaction).isFraud(), fraudDetectionResult.isFraud());
    }

    @Test
    public void testCountryJamaicaTrue(){
        FraudDetectionResult fraudDetectionResult = new FraudDetectionResult("Country", true);
        Trader trader = new Trader("Goblin", "Kingston","Jamaica");
        Transaction transaction = new Transaction(trader, 10000);
        assertEquals(detector.isFraud(transaction).getRuleName(), fraudDetectionResult.getRuleName());
        assertEquals(detector.isFraud(transaction).isFraud(), fraudDetectionResult.isFraud());
    }

    @Test
    public void testCityGermanyAmountTrue(){
        FraudDetectionResult fraudDetectionResult = new FraudDetectionResult("CountryAndAmount", true);
        Trader trader = new Trader("Goblin", "Germany", "Italy");
        Transaction transaction = new Transaction(trader, 1001);
        assertEquals(detector.isFraud(transaction).getRuleName(), fraudDetectionResult.getRuleName());
        assertEquals(detector.isFraud(transaction).isFraud(), fraudDetectionResult.isFraud());
    }

}
