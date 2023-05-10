package com.example.weather.sickness.details.service.vo;

import java.util.Date;
import java.util.Map;
import java.util.Objects;
import javax.xml.crypto.Data;
import org.springframework.data.mongodb.core.aggregation.ArrayOperators.In;

public class SicknessResponseVo {

  private Date updated;
  private String country;
  private Map<String, Object> countryInfo;
  private Integer cases;
  private Integer todayCases;
  private Integer deaths;
  private Integer todayDeaths;
  private Integer recovered;
  private Integer todayRecovered;
  private Integer active;
  private Integer critical;

  private Integer casesPerOneMillion;
  private Integer deathsPerOneMillion;
  private Integer tests;
  private Integer testsPerOneMillion;
  private Integer population;
  private String continent;
  private Integer oneCasePerPeople;
  private Integer oneDeathPerPeople;
  private Integer oneTestPerPeople;
  private Double activePerOneMillion;
  private Double recoveredPerOneMillion;
  private Integer criticalPerOneMillion;

  public SicknessResponseVo() {
  }

  public Date getUpdated() {
    return updated;
  }

  public void setUpdated(Date updated) {
    this.updated = updated;
  }

  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public Map<String, Object> getCountryInfo() {
    return countryInfo;
  }

  public void setCountryInfo(Map<String, Object> countryInfo) {
    this.countryInfo = countryInfo;
  }

  public Integer getCases() {
    return cases;
  }

  public void setCases(Integer cases) {
    this.cases = cases;
  }

  public Integer getTodayCases() {
    return todayCases;
  }

  public void setTodayCases(Integer todayCases) {
    this.todayCases = todayCases;
  }

  public Integer getDeaths() {
    return deaths;
  }

  public void setDeaths(Integer deaths) {
    this.deaths = deaths;
  }

  public Integer getTodayDeaths() {
    return todayDeaths;
  }

  public void setTodayDeaths(Integer todayDeaths) {
    this.todayDeaths = todayDeaths;
  }

  public Integer getRecovered() {
    return recovered;
  }

  public void setRecovered(Integer recovered) {
    this.recovered = recovered;
  }

  public Integer getTodayRecovered() {
    return todayRecovered;
  }

  public void setTodayRecovered(Integer todayRecovered) {
    this.todayRecovered = todayRecovered;
  }

  public Integer getActive() {
    return active;
  }

  public void setActive(Integer active) {
    this.active = active;
  }

  public Integer getCritical() {
    return critical;
  }

  public void setCritical(Integer critical) {
    this.critical = critical;
  }

  public Integer getCasesPerOneMillion() {
    return casesPerOneMillion;
  }

  public void setCasesPerOneMillion(Integer casesPerOneMillion) {
    this.casesPerOneMillion = casesPerOneMillion;
  }

  public Integer getDeathsPerOneMillion() {
    return deathsPerOneMillion;
  }

  public void setDeathsPerOneMillion(Integer deathsPerOneMillion) {
    this.deathsPerOneMillion = deathsPerOneMillion;
  }

  public Integer getTests() {
    return tests;
  }

  public void setTests(Integer tests) {
    this.tests = tests;
  }

  public Integer getTestsPerOneMillion() {
    return testsPerOneMillion;
  }

  public void setTestsPerOneMillion(Integer testsPerOneMillion) {
    this.testsPerOneMillion = testsPerOneMillion;
  }

  public Integer getPopulation() {
    return population;
  }

  public void setPopulation(Integer population) {
    this.population = population;
  }

  public String getContinent() {
    return continent;
  }

  public void setContinent(String continent) {
    this.continent = continent;
  }

  public Integer getOneCasePerPeople() {
    return oneCasePerPeople;
  }

  public void setOneCasePerPeople(Integer oneCasePerPeople) {
    this.oneCasePerPeople = oneCasePerPeople;
  }

  public Integer getOneDeathPerPeople() {
    return oneDeathPerPeople;
  }

  public void setOneDeathPerPeople(Integer oneDeathPerPeople) {
    this.oneDeathPerPeople = oneDeathPerPeople;
  }

  public Integer getOneTestPerPeople() {
    return oneTestPerPeople;
  }

  public void setOneTestPerPeople(Integer oneTestPerPeople) {
    this.oneTestPerPeople = oneTestPerPeople;
  }

  public Double getActivePerOneMillion() {
    return activePerOneMillion;
  }

  public void setActivePerOneMillion(Double activePerOneMillion) {
    this.activePerOneMillion = activePerOneMillion;
  }

  public Double getRecoveredPerOneMillion() {
    return recoveredPerOneMillion;
  }

  public void setRecoveredPerOneMillion(Double recoveredPerOneMillion) {
    this.recoveredPerOneMillion = recoveredPerOneMillion;
  }

  public Integer getCriticalPerOneMillion() {
    return criticalPerOneMillion;
  }

  public void setCriticalPerOneMillion(Integer criticalPerOneMillion) {
    this.criticalPerOneMillion = criticalPerOneMillion;
  }
}
