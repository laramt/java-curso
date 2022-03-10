package entities;

public class Company extends TaxPayer{

    private int numberEmployees;

    private double lessEmployees = 0.16;
    private double moreEmployees = 0.14;

    public Company(String name, Double anualIncome, int numberEmployees) {
        super(name, anualIncome);
        this.numberEmployees = numberEmployees;
    }

    public int getNumberEmployees() {
        return numberEmployees;
    }

    public void setNumberEmployees(int numberEmployees) {
        this.numberEmployees = numberEmployees;
    }

    @Override
    public Double tax() {

        if (numberEmployees > 10) {
            return getAnualIncome() * 0.14;
        }
        else {
            return getAnualIncome() * 0.16;
        }
    }

    @Override
    public String toString() {
        return  name + ": $" +
                String.format("%.2f ",anualIncome);
    }
}
