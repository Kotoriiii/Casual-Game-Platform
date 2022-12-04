package GoBang;

import java.util.Set;
import java.util.concurrent.ConcurrentSkipListSet;

public class Pot {
    /**
     * 记录 棋子点位 0/1_x_y
     * 0/1 表示 黑/白
     * x    x 坐标 小标 实际 位置 为 x*40 从1开始
     */
    public Set<String> pots = new ConcurrentSkipListSet<>();

    public String getKey(Boolean bool, double x, double y) {
        int i = bool ? 1 : 0;
        double indexX = Math.floor(x / 40);
        double indexY = Math.floor(y / 40);
        return i + "_" + indexX + "_" + indexY;
    }

    public boolean set(Boolean bool, double x, double y) {
        String key = getKey(bool, x, y);
        String key1 = getKey(!bool, x, y);
        if (pots.contains(key) || pots.contains(key1)) {
            return false;
        } else {
            pots.add(key);
            return true;
        }
    }

    public boolean valid(Boolean bool, double x, double y) {
        int r = bool ? 1 : 0;
        double indexX = Math.floor(x / 40);
        double indexY = Math.floor(y / 40);

        boolean heng = heng(r, indexX, indexY);
        if (heng) return true;
        boolean su = su(r, indexX, indexY);
        if (su) return true;
        boolean xieZheng = xieZheng(r, indexX, indexY);
        if (xieZheng) return true;
        return xieSu(r, indexX, indexY);
    }

    private boolean xieZheng(int r, double x, double y) {
        StringBuilder buffer = new StringBuilder();
        for (int i = (int) (x > 4 ? x - 4 : 1); i <= (int) (x > 15 ? 19 : x + 4); i++) {
            buffer.append(have(r, i, x + y - i));
        }
        return buffer.toString().contains("11111");
    }

    private boolean xieSu(int r, double x, double y) {
        StringBuilder buffer = new StringBuilder();
        for (int i = (int) (y > 4 ? y - 4 : 1); i <= (int) (y > 15 ? 19 : y + 4); i++) {
            buffer.append(have(r, x - (y - i), i));
        }
        return buffer.toString().contains("11111");
    }

    private boolean su(int r, double x, double y) {
        //  横 x 不变
        StringBuilder buffer = new StringBuilder();
        for (int i = (int) (y > 4 ? y - 4 : 1); i <= (int) (y > 15 ? 19 : y + 4); i++) {
            buffer.append(have(r, x, i));
        }
        return buffer.toString().contains("11111");
    }

    private boolean heng(int r, double x, double y) {
        StringBuilder buffer = new StringBuilder();
        for (int i = (int) (x > 4 ? x - 4 : 1); i <= (int) (x > 15 ? 19 : x + 4); i++) {
            buffer.append(have(r, i, y));
        }
        return buffer.toString().contains("11111");
    }

    private String have(int r, double x, double y) {
        return pots.contains(r + "_" + x + "_" + y) ? "1" : "0";
    }
}
