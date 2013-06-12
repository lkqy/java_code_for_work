package org.utility;
import java.util.Comparator;
public class Triple<First, Second, Third extends Comparable>{
	First first;
	Second second;
	Third third;
	public Triple(First f, Second s, Third t){
		first = f;
		second = s;
		third = t;
	}
	public Triple(Triple<First, Second, Third> t){
		first = t.first;
		second = t.second;
		third = t.third;
	}
	public First getFirst(){
		return first;
	}
	public Second getSecond(){
		return second;
	}
	public Third getThird(){
		return third;
	}
	public void setFirst(First f){
		first = f;
	}
	public void setSecond(Second s){
		second = s;
	}
	public void setThird(Third t){
		third = t;
	}
	public String getStr(String sep){
		StringBuilder str = new StringBuilder();
		str.append(first.toString())
			.append(sep)
			.append(second.toString())
			.append(sep)
			.append(third.toString());
		return str.toString();
	}
	public static class AscentCmp implements Comparator{
		public int compare(Object p1, Object p2){
			Triple q1 = (Triple)p1;
			Triple q2 = (Triple)p2;
			return q1.getThird().compareTo(q2.getThird());
		}
	}
	public static class DecentCmp implements Comparator{
		public int compare(Object p1, Object p2){
			Triple q1 = (Triple)p1;
			Triple q2 = (Triple)p2;
			return q2.getThird().compareTo(q1.getThird());
		}
	}
}
