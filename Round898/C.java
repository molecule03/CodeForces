package CodeForces_Contest.Round898;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class C {

    public static void main(String[] args) {

        FastScanner fs=new FastScanner();
        PrintWriter out=new PrintWriter(System.out);

        int T = fs.nextInt();
        for (int tt=0; tt<T; tt++) {
            char[][] arr = new char[10][10];
            ArrayList<int[]> list = new ArrayList<>();

            for (int i = 0; i < 10; i++) {
                String line = fs.next();
                for (int j = 0; j < 10; j++) {
                    arr[i][j] = line.charAt(j);
                    if (arr[i][j] == 'X') {
                        list.add(new int[]{i, j});
                    }
                }
            }

            int ans = 0;
            for (int[] pair : list) {
                int x = pair[0];
                int y = pair[1];
                if (x <= 4) {
                    if (y <= 4) ans += 5 - Math.max(4 - x, 4 - y);
                    else ans += 5 - Math.max(4 - x, y - 5);
                } else {
                    if (y <= 4) ans += 5 - Math.max(x - 5, 4 - y);
                    else  ans += 5 - Math.max(x - 5, y - 5);
                }
            }
//            for(int i=1; i<=5; i++){
//                for(int j=1; j<=5; j++){
//                    if(arr[i][j] == 'X'){
////                        out.println(i+" "+j);
//                        if(i < j){
//                            ans += (i);
//                        }
//                        else{
//                            ans += (j);
//                        }
//                        out.println(i+" "+j+" "+ans);
//                    }
//                }
//            }
//
//            for(int i=1; i<=5; i++){
//                for(int j=10; j>=6 ; j--){
//                    if(arr[i][j] == 'X'){
////                        out.println(i+" "+j);
//                        if(i%5 < j%5){
//                            ans += (i);
//                        }
//                        else{
//                            ans += 5-(j%5);
//                        }
//                        out.println(i+" "+j+" "+ans);
//                    }
//                }
//            }
//
//            for(int i=5; i<10; i++){
//                for(int j=0; j<10; j++){
//                    if(arr[i][j] == 'X'){
//
//                        if(i%5 < j%5){
//                            ans += (i%5)+1;
//                        }
//                        else{
//                            ans += (j%5)+1;
//                        }
//                        out.println(i+" "+j+" "+ans);
//                    }
//                }
//            }

            out.println(ans);

//            for(char c[] : arr){
//                out.println(Arrays.toString(c));
//            }

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