package TraderDefender.Fraud;

import TraderDefender.Transaction;

import java.util.ArrayList;
import java.util.List;

public class FraudCity implements FraudRule {

    private List<String> listCity;
    private final String NAMERULE = "City";

    @Override
    public boolean isFraud(Transaction transaction) {
        listCity = new ArrayList<>();
        listCity.add("Sydney");

        for (int i = 0; i < listCity.size(); i++) {
            return transaction.getTrader().getCity().equals(listCity.get(i));
        }
        return false;
    }

    @Override
    public String getRuleName() {
        return NAMERULE;
    }
}
