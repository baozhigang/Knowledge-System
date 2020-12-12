public class GreedyAlgorithm {
    public static void main(String[] args) {
        // 创建广播电台，放入到Map当中
        HashMap<String, HashSet<String>> broadcasts = new HashMap<String, HashSet<String>>();
        // 将各个电台放入到broadcasts
        HashSet<String> hashSet1 = new HashSet<String>();
        hashSet1.add("北京");
        hashSet1.add("上海");
        hashSet1.add("天津");

        HashSet<String> hashSet2 = new HashSet<String>();
        hashSet2.add("广州");
        hashSet2.add("北京");
        hashSet2.add("深圳");

        HashSet<String> hashSet3 = new HashSet<String>();
        hashSet3.add("成都");
        hashSet3.add("上海");
        hashSet3.add("杭州");

        HashSet<String> hashSet4 = new HashSet<String>();
        hashSet4.add("上海");
        hashSet4.add("天津");

        HashSet<String> hashSet5 = new HashSet<String>();
        hashSet5.add("杭州");
        hashSet5.add("大连");

        // 加入到Map里面
        broadcasts.put("K1", hashSet1);
        broadcasts.put("K2", hashSet2);
        broadcasts.put("K3", hashSet3);
        broadcasts.put("K4", hashSet4);
        broadcasts.put("K5", hashSet5);

        // 存放所有的地区
        HashSet<String> allAreas = new HashSet<String>();
        for (String key : broadcasts.keySet()) {
            allAreas.addAll(broadcasts.get(key));
        }

        // 存放选择的电台集合
        ArrayList<String> selects = new ArrayList<String>();

        // 临时集合，存放遍历过程中覆盖的区域和当前还没有覆盖的区域的交集
        HashSet<String> tempSet = new HashSet<String>();

        // 定义给maxKey，
        String maxKey = null;
        // 每一次遍历找到包含最多未覆盖地区的集合，找到后从所有地区中去掉。最关键点
        while(allAreas.size() != 0) {
            maxKey = null;

            // 遍历broadcasts 找到包含最多未覆盖地区的集合，key赋值给maxKey
            for (String key : broadcasts.keySet()) {
                tempSet.clear();
                HashSet<String> areas = broadcasts.get(key);
                tempSet.addAll(areas);
                // tempSet和allAreas 取交集，赋值给tempSet
                tempSet.retainAll(allAreas);
                if (tempSet.size() > 0 && (maxKey == null || tempSet.size() > broadcasts.get(maxKey).size() )) {
                    maxKey = key;
                }
            }
            // maxKey != null，将maxKey加入到selects中
            if (maxKey != null) {
                selects.add(maxKey);
                // maxKey指向的广播电台覆盖的区域去掉
                allAreas.removeAll(broadcasts.get(maxKey));
            }
        }

        System.out.println(selects);
    }
}
