package Programmers.Level1;

import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class 정답률70퍼센트이상문제들 {
    public static void main(String[] args) {
        int[] intArray = new int[]{};
        String[] strArray = new String[]{};
//        System.out.println(new Solution예산().solution(new int[]{1, 3, 2, 5, 4}, 9));
//        System.out.println(new Solution예산().solution(new int[]{2, 2, 3, 3}, 10));
        System.out.println(new Solution예산().solution(new int[]{1}, 2));
    }
}

class Solution예산 {
    public int solution(int[] d, int budget) {
        Arrays.sort(d);
        int sum = 0;
        for (int i = 0; i < d.length; i++) {
            sum += d[i];
            if (sum >= budget) {
                return sum == budget ? i + 1 : i;
            } else if (i == d.length - 1) {
                return i + 1;
            }
        }
        return 0;
    }
    /*
     *Someone else's code to study
     * */
    public int solution1(int[] d, int budget) {
        int answer = 0;
        Arrays.sort(d);
        for (int i = 0; i < d.length; i++) {
            budget -= d[i];
            if (budget < 0) break;
            answer++;
        }
        return answer;
    }
}

class Solution3진법_뒤집기 {
    public int solution(int n) {
        return ternary(n);
    }

    private int ternary(int n) {
        String remainder = String.valueOf(n % 3);
        String[] quotient = String.valueOf(n / 3).split("");

        for (int i = 0; i < quotient.length; i++) {
            if (quotient[i].compareTo("3") >= 1) {
                System.out.println("test :  " + quotient[i].compareTo("3"));

            }
        }
        return 0;

    }
}

class Solution제일_작은_수_제거하기 {
    public int[] solution(int[] arr) {
        if (arr.length == 1) return new int[]{-1};

        List<Integer> integerList = Arrays.stream(arr).boxed().collect(Collectors.toList());
        integerList.remove(integerList.stream().min(Integer::compareTo).get());
        return integerList.stream().mapToInt(Integer::intValue).toArray();
    }
}

class Solution두_개_뽑아서_더하기 {
    public int[] solution(int[] numbers) {
        Set<Integer> set = new TreeSet<>();
        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                set.add(numbers[i] + numbers[j]);
            }
        }
        return set.stream().mapToInt(Integer::intValue).toArray();
    }
}

class Solution문자열_내_마음대로_정렬하기 {
    public String[] solution(String[] strings, int n) {
        return Arrays.stream(strings).sorted((o1, o2) -> {
            if (o1.charAt(n) > o2.charAt(n)) {
                return 1;
            } else if (o1.charAt(n) == o2.charAt(n)) {
                int in = n + 1;
                while (o1.charAt(in) == o2.charAt(in)) {
                    if (in == Math.min(o1.length(), o2.length()) - 1) {
                        break;
                    }
                    in++;
                }
                return o1.charAt(in) > o2.charAt(in) ? 1 : -1;
            }
            return -1;
        }).toArray(String[]::new);
    }
}

class Solution_1차_비밀지도 {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] result = new String[n];
        for (int i = 0; i < n; i++) {
            String sum = String.valueOf(Long.valueOf(Integer.toBinaryString(arr1[i])) + Long.valueOf(Integer.toBinaryString(arr2[i])));
            sum = sum.replaceAll("[1-9]", "#").replace("0", " ");
//            String sum = Integer.toBinaryString(arr1[i] | arr2[i]);
//            sum = sum.replaceAll("1", "#").replace("0", " ");
            result[i] = sum.length() < n ? " ".repeat(n - sum.length()) + sum : sum;
        }
        return result;
    }

    /*
     *Someone else's code to study
     * */
    public String[] solution1(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        for (int i = 0; i < n; i++) {
            StringBuilder str = new StringBuilder();
            int temp = arr1[i] | arr2[i];
            int w = n;
            while (w-- != 0) {
                str.insert(0, (temp % 2) == 1 ? "#" : " ");
                temp >>= 1;
            }
            answer[i] = String.valueOf(str);
        }
        return answer;
    }
}

