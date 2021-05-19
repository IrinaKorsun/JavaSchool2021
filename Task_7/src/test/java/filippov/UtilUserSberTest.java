package filippov;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class UtilUserSberTest {

    private static final int TEST_COLLECTION_SIZE = 100_000;

    public static void main(String[] args) {
        UtilUserSberTest utilUserSberTest = new UtilUserSberTest();
        utilUserSberTest.zeroMatchesBecauseDifferentNames();
        utilUserSberTest.zeroMatchesBecauseDifferentEmail();
        utilUserSberTest.totalMatches();
        utilUserSberTest.randomMatchesBecauseRandomNames();
    }

    @Test
    void zeroMatchesBecauseDifferentNames() {
        List<UserSber> testList1 = new ArrayList<>();
        List<UserSber> testList2 = new ArrayList<>();
        for (int i = 0; i < TEST_COLLECTION_SIZE; i++) {
            UserSber userSber = new UserSber("Egor" + i, "black-stripe@ya.ru");
            testList1.add(userSber);
            testList2.add(userSber);
        }
        UtilUserSber utilUserSber1 = new UtilUserSber(testList1);
        UtilUserSber utilUserSber2 = new UtilUserSber(testList2);
        MeasuringTime measuringTime = new MeasuringTime();
        measuringTime.start();
        Assertions.assertEquals(utilUserSber1.getCollectionSize(), utilUserSber1.findDuplicates(utilUserSber2.getCollection()).size());
        Assertions.assertTrue(measuringTime.stop() <= 0.2);
    }

    @Test
    void zeroMatchesBecauseDifferentEmail() {
        List<UserSber> testList1 = new ArrayList<>();
        List<UserSber> testList2 = new ArrayList<>();
        for (int i = 0; i < TEST_COLLECTION_SIZE; i++) {
            UserSber userSber1 = new UserSber("Egor" + i, "black-stripe@ya.ru");
            testList1.add(userSber1);
            userSber1 = new UserSber("Egor" + i, "black-stripe" + i + "@ya.ru");
            testList2.add(userSber1);
        }
        UtilUserSber utilUserSber1 = new UtilUserSber(testList1);
        UtilUserSber utilUserSber2 = new UtilUserSber(testList2);
        MeasuringTime measuringTime = new MeasuringTime();
        measuringTime.start();
        Assertions.assertEquals(0, utilUserSber1.findDuplicates(utilUserSber2.getCollection()).size());
        Assertions.assertTrue(measuringTime.stop() <= 0.2);

    }

    @Test
    void totalMatches() {
        List<UserSber> testList1 = new ArrayList<>();
        List<UserSber> testList2 = new ArrayList<>();
        for (int i = 0; i < TEST_COLLECTION_SIZE; i++) {
            UserSber userSber = new UserSber("Egor" + i, "black-stripe@ya.ru");
            testList1.add(userSber);
            testList2.add(userSber);
        }
        UtilUserSber utilUserSber1 = new UtilUserSber(testList1);
        UtilUserSber utilUserSber2 = new UtilUserSber(testList2);
        MeasuringTime measuringTime = new MeasuringTime();
        measuringTime.start();
        Assertions.assertEquals(utilUserSber1.getCollectionSize(), utilUserSber1.findDuplicates(utilUserSber2.getCollection()).size());
        Assertions.assertTrue(measuringTime.stop() <= 0.2);
    }

    @Test
    void randomMatchesBecauseRandomNames() {
        UtilUserSber utilUserSber1 = new UtilUserSber(TEST_COLLECTION_SIZE);
        UtilUserSber utilUserSber2 = new UtilUserSber(TEST_COLLECTION_SIZE);
        MeasuringTime measuringTime = new MeasuringTime();
        measuringTime.start();
        Assertions.assertTrue((TEST_COLLECTION_SIZE / 100) < (utilUserSber1.findDuplicates(utilUserSber2.getCollection()).size()));
        Assertions.assertTrue(measuringTime.stop() <= 0.2);
    }

}