package com.prakash.leetcode.NewStart.Trie;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class WordSearchII {

    public static void main(String[] args) {
        //char[][] board = {{'o','a','a','n'},{'e','t','a','e'},{'i','h','k','r'},{'i','f','l','v'}};
        char[][] board = {{'o','a','a','n'},{'e','t','a','e'},{'i','h','k','r'},{'i','f','l','v'}};
        String[] words = {"oath","pea","eat","rain","oathi","oathk","oathf","oate","oathii","oathfi","oathfii"};
        new WordSearchIISolution().findWords(board, words);
    }


}


class WordSearchIISolution {

    int[][] dirs = {{0,-1},{-1,0},{1,0},{0,1}};
    public List<String> findWords(char[][] board, String[] words) {
        int n = board.length;
        int m = board[0].length;
        TrieArrayWithFullString root = new TrieArrayWithFullString();
        List<String> results = new ArrayList<>();
        boolean[][] visited = new boolean[n][m];

        for(String word : words){
            TrieArrayWithFullString current = root;
            for(char c :word.toCharArray()){
             if(current.child[c-'a']==null)
                 current.child[c-'a'] = new TrieArrayWithFullString();
             current = current.child[c-'a'];

            }

            current.str = word;
            System.out.println("current.str ---> " + current.str);
            current.wordEnd = true;
        }
        System.out.println(" n value -->" + n);
        System.out.println(" m value -->" + m);
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                    dfs(board, i, j, root, results, visited);

            }
        }
        System.out.println(" results ---> "+ results);

        return results;
    }

    public void dfs(char[][] board, int i, int j, TrieArrayWithFullString node, List<String> results, boolean[][] visited){

        char c = board[i][j];
        node = node.child[c-'a'];

        if(node==null) return;

        System.out.println(" node.wordEnd --> "+ node.wordEnd);

        if(node.wordEnd && !results.contains(node.str)){
            results.add(node.str);
        }
        visited[i][j] = true;
        for(int d=0;d<dirs.length;d++){
            int newI = i + dirs[d][0];
            int newJ = j + dirs[d][1];
            if(newI>=0 && newJ >=0 && newI<board.length && newJ<board[0].length && !visited[newI][newJ]){
                dfs(board, newI, newJ, node, results, visited);
            }
        }
        visited[i][j]= false;
    }


}


class TrieArrayWithFullString{
    TrieArrayWithFullString[] child;
    boolean wordEnd;
    String str;

    TrieArrayWithFullString(){
        child = new TrieArrayWithFullString[26];
        wordEnd = false;
        str = "";
    }

}
