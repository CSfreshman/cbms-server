//package com.cbms.util;
//
//import client.constant.CancelReason;
//import client.entity.OptionalTime;
//import client.entity.Venue;
//import client.mapper.OptionalTimeMapper;
//import client.mapper.OrderMapper;
//import client.mapper.VenueMapper;
//import cn.hutool.core.util.IdUtil;
//import cn.hutool.core.util.ObjectUtil;
//import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.scheduling.annotation.EnableScheduling;
//import org.springframework.scheduling.annotation.Scheduled;
//import org.springframework.stereotype.Component;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import javax.annotation.Resource;
//import java.sql.Time;
//import java.time.LocalDate;
//import java.time.LocalDateTime;
//import java.time.LocalTime;
//import java.time.ZoneId;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//
//// 定时任务组件
//
//@RestController
//@RequestMapping("/test")
//@EnableScheduling
//@Component
//@Slf4j
//public class ScheduledTasks {
//
//    @Resource
//    private OptionalTimeMapper optionalTimeMapper;
//
//    @Resource
//    private VenueMapper venueMapper;
//
//    @Resource
//    private OrderMapper orderMapper;
//
//    @PostMapping("/task")
//    // 每天凌晨执行 创建新的预约时间段
//    @Scheduled(cron = "0 0 0 * * ?")
//    public void createNewOptionalTime(){
//        // 先得到所有的场馆
//        List<Venue> venues = venueMapper.selectList(new QueryWrapper<>());
//        LocalDate day = LocalDate.now().plusDays(4);
//
//        // 需要批量插入的可选时间段的列表
//        List<OptionalTime> batchInsertOptionalTimeList = new ArrayList<>();
//
//        for (Venue venue : venues) {
//            // 先查看该场馆在要生成的日期是否有预设的时间段安排
//            // TODO: 这个需要在后台管理处完成，还没有做。。
//            List todoOptionalTime = new ArrayList();
//
//            // 如果已经有了安排，就是用预设的安排
//            if(!ObjectUtil.isEmpty(todoOptionalTime)){
//                System.out.println("使用预设的时间安排");
//            }else{
//                // 默认时间安排（8点开始，每次两小时，最后一个时间段是20~22，共7个时间段）
//                for (int i = 8; i <= 20; i+=2) {
//                    OptionalTime time = new OptionalTime();
//                    time.setId(IdUtil.getSnowflakeNextId());
//                    time.setNumber(venue.getNumber());
//                    time.setVenueId(venue.getId());
//                    time.setDate(Date.from(day.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));
//                    time.setSqlDate(new java.sql.Date(time.getDate().getTime()));
//                    time.setStartTime(TimeUtil.timeStringToTime(i + ":00:00"));
//                    time.setEndTime(TimeUtil.timeStringToTime((i + 2) + ":00:00"));
//                    batchInsertOptionalTimeList.add(time);
//                }
//            }
//        }
//
//        // 将所有的时间段通过一次数据库链接批量插入
//        for (OptionalTime time : batchInsertOptionalTimeList) {
//            System.out.println(time);
//        }
//
//        Integer integer = optionalTimeMapper.batchInsert(batchInsertOptionalTimeList);
//        System.out.println("执行自动插入可预约时间段的操作，执行时间为:"+LocalDateTime.now()+"插入成功，共插入: " + integer + " 条数据");
//
//    }
//
//    @PostMapping("/task1")
//    // 每个小时执行，取消没有按时出行的订单
//    @Scheduled(cron = "0 0 0/1 * * ?")
//    public void autoCancelOrder(){
//        System.out.println("执行自动取消订单--当前时间" + LocalDateTime.now());
//        orderMapper.autoCancelOrder(Time.valueOf(LocalTime.now()), java.sql.Date.valueOf(LocalDate.now().toString()), CancelReason.TimeOut);
//    }
//}
