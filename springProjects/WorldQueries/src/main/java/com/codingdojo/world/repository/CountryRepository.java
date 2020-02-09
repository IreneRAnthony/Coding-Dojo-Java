package com.codingdojo.world.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.codingdojo.world.model.Country;

public interface CountryRepository extends CrudRepository<Country, Long> {
	
	// 1
	@Query("SELECT c.name,l.language FROM Country c Join c.languages l WHERE l.language = 'Slovene' ORDER BY l.percentage DESC")
	public List<Object[]> countriesSpeakingSlovene();
	
	// 2
	@Query("SELECT c.name, COUNT(ci.id) AS num_cities FROM Country c JOIN c.cities ci GROUP BY c.id ORDER BY num_cities DESC")
	List<Object[]> findCountryCityCount();
	
	// 3
	@Query("SELECT ci.name, ci.population, FROM Country c JOIN City ci WHERE ci.country = 'Mexico' ORDER BY ci.population DESC")
	List<Object[]> citiesInMexicoWithPopulationOver500000();
	
	// 4
	@Query("SELECT c.name, l.language, FROM Country.languages l JOIN l.percentage WHERE l.percentage > 89.0 ORDER BY l.percentage DESC")
	List<Object[]> findLanguagesOverEightyNinePercent();
	
	// 5
	@Query("SELECT c.name,c.surfaceArea,c.population FROM Country c JOIN c.surfaceArea WHERE c.surfaceArea < 501 JOIN c.Population AND c.Population > 100000")
	List<Object[]> countriesWithSurfaceAreaUnder501AndPopulationOver100000();
	
	// 6
	@Query("SELECT c.name,c.surfaceArea,c.lifeExpectancy FROM Country c WHERE c.surfaceArea < 501.0 JOIN c.governmentForm AND c.governmentForm = Constitutional Monarchy JOIN c.lifeExpectancy AND c.lifeExpectancy > 75.0")
	List<Object[]> countriesWithSurfaceAreaOver501AndGovernmentFormIsConstitutionalMonarchyAndLifeExpectancyIsOver75();
	
	// 7
	@Query("SELECT c.name, ci.name, ci.district, ci.population, FROM City ci JOIN Country c.cities WHERE ci.country = 'Argentina' AND ci.district = 'Buenos Aires' AND ci.population > 500000")
	List<Object[]> citiesInArgentinaInBuenosAiresDistrictWhereCityPopulationIsMoreThan500000();
	
	// 8
	@Query("SELECT c.region, COUNT(c.id) AS num_countries FROM Country c GROUP BY c.id ORDER BY num_countries DESC")
	List<Object[]> summarizeNumberOfCountriesWithinEachRegion();
	
}
