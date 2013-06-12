package org.utility;
import org.utility.Pair;
public class Main{
	public static void main(String [] args){
		Pair<Integer, Integer> p = new Pair<Integer, Integer>(10, 11);
		Pair<Integer, Integer> q = new Pair<Integer, Integer>(10, 12);
		Pair.AscentCmp cmp = new Pair.AscentCmp();

		out(cmp.compare(p, q));
	}
	static void out(int a){
		System.out.println(a);
	}

}
