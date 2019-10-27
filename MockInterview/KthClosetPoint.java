
// time limit exceed...
class Solution {
    public int[][] kClosest(int[][] points, int K) {
        int[][] result = new int[K][2];
        // iterate each row to calculate each distance
        double[] res = new double[points.length];
        
        for(int i=0; i<points.length; i++) {
            int distance = (points[i][0]*points[i][0]) + (points[i][1]*points[i][1]);
            res[i] = Math.sqrt(distance);
            System.out.println(res[i]);
        }
        
        int k=0; 
        double min = 10000;
        int minIndex = 0;
        // get k closet point (minimal)
        for(int i=0; i<K; i++) {
            for(int j=0; j<res.length; j++) {
                if(min > res[j]) {
                    min = res[j];
                    minIndex = j;
                }
            }
            
            // put K shortest point into result...
            result[k][0] = points[minIndex][0];
            result[k][1] = points[minIndex][1];
            
            // reset value
            res[minIndex] = 10000;
            min = 10000;
            k++;
        } 
        
        return result;
    }
}

// find the kth shortest point's distance : distK (like threshold)
// use for loop to compare points one by one (< distK)
class Solution {
    public int[][] kClosest(int[][] points, int K) {
        // O(NlogN), N =  length of points

        int N = points.length;
        int[] dists = new int[N];
        for (int i=0; i < N; ++i) {
            dists[i] = dist(points[i]);
        }
        
        // find the K shortest distance.
        Arrays.sort(dists);
        int distK = dists[K-1];
        
        int[][] ans = new int[K][2];
        int t =0;
        
        // compare with the distK one by one...
        for (int i=0; i<N; ++i) {
            if(dist(points[i]) <= distK)
                ans[t++] = points[i];
        }
        return ans;
    }
    
    public int dist(int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }
}