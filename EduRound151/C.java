package CodeForces_Contest.EduRound151;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class C {



    public static void main(String[] args) {
        FastScanner scanner =new FastScanner();
        PrintWriter out=new PrintWriter(System.out);
        int T = scanner .nextInt();

        for (int tt=0; tt<T; tt++) {
            String s = scanner.next();

            List<List<Integer>> current = new ArrayList<>(10);
            List<Integer> idx = new ArrayList<>(10);
            for (int i = 0; i < 10; i++) {
                current.add(new ArrayList<>());
                idx.add(0);
            }

            for (int i = 0; i < s.length(); i++) {
                int digit = s.charAt(i) - '0';
                current.get(digit).add(i);
            }

            int m = scanner.nextInt();
            String left = scanner.next();
            String right = scanner.next();
            int cols = 0;

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < 10; j++) {
                    while (idx.get(j) < current.get(j).size() && current.get(j).get(idx.get(j)) < cols) {
                        idx.set(j, idx.get(j) + 1);
                    }
                }

                int rows = cols;
                for (int j = left.charAt(i) - '0'; j <= right.charAt(i) - '0'; j++) {
                    if (idx.get(j) >= current.get(j).size()) {
                        rows = s.length();
                    } else {
                        rows = Math.max(rows, current.get(j).get(idx.get(j)));
                    }
                }

                cols = rows + 1;
            }

            if (cols >= s.length() + 1) {
                out.println("YES");
            } else {
                out.println("NO");
            }
        }
        out.close();
    }

    public static int upperBound(List<Integer> list, int target) {
        int left = 0;
        int right = list.size();
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (list.get(mid) <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    private static int calculateDistance(int x1, int y1, int x2, int y2) {
        return Math.abs(x2 - x1) + Math.abs(y2 - y1);
    }

    private static int calculateDirection(int x1, int x2, int x3, int x4) {
        return (x2 < x1 && x3 < x1) || (x2 > x1 && x3 > x1) ? Math.min(Math.abs(x2 - x1), Math.abs(x3 - x1)) : 0;
    }





    public static boolean isPalindorme(int arr[]){

        int left = 0;
        int right = arr.length-1;

        while(left <= right){

            if(arr[left] != arr[right]) return false;

            left++;
            right--;
        }

        return true;
    }

    static List<Long> printDivisors(long n) {
        List<Long> list = new ArrayList<>();
        // Note that this loop runs till square root
        for (int i=1; i<=Math.sqrt(n); i++){

            if (n%i==0){
                // If divisors are equal, print only one
                if (n/i == i) {
                    list.add((long)i);
                }
                // Otherwise print both
                else {
                    list.add((long)i);
                    list.add(n/i);
                }
            }
        }
        return list;
    }

    static long gcd(long a, long b){
        if (a == 0)
            return b;

        return gcd(b%a, a);
    }

    // method to return LCM of two numbers
    static long lcm(long a, long b){
        return (a / gcd(a, b)) * b;
    }

    static final Random random=new Random();
    static final int mod=1_000_000_007;

    static void ruffleSort(int[] a) {
        int n=a.length;//shuffle, then sort
        for (int i=0; i<n; i++) {
            int oi=random.nextInt(n), temp=a[oi];
            a[oi]=a[i]; a[i]=temp;
        }
        Arrays.sort(a);
    }
    static long add(long a, long b) {
        return (a+b)%mod;
    }
    static long sub(long a, long b) {
        return ((a-b)%mod+mod)%mod;
    }
    static long mul(long a, long b) {
        return (a*b)%mod;
    }
    static long exp(long base, long exp) {
        if (exp==0) return 1;
        long half=exp(base, exp/2);
        if (exp%2==0) return mul(half, half);
        return mul(half, mul(half, base));
    }
    static long[] factorials=new long[2_000_001];
    static long[] invFactorials=new long[2_000_001];
    static void precompFacts() {
        factorials[0]=invFactorials[0]=1;
        for (int i=1; i<factorials.length; i++) factorials[i]=mul(factorials[i-1], i);
        invFactorials[factorials.length-1]=exp(factorials[factorials.length-1], mod-2);
        for (int i=invFactorials.length-2; i>=0; i--)
            invFactorials[i]=mul(invFactorials[i+1], i+1);
    }

    static long nCk(int n, int k) {
        return mul(factorials[n], mul(invFactorials[k], invFactorials[n-k]));
    }

    static void reverse(int[] arr){
        ArrayList<Integer> l = new ArrayList<>();
        for(int i : arr) l.add(i);
        Collections.reverse(l);
        for(int i=0; i<arr.length; i++) arr[i] = l.get(i);

    }

    static void swap(int a, int b, int arr[]){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    static void sort(int[] a) {
        ArrayList<Integer> l=new ArrayList<>();
        for (int i:a) l.add(i);
        Collections.sort(l);
        for (int i=0; i<a.length; i++) a[i]=l.get(i);
    }


    static class FastScanner {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer("");
        String next() {
            while (!st.hasMoreTokens())
                try {
                    st=new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
        int[] readArray(int n) {
            int[] a=new int[n];
            for (int i=0; i<n; i++) a[i]=nextInt();
            return a;
        }
        long nextLong() {
            return Long.parseLong(next());
        }
    }

    static class Pair<K, V> {
        private K key;
        private V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }


}