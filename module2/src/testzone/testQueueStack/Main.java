package testzone.testQueueStack;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        List<Person> personList = new ArrayList<>();
        personList.add(new Person("Khanh","girl","11/10/2002"));
        personList.add(new Person("Thảo","girl","1/10/1998"));
        personList.add(new Person("Nam","men","14/10/1988"));
        personList.add(new Person("Nhung","girl","15/10/1998"));
        personList.add(new Person("Yến","girl","13/10/1998"));
        Collections.sort(personList , new ComparatorBirthDay());
//        for (Person iteam : personList){
//            System.out.println(iteam + "\n");
//        }
        Queue<Person> queueNu = new LinkedList<>();
        Queue<Person> queueNam = new LinkedList<>();
        while (!personList.isEmpty()){
            Person iteam=personList.remove(0);
            if (iteam.getGender().equals("girl")){
                queueNu.add(iteam);
            }else if (iteam.getGender().equals("men")){
                queueNam.add(iteam);
            }
        }
        while (!queueNu.isEmpty()){
            personList.add(queueNu.remove());
        }
        while (!queueNam.isEmpty()){
            personList.add(queueNam.remove());
        }
        for (Person item : personList){
            System.out.println(item + "\n");
        }
    }
}
