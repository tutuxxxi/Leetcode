package com.linmu.q1604;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author by lijun
 * @since 2023/2/7 9:36
 */
public class Q1604 {
    public static void main(String[] args) {
        String[] users = new String[] {
                "aa","aa","aa","aa","aa","aa","aa","aa","ba","ba","ba","ba","ba","ba","ba","ba","ca","ca","ca","ca","ca","ca","ca","ca","da","da","da","da","da","da","da","da","ea","ea","ea","ea","ea","ea","ea","ea","fa","fa","fa","fa","fa","fa","fa","fa","ga","ga","ga","ga","ga","ga","ga","ga","ha","ha","ha","ha","ha","ha","ha","ha","ia","ia","ia","ia","ia","ia","ia","ia","ja","ja","ja","ja","ja","ja","ja","ja","ka","ka","ka","ka","ka","ka","ka","ka","la","la","la","la","la","la","la","la","ma","ma","ma","ma","ma","ma","ma","ma","na","na","na","na","na","na","na","na","oa","oa","oa","oa","oa","oa","oa","oa","pa","pa","pa","pa","pa","pa","pa","pa","qa","qa","qa","qa","qa","qa","qa","qa","ra","ra","ra","ra","ra","ra","ra","ra","sa","sa","sa","sa","sa","sa","sa","sa","ta","ta","ta","ta","ta","ta","ta","ta","ua","ua","ua","ua","ua","ua","ua","ua","va","va","va","va","va","va","va","va","wa","wa","wa","wa","wa","wa","wa","wa","xa","xa","xa","xa","xa","xa","xa","xa","ya","ya","ya","ya","ya","ya","ya","ya","za","za","za","za","za","za","za","za","ab","ab","ab","ab","ab","ab","ab","ab","bb","bb","bb","bb","bb","bb","bb","bb","cb","cb","cb","cb","cb","cb","cb","cb","db","db","db","db","db","db","db","db"
        };
        String[] times = new String[] {
                "15:47","07:06","23:32","03:44","16:02","18:04","13:06","06:28","12:39","21:09","05:07","03:43","19:54","15:44","23:45","06:42","15:11","11:01","05:11","05:46","20:14","09:44","09:06","15:43","15:12","21:45","18:39","14:49","03:54","22:03","15:28","06:15","12:49","23:31","13:43","16:14","16:56","10:40","13:26","02:08","04:39","00:18","23:52","19:04","13:48","07:41","15:19","20:15","16:30","11:44","03:40","08:06","17:10","17:47","19:35","14:27","21:55","19:48","22:06","01:46","23:23","11:36","01:33","17:48","16:20","05:01","10:12","16:48","18:44","23:31","18:36","21:50","22:05","20:26","22:49","12:34","20:15","15:56","00:28","00:23","00:28","08:19","18:52","07:44","12:12","00:33","22:14","13:10","02:12","15:32","01:04","07:23","00:35","21:07","00:30","19:48","17:14","21:22","16:54","12:58","11:11","17:54","12:10","14:27","08:07","04:21","22:43","11:06","04:33","23:45","03:54","16:12","22:47","00:26","01:04","20:53","20:50","02:18","10:25","06:39","22:07","21:09","04:20","13:38","09:43","11:29","19:42","06:55","00:07","18:29","08:26","00:59","07:29","04:52","21:11","14:33","12:19","16:48","09:46","13:47","13:26","06:56","19:19","23:18","20:47","21:55","07:44","10:38","21:11","04:07","09:24","04:26","10:19","12:30","02:36","10:53","13:43","20:48","04:22","17:59","16:50","23:21","21:02","04:18","23:11","13:46","02:37","16:55","21:14","22:35","18:09","15:41","13:49","07:08","11:48","19:03","21:17","05:20","19:52","22:02","19:16","09:00","03:24","14:55","23:16","02:57","02:23","13:40","17:47","12:13","03:23","02:38","18:29","15:32","20:48","20:27","14:38","12:16","10:25","11:59","08:09","18:31","21:53","03:11","09:19","17:39","14:41","19:29","00:59","00:39","02:32","18:24","17:17","17:59","20:41","17:19","04:18","03:44","22:26","13:43","02:17","18:46","18:40","05:46","20:57","12:50","15:57","08:34","01:17","17:47","14:34","14:56","03:09","09:38","19:14","13:02","20:54","20:11","11:55","18:19"
        };

        new Solution().alertNames(users, times);
    }
}

class Solution {
    public List<String> alertNames(String[] keyName, String[] keyTime) {
        Map<String, TreeSet<String>> userCountMap = new HashMap<>(16);
        int length = keyName.length;

        for (int i = 0; i < length; i++) {
            String userName = keyName[i];
            String time = keyTime[i];

            userCountMap.computeIfAbsent(userName, s -> new TreeSet<>()).add(time);
        }

        return userCountMap.entrySet().stream()
                .filter(entry -> containsThree(entry.getValue()))
                .map(Map.Entry::getKey)
                .sorted()
                .collect(Collectors.toList());
    }

    private static boolean containsThree(TreeSet<String> times) {
        if(times == null || times.size() < 3) {
            return false;
        }

        Queue<String> queue = new ArrayDeque<>(3);
        queue.offer(times.pollFirst());

        while(!times.isEmpty() && queue.size() < 3) {
            while(!queue.isEmpty() && !match(queue.peek(), times.first())) {
                queue.poll();
            }
            queue.offer(times.pollFirst());
        }
        return queue.size() >= 3;
    }

    private static boolean match(String time1, String time2) {
        String[] splitTime1 = time1.split(":");
        String[] splitTime2 = time2.split(":");

        // 同一个小时要求：
        // 1. hour相同
        // 2. hour不同时, minute后大于等于前

        int hour1 = Integer.valueOf(splitTime1[0]);
        int hour2 = Integer.valueOf(splitTime2[0]);
        int minute1 = Integer.valueOf(splitTime1[1]);
        int minute2 = Integer.valueOf(splitTime2[1]);
        if(hour1 == hour2) {
            return true;
        }
        if(hour1 == hour2 - 1 && minute2 <= minute1) {
            return true;
        }
        return false;
    }
}
