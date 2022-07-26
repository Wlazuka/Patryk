package LekarzeTest;

import Lekarze.Clinic;
import org.apache.commons.collections4.CollectionUtils;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.Arrays;
import java.util.List;

public class Task2 {

    @Test
    public void task2(){
        Clinic clinic = new Clinic();
        List<String> specialisations = clinic.listOfMostPopularSpecialisations();
        List<String> expected = Arrays.asList("nefrolog", "laryngolog");
        Assert.assertTrue(CollectionUtils.isEqualCollection(expected, specialisations));
    }
}
