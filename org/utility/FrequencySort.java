package org.utility;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FrequencySort<Key>{
	HashMap<Key, Integer> map = new HashMap<Key, Integer>();
	public FrequencySort(){
	}
	public void add(Key k){
		Integer count = map.get(k);
		if(count == null)
			count = 0;
		map.put(k, count + 1);
	}
	public int size(){
		return map.size();
	}
	public List<Key> getSortList(){
		ArrayList<Pair<Key, Integer>> array = new ArrayList<Pair<Key, Integer>>(size());
		for(Map.Entry<Key, Integer> entry : map.entrySet()){
			Pair<Key, Integer> p = new Pair<Key, Integer>(entry.getKey(), entry.getValue());
			array.add(p);
		}
		Collections.sort(array, new Pair.PairCmp());
		ArrayList<Key> keyArray = new ArrayList<Key>(size());
		for(Pair<Key, Integer> p : array){
			keyArray.add(p.getFirst());
		}
		return keyArray;
	}
	public String getSortStr(String sep){
		String s = "";
		StringBuilder str = new StringBuilder();
		for(Key k : getSortList()){
			str.append(s)
				.append(k.toString());
			s = sep;
		}
		return str.toString();
	}
}
