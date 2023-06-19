import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class BankDepositExercise {
    private static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("[dd/MM/yyyy][dd-MM-yyyy]");

    public static String getMaturityDate(String investmentDate, Period duration) {
        LocalDate date = LocalDate.parse(investmentDate, DATE_FORMAT);
        date = date.plus(duration);
        return date.format(DATE_FORMAT);
    }

    public static String getInvestmentPeriod(String investmentDate, String maturityDate) {
        LocalDate startDate = LocalDate.parse(investmentDate, DATE_FORMAT);
        LocalDate endDate = LocalDate.parse(maturityDate, DATE_FORMAT);
        Period period = Period.between(startDate, endDate);
        int years = period.getYears();
        int months = period.getMonths();
        return years + " years, " + months + " months";
    }



	public static void main(String[] args) {
		
		    String investmentDate = "01/01/2022";
		    Period duration = Period.of(2, 6, 0);
		    String maturityDate = BankDepositExercise.getMaturityDate(investmentDate, duration);
		    System.out.println("Maturity Date: " + maturityDate);

		    String investmentDate2 = "01-01-2021";
		    String maturityDate2 = "01/07/2023";
		    String investmentPeriod = BankDepositExercise.getInvestmentPeriod(investmentDate2, maturityDate2);
		    System.out.println("Investment Period: " + investmentPeriod);
		}

		

	

}
