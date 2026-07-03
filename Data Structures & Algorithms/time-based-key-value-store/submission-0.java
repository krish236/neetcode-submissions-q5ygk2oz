class Pair{
    String value;
    int timestamp;

    Pair(String value, int timestamp){
        this.value = value;
        this.timestamp = timestamp;
    }
}
class TimeMap {
    Map<String,List<Pair>>mp;
    public TimeMap() {
        mp = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        Pair p= new Pair(value,timestamp);
        mp.putIfAbsent(key, new ArrayList<>());
        mp.get(key).add(p);
    }
    
    public String get(String key, int timestamp) {
        List<Pair>ls = mp.get(key);
        if(ls==null) return "";
        String res = "";
        
        int low = 0;
        int high = ls.size()-1;


        while(low<=high){
            int mid = (low+high)/2;

            if(ls.get(mid).timestamp<=timestamp){
                res = ls.get(mid).value;
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }

        return res;
    }
}
