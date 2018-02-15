package seedu.addressbook.data.person;

public abstract class Contact {

    public String value;
    public  boolean isPrivate;

    @Override
    public String toString() {
        return value;
    }

    public abstract boolean isValid(String value);

    public boolean isPrivate() {
        return isPrivate;
    }
    @Override
    public int hashCode() {
        return value.hashCode();
    }
}
