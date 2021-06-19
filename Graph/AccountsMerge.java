package com.prakash.leetcode.NewStart.Graph;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.*;

public class AccountsMerge {

    public static void main(String[] args) {

        List<List<String>> accounts = Arrays.asList(Arrays.asList("David","David0@m.co","David1@m.co"),
                Arrays.asList("David","David3@m.co","David4@m.co"),
                Arrays.asList("David","David4@m.co","David5@m.co"),
                Arrays.asList("David","David2@m.co","David3@m.co"),
                Arrays.asList("David","David1@m.co","David2@m.co"));

        /*List<List<String>> accounts = Arrays.asList(Arrays.asList("p1","e1","e2"),
                Arrays.asList("p2","e2","e3"),
                Arrays.asList("p3","e3","e4"));*/

        System.out.println(" return list ---> "+ new AccountsMergeSolution().accountsMerge(accounts));
    }

}

class AccountsMergeSolution{
    public List<List<String>> accountsMerge(List<List<String>> accounts) {

        Map<String, Set<String>> graph = new HashMap<>();  //<email node, neighbor nodes>
        Map<String, String> name = new HashMap<>();        //<email, username>
        // Build the graph;
        for (List<String> account : accounts) {
            String userName = account.get(0);
            for (int i = 1; i < account.size(); i++) {
                if (!graph.containsKey(account.get(i))) {
                    graph.put(account.get(i), new HashSet<>());
                }
                name.put(account.get(i), userName);

                if (i == 1) continue;
                graph.get(account.get(i)).add(account.get(i - 1));
                graph.get(account.get(i - 1)).add(account.get(i));
            }
        }
        System.out.println("graph --->  "+ graph);
        System.out.println("name --->  "+ name);

        System.out.println("===========================================");



        Map<String, Integer> emailMap = new HashMap<>();
        Map<Integer, Set<Integer>> accountMap = new HashMap<>();
        List<List<String>> returnList = new ArrayList<>();

        for(int i=0;i<accounts.size();i++){
            List<String> account = accounts.get(i);
            int matchingIndex = findAnyMatchingAccount(emailMap, account, i);
            System.out.println(" matchingIndex --> "+ matchingIndex);
            for(int j=1;j<account.size();j++){
                emailMap.put(account.get(j), matchingIndex);
                Set<Integer> set = accountMap.getOrDefault(matchingIndex, new HashSet<>());
                set.add(i);
                accountMap.put(matchingIndex, set);
            }
            System.out.println(" emailMap ---> "+ emailMap);
        }
        System.out.println("emailMap --->  "+ emailMap);
        System.out.println("accountMap --->  "+ accountMap);
        int i = 0;
        for(Integer groupHead : accountMap.keySet()){
            returnList.add(new ArrayList<>());
            returnList.get(i).add(accounts.get(groupHead).get(0));
            List<String> emailList = new ArrayList<>();
            for(Integer sub : accountMap.get(groupHead)){
                for(int j=1;j< accounts.get(sub).size();j++){
                    if(!emailList.contains(accounts.get(sub).get(j)))
                        emailList.add(accounts.get(sub).get(j));
                }
            }
            Collections.sort(emailList);
            returnList.get(i).addAll(emailList);
            i++;
        }

        for(List<String> subList : returnList)
            System.out.println("subList ---> "+ subList);

        return returnList;

    }


    public int findAnyMatchingAccount(Map<String, Integer> emailMap, List<String> account, int index){
        for(int i=1;i<account.size();i++){
           if(emailMap.containsKey(account.get(i)))
               return emailMap.get(account.get(i));
        }
        return index;
    }

}
