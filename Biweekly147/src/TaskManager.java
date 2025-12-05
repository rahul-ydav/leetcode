import java.util.ArrayList;
import java.util.List;

class TaskManager {

    private List<List<Integer>> tasks;

    public TaskManager(List<List<Integer>> tasks) {
        this.tasks = tasks;
    }

    public void add(int userId, int taskId, int priority) {
        List<Integer> item = new ArrayList<>(List.of(userId, taskId, priority));
        tasks.add(item);
    }

    public void edit(int taskId, int newPriority) {
        for(int i=0; i<tasks.size(); i++){
            if(tasks.get(i).get(1)==taskId){
                tasks.get(i).set(2, newPriority);
                break;
            }
        }
    }

    public void rmv(int taskId) {

        for(int i=0; i<tasks.size(); i++){
            if(tasks.get(i).get(1)==taskId){
                tasks.remove(i);
                break;
            }
        }
    }

    public int execTop() {

        if(tasks.size()==0) return -1;
        int maxIdx = 0;
        int maxTaskId = -1;
        int maxPriority = -1;
        for(int i=0; i<tasks.size(); i++){
            if(tasks.get(i).get(2)>maxPriority){
                maxIdx = i;
                maxTaskId = tasks.get(i).get(1);
                maxPriority = tasks.get(i).get(2);
            }
            else if(tasks.get(i).get(2)==maxPriority && tasks.get(i).get(1)>maxTaskId){
                maxIdx = i;
                maxTaskId = tasks.get(i).get(1);
            }
        }

        int ans = tasks.get(maxIdx).get(0);
        this.rmv(maxTaskId);
        return ans;
    }

    public void print(){
        System.out.println(tasks);
    }
}