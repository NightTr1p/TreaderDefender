package TraderDefender.Fraud;

import TraderDefender.Transaction;

public class FraudCountryAndAmount implements FraudRule{

    private final String NAMERULE = "CountryAndAmount";

    @Override
    public boolean isFraud(Transaction transaction) {
        return transaction.getAmount() > 1000 && transaction.getTrader().getCity().contains("Germany");
    }

    @Override
    public String getRuleName() {
        return NAMERULE;
    }
}
