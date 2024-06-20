package company.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import company.dto.CompanyDTO;

public class DataProcessor {
    public static Map<String, Object> processData(List<CompanyDTO> list) {
        Map<String, Object> dataMap = new HashMap<>();

        int maleCount = 0;
        int femaleCount = 0;
        int salaryCount = 0;
        Map<String, Integer> departmentCounts = new HashMap<>();
        Map<String, Integer> joinYearCounts = new HashMap<>();
        Map<String, Integer> salarySums = new HashMap<>();
        Map<String, Integer> salaryCounts = new HashMap<>();
        int[] ageCounts = new int[5];

        for (CompanyDTO dto : list) {
            // Gender Count
            if ("male".equals(dto.getS_gender())) {
                maleCount++;
            } else if ("female".equals(dto.getS_gender())) {
                femaleCount++;
            }

            // Department Count
            String department = dto.getS_department();
            departmentCounts.put(department, departmentCounts.getOrDefault(department, 0) + 1);

            // Join Year Count
            String joinYear = dto.getDate().substring(0, 4);
            joinYearCounts.put(joinYear, joinYearCounts.getOrDefault(joinYear, 0) + 1);

            // Salary Count
            salarySums.put(department, salarySums.getOrDefault(department, 0) + dto.getS_salary());
            salaryCounts.put(department, salaryCounts.getOrDefault(department, 0) + 1);

            // Age Count
            int birthYear = dto.getS_birth() / 10000;
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
