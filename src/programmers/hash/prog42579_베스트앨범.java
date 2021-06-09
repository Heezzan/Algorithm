package programmers.hash;

import java.util.*;

public class prog42579_베스트앨범 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new String[]{"classic", "pop", "classic", "classic", "pop"}, new int[]{500, 600, 150, 800, 2500})));
    }

    /*
    * 장르별로 가장 많이 재생된 노래 두개씩 모을꺼임
    * 노래 수록 기준
    * 1. 많이 재생된 장르 먼저
    * 2. 장르 내에서 많이 재생된 노래
    * 3. 장르 내에서 재생 횟수가 같다면 고유번호가 낮은 노래 먼저
    * */
    public static class Genre {
        String name;
        int cnt;

        Genre(String name, int cnt) {
            this.name = name;
            this.cnt = cnt;
        }
    }

    public static int[] solution(String[] genres, int[] plays) {

        HashMap<String, Integer> genrescore = new HashMap<>();
        HashMap<String, int[]> first = new HashMap<>();
        HashMap<String, int[]> second = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {
            genrescore.put(genres[i], genrescore.getOrDefault(genres[i], 0)+plays[i]);

            if (!first.containsKey(genres[i])) {
                first.put(genres[i], new int[]{i, plays[i]});
            } else if (!second.containsKey(genres[i])) {
                if (first.get(genres[i])[1] < plays[i]) {
                    second.put(genres[i], first.get(genres[i]));
                    first.put(genres[i], new int[]{i, plays[i]});
                } else {
                    second.put(genres[i], new int[]{i, plays[i]});
                }
            } else {
                if (first.get(genres[i])[1] < plays[i]) {
                    second.put(genres[i], first.get(genres[i]));
                    first.put(genres[i], new int[]{i, plays[i]});
                } else if (second.get(genres[i])[1] < plays[i]){
                    second.put(genres[i], new int[]{i, plays[i]});
                }
            }
        }

        List<Genre> list = new ArrayList<>();
        Iterator iter = genrescore.keySet().iterator();
        while(iter.hasNext()) {
            String key = iter.next().toString();
            list.add(new Genre(key, genrescore.get(key)));
        }

        Collections.sort(list, new Comparator<Genre>() {
            @Override
            public int compare(Genre o1, Genre o2) {
                return -Integer.compare(o1.cnt, o2.cnt);
            }
        });

        List<Integer> answer = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {

            if (first.containsKey(list.get(i).name)) {
                answer.add(first.get(list.get(i).name)[0]);
            }
            if (second.containsKey(list.get(i).name)) {
                answer.add(second.get(list.get(i).name)[0]);
            }
        }

        int[] result = answer.stream().mapToInt(Integer::intValue).toArray();

        return result;
    }
}
