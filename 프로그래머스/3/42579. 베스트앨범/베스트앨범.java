import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        List<Integer> list_answer = new ArrayList<>();
        Map<String, Integer> genrePlayCount = new HashMap<>();
        Map<String, Map<Integer, Integer>> index = new HashMap<>();
        
        // 각 장르별 총 재생 횟수와 장르별로 노래의 고유번호와 재생 횟수를 저장
        for (int i = 0; i < genres.length; i++) {
            genrePlayCount.put(genres[i], genrePlayCount.getOrDefault(genres[i], 0) + plays[i]);
            index.computeIfAbsent(genres[i], k -> new HashMap<>()).put(i, plays[i]);
        }
        
        // 장르별로 총 재생 횟수가 많은 순으로 정렬
        List<Map.Entry<String, Integer>> sortedGenres = new ArrayList<>(genrePlayCount.entrySet());
        sortedGenres.sort((e1, e2) -> e2.getValue() - e1.getValue());
        
        // 장르별로 노래를 재생 횟수와 고유 번호 기준으로 정렬한 후 최대 두 곡씩 선택
        for (Map.Entry<String, Integer> entry : sortedGenres) {
            Map<Integer, Integer> genreSongs = index.get(entry.getKey());
            List<Map.Entry<Integer, Integer>> sortedSongs = new ArrayList<>(genreSongs.entrySet());
            
            // 재생 횟수가 같은 경우 고유 번호가 낮은 순으로 정렬
            sortedSongs.sort((e1, e2) -> {
                if (e2.getValue().equals(e1.getValue())) {
                    return e1.getKey() - e2.getKey(); // 고유 번호 기준 오름차순
                } else {
                    return e2.getValue() - e1.getValue(); // 재생 횟수 기준 내림차순
                }
            });
            
            // 최대 두 곡만 선택
            int count = 0;
            for (Map.Entry<Integer, Integer> song : sortedSongs) {
                if (count < 2) {
                    list_answer.add(song.getKey());
                    count++;
                } else {
                    break;
                }
            }
        }
        
        // List를 배열로 변환하여 반환
        int[] answer = new int[list_answer.size()];
        for (int i = 0; i < list_answer.size(); i++) {
            answer[i] = list_answer.get(i);
        }
        
        return answer;
    }
}
