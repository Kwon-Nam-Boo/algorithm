package samsungTest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class sdsd {

    public static final int BLACK = -1;
    public static final int RAINBOW = 0;
    public static final int EMPTY = 6;
    public static int n, m;
    public static int score;
    public static int[][] map;
    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = {0, 1, 0, -1};

    public static class Block {
        int x, y;

        public Block(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static class BlockGroup {
        List<Block> blocks = new ArrayList<>();
        int cnt = 0;

        public void addBlock(Block block) {
            this.blocks.add(block);
        }

        public void addCnt() {
            this.cnt += 1;
        }

        public List<Block> getBlocks() {
            return this.blocks;
        }
    }

    public static void gravity() {
        for (int i = n - 1; i > 0; i--) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == EMPTY) {

                    for (int k = i - 1; k >= 0; k--) {
                        if (map[k][j] == BLACK) break;
                        if (map[k][j] != EMPTY) {
                            map[i][j] = map[k][j];
                            map[k][j] = EMPTY;
                            break;
                        }
                    }


                }
            }
        }
    }

    public static int[][] rotateReverse90() {
        int[][] temp = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                temp[n - j - 1][i] = map[i][j];
            }
        }
        return temp;
    }

    public static boolean findLargeGroup() {
        List<Block> largestGroup = new ArrayList<>();
        boolean[][] visited = new boolean[n][n];
        int mr = -1, mc = -1;
        int maxRainbow = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == EMPTY || map[i][j] == BLACK || map[i][j] == RAINBOW) continue;
                BlockGroup blockGroup = findConnectedGroup(i, j, map[i][j], visited);
                if (blockGroup.blocks.size() < largestGroup.size() || blockGroup.blocks.size() < 2) continue;

                if (blockGroup.blocks.size() > largestGroup.size()) {
                    largestGroup = blockGroup.getBlocks();
                    maxRainbow = blockGroup.cnt;
                    mr = i; mc = j;
                } else if (blockGroup.blocks.size() == largestGroup.size()) {

                    if (blockGroup.cnt > maxRainbow) {
                        largestGroup = blockGroup.getBlocks();
                        maxRainbow = blockGroup.cnt;
                    } else if(blockGroup.cnt == maxRainbow) {
                        if(mr < i) {
                            largestGroup = blockGroup.getBlocks();
                            maxRainbow = blockGroup.cnt;
                        } else if(mr == i && mc < j) {
                            largestGroup = blockGroup.getBlocks();
                            maxRainbow = blockGroup.cnt;
                        }
                    }
                }
            }
        }

        // Game over
        if (largestGroup.size() == 0) {
            return false;
        }

        getScoreAndRemove(largestGroup);

        return true;
    }

    public static void getScoreAndRemove(List<Block> blocks) {
        score += Math.pow(blocks.size(), 2);

        for (Block block : blocks) {
            map[block.x][block.y] = EMPTY;
        }
    }

    public static BlockGroup findConnectedGroup(int x, int y, int color, boolean[][] visited) {

        Queue<Block> queue = new LinkedList<>();
        BlockGroup group = new BlockGroup();
        Block start = new Block(x, y);
        int cnt = 0;
        
        boolean[][] visited2 = new boolean[n][n];
        queue.add(start);
        visited[x][y] = true;
        visited2[x][y] = true;
        group.addBlock(start);

        while (!queue.isEmpty()) {
            Block block = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = block.x + dx[i];
                int ny = block.y + dy[i];
                if (nx < 0 || nx >= n || ny < 0 || ny >= n || visited2[nx][ny]) continue;
                if (map[nx][ny] != color && map[nx][ny] != RAINBOW) continue;
                if (map[nx][ny] == RAINBOW) group.addCnt();
                visited[nx][ny] = true;
                visited2[nx][ny] = true;
                Block next = new Block(nx, ny);
                queue.add(next);
                group.addBlock(next);
            }
        }

        return group;
    }

    public static void play() {
        while (findLargeGroup()) {
            //print();
            gravity();
           // print();
            map = rotateReverse90();
            gravity();
           // print();
        }
    }

    public static void print() {
        System.out.println("score = " + score);
        for (int[] ints : map) {
            System.out.println(Arrays.toString(ints));
        }

        System.out.println();
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

//        print();

        play();

        System.out.println(score);

    }
}