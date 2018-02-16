package seedu.addressbook.commands;

import org.junit.Test;
import seedu.addressbook.data.AddressBook;
import seedu.addressbook.data.person.ReadOnlyPerson;
import seedu.addressbook.data.person.UniquePersonList;
import seedu.addressbook.util.TypicalPersons;

import java.util.Collections;
import java.util.List;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;
public class SortCommandTest {

    private final AddressBook addressBook = new AddressBook();
    private final TypicalPersons testPersons = new TypicalPersons();
    private List<ReadOnlyPerson> listOfTypicalPersons = Arrays.asList(testPersons.amy, testPersons.bill, testPersons.candy);

    /**
     * Sets up the addressbook to test the SortCommand.
     * @throws UniquePersonList.DuplicatePersonException
     */
    private void assertSortCommandBehavior() throws UniquePersonList.DuplicatePersonException{
        SortCommand command = new SortCommand();
        command.setData(addressBook, Collections.emptyList());
        command.addressBook.addPerson(testPersons.candy);
        command.addressBook.addPerson(testPersons.amy);
        command.addressBook.addPerson(testPersons.bill);
        CommandResult result = command.execute();
        assertEquals(Command.getMessageForPersonListShownSummary(listOfTypicalPersons),result.feedbackToUser);
    }



    /**
     * Executes a sort operation test.
     */
    @Test
    public void execute_sort() throws UniquePersonList.DuplicatePersonException {
        assertSortCommandBehavior();
    }


}
