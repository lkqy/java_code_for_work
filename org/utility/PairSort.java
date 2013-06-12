package org.utility;
import java.util.AbstractList;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PairSort<Key, Value extends Comparable>{
	ArrayList<Pair<Key, Value>> array;// = new ArrayList<Pair<Key, Value>>();
	void init(int size){
		array = new ArrayList<Pair<Key, Value>>(size);
	}
	public PairSort(){
		init(16);
	}
	public PairSort(AbstractList<Pair<Key, Value>> l){
		init(l.size());
		add(l);
	}
	public PairSort(AbstractMap<Key, Value> map){
		init(map.size());
		add(map);
	}
	public void add(Key k, Value v){
		array.add(new Pair<Key, Value>(k, v));
	}
	public void add(Pair<Key, Value> p){
		array.add(p);
	}
	public void add(AbstractList<Pair<Key, Value>> l){
		for(Pair<Key, Value> p : l){
			array.add(p);
		}
	}
	public void add(AbstractMap<Key, Value> map){
		for(Map.Entry<Key, Value> entry : map.entrySet()){
			add(entry.getKey(), entry.getValue());
		}
	}
	public int size(){
		return array.size();
	}
	List<Pair<Key, Value>> getSortList(Comparator cmp){
		Collections.sort(array, cmp);
		return array;
	}
	public List<Pair<Key, Value>> getAscentList(){
		return getSortList(new Pair.AsscentCmp());
	}
	public List<Pair<Key, Value>> getDecentList(){
		return getSortList(new Pair.DecentCmp());
	}
	String getStr(List<Pair<Key, Value>> list, String sepin, String sepout){
		String s = "";
		StringBuilder str = new StringBuilder();
		for(Pair<Key, Value> p: list){
			str.append(s)
				.append(p.getFirst())
				.append(sepin)
				.append(p.getSecond());
			s = sepout;
		}
		return str.toString();
	}
	public String getAsscentStr(String sepin, String sepout){
		return getStr(getAscentList(), sepin, sepout);
	}
	public String getAsscentStr(String sepin, String sepout){
		return getStr(getDecentList(), sepin, sepout);
	}
}
