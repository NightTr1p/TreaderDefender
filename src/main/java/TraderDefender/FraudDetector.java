package TraderDefender;

import TraderDefender.Fraud.*;
import java.util.List;

public class FraudDetector {

    private List<FraudRule> listFraud = List.of(
            new FraudName(),
        new FraudAmount(),
        new FraudCity(),
        new FraudCountry(),
        new FraudCountryAndAmount()
    );

    public FraudDetectionResult isFraud(Transaction transaction) {
        return listFraud.stream()
                .filter(listFraud -> listFraud.isFraud(transaction))
                .findFirst()
                .map(this::buildFraudResult)
                .orElse(buildNotFraudResult());
    }

    private FraudDetectionResult buildNotFraudResult() {
        return new FraudDetectionResult(null, false);
    }

    private FraudDetectionResult buildFraudResult(FraudRule fraudRule) {
        return new FraudDetectionResult(fraudRule.getRuleName(), true);
    }
}
