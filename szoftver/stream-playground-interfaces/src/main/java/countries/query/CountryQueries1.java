package countries.query;

import countries.model.Country;
import countries.model.Region;
import lombok.NonNull;

import java.time.ZoneId;
import java.util.List;
import java.util.LongSummaryStatistics;
import java.util.Optional;
import java.util.Set;

/**
 * Defines query methods for {@link Country} objects.
 */
public interface CountryQueries1 {

    /**
     * Returns the list of country names.
     *
     * @param countries the list of countries
     * @return the list of country names
     */
    List<String> getCountryNames(@NonNull List<Country> countries);

    /**
     * Returns the list of capitals in alphabetical order.
     *
     * @param countries the list of countries
     * @return the list of capitals in alphabetical order
     */
    List<String> getCapitalsInAlphabeticalOrder(@NonNull List<Country> countries);

    /**
     * Returns the list of capitals in reverse alphabetical order.
     *
     * @param countries the list of countries
     * @return the list of capitals in reverse alphabetical order
     */
    List<String> getCapitalsInReverseOrder(@NonNull List<Country> countries);

    /**
     * Returns the maximum population.
     *
     * @param countries the list of countries
     * @return the maximum population
     */
    long getMaxPopulation(@NonNull List<Country> countries);

    /**
     * Returns the average population.
     *
     * @param countries the list of countries
     * @return the average population
     */
    double getAveragePopulation(@NonNull List<Country> countries);

    /**
     * Returns summary statistics about the population field.
     *
     * @param countries the list of countries
     * @return the summary statistics of population field
     */
    LongSummaryStatistics getPopulationSummaryStatistics(@NonNull List<Country> countries);

    /**
     * Returns the list of European country names.
     *
     * @param countries the list of countries
     * @return the list of European country names
     */
    List<String> getEuropeanCountryNames(@NonNull List<Country> countries);

    /**
     * Returns the list of country names of the given region.
     *
     * @param countries the list of countries
     * @param region the region
     * @return the list of country names of the given region
     */
    List<String> getCountryNamesInRegion(@NonNull List<Country> countries, @NonNull Region region);

    /**
     * Returns the number of European countries.
     *
     * @param countries the list of countries
     * @return the number of European countries
     */
    long getCountOfEuropeanCountries(@NonNull List<Country> countries);

    /**
     * Returns the number of countries of the given region.
     *
     * @param countries the list of countries
     * @param region the region
     * @return the number of countries of the given region
     */
    long getCountOfCountriesInRegion(@NonNull List<Country> countries, @NonNull Region region);

    /**
     * Returns the number of independent countries.
     *
     * @param countries the list of countries
     * @return the number of independent countries
     */
    long getCountOfIndependentCountries(@NonNull List<Country> countries);

    /**
     * Returns the list of countries with population below 100.
     *
     * @param countries the list of countries
     * @return the list of countries with population below 100
     */
    List<Country> getCountriesWithPopulationBelowOneHundred(@NonNull List<Country> countries);

    /**
     * Returns the list of countries with population below the given threshold.
     *
     * @param countries the list of countries
     * @param threshold the threshold
     * @return the list of countries with population below the given threshold
     */
    List<Country> getCountriesWithPopulationBelowThreshold(@NonNull List<Country> countries, @NonNull long threshold);

    /**
     * Returns the list of country names with population below 100.
     *
     * @param countries the list of countries
     * @param threshold the threshold
     * @return the list of country names with population below 100
     */
    List<String> getCountryNamesWithPopulationBelowOneHundred(@NonNull List<Country> countries, @NonNull long threshold);

    /**
     * Returns the list of country names with population below the given threshold.
     *
     * @param countries the list of countries
     * @param threshold the threshold
     * @return the list of country names with population below the given threshold
     */
    List<String> getCountryNamesWithPopulationBelowThreshold(@NonNull List<Country> countries, @NonNull long threshold);

    /**
     * Returns the sum of population of European countries.
     *
     * @param countries the list of countries
     * @return the sum of population of European countries
     */
    long getSumOfEuropeanPopulation(@NonNull List<Country> countries);

    /**
     * Returns the sum of population of countries of the given region.
     *
     * @param countries the list of countries
     * @param region the region
     * @return the sum of population of countries of the given region
     */
    long getSumOfPopulationInRegion(@NonNull List<Country> countries, @NonNull Region region);

    /**
     * Returns the list of populations of European countries in ascending order.
     *
     * @param countries the list of countries
     * @return the list of populations of European countries in ascending order
     */
    List<Long> getEuropeanCountriesPopulationInAscOrder(@NonNull List<Country> countries);

