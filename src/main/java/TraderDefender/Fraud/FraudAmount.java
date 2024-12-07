package TraderDefender.Fraud;

import TraderDefender.Transaction;

import java.util.ArrayList;
import java.util.List;

public class FraudAmount implements FraudRule{

    List<Integer> listAmount;
    private final String NAMERULE = "Amount";

    @Override
    public boolean isFraud(Transaction transaction) {
        listAmount = new ArrayList<>();
        listAmount.add(1000000);

        for (int i = 0; i < listAmount.size(); i++) {
            return transaction.getAmount() > listAmount.get(i);
        }
        return false;
    }

    @Override
    public String getRuleName() {
        return NAMERULE;
    }
}
