package Math;

/**
 * @authtor liFei
 * @date 2020/9/28-11:54
 */
public class Solution789 {
    /*
    你在进行一个简化版的吃豆人游戏。你从 (0, 0) 点开始出发，你的目的地是 (target[0], target[1]) 。
    地图上有一些阻碍者，第 i 个阻碍者从 (ghosts[i][0], ghosts[i][1]) 出发。
每一回合，你和阻碍者们*可以*同时向东，西，南，北四个方向移动，每次可以移动到距离原位置1个单位的新位置。
如果你可以在任何阻碍者抓住你之前到达目的地（阻碍者可以采取任意行动方式），则被视为逃脱成功。
如果你和阻碍者同时到达了一个位置（包括目的地）都不算是逃脱成功。
当且仅当你有可能成功逃脱时，输出 True。
     */
    public boolean escapeGhosts(int[][] ghosts, int[] target) {
        int min=getDis(0,0,target[0],target[1]);
        for (int i = 0; i <ghosts.length ; i++) {
            if(min>=getDis(ghosts[i][0],ghosts[i][1],target[0],target[1])){
                return false;
            }
        }
        return true;
    }
    public int getDis(int row,int col,int target_row,int target_col){
        return Math.abs(row-target_row)+Math.abs(col-target_col);
    }
}
