package filippov;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PersonFactoryTest {

    @Test
    void PersonFactoryCreatesThroughIteratedPersonType() {
        PersonFactory personFactory = new PersonFactory();
        List<Person> personsArray = new ArrayList<>(PersonType.values().length);
        for (int i = 0; i < PersonType.values().length; i++) {
            personsArray.add(personFactory.createPerson("Name" + i, i));
        }
        for (int i = 0; i < PersonType.values().length; i++) {
            assertEquals(PersonType.values()[i], personsArray.get(i).getPersonType());
        }
    }
}