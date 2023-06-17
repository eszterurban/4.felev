package countries;

import countries.model.Country;
import countries.model.Region;
import countries.query.CountryQueries1;
import countries.query.CountryQueries2;
import countries.query.CountryQueries3;
import countries.repository.CountryRepository;
import lombok.NonNull;

import java.math.BigDecimal;
import java.time.ZoneId;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CountryExercises implements CountryQueries1, CountryQueries2, CountryQueries3 {
    private final List<Country> countries;

    public static void main(String[] args){
        var countryExercises = new CountryExercises();
        System.out.println(countryExercises.getCountriesByCode(countryExercises.countries));
    }

    public CountryExercises() {
        this.countries = new CountryRepository().getAll();
    }

    /**
     * Returns the list of country names.
     *
     * @param countries the list of countries
     * @return the list of country names
     */
    @Override
    public List<String> getCountryNames(@NonNull List<Country> countries) {
        return countries.stream()
                .map(country -> country.getName())
                .collect(Collectors.toList());
    }

    /**
     * Returns the list of capitals in alphabetical order.
     *
     * @param countries the list of countries
     * @return the list of capitals in alphabetical order
     */
    @Override
    public List<String> getCapitalsInAlphabeticalOrder(@NonNull List<Country> countries) {
        return countries.stream()
                .map(country -> country.getCapital())
                .sorted(Comparator.nullsFirst(Comparator.naturalOrder()))
                .collect(Collectors.toList());
    }

    /**
     * Returns the list of capitals in reverse alphabetical order.
     *
     * @param countries the list of countries
     * @return the list of capitals in reverse alphabetical order
     */
    @Override
    public List<String> getCapitalsInReverseOrder(@NonNull List<Country> countries) {
        return countries.stream()
                .map(country -> country.getCapital())
                .sorted(Comparator.nullsLast(Comparator.reverseOrder()))
                .collect(Collectors.toList());
    }

    /**
     * Returns the maximum population.
     *
     * @param countries the list of countries
     * @return the maximum population
     */
    @Override
    public long getMaxPopulation(@NonNull List<Country> countries) {
        return countries.stream()
                .mapToLong(country -> country.getPopulation())
                .max()
                .orElseGet(() -> 0);
    }

    /**
     * Returns the average population.
     *
     * @param countries the list of countries
     * @return the average population
     */
    @Override
    public double getAveragePopulation(@NonNull List<Country> countries) {
        return countries.stream()
                .mapToLong(country -> country.getPopulation())
                .average()
                .orElseGet(() -> 0);
    }

    /**
     * Returns summary statistics about the population field.
     *
     * @param countries the list of countries
     * @return the summary statistics of population field
     */
    @Override
    public LongSummaryStatistics getPopulationSummaryStatistics(@NonNull List<Country> countries) {
        return null;
    }

    /**
     * Returns the list of European country names.
     *
     * @param countries the list of countries
     * @return the list of European country names
     */
    @Override
    public List<String> getEuropeanCountryNames(@NonNull List<Country> countries) {
        return countries.stream()
                .filter(country -> country.getRegion() == Region.EUROPE)
                .map(eurpeanCountry -> eurpeanCountry.getName())
                .collect(Collectors.toList());
    }

    /**
     * Returns the list of country names of the given region.
     *
     * @param countries the list of countries
     * @param region    the region
     * @return the list of country names of the given region
     */
    @Override
    public List<String> getCountryNamesInRegion(@NonNull List<Country> countries, @NonNull Region region) {
        return null;
    }

    /**
     * Returns the number of European countries.
     *
     * @param countries the list of countries
     * @return the number of European countries
     */
    @Override
    public long getCountOfEuropeanCountries(@NonNull List<Country> countries) {
        return 0;
    }

    /**
     * Returns the number of countries of the given region.
     *
     * @param countries the list of countries
     * @param region    the region
     * @return the number of countries of the given region
     */
    @Override
    public long getCountOfCountriesInRegion(@NonNull List<Country> countries, @NonNull Region region) {
        return 0;
    }

    /**
     * Returns the number of independent countries.
     *
     * @param countries the list of countries
     * @return the number of independent countries
     */
    @Override
    public long getCountOfIndependentCountries(@NonNull List<Country> countries) {
        return 0;
    }

    /**
     * Returns the list of countries with population below 100.
     *
     * @param countries the list of countries
     * @return the list of countries with population below 100
     */
    @Override
    public List<Country> getCountriesWithPopulationBelowOneHundred(@NonNull List<Country> countries) {
        return null;
    }

    /**
     * Returns the list of countries with population below the given threshold.
     *
     * @param countries the list of countries
     * @param threshold the threshold
     * @return the list of countries with population below the given threshold
     */
    @Override
    public List<Country> getCountriesWithPopulationBelowThreshold(@NonNull List<Country> countries, @NonNull long threshold) {
        return null;
    }

    /**
     * Returns the list of country names with population below 100.
     *
     * @param countries the list of countries
     * @param threshold the threshold
     * @return the list of country names with population below 100
     */
    @Override
    public List<String> getCountryNamesWithPopulationBelowOneHundred(@NonNull List<Country> countries, @NonNull long threshold) {
        return null;
    }

    /**
     * Returns the list of country names with population below the given threshold.
     *
     * @param countries the list of countries
     * @param threshold the threshold
     * @return the list of country names with population below the given threshold
     */
    @Override
    public List<String> getCountryNamesWithPopulationBelowThreshold(@NonNull List<Country> countries, @NonNull long threshold) {
        return null;
    }

    /**
     * Returns the sum of population of European countries.
     *
     * @param countries the list of countries
     * @return the sum of population of European countries
     */
    @Override
    public long getSumOfEuropeanPopulation(@NonNull List<Country> countries) {
        return 0;
    }

    /**
     * Returns the sum of population of countries of the given region.
     *
     * @param countries the list of countries
     * @param region    the region
     * @return the sum of population of countries of the given region
     */
    @Override
    public long getSumOfPopulationInRegion(@NonNull List<Country> countries, @NonNull Region region) {
        return 0;
    }

    /**
     * Returns the list of populations of European countries in ascending order.
     *
     * @param countries the list of countries
     * @return the list of populations of European countries in ascending order
     */
    @Override
    public List<Long> getEuropeanCountriesPopulationInAscOrder(@NonNull List<Country> countries) {
        return null;
    }

    /**
     * Returns the list of populations of countries of the given region in descending order.
     *
     * @param countries the list of countries
     * @param region    the region
     * @return the list of populations of countries of the given region in descending order
     */
    @Override
    public List<Long> getCountriesPopulationInDescOrderInRegion(@NonNull List<Country> countries, @NonNull Region region) {
        return null;
    }

    /**
     * Returns the European country with the highest population.
     *
     * @param countries the list of countries
     * @return the most populous European country
     */
    @Override
    public Optional<Country> getMostPopulousEuropeanCountry(@NonNull List<Country> countries) {
        return Optional.empty();
    }

    /**
     * Returns the country in the given region with the highest population.
     *
     * @param countries the list of countries
     * @param region    the region
     * @return the most populous country in the given region
     */
    @Override
    public Optional<Country> getMostPopulousCountryInRegion(@NonNull List<Country> countries, @NonNull Region region) {
        return Optional.empty();
    }

    /**
     * Returns the name of the European country with the highest population.
     *
     * @param countries the list of countries
     * @return the name of the most populous European country
     */
    @Override
    public String getMostPopulousEuropeanCountryName(@NonNull List<Country> countries) {
        return null;
    }

    /**
     * Returns the country name in the given region with the highest population.
     *
     * @param countries the list of countries
     * @param region    the region
     * @return the name of the most populous country in the given region
     */
    @Override
    public String getMostPopulousCountryNameInRegion(@NonNull List<Country> countries, @NonNull Region region) {
        return null;
    }

    /**
     * Returns the list of country names of the first five countries.
     *
     * @param countries the list of countries
     * @return the list of country names of the first five countries
     */
    @Override
    public List<String> getFirstFiveCountryNames(@NonNull List<Country> countries) {
        return null;
    }

    /**
     * Returns the list of country names of the first n countries.
     *
     * @param countries the list of countries
     * @param count     the number of countries to return
     * @return the list of country names of the first n countries
     */
    @Override
    public List<String> getFirstNCountryNames(@NonNull List<Country> countries, @NonNull int count) {
        return null;
    }

    /**
     * Returns whether there is at least one country with 0 population.
     *
     * @param countries the list of countries
     * @return if there is at least one country with 0 population
     */
    @Override
    public boolean doesCountryWithZeroPopulationExist(@NonNull List<Country> countries) {
        return false;
    }

    /**
     * Returns whether there is at least one country with the given population.
     *
     * @param countries  the list of countries
     * @param population the population
     * @return if there is at least one country with the given population
     */
    @Override
    public boolean doesCountryWithPopulationExist(@NonNull List<Country> countries, @NonNull long population) {
        return false;
    }

    /**
     * Returns whether each country has at least one timezone.
     *
     * @param countries the list of countries
     * @return if each country has at least one timezone
     */
    @Override
    public boolean doesEveryCountryHaveAtLeastOneTimezone(@NonNull List<Country> countries) {
        return false;
    }

    /**
     * Returns the first country whose name starts with H.
     *
     * @param countries the list of countries
     * @return the first country whose name starts with H
     */
    @Override
    public Country getFirstCountryStartingWithH(@NonNull List<Country> countries) {
        return null;
    }

    /**
     * Returns the first country whose name starts with the given letter.
     *
     * @param countries the list of countries
     * @param letter    the letter
     * @return the first country whose name starts with the given letter
     */
    @Override
    public Country getFirstCountryStartingWithLetter(@NonNull List<Country> countries, @NonNull char letter) {
        return null;
    }

    /**
     * Returns the number of all distinct timezones.
     *
     * @param countries the list of countries
     * @return the number of all distinct timezones
     */
    @Override
    public double getCountOfDistinctTimezones(@NonNull List<Country> countries) {
        return 0;
    }

    /**
     * Returns the set of distinct timezones of European countries.
     *
     * @param countries the list of countries
     * @return the set of distinct timezones of European countries
     */
    @Override
    public Set<ZoneId> getDistinctTimezonesOfEuropeanCountries(@NonNull List<Country> countries) {
        return null;
    }

    /**
     * Returns the list of countries in descending order of population.
     *
     * @param countries the list of countries
     * @return the list of countries in descending order of population
     */
    @Override
    public List<Country> getCountriesInDescPopulationOrder(@NonNull List<Country> countries) {
        return null;
    }

    /**
     * Returns the length of the longest country name.
     *
     * @param countries the list of countries
     * @return the length of the longest country name
     */
    @Override
    public long getLengthOfLongestCountryName(@NonNull List<Country> countries) {
        return countries.stream()
                .mapToLong(country -> country.getName().length())
                .max()
                .orElse(0);
    }

    /**
     * Returns the list of capitals in ascending order of length.
     *
     * @param countries the list of countries
     * @return the list of capitals of each country in ascending order of length
     */
    @Override
    public List<String> getCapitalsInAscLengthOrder(@NonNull List<Country> countries) {
        return null;
    }

    /**
     * Returns the list of capitals in ascending order of length and then in alphabetical order.
     *
     * @param countries the list of countries
     * @return the list of capitals in ascending order of length and then in alphabetical order
     */
    @Override
    public List<String> getCapitalsInAscLengthAndAlphabeticalOrder(@NonNull List<Country> countries) {
        return null;
    }

    /**
     * Returns whether there is at least one country with the word "island" in its name ignoring case.
     *
     * @param countries the list of countries
     * @return if there is at least one country with the word "island" in its name ignoring case
     */
    @Override
    public boolean doesCountryWithNameContainingIslandExist(@NonNull List<Country> countries) {
        return countries.stream()
                .anyMatch(country -> country.getName().toLowerCase().contains("island"));
    }

    /**
     * Returns whether there is at least one country with the given word in its name ignoring case.
     *
     * @param countries the list of countries
     * @param word      the word
     * @return if there is at least one country with the given word in its name ignoring case
     */
    @Override
    public boolean doesCountryWithNameContainingTextExist(@NonNull List<Country> countries, @NonNull String word) {
        return false;
    }

    /**
     * Returns the first country name that contains the word "island" ignoring case.
     *
     * @param countries the list of countries
     * @return the first country name that contains the word "island" ignoring case
     */
    @Override
    public Optional<String> getFirstCountryNameContainingIsland(@NonNull List<Country> countries) {
        return Optional.empty();
    }

    /**
     * Returns the first country name that contains the given word ignoring case.
     *
     * @param countries the list of countries
     * @param word      the word
     * @return the first country name that contains the given word ignoring case
     */
    @Override
    public Optional<String> getFirstCountryNameContainingText(@NonNull List<Country> countries, @NonNull String word) {
        return Optional.empty();
    }

    /**
     * Returns the list of country names in which the first and the last letters are the same ignoring case.
     *
     * @param countries the list of countries
     * @return the list of country names in which the first and the last letters are the same ignoring case
     */
    @Override
    public List<String> getCountryNamesWithMatchingFirstAndLastLetters(@NonNull List<Country> countries) {
        return null;
    }

    /**
     * Returns the list of populations of the first ten least populous countries.
     *
     * @param countries the list of countries
     * @return the list of populations of the first ten least populous countries
     */
    @Override
    public List<Long> getPopulationsOfFirstTenLeastPopulousCountries(@NonNull List<Country> countries) {
        return null;
    }

    /**
     * Returns the list of populations of the first n least populous countries.
     *
     * @param countries the list of countries
     * @param count     the number of populations to return
     * @return the list of populations of the first n least populous countries
     */
    @Override
    public List<Long> getPopulationsOfFirstNLeastPopulousCountries(@NonNull List<Country> countries, @NonNull int count) {
        return null;
    }

    /**
     * Returns the list of the first ten least populous country names.
     *
     * @param countries the list of countries
     * @return the list of the first ten least populous country names
     */
    @Override
    public List<String> getNamesOfFirstTenLeastPopulousCountries(@NonNull List<Country> countries) {
        return null;
    }

    /**
     * Returns the list of the first n least populous country names.
     *
     * @param countries the list of countries
     * @param count     the number of country names to return
     * @return the list of the first n least populous country names
     */
    @Override
    public List<String> getNamesOfFirstNLeastPopulousCountries(@NonNull List<Country> countries, @NonNull int count) {
        return null;
    }

    /**
     * Returns summary statistics about the number of country name translations associated with each country.
     *
     * @param countries the list of countries
     * @return summary statistics about the number of country name translations associated with each country
     */
    @Override
    public IntSummaryStatistics getSummaryStatisticsOfNumberOfCountryNameTranslations(@NonNull List<Country> countries) {
        return null;
    }

    /**
     * Returns the list of country names in the ascending order of the number of timezones.
     *
     * @param countries the list of countries
     * @return the list of country names in the ascending order of the number of timezones
     */
    @Override
    public List<String> getCountryNamesInNumberOfTimezonesAscOrder(@NonNull List<Country> countries) {
        return null;
    }

    /**
     * Returns the number of timezones for each country in the form name:timezones, in the ascending order of the number of timezones.
     *
     * @param countries the list of countries
     * @return the number of timezones for each country in the form name:timezones, in the ascending order of the number of timezones
     */
    @Override
    public List<String> getNumberOfTimezonesInCustomFormat(@NonNull List<Country> countries) {
        return null;
    }

    /**
     * Returns the number of countries with no Spanish country name translation (the Spanish language is identified by the language code "es").
     *
     * @param countries the list of countries
     * @return the number of countries with no Spanish country name translation (the Spanish language is identified by the language code "es")
     */
    @Override
    public long getCountOfCountriesWithoutSpanishTranslation(@NonNull List<Country> countries) {
        return 0;
    }

    /**
     * Returns the number of countries which does not have country name translation in the given language.
     *
     * @param countries    the list of countries
     * @param languageCode the two-letter language code
     * @return the number of countries which does not have country name translation in the given language
     */
    @Override
    public long getCountOfCountriesWithoutGivenTranslation(@NonNull List<Country> countries, @NonNull String languageCode) {
        return 0;
    }

    /**
     * Returns the largest country.
     *
     * @param countries the list of countries
     * @return the largest country
     */
    @Override
    public Optional<Country> getLargestCountry(@NonNull List<Country> countries) {
        return Optional.empty();
    }

    /**
     * Returns the list of country names with null area.
     *
     * @param countries the list of countries
     * @return the list of country names with null area
     */
    @Override
    public List<String> getCountryNamesWithNullArea(@NonNull List<Country> countries) {
        return null;
    }

    /**
     * Returns summary statistics about the area field.
     *
     * @param countries the list of countries
     * @return the summary statistics about the area field
     */
    @Override
    public DoubleSummaryStatistics getSummaryStatisticsOfArea(@NonNull List<Country> countries) {
        return null;
    }

    /**
     * Returns the total area of countries.
     *
     * @param countries the list of countries
     * @return the total area of countries
     */
    @Override
    public Optional<BigDecimal> getTotalAreaOfCountries(@NonNull List<Country> countries) {
        return countries.stream()
                .map(country -> country.getArea())
                .filter(area -> Objects.nonNull(area))
                .reduce(BigDecimal::add);
    }

    /**
     * Returns a comma-separated string of country names sorted alphabetically.
     *
     * @param countries the list of countries
     * @return the comma-separated string of country names sorted alphabetically
     */
    @Override
    public String getSortedCountryNamesSeparatedByComma(@NonNull List<Country> countries) {
        return null;
    }

    /**
     * Returns the map of country code-country name pairs.
     *
     * @param countries the list of countries
     * @return the map of country code-country name pairs
     */
    @Override
    public Map<String, String> getCountriesByCodeAndName(@NonNull List<Country> countries) {
        return null;
    }

    /**
     * Returns the map of countries for efficient access by country code.
     *
     * @param countries the list of countries
     * @return the map of countries by country code
     */
    @Override
    public Map<String, Country> getCountriesByCode(@NonNull List<Country> countries) {
        return countries.stream()
                .collect(Collectors.toMap(country -> country.getCode(), country -> country.getName()));
    }

    /**
     * Returns the list of countries with population less or equal to that of Hungary in descending order of population.
     *
     * @param countries the list of countries
     * @return the list of countries with population less or equal to that of Hungary in descending order of population
     */
    @Override
    public List<Country> getCountriesSmallerThanHungaryInDescOrder(@NonNull List<Country> countries) {
        return null;
    }

    /**
     * Returns the list of countries with population less or equal to that of the given country in descending order of population.
     *
     * @param countries        the list of countries
     * @param comparingCountry the country for comparison
     * @return the list of countries with population less or equal to that of the given country in descending order of population
     */
    @Override
    public List<Country> getCountriesSmallerThanCountryInDescOrder(@NonNull List<Country> countries, @NonNull Country comparingCountry) {
        return null;
    }

    /**
     * Returns the number of European and non-European countries.
     *
     * @param countries the list of countries
     * @return the number of European and non-European countries
     */
    @Override
    public Map<Boolean, Long> getCountriesPartitionedByBeingEuropeanAndCount(@NonNull List<Country> countries) {
        return null;
    }

    /**
     * Returns the number of countries of the given region, as well as the number of countries which do not belong to the given region.
     *
     * @param countries the list of countries
     * @param region    the region
     * @return the number of countries of the given region, as well as the number of countries which do not belong to the given region
     */
    @Override
    public Map<Boolean, Long> getCountriesPartitionedByRegionAndCount(@NonNull List<Country> countries, @NonNull Region region) {
        return null;
    }

    /**
     * Returns the lists of countries by region.
     *
     * @param countries the list of countries
     * @return the lists of countries by region
     */
    @Override
    public Map<Region, List<Country>> getCountriesByRegion(@NonNull List<Country> countries) {
        return null;
    }

    /**
     * Returns the number of countries by region.
     *
     * @param countries the list of countries
     * @return the number of countries by region
     */
    @Override
    public Map<Region, Long> getNumberOfCountriesByRegion(@NonNull List<Country> countries) {
        return null;
    }

    /**
     * Returns population average by region.
     *
     * @param countries the list of countries
     * @return the population average by region
     */
    @Override
    public Map<Region, Double> getAveragePopulationByRegion(@NonNull List<Country> countries) {
        return null;
    }

    /**
     * Returns the most populous country by region.
     *
     * @param countries the list of countries
     * @return the most populous country by region
     */
    @Override
    public Map<Region, Optional<Country>> getMostPopulousCountryByRegion(@NonNull List<Country> countries) {
        return null;
    }

    /**
     * Returns the largest population by region.
     *
     * @param countries the list of countries
     * @return the largest population by region
     */
    @Override
    public Map<Region, Optional<Long>> getLargestPopulationByRegion(@NonNull List<Country> countries) {
        return null;
    }

    /**
     * Returns the longest country name by region.
     *
     * @param countries the list of countries
     * @return the longest country name by region
     */
    @Override
    public Map<Region, String> getLongestCountryNameByRegion(@NonNull List<Country> countries) {
        return null;
    }

    /**
     * Returning the number of countries grouped by the first letter of their name.
     *
     * @param countries the list of countries
     * @return the number of countries grouped by the first letter of their name
     */
    @Override
    public Map<Character, Long> getNumberOfCountriesByFirstLetter(@NonNull List<Country> countries) {
        return null;
    }

    /**
     * Returns whether there are two or more countries with the same non-null area.
     *
     * @param countries the list of countries
     * @return if there are two or more countries with the same non-null area
     */
    @Override
    public boolean doesTwoOrMoreCountriesWithSameNonNullAreaExist(@NonNull List<Country> countries) {
        return false;
    }

    /**
     * Returns the set of distinct language tags of country name translations sorted in alphabetical order.
     *
     * @param countries the list of countries
     * @return the set of distinct language tags of country name translations sorted in alphabetical order
     */
    @Override
    public Set<String> getDistinctLanguageTagsInAlphabeticalOrder(@NonNull List<Country> countries) {
        return null;
    }

    /**
     * Returns the average length of country names.
     *
     * @param countries the list of countries
     * @return the average length of country names
     */
    @Override
    public double getAverageLengthOfCountryNames(@NonNull List<Country> countries) {
        return 0;
    }

    /**
     * Returns the set of distinct regions of null area countries.
     *
     * @param countries the list of countries
     * @return the set of distinct regions of null area countries
     */
    @Override
    public Set<Region> getDistinctRegionsOfNullAreaCountries(@NonNull List<Country> countries) {
        return null;
    }

    /**
     * Returns the largest country with non-null area.
     *
     * @param countries the list of countries
     * @return the largest country with non-null area
     */
    @Override
    public Optional<Country> getLargestNonNullAreaCountry(@NonNull List<Country> countries) {
        return Optional.empty();
    }

    /**
     * Returns the list of country names with a non-null area below 1.
     *
     * @param countries the list of countries
     * @return the list of country names with a non-null area below 1
     */
    @Override
    public List<String> getNonNullAreaCountryNamesBelowOne(@NonNull List<Country> countries) {
        return null;
    }

    /**
     * Returns the list of country names with a non-null area below the given threshold.
     *
     * @param countries the list of countries
     * @param threshold the threshold
     * @return the list of country names with a non-null area below the given threshold
     */
    @Override
    public List<String> getNonNullAreaCountryNamesBelowThreshold(@NonNull List<Country> countries, @NonNull long threshold) {
        return null;
    }

    /**
     * Returns the set of distinct timezones of European and Asian countries.
     *
     * @param countries the list of countries
     * @return the set of distinct timezones of European and Asian countries
     */
    @Override
    public Set<ZoneId> getDistinctTimezonesOfEuropeanAndAsianCountries(@NonNull List<Country> countries) {
        return countries.stream()
                .filter(country -> country.getRegion() == Region.EUROPE || country.getRegion() == Region.ASIA)
                .flatMap(country -> country.getTimezones().stream())
                .distinct()
                .collect(Collectors.toSet());
    }
}
