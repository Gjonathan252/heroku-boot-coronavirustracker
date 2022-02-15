package com.example.controllers;

import com.example.models.LocationStats;
import com.example.services.US_CoronaVirusDataServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    US_CoronaVirusDataServices coronaVirusDataService;

    @GetMapping("/")
    public String index(Model model) throws Exception{
        try {
            List<LocationStats> allStats = coronaVirusDataService.getAllStats();
            int totalReportedCases = allStats.stream().mapToInt(LocationStats::getLatestTotalCases).sum();
            int totalNewCases = allStats.stream().mapToInt(LocationStats::getDiffFromPrevDay).sum();
            model.addAttribute("locationStats", allStats);
            model.addAttribute("totalReportedCases", totalReportedCases);
            model.addAttribute("totalNewCases", totalNewCases);
            return "index";
        }catch (Exception e) {
            model.addAttribute("message", "unable to get data");
            return "error";
        }
    }

    @GetMapping("/global")
    public String global(Model model) throws Exception{
        try {
            List<LocationStats> allGlobalStats = coronaVirusDataService.getAllGlobalStats();
            int totalReportedCases = allGlobalStats.stream().mapToInt(LocationStats::getLatestTotalCases).sum();
            int totalNewCases = allGlobalStats.stream().mapToInt(LocationStats::getDiffFromPrevDay).sum();
            model.addAttribute("locationStats", allGlobalStats);
            model.addAttribute("totalReportedCases", totalReportedCases);
            model.addAttribute("totalNewCases", totalNewCases);
            return "global";
        }catch (Exception e) {
            model.addAttribute("message", "unable to get data");
            return "error";
        }
    }
}