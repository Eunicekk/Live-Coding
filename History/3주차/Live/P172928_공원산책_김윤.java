class Solution {
    public int[] solution(String[] park, String[] routes) {
        String[][] parks = new String[park.length][park[0].length()];
        int[] answer = new int[2];
        
        for (int i = 0; i < park.length; i++) {
            parks[i] = park[i].split("");
        }
        
        out: for (int i = 0; i < parks.length; i++) {
            for (int j = 0; j < parks[0].length; j++) {
                if (parks[i][j].equals("S")) {
                    answer[0] = i;
                    answer[1] = j;
                    break out;
                }
            }
        }
        
        out: for (String route : routes) {
            String command = route.split(" ")[0];
            int count = Integer.parseInt(route.split(" ")[1]);
            
            if (command.equals("E")) {
                for (int d = 1; d <= count; d++) {
                    if (answer[1] + d >= parks[0].length || parks[answer[0]][answer[1] + d].equals("X")) {
                        continue out;
                    }
                }
                
                answer[1] += count;
            } else if (command.equals("W")) {
                for (int d = 1; d <= count; d++) {
                    if (answer[1] - d < 0 || parks[answer[0]][answer[1] - d].equals("X")) {
                        continue out;
                    }
                }
                
                answer[1] -= count;
            } else if (command.equals("S")) {
                for (int d = 1; d <= count; d++) {
                    if (answer[0] + d >= parks.length || parks[answer[0] + d][answer[1]].equals("X")) {
                        continue out;
                    }
                }
                
                answer[0] += count;
            } else if (command.equals("N")) {
                for (int d = 1; d <= count; d++) {
                    if (answer[0] - d < 0 || parks[answer[0] - d][answer[1]].equals("X")) {
                        continue out;
                    }
                }
                
                answer[0] -= count;
            }
        }        
        
        return answer;
    }
}
