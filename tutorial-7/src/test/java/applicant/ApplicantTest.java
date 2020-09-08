package applicant;

import java.util.function.Predicate;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ApplicantTest {
    private Predicate<Applicant> creditEvaluator;
    private Predicate<Applicant> criminalRecordsEvaluator;
    private Predicate<Applicant> employmentEvaluator;
    private Predicate<Applicant> qualifiedEvaluator;
    private Applicant applicant;

    @Before
    public void setUp() {
        applicant = new Applicant();
        qualifiedEvaluator = Applicant::isCredible;
        creditEvaluator = anApplicant -> anApplicant.getCreditScore() > 600;
        employmentEvaluator = anApplicant -> anApplicant.getEmploymentYears() > 0;
        criminalRecordsEvaluator = anApplicant -> !anApplicant.hasCriminalRecord();
    }

    @Test
    public void testApplicantOneisQualified() {
        Assert.assertEquals(true, Applicant.evaluate(applicant, qualifiedEvaluator));
    }

    @Test
    public void testApplicantTwotisQualified() {
        Assert.assertEquals(true, Applicant.evaluate(applicant, qualifiedEvaluator
                .and(employmentEvaluator)));
    }

    @Test
    public void testApplicantThreeisQualified() {
        Assert.assertEquals(false, Applicant.evaluate(applicant, qualifiedEvaluator
                .and(employmentEvaluator)
                .and(criminalRecordsEvaluator)));
    }

    @Test
    public void testApplicantFourisQualified() {
        Assert.assertEquals(false, Applicant.evaluate(applicant, qualifiedEvaluator
                .and(employmentEvaluator)
                .and(creditEvaluator)
                .and(criminalRecordsEvaluator)));
    }
}
