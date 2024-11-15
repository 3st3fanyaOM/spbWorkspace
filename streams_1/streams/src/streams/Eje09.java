package streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Eje09 {

	public static void main(String[] args) {
		/*
		 * Dado una clase Persona, con nombre y edad, crear un main con una lista de 5
		 * personas y obtener sólo aquellas personas mayores de 25 años y ordenarlas por
		 * nombre e imprimir el resultado. Imprimirlos de la forma: nombre ( edad ) Ej:
		 * Ana (30 años)
		 */

		List<Persona> personas = new ArrayList<>();

		Persona p1 = new Persona("Juan", 23);
		Persona p2 = new Persona("Ana", 19);
		Persona p3 = new Persona("Diana", 33);
		Persona p4 = new Persona("Belén", 40);
		Persona p5 = new Persona("José", 26);

		personas.add(p5);
		personas.add(p4);
		personas.add(p3);
		personas.add(p2);
		personas.add(p1);

		Stream<Persona> mayoresDe25 = personas.stream();

		mayoresDe25.filter(n -> n.getEdad() > 25).sorted().forEach(System.out::print);
	}

}
