package io.github.lgxkdream.unit3;

/**
 * @author Jackie Lee
 * @version 1.0.0
 * @title 山脉数组中查找目标值
 * @description https://leetcode-cn.com/problems/find-in-mountain-array/
 * @since 2020-04-29 10:07
 */
public class FindInMountainArray {

    public static void main(String[] args) {
        MountainArray mountainArr = new MountainArray(new int[]{1, 2, 3, 4, 5, 3, 1});
        System.out.println(getTopIndex(mountainArr));
        System.out.println(findInMountainArray(3, mountainArr)); // 2
        mountainArr = new MountainArray(new int[]{0, 1, 2, 4, 2, 1});
        System.out.println(getTopIndex(mountainArr));
        System.out.println(findInMountainArray(3, mountainArr)); // -1
    }

    /**
     * 二分查找思想
     *
     * @param target
     * @param mountainArr
     * @return
     */
    public static int findInMountainArray(int target, MountainArray mountainArr) {
        int topIndex = getTopIndex(mountainArr);
        if (mountainArr.get(topIndex) == target) {
            return topIndex;
        }
        int leftFind = find(mountainArr, 0, topIndex - 1, target, true);
        int rightFind = find(mountainArr, topIndex + 1, mountainArr.length() - 1, target, false);
        return leftFind == -1 ? (rightFind == -1 ? -1 : rightFind) : leftFind;
    }

    /**
     * 山脉两侧查找目标值
     *
     * @param mountainArr
     * @param left
     * @param right
     * @param target
     * @param findLeft
     * @return
     */
    private static int find(MountainArray mountainArr, int left, int right, int target, boolean findLeft) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (mountainArr.get(mid) > target) {
                if (findLeft) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else if (mountainArr.get(mid) < target) {
                if (findLeft) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else {
                return mid;
            }
        }
        return -1;
    }

    /**
     * 二分查找获取山顶
     *
     * @param mountainArr
     * @return
     */
    private static int getTopIndex(MountainArray mountainArr) {
        int left = 0, right = mountainArr.length() - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            int midRight = mid + 1;
            int midValue = mountainArr.get(mid);
            int midRightValue = mountainArr.get(midRight);
            if (midValue < midRightValue) {
                left = midRight;
            } else if (midValue > midRightValue) {
                right = mid;
            }
        }
        return left;
    }

    static class MountainArray {

        private int[] array;

        public MountainArray(int[] array) {
            this.array = array;
        }

        /**
         * 会返回数组中索引为k 的元素（下标从 0 开始）
         *
         * @return
         */
        public int get(int k) {
            return array[k];
        }

        /**
         * 会返回该数组的长度
         *
         * @return
         */
        public int length() {
            return array.length;
        }

    }

}
