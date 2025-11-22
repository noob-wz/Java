// 目的：了解continue搭配标签使用

public class Continue01 {
    public static void main(String[] args) {
        OUTER_LOOP:
        for (int i = 0; i < 2; i++) {
        INNER_LOOP:
            for (int j = 0; j < 10; j++) {
                if (j == 2) {
                    continue OUTER_LOOP;
                }
                System.out.println("i=" + i + ", j=" + j);
            }
        }
    }
}
