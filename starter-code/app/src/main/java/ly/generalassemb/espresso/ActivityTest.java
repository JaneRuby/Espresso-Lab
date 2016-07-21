package ly.generalassemb.espresso;

import android.support.test.rule.ActivityTestRule;

import org.junit.Rule;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.clearText;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

//import static android.support.test.espresso.matcher.ViewMatchers.onData;

/**
 * Created by janerubygrissom on 7/21/16.
 */
public class ActivityTest {

    @Rule
    public ActivityTestRule<BalanceActivity> mBalanceTestRule = new ActivityTestRule<BalanceActivity>(BalanceActivity.class);

    @ActivityTest
    public void canViewCurrentBalanceTest() throws Exception {
        onView(withId(R.id.balanceTextView))
                .check(matches(isDisplayed()));
    }

    @ActivityTest
    public void canWithdrawMoneyTest() throws Exception {
        String description = "Tuition";
        String value = "25";
        String expectedAnswer = "-$25.00";

        onView(withId(R.id.newTransactionButton))
                .perform(click());
        onView(withId(R.id.descriptionEditText))
                .perform(typeText(description));
        onView(withId(R.id.amountEditText))
                .perform(typeText(value));
        onView(withId(R.id.withdrawButton))
                .perform(click());
        onView(withId(R.id.balanceTextView))
                .check(matches(withText(expectedAnswer)));
    }

    @ActivityTest
    public void canDepositMoneyTest() throws Exception {
        String description = "Tuition";
        String value = "25";
        String expectedAnswer = "$25.00";

        onView(withId(R.id.newTransactionButton))
                .perform(click());
        onView(withId(R.id.descriptionEditText))
                .perform(typeText(description));
        onView(withId(R.id.amountEditText))
                .perform(typeText(value));
        onView(withId(R.id.depositButton))
                .perform(click());
        onView(withId(R.id.balanceTextView))
                .check(matches(withText(expectedAnswer)));
    }

    @ActivityTest
    public void multipleTransactionsTest() throws Exception {
        String description = "Tuition";
        String value = "25";
        String expectedAnswer = "$25.00";

        onView(withId(R.id.newTransactionButton))
                .perform(click());
        onView(withId(R.id.descriptionEditText))
                .perform(typeText(description));
        onView(withId(R.id.amountEditText))
                .perform(typeText(value));
        onView(withId(R.id.withdrawButton))
                .perform(click());

        onView(withId(R.id.newTransactionButton))
                .perform(click());
        onView(withId(R.id.descriptionEditText))
                .perform(clearText(), typeText(description));
        onView(withId(R.id.amountEditText))
                .perform(clearText(), typeText(value));
        onView(withId(R.id.depositButton))
                .perform(click());

        onView(withId(R.id.newTransactionButton))
                .perform(click());
        onView(withId(R.id.descriptionEditText))
                .perform(clearText(), typeText(description));
        onView(withId(R.id.amountEditText))
                .perform(clearText(), typeText(value));
        onView(withId(R.id.depositButton))
                .perform(click());

        onView(withId(R.id.newTransactionButton))
                .perform(click());
        onView(withId(R.id.descriptionEditText))
                .perform(clearText(), typeText(description));
        onView(withId(R.id.amountEditText))
                .perform(clearText(), typeText(value));
        onView(withId(R.id.withdrawButton))
                .perform(click());

        onView(withId(R.id.newTransactionButton))
                .perform(click());
        onView(withId(R.id.descriptionEditText))
                .perform(clearText(), typeText(description));
        onView(withId(R.id.amountEditText))
                .perform(clearText(), typeText(value));
        onView(withId(R.id.depositButton))
                .perform(click());

        onView(withId(R.id.balanceTextView))
                .check(matches(withText(expectedAnswer)));
    }

}
