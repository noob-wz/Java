/** 功能：
 * 场景：仓库盘点系统。
 * 我们有一个商品 ID 列表，其中包含一些无效的 ID（比如 -1 表示已损坏）。
 * * 要求：
 * 1. 编写一个方法，接收原始 ID 数组。
 * 2. 移除所有的 -1。
 * 3. 由于数组不能变短，请返回一个新的数组，其中只包含有效 ID。
 * 4. 保持 ID 的原始相对顺序。
 *
 * 示例：
 * 输入：[101, -1, 103, -1, 105]
 * 输出：[101, 103, 105] (返回的新数组长度应为 3)
 */

import java.util.Arrays;

public class InventoryCleaner {
    public static int[] cleanDamagedGoods(int[] ids) {
        // 1. 防御性编程：处理 null
        //  (1)如果调用方传入 null（例如 cleanDamagedGoods(null)），代码会在 ids.length 处直接崩溃（抛出 NullPointerException）。
        //  (2) 所以，作为工具方法，必须要进行防御性编程
        if(ids == null) {
            return new int[0];
        }

        // 2. 统计有效数量
        int length = ids.length;
        for(int i = 0; i < ids.length; i++) {
            if(ids[i] == -1) {
                length -= 1;
            }
        }

        // 3. 如果长度没有变化，直接返回原数组
        if (length == ids.length) {
            return Arrays.copyOf(ids, ids.length);
            // 或者 return ids 取决于是否需要防御外部修改

        }

        // 4. 数据搬运
        int[] newArr = new int[length];
        int j = 0;
        for(int i = 0; i < ids.length; i++) {
            if(ids[i] == -1) {
                continue;
            }
            newArr[j] = ids[i];
            j++;
        }
        return newArr;
    }

    public static void main(String[] args) {
        int[] rawIds = {101, -1, 103, -1, 105};
        int[] validIds = cleanDamagedGoods(rawIds);

        System.out.println(Arrays.toString(validIds));
    }
}
