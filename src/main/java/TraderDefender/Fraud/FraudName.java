package TraderDefender.Fraud;

import TraderDefender.Transaction;

import java.util.ArrayList;
import java.util.List;

public class FraudName implements FraudRule {

    private List listName;
    private final String NAMERULE = "Name";

    @Override
    public boolean isFraud(Transaction transaction) {
        listName = new ArrayList();
        listName.add("Pokemon");
        for (int i = 0; i < listName.size(); i++) {
            return transaction.getTrader().getFullName().equals(listName.get(i));
        }
        return false;
    }

    @Override
    public String getRuleName() {
        return NAMERULE;
    }
}
