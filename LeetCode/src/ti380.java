import java.util.*;

public class ti380 {
    public static void main(String[] args) {
        RandomizedSet a = new RandomizedSet();
        a.insert(12);

        System.out.println(a.remove(12));
    }
}

    class RandomizedSet {
        List<Integer>nums;
        Map<Integer,Integer>index;
        Random random;

        public RandomizedSet() {
            nums = new ArrayList<Integer>();
            index = new HashMap<Integer,Integer>();
            random = new Random();

        }

        public boolean insert(int val) {
            if(index.containsKey(val)){
                return false;
            }else {
                nums.add(val);
                int key = nums.size() - 1;
                index.put(key,val);
                return true;
            }
        }

        public boolean remove(int val) {
            if (!index.containsKey(val)){
                return false;
            }
            int key = index.get(val);//���Ǻܶ�
            int last = nums.get(nums.size() - 1);
            nums.set(key, last);
            index.put(last, key);
            nums.remove(nums.size() - 1);
            index.remove(val);
            return true;

        }

        public int getRandom() {
            int randomindex = random.nextInt(nums.size());
            return nums.get(randomindex);
        }
    }

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
/*class RandomizedSet {
    List<Integer> nums;
    Map<Integer, Integer> indices;
    Random random;

    public RandomizedSet() {
        nums = new ArrayList<Integer>();
        indices = new HashMap<Integer, Integer>();
        random = new Random();
    }

    public boolean insert(int val) {
        if (indices.containsKey(val)) {
            return false;
        }
        int index = nums.size();
        nums.add(val);
        indices.put(val, index);
        return true;
    }

    public boolean remove(int val) {
        if (!indices.containsKey(val)) {
            return false;
        }
        int index = indices.get(val);
        int last = nums.get(nums.size() - 1);
        nums.set(index, last);
        indices.put(last, index);
        nums.remove(nums.size() - 1);
        indices.remove(val);
        return true;
    }

    public int getRandom() {
        int randomIndex = random.nextInt(nums.size());
        return nums.get(randomIndex);
    }
}
 */
