public class Money implements IExpression {

    protected int ammount;
    protected String currency;

    public Money(int ammount, String currency) {
        this.ammount = ammount;
        this.currency = currency;
    }

    public static Money dollar(int ammount) {
        return new Money(ammount, "USD");
    }

    public static Money franc(int ammount) {
        return new Money(ammount, "CHF");
    }

    public IExpression

    plus(IExpression addend) {
        return new Sum(this, addend);
    }

    public Money reduce(Bank bank, String to) {
        int rate = bank.rate(currency, to);
        return new Money(ammount / rate, to);
    }

    public IExpression times(int multiplier){
        return new Money(ammount * multiplier, currency);
    }

    public String currency() {
        return currency;
    }

    @Override
    public String toString() {
        return "Money{" +
                "ammount=" + ammount +
                ", currency='" + currency + '\'' +
                '}';
    }

    public boolean equals(Object object) {
        Money money = (Money) object;
        return ammount == money.ammount && currency().equals(money.currency());
    }
}
