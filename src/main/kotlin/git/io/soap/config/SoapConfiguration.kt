package git.io.soap.config

import jakarta.annotation.PostConstruct
import org.springframework.stereotype.Component
import java.util.*

@Component
class CountryRepository {
    @PostConstruct
    fun initData() {
        val spain: Country = Country()
        spain.setName("Spain")
        spain.setCapital("Madrid")
        spain.setCurrency(Currency.EUR)
        spain.setPopulation(46704314)

        countries[spain.getName()] = spain

        val poland: Country = Country()
        poland.setName("Poland")
        poland.setCapital("Warsaw")
        poland.setCurrency(Currency.PLN)
        poland.setPopulation(38186860)

        countries[poland.getName()] = poland

        val uk: Country = Country()
        uk.setName("United Kingdom")
        uk.setCapital("London")
        uk.setCurrency(Currency.GBP)
        uk.setPopulation(63705000)

        countries[uk.getName()] = uk
    }

    fun findCountry(name: String): Country? {
        Assert.notNull(name, "The country's name must not be null")
        return countries[name]
    }

    companion object {
        private val countries: MutableMap<String, Country> = HashMap<String, Country>()
    }
}