class Solution {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        // 左右重疊, 上下不重疊 （只要上下不重疊，左右重疊也是不重疊）
        if (rec1[1] >= rec2[3] || rec1[3] <= rec2[1]) {
            return false;
        }
        if (rec1[2] <= rec2[0] || rec2[2] <= rec1[0]) {
            return false;
        }
        return true;
    }
}