package seedu.addressbook.commands;

import seedu.addressbook.data.person.ReadOnlyPerson;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Comparator;

public class SortCommand extends Command {

    public static final String COMMAND_WORD = "sort";
    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Sorts entries in alphabetical order."
            + " Indices are also updated.\n"
            + "Example: " + COMMAND_WORD;


    /**
     * Executes the "sort" command.
     * @return Executes "sort" operation.
     */
    @Override
    public CommandResult execute() {
        List<ReadOnlyPerson> allPersons = addressBook.getAllPersons().immutableListView();
        List<ReadOnlyPerson> mutableListView = new ArrayList<>(allPersons);
        Collections.sort(mutableListView, new SortByName());
        return new CommandResult(getMessageForPersonListShownSummary(mutableListView), mutableListView);
    }
}

/**
 * This is used to implement the comparator interface for sorting names alphabetically.
 */
class SortByName implements Comparator<ReadOnlyPerson> {
    public int compare(ReadOnlyPerson p1, ReadOnlyPerson p2) {
        return p1.getName().fullName.compareTo(p2.getName().fullName);
    }
}
