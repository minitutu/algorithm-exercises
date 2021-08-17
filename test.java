public class Main {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int[] input = null;
        int m = 0;

        String first = reader.nextLine();
        String second = reader.nextLine();
        int arrayLen = Integer.parseInt(first.split(" ")[0]);
        m = Integer.parseInt(first.split(" ")[1]);
        input = new int[arrayLen];
        for (int i = 0; i < arrayLen; i++) {
            String[] inputs = second.split(" ");
            input[i] = Integer.parseInt(inputs[i]);
        }

        if (input == null || input.length == 0 ) {
            System.out.println(0);
        }
        int j = 0;
        int len = 1;
        TreeMap<Integer, List<Integer>> maxMinMap = new TreeMap<>();
        HashMap<Integer, Integer> indexMap = new HashMap<>();
        for(int i=0; i< input.length; i++){
            while(j < input.length){
                maxMinMap.putIfAbsent(input[j], new ArrayList<>());
                maxMinMap.get(input[j]).add(j);
                //index放入值对应的列表
                indexMap.put(j, input[j]);
                if(!maxMinMap.isEmpty() && maxMinMap.lastKey() - maxMinMap.firstKey() > m ) {
                    //最大最小值超过m, 移动左指针
                    break;
                }
                len = Math.max(len, j-i+1);
                //计算最大值
                j++;
            }
            if(!maxMinMap.isEmpty()){
                //获得当前左指针index对应的值
                int val = indexMap.get(i);
                List<Integer> resultList = maxMinMap.getOrDefault(val, new ArrayList<>());
                //拿到值对应的列表
                if(!resultList.isEmpty()) {
                    resultList.remove(Integer.valueOf(i));
                    //去掉在列表中的当前值
                    if(resultList.isEmpty()) {
                        //如果空列表, 移除列表
                        maxMinMap.remove(val);
                    }
                }
            }
        }
        System.out.println(len);;
    }
}
