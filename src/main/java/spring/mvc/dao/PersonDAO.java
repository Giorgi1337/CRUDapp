package spring.mvc.dao;

import org.springframework.stereotype.Component;
import spring.mvc.models.Person;

import java.util.ArrayList;
import java.util.List;
@Component
public class PersonDAO {
    private static int PEOPLE_COUNT;
    private List<Person> people;

    {
        people = new ArrayList<>();

        people.add(new Person(++PEOPLE_COUNT,"Giorgi",21,"kvacabaya02@gmail.com"));
        people.add(new Person(++PEOPLE_COUNT,"Anna",25,"Anna25@gmai.com"));
        people.add(new Person(++PEOPLE_COUNT,"Mike",30, "supermike@yeahoo.com"));
        people.add(new Person(++PEOPLE_COUNT,"Katy", 29,"Katkat29@gmail.com"));
    }

    public List<Person> index() {
        return people;
    }
    public Person show(int id) {
        return people.stream().filter(person -> person.getId() == id)
                .findAny().orElse(null);
    }
    public void save(Person person) {
        person.setId(++PEOPLE_COUNT);
        people.add(person);
    }

    public void update(int id, Person updatedperson) {
        Person personToBeUpdated = show(id);

        personToBeUpdated.setName(updatedperson.getName());
        personToBeUpdated.setAge(updatedperson.getAge());
        personToBeUpdated.setName(updatedperson.getName());
    }

    public void delete(int id) {
        people.removeIf(p -> p.getId() == id);
    }
}
