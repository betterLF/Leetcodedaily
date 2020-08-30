package Recursion;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @authtor liFei
 * @date 2020/8/28-10:23
 */
public class Solution690 {
    /*
    给定一个保存员工信息的数据结构，它包含了员工唯一的id，重要度 和 直系下属的id。
比如，员工1是员工2的领导，员工2是员工3的领导。他们相应的重要度为15, 10, 5。那么员工1的数据结构是[1, 15, [2]]，
员工2的数据结构是[2, 10, [3]]，
[3, 5, []]。注意虽然员工3也是员工1的一个下属，但是由于并不是直系下属，因此没有体现在员工1的数据结构中。
现在输入一个公司的所有员工信息，以及单个员工id，返回这个员工和他所有下属的重要度之和。
     */
    class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;
    };
//    public int getImportance(List<Employee> employees, int id) {
//        for (int i = 0; i <employees.size() ; i++) {
//            Employee e=employees.get(i);
//            if(employees.get(i).id==id){
//               int ans=e.importance;
//               List<Integer> id1=e.subordinates;
//                for (int j = 0; j <id1.size() ; j++) {
//                    ans+=getImportance(employees,id1.get(j));
//                }
//                return ans;
//            }
//        }
//        return -1;
//    }
    private Map<Integer,Employee> map;
    public int getImportance(List<Employee> employees, int id) {
        map=new HashMap<>();
        for (Employee employee:employees){
            map.put(employee.id,employee);
        }
        return dfs(id);
    }
    public int dfs(int eid) {
        Employee employee = map.get(eid);
        int ans = employee.importance;
        for (Integer subid: employee.subordinates)
            ans += dfs(subid);
        return ans;
    }
}
