class MyHashSet {
	
	private static final int BUCKET = 1001;
	private static final int BUCKETSIZE = 1001;
	private boolean[][] hashArr;
	
    /** Initialize your data structure here. */
    public MyHashSet() {
    	hashArr = new boolean[BUCKET][];
    }
    
    public void add(int key) {
  		int bucketHashCode = hashCodeBucket(key);
  		int bucketSizeHashCode = hashCodeBucketSize(key);
  		
  		if (hashArr[bucketHashCode] == null) {
  			hashArr[bucketHashCode] = new boolean[BUCKETSIZE];
  		}
  		
  		hashArr[bucketHashCode][bucketSizeHashCode] = true;
    }
    
    public void remove(int key) {
        int bucketHashCode = hashCodeBucket(key);
  		int bucketSizeHashCode = hashCodeBucketSize(key);
  		
  		if (hashArr[bucketHashCode] != null) {
  			hashArr[bucketHashCode][bucketSizeHashCode] = false;
  		}
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
    	int bucketHashCode = hashCodeBucket(key);
  		int bucketSizeHashCode = hashCodeBucketSize(key);
  		
  		if (hashArr[bucketHashCode] != null) {
  			return hashArr[bucketHashCode][bucketSizeHashCode];
  		}
  		
  		return false;
    }
    
    private int hashCodeBucket(int key) {
    	return key%BUCKET;
    }
    
    private int hashCodeBucketSize(int key) {
    	return key/BUCKETSIZE;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */