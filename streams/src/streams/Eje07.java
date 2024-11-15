package streams;

import java.util.stream.Stream;

public class Eje07 {

	public static void main(String[] args) {
		// Multiplicar todos los elementos de un array de 10 numeros

		Integer[] numeros = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		Stream<Integer> producto = Stream.of(numeros);
		Integer resultado = producto.reduce(1, (a, b) -> a * b);
		System.out.println(resultado);

	}

}
