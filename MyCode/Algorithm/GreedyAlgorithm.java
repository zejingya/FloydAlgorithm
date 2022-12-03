package Algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class GreedyAlgorithm {

    public static void main(String[] args) {

        HashMap<String, HashSet<String>> broadcasts = new HashMap<String, HashSet<String>>();
        HashSet<String> hashSet1 = new HashSet<String>();
        hashSet1.add("����");
        hashSet1.add("�Ϻ�");
        hashSet1.add("���");

        HashSet<String> hashSet2 = new HashSet<String>();
        hashSet2.add("����");
        hashSet2.add("����");
        hashSet2.add("����");

        HashSet<String> hashSet3 = new HashSet<String>();
        hashSet3.add("�ɶ�");
        hashSet3.add("�Ϻ�");
        hashSet3.add("����");


        HashSet<String> hashSet4 = new HashSet<String>();
        hashSet4.add("�Ϻ�");
        hashSet4.add("���");

        HashSet<String> hashSet5 = new HashSet<String>();
        hashSet5.add("����");
        hashSet5.add("����");

        //���뵽map
        broadcasts.put("K1", hashSet1);
        broadcasts.put("K2", hashSet2);
        broadcasts.put("K3", hashSet3);
        broadcasts.put("K4", hashSet4);
        broadcasts.put("K5", hashSet5);

        //allAreas ������еĵ���
        HashSet<String> allAreas = new HashSet<String>();
        allAreas.add("����");
        allAreas.add("�Ϻ�");
        allAreas.add("���");
        allAreas.add("����");
        allAreas.add("����");
        allAreas.add("�ɶ�");
        allAreas.add("����");
        allAreas.add("����");

        ArrayList<String> selects = new ArrayList<String>();
        HashSet<String> tempSet = new HashSet<String>();
        String maxKey = null;

        while (allAreas.size() != 0){

            maxKey = null;

            for (String key :
                    broadcasts.keySet()) {

                tempSet.clear();
                HashSet<String> areas = broadcasts.get(key);

                tempSet.addAll(areas);
                tempSet.retainAll(allAreas);
                if (tempSet.size() > 0 && (maxKey == null || tempSet.size() >broadcasts.get(maxKey).size())){
                    maxKey = key;
                }
            }

            if(maxKey != null) {
                selects.add(maxKey);
                allAreas.removeAll(broadcasts.get(maxKey));
            }
        }
        System.out.println("�õ���ѡ������" + selects);
    }
}
