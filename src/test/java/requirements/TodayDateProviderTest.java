package requirements;

import bankkata.TodayDateProvider;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mock;
//This test will mostlikely fail due to the date changing each day
public class TodayDateProviderTest {
    @Test
    public void provideTodayDate(){
        TodayDateProvider todayDateProvider = new TodayDateProvider();
        String today = todayDateProvider.todayString();
        Assert.assertEquals("28/02/2025",today); // Make sure to change it when reviewing my code
    }
}
