public class MyHashSet {
	
	private static final int BUCKET = 1000;
	private static final int BUCKETSIZE = 1000;
	private boolean[] hashArr;
	
    /** Initialize your data structure here. */
    public MyHashSet() {
    	hashArr = new boolean[BUCKET][];
    }
    
    public void add(int key) {
  
    }
    
    public void remove(int key) {
        
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
     
    }
    
    private int hashCodeBucket(int key) {
    	return key % 5;
    }
    
    private int hashCodeBucketSize(int key) {
    	return key / 5;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */