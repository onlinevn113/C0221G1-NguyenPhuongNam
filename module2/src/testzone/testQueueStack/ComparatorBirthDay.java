package testzone.testQueueStack;
import java.util.Comparator;
public class ComparatorBirthDay implements Comparator<Person> {
    @Override
    public int compare(Person o1, Person o2) {
        return o1.getBirthday().compareTo(o2.getBirthday());
    }
}