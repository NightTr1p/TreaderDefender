package TraderDefender.Fraud;

import TraderDefender.Transaction;

import java.util.ArrayList;
import java.util.List;

public class FraudCountry implements FraudRule{

    private List<String> listCountry;
    private final String NAMERULE = "Country";


    @Override
    public boolean isFraud(Transaction transaction) {
        listCountry = new ArrayList<>();
        listCountry.add("Jamaica");
        for (int i = 0; i < listCountry.size(); i++) {
            return (transaction.getTrader().getCountry().equals(listCountry.get(i)));
        }
        return false;
    }

    @Override
    public String getRuleName() {
        return NAMERULE;
    }
}
