package java17.ex03;

import java.util.function.BinaryOperator;

import org.junit.Test;

import java17.data.Person;

/**
 * Exercice 03 - java.util.function.BinaryOperator
 */
public class Function_03_Test {

	// tag::makeAChild[]
	// TODO Compléter la fonction makeAChild
	// TODO l'enfant possède le nom du père
	// TODO l'enfant possède le prenom "<PRENOM_PERE> <PRENOM_MERE>"
	// TODO l'age de l'enfant est 0
	// TODO le mot de passe de l'enfant est null
	// BinaryOperator<Person> makeAChild = null;
	BinaryOperator<Person> makeAChild = (fp, mp) -> new Person(fp.getFirstname() + " " + mp.getFirstname(),fp.getLastname(), 0, null);

	// Autre façon de l'écrire
//	BinaryOperator<Person> makeAChild = (pere, mere) -> {
//		Person enfant = new Person();
//		enfant.setLastname(pere.getLastname());
//		enfant.setFirstname(pere.getFirstname() + " " + mere.getFirstname());
//		enfant.setAge(0);
//		//enfant.setPassword(null);
//		System.out.println(enfant);
//		return enfant;
//};
	// end::makeAChild[]

	@Test
	public void test_makeAChild() throws Exception {

		Person father = new Person("John", "France", 25, "johndoe");
		Person mother = new Person("Aline", "Lebreton", 22, "alino");

		// TODO compléter le test pour qu'il soit passant
		// Person child = null;
		Person child = makeAChild.apply(father, mother);

		assert child.getFirstname().equals("John Aline");
		assert child.getLastname().equals("France");
		assert child.getAge().equals(0);
		assert child.getPassword() == null;
	}

}