class Solution서울에서_김서방_찾기 {
    public String solution(String[] seoul) {
        for (int i = 0; i < seoul.length; i++) {
            if (seoul[i].equals("Kim")) {
                return "김서방은 " + i + "에 있다";
            }
        }
        /*
         *Someone else's code to study
         * */
        Arrays.asList(seoul).indexOf("Kim");
        return null;
    }

}

class Solution문자열_다루기_기본 {
    public boolean solution(String s) {
        return s.length() == 4 || s.length() == 6 ? s.chars().allMatch(Character::isDigit) : false;
    }
}

class Solution나누어_떨어지는_숫자_배열 {
    public int[] solution(int[] arr, int divisor) {
        Arrays.sort(arr);
        arr = Arrays.stream(arr).filter(a -> a % divisor == 0).toArray();
        return arr.length != 0 ? arr : new int[]{-1};
    }
}

class Solution문자열_내림차순으로_배치하기 {
    public String solution(String s) {
        return Arrays.stream(s.split("")).sorted(Comparator.reverseOrder()).collect(Collectors.joining());
    }
}


class Solution두_정수_사이의_합 {
    public long solution(int a, int b) {
        long max = Math.max(a, b);
        long min = Math.min(a, b) - 1;
        return (max * (max + 1) / 2) - (min * (min + 1) / 2);
    }
}

class Solution가운데_글자_가져오기 {
    public String solution(String s) {
        int length = s.length();
        return length % 2 == 0 ? s.substring(length / 2 - 1, length / 2 + 1) : s.substring(length / 2, length / 2 + 1);
    }
}


class SolutionK번째수 {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for (int n = 0; n < commands.length; n++) {
            int i = commands[n][0];
            int j = commands[n][1];
            int[] result = new int[j - i + 1];
            for (int index = i - 1; index < j; index++) result[index - (i - 1)] = array[index];
            Arrays.sort(result);
            answer[n] = result[commands[n][2] - 1];
        }
        return answer;
    }

    /*
     *Someone else's code to study
     * */
    public int[] solution1(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for (int i = 0; i < commands.length; i++) {
            int[] temp = Arrays.copyOfRange(array, commands[i][0] - 1, commands[i][1]);
            Arrays.sort(temp);
            answer[i] = temp[commands[i][2] - 1];
        }
        return answer;
    }
}

class Solution내적 {
    public int solution(int[] a, int[] b) {
//        IntStream.range(0, a.length).map(i -> a[i] * b[i]).reduce(Integer::sum).getAsInt();
//        IntStream.range(0, a.length).map(i -> a[i] * b[i]).sum();
        int answer = 0;
        for (int i = 0; i < a.length; i++)
            answer += a[i] * b[i];
        return answer;
    }
}

class Solution음양_더하기 {
    public int solution(int[] absolutes, boolean[] signs) {
        int answer = 0;
        for (int i = 0; i < absolutes.length; i++)
            if (signs[i]) answer += absolutes[i];
            else answer -= absolutes[i];
        return answer;
    }
}

class Solution약수의_개수와_덧셈 {
    public int solution(int left, int right) {
        int answer = 0;
        for (int i = left; i <= right; i++) {
            int cnt = 0;
            for (int j = 1; j * j <= i; j++) {
                if (j * j == i) cnt++;
                else if (i % j == 0) cnt += 2;
            }
            if (cnt % 2 == 0) answer += i;
            else answer -= i;
        }
        return answer;
    }

    /*
     *Someone else's code to study
     * */
    public int solution2(int left, int right) {
        int answer = 0;
        for (int i = left; i <= right; i++) {
            if (i % Math.sqrt(i) == 0) {
                answer -= i;
            } else {
                answer += i;
            }
        }
        return answer;
    }
}

