class Solution {
    public int maxArea(int[] height) {
        int bestArea = 0;

        int left = 0;
        int right = height.length - 1;

        while (left < right) {
            int w = right - left;
            int h = Math.min(height[left], height[right]);
            bestArea = Math.max(bestArea, w * h);

            if (height[left] < height[right]) {
                left++;
            } else if (height[right] < height[left]) {
                right--;
            } else {
                if (height[left + 1] >= height[right - 1]) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return bestArea;
    }
}
