package implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Implement20006 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Object[]> list;
        Map<String, List<Object[]>> hashMap = new LinkedHashMap<>();
        int P = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < P; i++) {
            st = new StringTokenizer(br.readLine());
            int L = Integer.parseInt(st.nextToken());
            String N = st.nextToken();
            list = new ArrayList<>();

            boolean flag = false;
            for (String key : hashMap.keySet()) {
                List<Object[]> room = hashMap.get(key);
                if (room.size() != M) {
                    Object[] objects = room.get(0);
                    if ((int) objects[0] + 10 >= L && L >= (int) objects[0] - 10) {
                        room.add(new Object[]{L, L, N});
                        hashMap.put(key, room);
                        flag = true;
                        break;
                    }
                }
            }
            if (!flag) {
                list.add(new Object[]{L, L, N});
                hashMap.put(UUID.randomUUID().toString(), list);
            }

        }


        for (String key : hashMap.keySet()) {
            List<Object[]> room = hashMap.get(key);
            Collections.sort(room, (o1, o2) -> {
                String name1 = (String) o1[2];
                String name2 = (String) o2[2];
                return name1.compareTo(name2);
            }); // 이름 기준 오름차순
            if (room.size() == M) {
                System.out.println("Started!");

            } else {
                System.out.println("Waiting!");
            }
            for (Object[] objects : room) {
                System.out.println(objects[1] + " " + objects[2]);
            }
        }


    }
}

