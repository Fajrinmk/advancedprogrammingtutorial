package applicant;

import java.util.function.Predicate;

/**
 * 4th exercise.
 */
public class Applicant {

    public boolean isCredible() {
        return true;
    }

    public int getCreditScore() {
        return 700;
    }

    public int getEmploymentYears() {
        return 10;
    }

    public boolean hasCriminalRecord() {
        return true;
    }

    public static boolean evaluate(Applicant applicant, Predicate<Applicant> evaluator) {
        return evaluator.test(applicant);
    }

    private static void printEvaluation(boolean result) {
        String msg = "Result of evaluating applicant: %s";
        msg = result ? String.format(msg, "accepted") : String.format(msg, "rejected");

        System.out.println(msg);
    }

    public static void main(String[] args) {
        Applicant applicant = new Applicant();

        Predicate<Applicant> qualifiedEvaluator = Applicant::isCredible;
        Predicate<Applicant> creditCheck = theApplicant -> theApplicant.getCreditScore() > 600;
        Predicate<Applicant> employmentCheck = theApplicant -> theApplicant.getEmploymentYears() > 0;
        Predicate<Applicant> crimeCheck = theApplicant -> !theApplicant.hasCriminalRecord();

        printEvaluation(evaluate(applicant, qualifiedEvaluator.and(creditCheck)));
        printEvaluation(evaluate(applicant, qualifiedEvaluator.and(employmentCheck)));
        printEvaluation(evaluate(applicant, qualifiedEvaluator.and(employmentCheck).and(crimeCheck)));
        printEvaluation(evaluate(applicant, qualifiedEvaluator.and(employmentCheck).and(creditCheck).and(crimeCheck)));

    }
}
