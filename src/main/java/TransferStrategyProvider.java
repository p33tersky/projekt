public class TransferStrategyProvider {

    public MoneyTransferStrategy get(final StrategyType strategyType) {
        switch (strategyType) {
            case INTERNAL:
                return new InternalTransferStrategy();
            case EXTERNAL_NATIONAL:
                return new ExternalNationalTransferStrategy();
            case EXTERNAL_INTERNATIONAL:
                return new ExternalInternationalTransferStrategy();
        }
        throw new UnsupportedOperationException("Unsupported strategy type");
    }
}
