package ciic4020.lab7.map.studentRecord;

public interface KeyExtractor<K, V> {
	public K getKey(V value);
}
