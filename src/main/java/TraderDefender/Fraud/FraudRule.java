package TraderDefender.Fraud;

import TraderDefender.Transaction;

public interface FraudRule {

    boolean isFraud(Transaction transaction);
    String getRuleName();
}
