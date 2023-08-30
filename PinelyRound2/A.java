package CodeForces_Contest.PinelyRound2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class A {

    public static void main(String[] args) {

        FastScanner fs=new FastScanner();
        PrintWriter out=new PrintWriter(System.out);

        int T = fs.nextInt();
        for (int tt=0; tt<T; tt++) {

            int n = fs.nextInt();
            int a = fs.nextInt();
            int q = fs.nextInt();
            String s = fs.next();

            if(a >= n){
                out.println("YES");
                continue;
            }

            int total = a;
            boolean flag = false;

            for(char c : s.toCharArray()){
                if(c == '-'){
                    a--;
                }
                else{
                    total++;
                    a++;
                }

                if(a >= n){
                    out.println("YES");
                    flag = true;
                    break;
                }
            }

            if(flag){
                continue;
            }

            if(a >= n){
                out.println("YES");
            }
            else if(total >= n){
                out.println("MAYBE");
            }
            else{
                out.println("NO");
            }

        }

        out.close();
    }

    static void reverseString(String input) {
        if (input == null || input.isEmpty()) return; char[] chars = input.toCharArray(); int left = 0, right = input.length() - 1;
        while (left < right) {char temp = chars[left]; chars[left++] = chars[right]; chars[right--] = temp;} input = new String(chars);
    }
    static boolean isPalindorme(int arr[]){
        int left = 0,right = arr.length-1;
        while(left <= right)if(arr[left++] != arr[right--]) return false; return true;
    }
    static List<Long> printDivisorsInList(long n) {
        List<Long> list = new ArrayList<>();
        for (int i=1; i<=Math.sqrt(n); i++){if (n%i==0){ if (n/i == i) {list.add((long)i);} else {list.add((long)i); list.add(n/i);}}}return list;
    }
    static Set<Integer> printDivisorsInSet(int n) {
        Set<Integer> list = new HashSet<>();
        for (int i=1; i*i<=n; i++){ if (n%i==0){list.add(i); list.add(n/i);} } return list;
    }
    static long gcd(long a, long b){ if (a == 0)return b; return gcd(b%a, a);}
    static long lcm(long a, long b){return (a / gcd(a, b)) * b;}
    static final Random random=new Random();
    static final int mod=1_000_000_007;
    static void ruffleSort(int[] a) {int n=a.length;for (int i=0; i<n; i++) { int oi=random.nextInt(n), temp=a[oi]; a[oi]=a[i]; a[i]=temp;}Arrays.sort(a);}
    static long add(long a, long b) {a = a%mod; b = b%mod; return ((a+b)%mod+mod)%mod;}
    static long sub(long a, long b) {a = a%mod; b = b%mod; return ((a-b)%mod+mod)%mod;}
    static long mul(long a, long b) {a = a%mod; b = b%mod; return ((a*b)%mod+mod)%mod;}
    static long div(long a, long b) {a = a%mod; b = b%mod; return (mul(a, exp(a, mod-2))+mod)%mod;}
    static long exp(long base, long exp) {if (exp==0) return 1; long half=exp(base, exp/2); if (exp%2==0) return mul(half, half); return mul(half, mul(half, base));}
    static long[] factorials=new long[2_000_001];
    static long[] invFactorials=new long[2_000_001];
    static void precompFacts() {
        factorials[0]=invFactorials[0]=1; for (int i=1; i<factorials.length; i++) factorials[i]=mul(factorials[i-1], i);
        invFactorials[factorials.length-1]=exp(factorials[factorials.length-1], mod-2);
        for (int i=invFactorials.length-2; i>=0; i--) invFactorials[i]=mul(invFactorials[i+1], i+1);
    }
    static long nCk(int n, int k) {return mul(factorials[n], mul(invFactorials[k], invFactorials[n-k]));}
    static void reverse(int[] arr){ArrayList<Integer> l = new ArrayList<>(); for(int i : arr) l.add(i); Collections.reverse(l); for(int i=0; i<arr.length; i++) arr[i] = l.get(i);}
    static void reverse(long[] arr){ArrayList<Long> l = new ArrayList<>(); for(long i : arr) l.add(i); Collections.reverse(l); for(int i=0; i<arr.length; i++) arr[i] = l.get(i);}
    static void swap(int a, int b, int arr[]){int temp = arr[a]; arr[a] = arr[b]; arr[b] = temp;}
    static void swap(long a, long b, long arr[]){long temp = arr[(int) a]; arr[(int) a] = arr[(int) b];arr[(int) b] = temp;}
    static void sort(int[] arr) {ArrayList<Integer> l=new ArrayList<>(); for (int i:arr) l.add(i);Collections.sort(l); for (int i=0; i<arr.length; i++) arr[i]=l.get(i);}
    static void sort(long[] arr) {ArrayList<Long> l=new ArrayList<>(); for (long i:arr) l.add(i);Collections.sort(l); for (int i=0; i<arr.length; i++) arr[i]=l.get(i);}

    static class FastScanner {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer("");
        String next() {while (!st.hasMoreTokens()) try { st=new StringTokenizer(br.readLine());} catch (IOException e) { e.printStackTrace();}return st.nextToken();}
        int nextInt() {
            return Integer.parseInt(next());
        }
        int[] intreadArray(int n) {int[] a=new int[n]; for (int i=0; i<n; i++) a[i]=nextInt(); return a;}
        long[] longreadArray(int n) {long[] a=new long[n]; for (int i=0; i<n; i++) a[i]=nextLong(); return a;}
        long nextLong() {
            return Long.parseLong(next());
        }
        double nextDouble() {
            return Double.parseDouble(next());
        }
        float nextFloat() {
            return Float.parseFloat(next());
        }
    }
    static class Pair<K, V> {
        private K key; private V value;
        public Pair(K key, V value) {this.key = key; this.value = value;}
        public K getKey() {
            return key;
        }
        public V getValue() {
            return value;
        }
    }
}