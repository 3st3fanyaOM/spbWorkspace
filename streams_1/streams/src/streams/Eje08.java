package streams;

import java.util.stream.Stream;

public class Eje08 {

	public static void main(String[] args) {
		// Dado un array de 5 precios, devolver en una lista
		// los mayores de 20 euros. Usar Double.

		Double[] precios = { 5.90, 6.50, 21.70, 11.90, 55.50 };
		Stream<Double> masDe20 = Stream.of(precios);
		masDe20.filter(n -> n > 20.00).toList();

	}

}
