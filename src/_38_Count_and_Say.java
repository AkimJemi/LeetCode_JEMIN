public class _38_Count_and_Say {
    public static void main(String[] args) {
        System.out.println(new Solution38().countAndSay(6));

    }
}

class Solution38 {
    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        String nums = "1";
        for (int i = 2; i <= n; i++) {
            int count = 0;
            String[] strArray = nums.split("");
            nums = "";
            for (int j = 0; j < strArray.length; j++) {
                count++;
                if (j < strArray.length - 1) {
                    if (!strArray[j].equals(strArray[j + 1])) {
                        nums += count + strArray[j];
                        count = 0;
                        continue;
                    }
                }
                if (j == strArray.length - 1) {
                    nums += count + strArray[j];
                    count = 0;
                    continue;
                }
            }
        }
        return nums;
    }
}

