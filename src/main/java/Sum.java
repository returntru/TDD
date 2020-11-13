public class Sum implements IExpression{

    public IExpression augend;
    public IExpression addend;

    public Sum(IExpression augend, IExpression addend) {
        this.augend = augend;
        this.addend = addend;
    }

    public Money reduce(Bank bank, String to) {
        int ammount = augend.reduce(bank, to).ammount + addend.reduce(bank, to).ammount;
        return new Money(ammount, to);
    }

    public IExpression plus(IExpression addend) {
        return new Sum(this, addend);
    }

    public IExpression times(int multiplier) {
        return new Sum(augend.times(multiplier), addend.times(multiplier));
    }
}
