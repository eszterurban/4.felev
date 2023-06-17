package countries.query;

import countries.model.Country;
import countries.model.Region;
import lombok.NonNull;

import java.time.ZoneId;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Optional;
import java.util.Set;

/**
 * Defines query methods for {@link Country} objects.
 */
public interface CountryQueries2 {

    /**
     * Returns whether there is at least one country with the word "island" in its name ignoring case.
     *
     * @param countries the list of countries
     * @return if there is at least one country with the word "island" in its name ignoring case
     */
    boolean doesCountryWithNameContainingIslandExist(@NonNull List<Country> countries);

    /**
     * Returns whether there is at least one country with the given word in its name ignoring case.
     *
     * @param countries the list of countries
     * @param word the word
     * @return if there is at least one country with the given word in its name ignoring case
     */
    boolean doesCountryWithNameContainingTextExist(@NonNull List<Country> countries, @NonNull String word);

    /**
     * Returns the first country name that contains the word "island" ignoring case.
     *
     * @param countries the list of countries
     * @return the first country name that contains the word "island" ignoring case
     */
    Optional<String> getFirstCountryNameContainingIsland(@NonNull List<Country> countries);

    /**
     * Returns the first country name that contains the given word ignoring case.
     *
     * @param countries the list of countries
     * @param word the word
     * @return the first country name that contains the given word ignoring case
     */
    Optional<String> getFirstCountryNameContainingText(@NonNull List<Country> countries, @NonNull String word);

    /**
     * Returns the list of country names in which the first and the last letters are the same ignoring case.
     *
     * @param countries the list of countries
     * @return the list of country names in which the first and the last letters are the same ignoring case
     */
    List<String> getCountryNamesWithMatchingFirstAndLastLetters(@NonNull List<Country> countries);

    /**
     * Returns the list of populations of the first ten least populous countries.
     *
     * @param countries the list of countries
     * @return the list of populations of the first ten least populous countries
     */
    List<Long> getPopulationsOfFirstTenLeastPopulousCountries(@NonNull List<Country> countries);

    /**
     * Returns the list of populations of the first n least populous countries.
     *
     * @param countries the list of countries
     * @param count the number of populations to return
     * @return the list of populations of the first n least populous countries
     */
    List<Long> getPopulationsOfFirstNLeastPopulousCountries(@NonNull List<Country> countries, @NonNull int count);

    /**
     * Returns the list of the first ten least populous country names.
     *
     * @param countries the list of countries
     * @return the list of the first ten least populous country names
     */
    List<String> getNamesOfFirstTenLeastPopulousCountries(@NonNull List<Country> countries);

    /**
     * Returns the list of the first n least populous country names.
     *
     * @param countries the list of countries
     * @param count the number of country names to return
     * @return the list of the first n least populous country names
     */
    List<String> getNamesOfFirstNLeastPopulousCountries(@NonNull List<Country> countries, @NonNull int count);

    /**
     * Returns summary statistics about the number of country name translations associated with each country.
     *
     * @param countries the list of countries
     * @return summary statistics about the number of country name translations associated with each country
     */
    IntSummaryStatistics getSummaryStatisticsOfNumberOfCountryNameTranslations(@NonNull List<Country> countries);

    /**
     * Returns the list of country names in the ascending order of the number of timezones.
     *
     * @param countries the list of countries
     * @return the list of country names in the ascending order of the number of timezones
     */
    List<String> getCountryNamesInNumberOfTimezonesAscOrder(@NonNull List<Country> countries);

    /**
     * Returns the number of timezones for each country in the form name:timezones, in the ascending order of the number of timezones.
     *
     * @param countries the list of countries
     * @return the number of timezones for each country in the form name:timezones, in the ascending order of the number of timezones
     */
    List<String> getNumberOfTimezonesInCustomFormat(@NonNull List<Country> countries);

    /**
     * Returns the number of countries with no Spanish country name translation (the Spanish language is identified by the language code "es").
     *
     * @param countries the list of countries
     * @return the number of countries with no Spanish country name translation (the Spanish language is identified by the language code "es")
     */
    long getCountOfCountriesWithoutSpanishTranslation(@NonNull List<Country> countries);

    /**
     * Returns the number of countries which does not have country name translation in the given language.
     *
     * @param countries the list of countries
     * @param languageCode the two-letter language code
     * @return the number of countries which does not have country name translation in the given language
     */
    long getCountOfCountriesWithoutGivenTranslation(@NonNull List<Country> countries, @NonNull String languageCode);

    /**
     * Returns the list of country names with null area.
     *
     * @param countries the list of countries
     * @return the list of country names with null area
     */
    List<String> getCountryNamesWithNullArea(@NonNull List<Country> countries);

    /**
     * Returns the set of distinct language tags of country name translations sorted in alphabetical order.
     *
     * @param countries the list of countries
     * @return the set of distinct language tags of country name translations sorted in alphabetical order
     */
    Set<String> getDistinctLanguageTagsInAlphabeticalOrder(@NonNull List<Country> countries);

    /**
     * Returns the average length of country names.
     *
     * @param countries the list of countries
     * @return the average length of country names
     */
    double getAverageLengthOfCountryNames(@NonNull List<Country> countries);

    /**
     * Returns the set of distinct regions of null area countries.
     *
     * @param countries the list of countries
     * @return the set of distinct regions of null area countries
     */
    Set<Region> getDistinctRegionsOfNullAreaCountries(@NonNull List<Country> countries);

    /**
     * Returns the largest country with non-null area.
     *
     * @param countries the list of countries
     * @return the largest country with non-null area
     */
    Optional<Country> getLargestNonNullAreaCountry(@NonNull List<Country> countries);

    /**
     * Returns the list of country names with a non-null area below 1.
     *
     * @param countries the list of countries
     * @return the list of country names with a non-null area below 1
     */
    List<String> getNonNullAreaCountryNamesBelowOne(@NonNull List<Country> countries);

    /**
     * Returns the list of country names with a non-null area below the given threshold.
     *
     * @param countries the list of countries
     * @param threshold the threshold
     * @return the list of country names with a non-null area below the given threshold
     */
    List<String> getNonNullAreaCountryNamesBelowThreshold(@NonNull List<Country> countries, @NonNull long threshold);

    /**
     * Returns the set of distinct timezones of European and Asian countries.
     *
     * @param countries the list of countries
     * @return the set of distinct timezones of European and Asian countries
     */
    Set<ZoneId> getDistinctTimezonesOfEuropeanAndAsianCountries(@NonNull List<Country> countries);

}
