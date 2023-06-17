package countries.query;

import countries.model.Country;
import countries.model.Region;
import lombok.NonNull;

import java.time.ZoneId;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * Defines query methods for {@link Country} objects.
 */
public interface CountryQueries4 {

    /**
     * Returns the longest country name translation.
     *
     * @param countries the list of countries
     * @return the longest country name translation
     */
    Optional<String> getLongestCountryNameTranslation(@NonNull List<Country> countries);

    /**
     * Returns the longest Farsi (i.e. `"fa"`) country name translation.
     *
     * @param countries the list of countries
     * @return the longest Farsi country name translation
     */
    Optional<String> getLongestFarsiCountryNameTranslation(@NonNull List<Country> countries);

    /**
     * Returns the longest country name translation of the given language.
     *
     * @param countries the list of countries
     * @param languageCode the two-letter language code
     * @return the longest country name translation of the given language
     */
    Optional<String> getLongestCountryNameTranslationInLanguage(@NonNull List<Country> countries, @NonNull String languageCode);

    /**
     * Returns the longest country name translation together with its language code in the form language=translation.
     *
     * @param countries the list of countries
     * @return the longest country name translation together with its language code in the form language=translation
     */
    Optional<String> getLongestCountryNameTranslationWithLanguageCode(@NonNull List<Country> countries);

    /**
     * Returns single word country names (i.e. country names that do not contain any space characters).
     *
     * @param countries the list of countries
     * @return list of single word country names
     */
    List<String> getSingleWordCountryNames(@NonNull List<Country> countries);

    /**
     * Returns the country name with the most number of words.
     *
     * @param countries the list of countries
     * @return the country name with the most number of words
     */
    Optional<String> getCountryNameWithMostNumberOfWords(@NonNull List<Country> countries);

    /**
     * Returns whether there exists at least one capital that is a palindrome.
     *
     * @param countries the list of countries
     * @return whether there exists at least one capital that is a palindrome
     */
    boolean doesPalindromeCapitalExist(@NonNull List<Country> countries);

    /**
     * Returns the country name with the most number of 'e' characters ignoring case.
     *
     * @param countries the list of countries
     * @return the country name with the most number of 'e' characters ignoring case
     */
    Optional<String> getCountryNameWithMostNumberOfEIgnoringCase(@NonNull List<Country> countries);

    /**
     * Returns the country name with the most number of the given letter ignoring case.
     *
     * @param countries the list of countries
     * @param letter the letter
     * @return the country name with the most number of the given letter ignoring case
     */
    Optional<String> getCountryNameWithMostNumberOfLetterIgnoringCase(@NonNull List<Country> countries, @NonNull char letter);

    /**
     * Returns the capital with the most number of English vowels (i.e. 'a', 'e', 'i', 'o', 'u').
     *
     * @param countries the list of countries
     * @return the capital with the most number of English vowels
     */
    Optional<String> getCapitalWithMostNumberOfEnglishVowels(@NonNull List<Country> countries);

    /**
     * Returns a map that contains for each character the number of occurrences in country names ignoring case.
     *
     * @param countries the list of countries
     * @return a map that contains for each character the number of occurrences in country names ignoring case
     */
    Map<Character, Long> getCharacterOccurrencesInCountryNamesIgnoringCase(@NonNull List<Country> countries);

    /**
     * Returns a map that contains the number of countries for each possible timezone.
     *
     * @param countries the list of countries
     * @return a map that contains the number of countries for each possible timezone
     */
    Map<ZoneId, Long> getNumberOfCountriesByTimezone(@NonNull List<Country> countries);

    /**
     * Returns the number of country names by region that starts with their two-letter country code ignoring case.
     *
     * @param countries the list of countries
     * @return a map that contains the number of country names by region that starts with their two-letter country code ignoring case
     */
    Map<Region, Long> getNumberOfCountryNamesStartingWithCountryCodeByRegion(@NonNull List<Country> countries);

    /**
     * Returns a map that contains the number of countries whose population is greater or equal than the population average versus the number of countries with population below the average.
     *
     * @param countries the list of countries
     * @return a map that contains the number of countries whose population is greater or equal than the population average versus the number of countries with population below the average
     */
    Map<Boolean, Long> getNumberOfCountriesPartitionedByPopulationAverage(@NonNull List<Country> countries);

    /**
     * Returns a map that contains for each country code the name of the corresponding country in Portuguese ("pt").
     *
     * @param countries the list of countries
     * @return a map that contains for each country code the name of the corresponding country in Portuguese ("pt")
     */
    Map<String, String> getPortugueseCountryNamesByCountryCode(@NonNull List<Country> countries);

    /**
     * Returns a map that contains for each country code the name of the corresponding country in the given language.
     *
     * @param countries the list of countries
     * @param languageCode the two-letter language code
     * @return a map that contains for each country code the name of the corresponding country in the given language
     */
    Map<String, String> getCountryNamesInLanguageByCountryCode(@NonNull List<Country> countries, @NonNull String languageCode);

    /**
     * Returns the list of capitals by region whose name is the same is the same as the name of their country.
     *
     * @param countries the list of countries
     * @return the list of capitals by region whose name is the same is the same as the name of their country
     */
    List<String> getCapitalsByRegionWithSameNameAsCountry(@NonNull List<Country> countries);

    /**
     * Returns a map of country name-population density pairs.
     *
     * @param countries the list of countries
     * @return a map of country name-population density pairs
     */
    Map<String, Double> getCountryNamePopulationDensityPairs(@NonNull List<Country> countries);
}
