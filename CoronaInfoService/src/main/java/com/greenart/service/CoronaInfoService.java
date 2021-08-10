package com.greenart.service;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.greenart.mapper.CoronaInfoMapper;
import com.greenart.vo.CoronaInfoVO;
import com.greenart.vo.CoronaSidoInfoVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CoronaInfoService {
    @Autowired
    CoronaInfoMapper mapper;
    public void insertCoronaInfo(CoronaInfoVO vo){
        mapper.insertCoronaInfo(vo);
    }
    public CoronaInfoVO selectTodayCoronaInfo(){
        // Calendar start = Calendar.getInstance();
        // Calendar end = Calendar.getInstance();
        
        // start.set(Calendar.HOUR_OF_DAY, 10);
        // start.set(Calendar.MINUTE, 30);
        // start.set(Calendar.SECOND, 0);
        
        //2021-08-11 01:00:00 - 이전시간 
        //2021-08-11 10:30:00 - 세팅값
        //2021-08-11 14:30:00 - 이후시간

        //현재 시간이 세팅값보다 이전시간 일때, 전날 데이터를 뽑아주고
        //현재 시간이 세팅값보다 이후시간 이라면, 오늘 데이터를 뽑아준다.

        Date now = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String date = formatter.format(now);

        CoronaInfoVO data = mapper.selectCoronaInfoByDate(date);

        Integer accExamCnt = data.getAccExamCnt();
        Integer decideCnt = data.getDecideCnt();

        DecimalFormat dFormatter = new DecimalFormat("###,###");
        String strAccExamCnt = dFormatter.format(accExamCnt);
        String strDecideCnt = dFormatter.format(decideCnt);
        
        data.setStrAccExamCnt(strAccExamCnt);
        data.setStrDecideCnt(strDecideCnt);

        return data;

        //10시 30분 - 10시 29분(이전 날의 데이터).. 

    }
    public void insertCoronaSidoInfo(CoronaSidoInfoVO vo){
        mapper.insertCoronaSidoInfo(vo);
    }
    public CoronaInfoVO selectTodayCoronaSidoInfo(){
        // Calendar start = Calendar.getInstance();
        // Calendar end = Calendar.getInstance();
        
        // start.set(Calendar.HOUR_OF_DAY, 10);
        // start.set(Calendar.MINUTE, 30);
        // start.set(Calendar.SECOND, 0);
        
        //2021-08-11 01:00:00 - 이전시간 
        //2021-08-11 10:30:00 - 세팅값
        //2021-08-11 14:30:00 - 이후시간

        //현재 시간이 세팅값보다 이전시간 일때, 전날 데이터를 뽑아주고
        //현재 시간이 세팅값보다 이후시간 이라면, 오늘 데이터를 뽑아준다.

        Date now = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String date = formatter.format(now);

        CoronaInfoVO data = mapper.selectCoronaInfoByDate(date);

        Integer accExamCnt = data.getAccExamCnt();
        Integer decideCnt = data.getDecideCnt();

        DecimalFormat dFormatter = new DecimalFormat("###,###");
        String strAccExamCnt = dFormatter.format(accExamCnt);
        String strDecideCnt = dFormatter.format(decideCnt);
        
        data.setStrAccExamCnt(strAccExamCnt);
        data.setStrDecideCnt(strDecideCnt);

        return data;

        //10시 30분 - 10시 29분(이전 날의 데이터).. 
    }
}
