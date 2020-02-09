package com.codingdojo.world;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.codingdojo.world.model.City;
import com.codingdojo.world.model.Country;
import com.codingdojo.world.model.Language;

import com.codingdojo.world.repository.CountryRepository;

@SpringBootTest
class WorldQueriesApplicationTests {
	
	@Autowired
	CountryRepository countryRepository;

	@Test
	void contextLoads() {
	}
	
	@Test
	public void testRepository() {
		List<Object[]> countries = countryRepository.countriesSpeakingSlovene();
		for (Object[] obj : countries) {
			System.out.println(((Country)obj[0]).getName() + " "+((Language)obj[1]).getLanguage() + " " + ((Language)obj[1]).getPercentage());
		}
	}
	
	@Test
	public void testCityCount() {
		List<Object[]> counts = countryRepository.findCountryCityCount();
		for (Object[] obj : counts) {
			System.out.println(obj[0] + " " + obj[1]);
		}
	}
	
	@Test
	public void testCitiesInMexicoCount() {
		List<Object[]> citiesInMexico = countryRepository.citiesInMexicoWithPopulationOver500000();
		for(Object[] obj : citiesInMexico) {
			System.out.println(((City)obj[0]).getName());
		}
	}

	@Test
	public void testLanguagesOverEightyNinePercent() {
		List<Object[]> languagesOverEightyNinePercent = countryRepository.findLanguagesOverEightyNinePercent();
		for(Object[] obj : languagesOverEightyNinePercent) {
			System.out.println(((Language)obj[0]).getLanguage());
		}
	}
	
	@Test
	public void testCountriesSurfaceAreaAndPopulation() {
		List<Object[]> countries = countryRepository.countriesWithSurfaceAreaUnder501AndPopulationOver100000();
		for(Object[] obj : countries) {
			System.out.println(((Country)obj[0]).getName());
		}
	}
	
	@Test
	public void testCountriesMonarchySurfaceArea() {
		List<Object[]> countries = countryRepository.countriesWithSurfaceAreaOver501AndGovernmentFormIsConstitutionalMonarchyAndLifeExpectancyIsOver75();
		for(Object[] obj : countries) {
			System.out.println(((Country)obj[0]).getName());
		}
	}
	
	@Test
	public void testArgentinaBuenosAiresPopulation() {
		List<Object[]> Argentina = countryRepository.citiesInArgentinaInBuenosAiresDistrictWhereCityPopulationIsMoreThan500000();
		for(Object[] obj : Argentina) {
			System.out.println(((Country)obj[0]).getName() + " " + ((City)obj[0]).getName() + " " + ((City)obj[0]).getDistrict() + " " + ((City)obj[0]).getPopulation());
		}
	}
	
	@Test
	public void testCountriesInRegion() {
		List<Object[]> countries = countryRepository.summarizeNumberOfCountriesWithinEachRegion();
		for(Object[] obj : countries) {
			System.out.println(((Country)obj[0]).getName() + " " + obj[1]);
		}
	}
	
}
