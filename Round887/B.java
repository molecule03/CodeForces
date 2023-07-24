package CodeForces_Contest.Round887;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class B {


    static long[][] facts = new long[901][2];
    public static void main(String[] args) {

        FastScanner fs=new FastScanner();
        PrintWriter out=new PrintWriter(System.out);


        precomputeFibonacci();

        int T = fs.nextInt();
        for (int tt=0; tt<T; tt++) {

            int n = fs.nextInt();
            int k = fs.nextInt();

            if (k >= 901) {
                out.println(0);
                continue;
            }

            long[] val = facts[k];
            int result = 0;

            for (int i = 0; i <= n; ++i) {
                long temp = (n - val[0] * i);
                if (temp % val[1] == 0 && (temp / val[1]) >= i) {
                        ++result;
                }
            }
            out.println(result);
        }
        out.close();
    }

    public static void precomputeFibonacci() {

        facts[1] = new long[]{1, 0};
        facts[2] = new long[]{0, 1};

        for (int i = 3; i < 901; ++i) {
            long[] current = new long[2];
            current[0] = facts[i - 2][0] + facts[i - 1][0];
            current[1] = facts[i - 2][1] + facts[i - 1][1];
            facts[i] = current;
        }
    }

    public static int countFibonacciLikeSequences(int n, int k) {
        if (k <= 2) {
            return (k == 2 && n == 0) ? 1 : 0;
        }

        // Initialize the dynamic programming table to store the number of sequences for each k-th element (n)
        int[] dp = new int[n + 1];

        // Base cases
        dp[0] = 1; // Only one sequence [0, 0] is possible with k = 2
        dp[n] = 1; // [n, n] is a valid sequence if n is non-negative

        int mod = 1_000_000_007; // Modulo to handle large numbers

        // Build the sequences from k-1 to 2
        for (int i = k - 1; i >= 2; i--) {
            dp[i] = (dp[i + 1] + dp[i + n]) % mod;
        }

        // The number of sequences with k-th element as n is the value at index 2 of the DP table
        return dp[2];
    }


    static boolean isPalindorme(int arr[]){

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

    static Set<Integer> printDivisors(int n) {
        Set<Integer> list = new HashSet<>();
        // Note that this loop runs till square root
        for (int i=1; i*i<=n; i++){

            if (n%i==0){
                // If divisors are equal, print only one
                list.add(i);
                list.add(n/i);
            }
        }
        return list;
    }
//    static List<Integer> printDivisors(int n) {
//        List<Integer> list = new ArrayList<>();
//        // Note that this loop runs till square root
//        for (int i=1; i<=Math.sqrt(n); i++){
//
//            if (n%i==0){
//                // If divisors are equal, print only one
//                if (n/i == i) {
//                    list.add(i);
//                }
//                // Otherwise print both
//                else {
//                    list.add(i);
//                    list.add(n/i);
//                }
//            }
//        }
//        return list;
//    }

    static long gcd(long a, long b){
        if (a == 0)
            return b;

        return gcd(b%a, a);
    }


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
    static void print(int[] arr){
        PrintWriter out=new PrintWriter(System.out);
        out.print(Arrays.toString(arr)+" ");
    }
    static void print(long[] arr){
        PrintWriter out=new PrintWriter(System.out);
        out.print(Arrays.toString(arr)+" ");
    }
    static void println(long[] arr){
        PrintWriter out=new PrintWriter(System.out);
        out.println(Arrays.toString(arr)+" ");
    }
    static void println(int[] arr){
        PrintWriter out=new PrintWriter(System.out);
        out.println(Arrays.toString(arr)+" ");
    }
    static void reverse(int[] arr){
        ArrayList<Integer> l = new ArrayList<>();
        for(int i : arr) l.add(i);
        Collections.reverse(l);
        for(int i=0; i<arr.length; i++) arr[i] = l.get(i);
    }
    static void reverse(long[] arr){
        ArrayList<Long> l = new ArrayList<>();
        for(long i : arr) l.add(i);
        Collections.reverse(l);
        for(int i=0; i<arr.length; i++) arr[i] = l.get(i);
    }
    static void swap(int a, int b, int arr[]){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
    static void sort(int[] arr) {
        ArrayList<Integer> l=new ArrayList<>();
        for (int i:arr) l.add(i);
        Collections.sort(l);
        for (int i=0; i<arr.length; i++) arr[i]=l.get(i);
    }
    static void sort(long[] arr) {
        ArrayList<Long> l=new ArrayList<>();
        for (long i:arr) l.add(i);
        Collections.sort(l);
        for (int i=0; i<arr.length; i++) arr[i]=l.get(i);
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