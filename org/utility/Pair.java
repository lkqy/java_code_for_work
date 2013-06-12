package org.utility;
import java.util.Comparator;
public class Pair<First, Second extends Comparable>{
	First first;
	Second second;
	public Pair(Pair<First, Second> p){
		first = p.first;
		second = p.second;
	}
	public Pair(First f, Second s){
		first = f;
		second = s;
	}
	public First getFirst(){
		return first;
	}
	public Second getSecond(){
		return second;
	}
	public void setFirst(First f){
		first = f;
	}
	public void setSecond(Second s){
		second = s;
	}
	public String getStr(String sep){
		StringBuilder str = new StringBuilder();
		str.append(first.toString())
			.append(sep)
			.append(second.toString());
		return str.toString();
	}
	public static class AscentCmp implements Comparator{
		public int compare(Object p1, Object p2){
			Pair q1 = (Pair)p1;
			Pair q2 = (Pair)p2;
			return q1.getSecond().compareTo(q2.getSecond());
		}
	}
	public static class DescentCmp implements Comparator{
		public int compare(Object p1, Object p2){
			Pair q1 = (Pair)p1;
			Pair q2 = (Pair)p2;
			return q2.getSecond().compareTo(q1.getSecond());
		}
	}
}
