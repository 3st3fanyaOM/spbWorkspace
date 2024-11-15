package com.example.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PalindromoController {

	/**
	 * 
	 * @param palabra palabra para comprobar
	 * @return mensaje indicando si la palabra es palíndromo o no.
	 */
	@GetMapping("/palindromo/{palabra}")
	public String esPalindromo(@PathVariable String palabra) {

		for (int i = 0, j = palabra.length() - 1; i < j; i++, j--) {
			if (palabra.charAt(i) != palabra.charAt(j)) {
				return palabra + " no es palindromo";
			}
		}
		return palabra + " es palíndromo";
	}

}
