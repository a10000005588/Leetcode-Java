class Solution {
    public boolean rotateString(String A, String B) {
        char[] a = A.toCharArray();
        char[] b = B.toCharArray();
        
        if(a.length == 0 && b.length ==0) {
            return true;
        }
        
        if(a.length != b.length) {
            return false;
        }
        for(int i=0; i<b.length; i++) {
            char start = a[0];
            
            for(int j=1; j<a.length; j++) {
                a[j-1] = a[j];
            }
            a[a.length-1] = start;
            
            String res = new String(a);
            if(res.equals(B)) {
                return true;
            }
        }
        return false;
    }
}