    /**
     * Returns the list of populations of countries of the given region in descending order.
     *
     * @param countries the list of countries
     * @param region the region
     * @return the list of populations of countries of the given region in descending order
     */
    List<Long> getCountriesPopulationInDescOrderInRegion(@NonNull List<Country> countries, @NonNull Region region);

    /**
     * Returns the European country with the highest population.
     *
     * @param countries the list of countries
     * @return the most populous European country
     */
    Optional<Country> getMostPopulousEuropeanCountry(@NonNull List<Country> countries);

    /**
     * Returns the country in the given region with the highest population.
     *
     * @param countries the list of countries
     * @param region the region
     * @return the most populous country in the given region
     */
    Optional<Country> getMostPopulousCountryInRegion(@NonNull List<Country> countries, @NonNull Region region);

    /**
     * Returns the name of the European country with the highest population.
     *
     * @param countries the list of countries
     * @return the name of the most populous European country
     */
    String getMostPopulousEuropeanCountryName(@NonNull List<Country> countries);

    /**
     * Returns the country name in the given region with the highest population.
     *
     * @param countries the list of countries
     * @param region the region
     * @return the name of the most populous country in the given region
     */
    String getMostPopulousCountryNameInRegion(@NonNull List<Country> countries, @NonNull Region region);

    /**
     * Returns the list of country names of the first five countries.
     *
     * @param countries the list of countries
     * @return the list of country names of the first five countries
     */
    List<String> getFirstFiveCountryNames(@NonNull List<Country> countries);

    /**
     * Returns the list of country names of the first n countries.
     *
     * @param countries the list of countries
     * @param count the number of countries to return
     * @return the list of country names of the first n countries
     */
    List<String> getFirstNCountryNames(@NonNull List<Country> countries, @NonNull int count);

    /**
     * Returns whether there is at least one country with 0 population.
     *
     * @param countries the list of countries
     * @return if there is at least one country with 0 population
     */
    boolean doesCountryWithZeroPopulationExist(@NonNull List<Country> countries);

    /**
     * Returns whether there is at least one country with the given population.
     *
     * @param countries the list of countries
     * @param population the population
     * @return if there is at least one country with the given population
     */
    boolean doesCountryWithPopulationExist(@NonNull List<Country> countries, @NonNull long population);

    /**
     * Returns whether each country has at least one timezone.
     *
     * @param countries the list of countries
     * @return if each country has at least one timezone
     */
    boolean doesEveryCountryHaveAtLeastOneTimezone(@NonNull List<Country> countries);

    /**
     * Returns the first country whose name starts with H.
     *
     * @param countries the list of countries
     * @return the first country whose name starts with H
     */
    Country getFirstCountryStartingWithH(@NonNull List<Country> countries);

    /**
     * Returns the first country whose name starts with the given letter.
     *
     * @param countries the list of countries
     * @param letter the letter
     * @return the first country whose name starts with the given letter
     */
    Country getFirstCountryStartingWithLetter(@NonNull List<Country> countries, @NonNull char letter);

    /**
     * Returns the number of all distinct timezones.
     *
     * @param countries the list of countries
     * @return the number of all distinct timezones
     */
    double getCountOfDistinctTimezones(@NonNull List<Country> countries);

    /**
     * Returns the set of distinct timezones of European countries.
     *
     * @param countries the list of countries
     * @return the set of distinct timezones of European countries
     */
    Set<ZoneId> getDistinctTimezonesOfEuropeanCountries(@NonNull List<Country> countries);

    /**
     * Returns the list of countries in descending order of population.
     *
     * @param countries the list of countries
     * @return the list of countries in descending order of population
     */
    List<Country> getCountriesInDescPopulationOrder(@NonNull List<Country> countries);

    /**
     * Returns the length of the longest country name.
     *
     * @param countries the list of countries
     * @return the length of the longest country name
     */
    long getLengthOfLongestCountryName(@NonNull List<Country> countries);

    /**
     * Returns the list of capitals in ascending order of length.
     *
     * @param countries the list of countries
     * @return the list of capitals of each country in ascending order of length
     */
    List<String> getCapitalsInAscLengthOrder(@NonNull List<Country> countries);

    /**
     * Returns the list of capitals in ascending order of length and then in alphabetical order.
     *
     * @param countries the list of countries
     * @return the list of capitals in ascending order of length and then in alphabetical order
     */
    List<String> getCapitalsInAscLengthAndAlphabeticalOrder(@NonNull List<Country> countries);

}
