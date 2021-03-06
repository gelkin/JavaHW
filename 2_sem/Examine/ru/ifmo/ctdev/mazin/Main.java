package ru.ifmo.ctdev.mazin;

import java.util.List;
import java.util.ArrayList;

import ru.ifmo.ctdev.mazin.*;

public class Main {
	public static void main(String[] args) {
		
		List<Evaluable> elements = new ArrayList<Evaluable>();
		List<Integer> result = new ArrayList<Integer>();
		String[] strs = args[0].split("\\|");
		try {
			for (int i = 0; i < strs.length; i++) {
				elements.add(new Parser().parse(strs[i]));
				result.add(elements.get(i).evaluate(elements, result));
			}
		} catch (NumException e) {
			System.out.println(e.get());
		} catch (ExpException e) {
			System.out.println(e.get());
		}
		for (int i = 0; i < result.size(); i++) {
			System.out.print(result.get(i) + "|");
		}
		System.out.println("");

	}
}
