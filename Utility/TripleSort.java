import java.util.AbstractList;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TripleSort<First, Second, Third extends Comparable>{
	ArrayList<Triple<First, Second, Third>> array;// = new ArrayList<Triple<First, Third>>();
	void init(int size){
		array = new ArrayList<Triple<First, Second, Third>>(size);
	}
	public TripleSort(){
		init(16);
	}
	public TripleSort(AbstractList<Triple<First, Second, Third>> l){
		init(l.size());
		add(l);
	}
	public void add(First f, Second s, Third t){
		array.add(new Triple<First, Second, Third>(f, s, t));
	}
	public void add(Triple<First, Second, Third> p){
		array.add(p);
	}
	public void add(AbstractList<Triple<First, Second, Third>> l){
		for(Triple<First, Second, Third> p : l){
			array.add(p);
		}
	}
	public int size(){
		return array.size();
	}
	public List<Triple<First, Second, Third>> getSortList(){
		Collections.sort(array, new Triple.TripleCmp());
		return array;
	}
	public String getSortStr(String sepin, String sepout){
		String s = "";
		StringBuilder str = new StringBuilder();
		for(Triple<First, Second, Third> p: getSortList()){
			str.append(s)
				.append(p.getFirst())
				.append(sepin)
				.append(p.getSecond())
				.append(sepin)
				.append(p.getThird());
			s = sepout;
		}
		return str.toString();
	}
}
