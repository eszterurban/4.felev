package countries.query;

import countries.model.Country;
import countries.model.Region;
import lombok.NonNull;

import java.math.BigDecimal;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * Defines query methods for {@link Country} objects.
 */
public interface CountryQueries3 {

    /**
     * Returns the largest country.
     *
     * @param countries the list of countries
     * @return the largest country
     */
    Optional<Country> getLargestCountry(@NonNull List<Country> countries);

    /**
     * Returns the names of countries with null area.
     *
     * @param countries the list of countries
     * @return list of country names with null area
     */
    List<String> getCountryNamesWithNullArea(@NonNull List<Country> countries);

    /**
     * Returns summary statistics about the area field.
     *
     * @param countries the list of countries
     * @return the summary statistics about the area field
     */
    DoubleSummaryStatistics getSummaryStatisticsOfArea(@NonNull List<Country> countries);

    /**
     * Returns the total area of countries.
     *
     * @param countries the list of countries
     * @return the total area of countries
     */
    Optional<BigDecimal> getTotalAreaOfCountries(@NonNull List<Country> countries);

    /**
     * Returns a comma-separated string of country names sorted alphabetically.
     *
     * @param countries the list of countries
     * @return the comma-separated string of country names sorted alphabetically
     */
    String getSortedCountryNamesSeparatedByComma(@NonNull List<Country> countries);

    /**
     * Returns the map of country code-country name pairs.
     *
     * @param countries the list of countries
     * @return the map of country code-country name pairs
     */
    Map<String, String> getCountriesByCodeAndName(@NonNull List<Country> countries);

    /**
     * Returns the map of countries for efficient access by country code.
     *
     * @param countries the list of countries
     * @return the map of countries by country code
     */
    Map<String, Country> getCountriesByCode(@NonNull List<Country> countries);

    /**
     * Returns the list of countries with population less or equal to that of Hungary in descending order of population.
     *
     * @param countries the list of countries
     * @return the list of countries with population less or equal to that of Hungary in descending order of population
     */
    List<Country> getCountriesSmallerThanHungaryInDescOrder(@NonNull List<Country> countries);

    /**
     * Returns the list of countries with population less or equal to that of the given country in descending order of population.
     *
     * @param countries the list of countries
     * @param comparingCountry the country for comparison
     * @return the list of countries with population less or equal to that of the given country in descending order of population
     */
    List<Country> getCountriesSmallerThanCountryInDescOrder(@NonNull List<Country> countries, @NonNull Country comparingCountry);

    /**
     * Returns the number of European and non-European countries.
     *
     * @param countries the list of countries
     * @return the number of European and non-European countries
     */
    Map<Boolean, Long> getCountriesPartitionedByBeingEuropeanAndCount(@NonNull List<Country> countries);

    /**
     * Returns the number of countries of the given region, as well as the number of countries which do not belong to the given region.
     *
     * @param countries the list of countries
     * @param region the region
     * @return the number of countries of the given region, as well as the number of countries which do not belong to the given region
     */
    Map<Boolean, Long> getCountriesPartitionedByRegionAndCount(@NonNull List<Country> countries, @NonNull Region region);

    /**
     * Returns the lists of countries by region.
     *
     * @param countries the list of countries
     * @return the lists of countries by region
     */
    Map<Region, List<Country>> getCountriesByRegion(@NonNull List<Country> countries);

    /**
     * Returns the number of countries by region.
     *
     * @param countries the list of countries
     * @return the number of countries by region
     */
    Map<Region, Long> getNumberOfCountriesByRegion(@NonNull List<Country> countries);

    /**
     * Returns population average by region.
     *
     * @param countries the list of countries
     * @return the population average by region
     */
    Map<Region, Double> getAveragePopulationByRegion(@NonNull List<Country> countries);

    /**
     * Returns the most populous country by region.
     *
     * @param countries the list of countries
     * @return the most populous country by region
     */
    Map<Region, Optional<Country>> getMostPopulousCountryByRegion(@NonNull List<Country> countries);

    /**
     * Returns the largest population by region.
     *
     * @param countries the list of countries
     * @return the largest population by region
     */
    Map<Region, Optional<Long>> getLargestPopulationByRegion(@NonNull List<Country> countries);

    /**
     * Returns the longest country name by region.
     *
     * @param countries the list of countries
     * @return the longest country name by region
     */
    Map<Region, String> getLongestCountryNameByRegion(@NonNull List<Country> countries);

    /**
     * Returning the number of countries grouped by the first letter of their name.
     *
     * @param countries the list of countries
     * @return the number of countries grouped by the first letter of their name
     */
    Map<Character, Long> getNumberOfCountriesByFirstLetter(@NonNull List<Country> countries);

    /**
     * Returns whether there are two or more countries with the same non-null area.
     *
     * @param countries the list of countries
     * @return if there are two or more countries with the same non-null area
     */
    boolean doesTwoOrMoreCountriesWithSameNonNullAreaExist(@NonNull List<Country> countries);
}
