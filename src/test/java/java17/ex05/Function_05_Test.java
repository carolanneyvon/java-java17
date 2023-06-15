package java17.ex05;

import java.util.List;
import java.util.function.Consumer;

import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
//import static org.hamcrest.MatcherAssert.assertThat;
//import static org.hamcrest.Matchers.greaterThan;

import java17.data.Data;
import java17.data.Person;

/**
 * Exercice 5 - java.util.function.Consumer
 */
public class Function_05_Test {

    //tag::functions[]
    // TODO compléter la fonction
    // TODO modifier le mot de passe en "secret"
    // Consumer<Person> changePasswordToSecret = null;
	 Consumer<Person> changePasswordToSecret = p -> p.setPassword("secret");

    // TODO compléter la fonction
    // TODO vérifier que l'age > 4 avec une assertion JUnit
    // Consumer<Person> verifyAge = null;
	 Consumer<Person> verifyAge = p -> assertTrue(p.getAge() > 4);
	 
	// Autre façon de l'écrire 
//	Consumer<Person> verifyAge = p -> assertThat(p.getAge(), greaterThan(4));

    // TODO compléter la fonction
    // TODO vérifier que le mot de passe est "secret" avec une assertion JUnit
    // Consumer<Person> verifyPassword = null;
	 Consumer<Person> verifyPassword = p -> assertEquals("secret", p.getPassword());
    //end::functions[]


    @Test
    public void test_consumer() throws Exception {
        List<Person> personList = Data.buildPersonList();

        // TODO invoquer la méthode personList.forEach pour modifier les mots de passe en "secret"
        // personList.forEach...
        personList.forEach(changePasswordToSecret);

        // TODO remplacer la boucle for par l'invocation de la méthode forEach
        // TODO Utiliser la méthode andThen pour chaîner les vérifications verifyAge et verifyPassword
        // personList.forEach...
        personList.forEach((p) -> verifyAge.andThen(verifyPassword));
        
//        for(Person p : personList) {
//            verifyAge.accept(p);
//            verifyPassword.accept(p);
//        }
    }
}
