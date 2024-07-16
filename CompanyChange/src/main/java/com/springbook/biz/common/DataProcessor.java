package com.springbook.biz.common;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.springbook.biz.salary.CompanyVO;

public class DataProcessor {
    public static Map<String, Object> processData(List<CompanyVO> list) {
        Map<String, Object> dataMap = new HashMap<>();

        int maleCount = 0;
        int femaleCount = 0;
        int salaryCount = 0;
        Map<String, Integer> departmentCounts = new HashMap<>();
        Map<String, Integer> joinYearCounts = new HashMap<>();
        Map<String, Integer> salarySums = new HashMap<>();
        Map<String, Integer> salaryCounts = new HashMap<>();
        int[] ageCounts = new int[5];

        for (CompanyVO VO : list) {
            // Gender Count
            if ("male".equals(VO.getS_gender())) {
                maleCount++;
            } else if ("female".equals(VO.getS_gender())) {
                femaleCount++;
            }

            // Department Count
            String department = VO.getS_department();
            departmentCounts.put(department, departmentCounts.getOrDefault(department, 0) + 1);

            // Join Year Count
            String joinYear = VO.getDate().substring(0, 4);
            joinYearCounts.put(joinYear, joinYearCounts.getOrDefault(joinYear, 0) + 1);

            // Salary Count
            salarySums.put(department, salarySums.getOrDefault(department, 0) + VO.getS_salary());
            salaryCounts.put(department, salaryCounts.getOrDefault(department, 0) + 1);

            // Age Count
            int birthYear = VO.getS_birth() / 10000;
            int age = 2024 - birthYear;
            if (age < 30) ageCounts[0]++;
            else if (age < 40) ageCounts[1]++;
            else if (age < 50) ageCounts[2]++;
            else if (age < 60) ageCounts[3]++;
            else ageCounts[4]++;
            
            // Total Salary_man Count
            salaryCount++;
        }

        Map<String, Integer> averageSalaries = new HashMap<>();
        for (Map.Entry<String, Integer> entry : salarySums.entrySet()) {
            String dept = entry.getKey();
            int avgSalary = entry.getValue() / salaryCounts.get(dept);
            averageSalaries.put(dept, avgSalary);
        }

        dataMap.put("maleCount", maleCount);
        dataMap.put("femaleCount", femaleCount);
        dataMap.put("departmentCounts", departmentCounts);
        dataMap.put("joinYearCounts", joinYearCounts);
        dataMap.put("averageSalaries", averageSalaries);
        dataMap.put("ageCounts", ageCounts);
        dataMap.put("salaryCount", salaryCount);

        return dataMap;
    }
}