class Solution숫자_문자열과_영단어 {
    public int solution(String s) {
        return Integer.valueOf(s.replace("zero", "0").replace("one", "1").replace("two", "2").replace("three", "3").replace("four", "4").replace("five", "5").replace("six", "6").replace("seven", "7").replace("eight", "8").replace("nine", "9"));
    }

    /*
     *Someone else's code to study
     * */
    public int solution1(String s) {
        String[] strArr = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        for (int i = 0; i < strArr.length; i++) {
            s = s.replaceAll(strArr[i], Integer.toString(i));
        }
        return Integer.parseInt(s);
    }
}

class Solution부족한_금액_계산하기 {
    public long solution(int price, int money, int count) {
        BigInteger priceBig = new BigInteger(String.valueOf(price));
        BigInteger countBig = new BigInteger(String.valueOf((count * (count + 1) / 2)));
        long result = Long.valueOf(priceBig.multiply(countBig).toString()) - money;
        return result < 0 ? 0 : result;
    }

    /*
     *Someone else's code to study
     * */
    // parameter is not long anymore
    public long solution1(long price, long money, long count) {
        return Math.max(price * (count * (count + 1) / 2) - money, 0);
    }

    public long solution2(int price, int money, int count) {
        long totalPrice = (price * count * ((long) count + 1)) / 2;
        return (money >= totalPrice) ? 0 : totalPrice - money;
    }
}

class Solution최소직사각형 {
    public int solution(int[][] sizes) {
        int max = 0;
        int min = 0;
        for (int i = 0; i < sizes.length; i++) {
            if (max < (sizes[i][0] > sizes[i][1] ? sizes[i][0] : sizes[i][1]))
                max = (sizes[i][0] > sizes[i][1] ? sizes[i][0] : sizes[i][1]);
            if (min < (sizes[i][0] < sizes[i][1] ? sizes[i][0] : sizes[i][1]))
                min = sizes[i][0] < sizes[i][1] ? sizes[i][0] : sizes[i][1];
        }
        return max * min;
    }

    /*
     *Someone else's code to study
     * */
    public int solution2(int[][] sizes) {
        int length = 0, height = 0;
        for (int[] card : sizes) {
            length = Math.max(length, Math.max(card[0], card[1]));
            height = Math.max(height, Math.min(card[0], card[1]));
        }
        int answer = length * height;
        return answer;
    }

    public int solution3(int[][] sizes) {
        return Arrays.stream(sizes).reduce((a, b) -> new int[]{
                Math.max(Math.max(a[0], a[1]), Math.max(b[0], b[1])), Math.max(Math.min(a[0], a[1]), Math.min(b[0], b[1]))
        }).map(it -> it[0] * it[1]).get();
    }

}

class Solution없는_숫자_더하기 {
    public int solution(int[] numbers) {
        int sum = 0;
        for (int num : numbers)
            sum += num;
        return 45 - sum;
    }
}

class Solution나머지가_1이_되는_수_찾기 {
    public int solution(int n) {
        return IntStream.range(2, n).filter(a -> n % a == 1).findFirst().getAsInt();
    }
}

class Solution문자열_내_p와_y의_개수 {
    boolean solution(String s) {
        int pCount = 0;
        int sCount = 0;
        for (Character cha : s.toCharArray()) {
            pCount = cha == 'p' || cha == 'P' ? pCount + 1 : pCount;
            sCount = cha == 'y' || cha == 'Y' ? sCount + 1 : sCount;
        }
        return pCount == sCount;
    }

    /*
     *Someone else's code to study
     * */
    boolean solution2(String s) {
        s = s.toUpperCase();
        return s.chars().filter(e -> 'P' == e).count() == s.chars().filter(e -> 'Y' == e).count();
    }

    boolean solution3(String s) {
        return s.replaceAll("[^yY]", "").length() - s.replaceAll("[^pP]", "").length() == 0 ? true : false;
    }
}

