package edu.ti.caih313.collections.aggregate;

import edu.ti.caih313.collections.dataobj.EmailAddress;
import edu.ti.caih313.collections.dataobj.Name;
import edu.ti.caih313.collections.dataobj.Person;

import java.util.Arrays;

import static edu.ti.caih313.collections.dataobj.Person.Gender.*;
import static edu.ti.caih313.collections.dataobj.EmailAddress.EmailType;

public class PeopleFilterDemo {
    public static void main(String... args) {
//        Person personArray[] = {
//                new Person(new Name("John", "Smith"), MALE, 42),
//                new Person(new Name("Karl", "Ng"), MALE, 73),
//                new Person(new Name("Jeff", "Smith"), MALE, 21),
//                new Person(new Name("Tom", "Rich"), MALE, 18),
//                new Person(new Name("Bob", "Smith"), MALE, 13),
//                new Person(new Name("Jane", "Doe"), FEMALE, 27),
//                new Person(new Name("Tony", "Stark"), MALE, 52),
//                new Person(new Name("Bo", "Peep"), FEMALE, 205)
//        };

        Person johnSmith = new Person(new Name("John", "Smith"), MALE, 42, null);
        johnSmith.EmailAddress(EmailAddress.EmailType.SCHOOL, "john.smith@ti.htc.edu");
        johnSmith.EmailAddress(EmailAddress.EmailType.HOME, "john@gmail.com");
        johnSmith.EmailAddress(EmailAddress.EmailType.WORK, "smith.john@careonerx.com");

        Person karlNg = new Person(new Name("Karl", "Ng"), MALE, 73, null);
        karlNg.EmailAddress(EmailAddress.EmailType.SCHOOL, "karl.ng@ti.htc.edu");
        karlNg.EmailAddress(EmailAddress.EmailType.WORK, "ng.karl@careonerx.com");

        Person jeffSmith = new Person(new Name("Jeff", "Smith"), MALE, 21, null);
        jeffSmith.EmailAddress(EmailAddress.EmailType.SCHOOL, "jeff.smith@ti.htc.edu");
        jeffSmith.EmailAddress(EmailAddress.EmailType.HOME, "jeff@gmail.com");

        Person tomRich = new Person(new Name("Tom", "Rich"), MALE, 18, null);
        tomRich.EmailAddress(EmailAddress.EmailType.SCHOOL, "tom.rich@ti.htc.edu");

        Person bobSmith = new Person(new Name("Bob", "Smith"), MALE, 13, null);
        bobSmith.EmailAddress(EmailAddress.EmailType.SCHOOL, "bob.smith@ti.htc.edu");

        Person janeDoe = new Person(new Name("Jane", "Doe"), FEMALE, 27, null);
        janeDoe.EmailAddress(EmailAddress.EmailType.SCHOOL, "jane.doe@ti.htc.edu");
        janeDoe.EmailAddress(EmailAddress.EmailType.HOME, "jane@gmail.com");

        Person tonyStark = new Person(new Name("Tony", "Stark"), MALE, 52, null);
        tonyStark.EmailAddress(EmailAddress.EmailType.SCHOOL, "tony.stark@ti.htc.edu");
        tonyStark.EmailAddress(EmailAddress.EmailType.WORK, "stark.tony@careonerx.com");

        Person boPeep = new Person(new Name("Bo", "Peep"), FEMALE, 205, null);
        boPeep.EmailAddress(EmailAddress.EmailType.SCHOOL, "bo.peep@ti.htc.edu");
        boPeep.EmailAddress(EmailAddress.EmailType.HOME, "bo@gmail.com");
        boPeep.EmailAddress(EmailAddress.EmailType.WORK, "peep.bo@careonerx.com");

        Person personArray[] = {johnSmith, karlNg, jeffSmith, tomRich, bobSmith, janeDoe, tonyStark, boPeep};


        System.out.println("List of Person's school email addresses: ");
        Arrays.stream(personArray)
                .forEach(e -> System.out.println(e.getEmailMap().get(EmailAddress.EmailType.SCHOOL)));

        System.out.println();
        System.out.println("List of all Person's emails over the age of 30:");
        Arrays.stream(personArray)
                .filter(p -> p.getAge()>30)
                .forEach(e -> System.out.println(e.getName().getFirstName() + " " + e.getName().getLastName() +
                        "'s email addresses are: " + e.getEmailMap().values()));

        System.out.println();
        System.out.println("Print out of how many email addresses each Person has.");
        Arrays.stream(personArray)
                .sorted((p1, p2) -> p1.getEmailMap().size() - p2.getEmailMap().size())
                .forEach(p -> System.out.println(p.getName().getFirstName() + p.getName().getLastName() +
                        " has " + p.getEmailMap().size() + " email addresses."));

        System.out.println();
        System.out.println("All Person's emails, ordered by number of email addresses, last name, first name: ");
        Arrays.stream(personArray)
                .sorted((p1, p2) -> p1.getEmailMap().size() - p2.getEmailMap().size())
//                .sorted((p1, p2) -> p1.getName().getLastName().compareTo(p2.getName().getLastName()))
//                .sorted((p1, p2) -> p1.getName().getFirstName().compareTo(p2.getName().getFirstName()))
                .forEach(p -> System.out.println(p.getName().getFirstName() + " " + p.getName().getLastName() +
                        " has " + p.getEmailMap().size() + " email addresses."));
    }
}


//        Extra credit/honors:
//        Write a pipeline, given a Person collection, to:
//        Print each name, followed by number of email addresses; ordered by number of email address, last name, first name


//        Person personArray[] = {johnSmith};
//        System.out.println("All persons");
//        Arrays.stream(personArray).forEach(e -> System.out.println(e.getName()));
//
//        System.out.print("\n");
//        long numOver20 = Arrays.stream(personArray).filter(p -> p.getAge() > 20).count();
//        System.out.println("Number of persons older than 20: " + numOver20);
//
//        System.out.print("\n");
//        System.out.println("All persons older than 20");
//        Arrays.stream(personArray)
//                .filter(p -> p.getAge()>20)
//                .forEach(e -> System.out.println(e.getName()));
//
//        System.out.print("\n");
//        System.out.println("All " + MALE + " persons");
//        Arrays.stream(personArray)
//                .filter(p -> p.getGender()==MALE)
//                .forEach(p -> System.out.println(p.getName()));
//
//        System.out.print("\n");
//        OptionalDouble averageFemaleAge =
//                Arrays.stream(personArray)
//                .filter(p -> p.getGender()==FEMALE)
//                .mapToInt(Person::getAge) // <=> mapToInt(p -> p.getAge())
//                .average();
//        if (averageFemaleAge.isPresent()) {
//            System.out.println("Average age of  "
//                    + FEMALE + " persons = "
//                    + averageFemaleAge.getAsDouble());
//        } else {
//            System.out.println("Average age of  "
//                    + FEMALE + " persons is not available.");
//        }
//
//        System.out.print("\n");
//        System.out.println("All persons in age order");
//        Arrays.stream(personArray)
//                .sorted((p1,p2) -> (p1.getAge() - p2.getAge()))
//                .forEach(e -> System.out.println(e.getName()));
//
//        System.out.print("\n");
//        System.out.println("First four last names uppercased.");
//        Stream<String> fourLastNamesUpperStream =
//                Arrays.stream(personArray)
//                .map(p -> p.getName().getLastName().toUpperCase())
//                .sorted()
//                .limit(4);
//        fourLastNamesUpperStream.forEach(s -> System.out.print(s + ", "));
//    }
//}
