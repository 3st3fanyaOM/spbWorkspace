package streams;

import java.util.stream.Stream;

public class Eje06 {

	public static void main(String[] args) {

		// Crea un array de 10 enteros y devuelve el numero de pares que hay.

		Integer[] numeros = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		Stream<Integer> pares = Stream.of(numeros);

		pares.filter(n -> n % 2 == 0).forEach(System.out::print);
	}
}
