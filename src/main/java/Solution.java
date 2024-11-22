import java.util.HashMap;
import java.util.Map;

class Solution {
    public int maxEqualRowsAfterFlips(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        Map<String, Integer> map = new HashMap<>();
        int res = 0;
        for(int i = 0; i < m; i++) {
            StringBuilder sb = new StringBuilder();
            int c = 1;
            for(int j = 1; j < n; j++) {
                if(matrix[i][j - 1] == matrix[i][j]) {
                    c++;
                }else if(matrix[i][j - 1] != matrix[i][j]){
                    sb.append(c);
                    sb.append('*');
                    c = 1;
                }
            }
            sb.append(c);
            int count = map.getOrDefault(sb.toString(), 0);
            count++;
            res= Math.max(res, count);
            map.put(sb.toString(), count);
        }

        return res;
    }
}