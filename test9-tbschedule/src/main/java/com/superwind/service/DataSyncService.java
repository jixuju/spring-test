package com.superwind.service;

import com.superwind.pojo.OrderInfo;
import com.taobao.pamirs.schedule.IScheduleTaskDealSingle;
import com.taobao.pamirs.schedule.TaskItemDefine;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class DataSyncService implements IScheduleTaskDealSingle<OrderInfo> {
    @Override
    public List<OrderInfo> selectTasks(String taskParameter, String ownSign,
                                       int taskItemNum, List<TaskItemDefine> taskItemList,
                                       int eachFetchDataNum) throws Exception {

        List<OrderInfo> result = new ArrayList<OrderInfo>();
        if (taskItemList.size() == 0) {
            return result;
        }

        StringBuffer condition = new StringBuffer();
        for (int i = 0; i < taskItemList.size(); i++) {
            if (i > 0) {
                condition.append(",");
            }
            condition.append(taskItemList.get(i).getTaskItemId());
        }

         /* 场景A：将tbOrder表中的数据分8个任务项，每次取200条数据， 同步到tbOrder_copy表中。 */
        String sql = "select * from tbOrder " + "where "
                + " BillNumber not in (select BillNumber from tbOrder_copy) "
                + " and RIGHT(BuildDate,1) in (" + condition + ") " + "limit "
                + eachFetchDataNum;

        System.out.println("execute select");
        result.add(new OrderInfo());
        return result;
    }

    @Override
    public Comparator<OrderInfo> getComparator() {
        return null;
    }

    @Override
    public boolean execute(OrderInfo task, String ownSign) throws Exception {

        System.out.println("execute insert" );

        return true;
    }
}
